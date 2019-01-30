package com.example.beatrice.globonews.fragments;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.AbsListView.OnScrollListener;

import com.example.beatrice.globonews.adapters.NewsRecyclerAdapter;
import com.example.beatrice.globonews.R;
import com.example.beatrice.globonews.services.ServiceResult;
import com.example.beatrice.globonews.viewModels.ServicesViewModel;
import com.example.beatrice.globonews.models.ItemsModel;

import org.json.JSONArray;
import org.json.JSONException;


public class MainFragment extends Fragment {

    private  View view;
    private  RecyclerView listRecyclerView;
    private NewsRecyclerAdapter adapter;
    private static RelativeLayout bottomLayout;
    private static LinearLayoutManager mLayoutManager;
    private boolean userScrolled = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    ArrayList<ItemsModel> listArrayList = new ArrayList();
    public MainFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.linearlayout_fragment, container, false);
        init();
        populatRecyclerView();
        implementScrollListener();

        Toolbar toolbar = view.findViewById(R.id.main_toolbar);

        toolbar.setTitle(R.string.app_name);
        return view;
    }

    private void init() {

        bottomLayout = view.findViewById(R.id.loadItemsLayout_recyclerView);

        mLayoutManager = new LinearLayoutManager(getActivity());

        listRecyclerView = view.findViewById(R.id.linear_recyclerview);

        listRecyclerView.setHasFixedSize(true);

        listRecyclerView.setLayoutManager(mLayoutManager);

    }

    private void populatRecyclerView() {

        ServicesViewModel viewModel = ViewModelProviders.of(this).get(ServicesViewModel.class);

        viewModel.startServices(getContext()).observe(this, result -> {

            if (result != null) {

                for (int i = 0; i < result.getList().size(); i++) {

                    if (result.getList().get(i).getType().equals("basico"))

                    listArrayList.add(result.getList().get(i));
                }

                adapter = new NewsRecyclerAdapter(getActivity(), listArrayList);

                listRecyclerView.setAdapter(adapter);

                adapter.notifyDataSetChanged();

            }
        });

    }

    private void implementScrollListener() {

        listRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView,
                                             int newState) {

                super.onScrollStateChanged(recyclerView, newState);

                if (newState == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {

                    userScrolled = true;

                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx,
                                   int dy) {

                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = mLayoutManager.getChildCount();

                totalItemCount = mLayoutManager.getItemCount();

                pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                if (userScrolled && (visibleItemCount + pastVisiblesItems) == totalItemCount) {

                    userScrolled = false;

                    updateRecyclerView();
                }
            }
        });
    }

    private void updateRecyclerView() {

        bottomLayout.setVisibility(View.VISIBLE);

        new Handler().postDelayed(() -> {

            populatRecyclerView();

            bottomLayout.setVisibility(View.GONE);

        }, 5000);
    }
}