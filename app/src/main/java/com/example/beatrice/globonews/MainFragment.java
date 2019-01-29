package com.example.beatrice.globonews;
import java.util.ArrayList;
import java.util.Objects;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;


public class MainFragment extends Fragment {
    private static View view;
    private static RecyclerView listRecyclerView;
    private static NewsRecyclerAdapter adapter;


    String[] getTitle, getLocation, getYear;
    private static RelativeLayout bottomLayout;
    private static LinearLayoutManager mLayoutManager;

    private boolean userScrolled = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    public MainFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.linearlayout_fragment, container,
                false);
        init();
        populatRecyclerView();
        implementScrollListener();
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

        viewModel.startServices(getContext()).observe(this, new Observer<ServiceResult>() {

            @Override
            public void onChanged(@Nullable ServiceResult result) {

                if (result != null) {

                    ArrayList<ItemsModel> listArrayList = new ArrayList();

                    for (int i = 0; i < result.getList().size(); i++) {

                        if (result.getList().get(i).getType().equals("basico"))

                        listArrayList.add(result.getList().get(i));
                    }

                    adapter = new NewsRecyclerAdapter(getActivity(), listArrayList);

                    listRecyclerView.setAdapter(adapter);

                    adapter.notifyDataSetChanged();

                }
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

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                populatRecyclerView();

                bottomLayout.setVisibility(View.GONE);

            }
        }, 5000);
    }
}