package com.example.beatrice.globonews;
import java.util.ArrayList;
import java.util.Objects;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;


public class LinearLayoutFragment extends Fragment {
    private static View view;
    private static RecyclerView listRecyclerView;
    private static ArrayList<DataModel> listArrayList;
    private static ListViewRecyclerAdapter adapter;

    private static final int[] images = { R.drawable.iconecertificado,
            R.drawable.configura, R.drawable.certificado, R.drawable.changepin,
            R.drawable.conficon, R.drawable.iconealerta, R.drawable.iconeassinatura,
            R.drawable.iconebiometrico, R.drawable.iconecadeado };

    String[] getTitle, getLocation, getYear;
    private static RelativeLayout bottomLayout;
    private static LinearLayoutManager mLayoutManager;

    private boolean userScrolled = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    public LinearLayoutFragment() {

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

        getTitle = Objects.requireNonNull(getActivity()).getResources().getStringArray(R.array.title);

        getLocation = getActivity().getResources().getStringArray(R.array.location);

        getYear = getActivity().getResources().getStringArray(R.array.constructed_year);

        mLayoutManager = new LinearLayoutManager(getActivity());

        listRecyclerView = view.findViewById(R.id.linear_recyclerview);

        listRecyclerView.setHasFixedSize(true);

        listRecyclerView.setLayoutManager(mLayoutManager);

    }

    private void populatRecyclerView() {

        listArrayList = new ArrayList<>();

        for (int i = 0; i < getTitle.length; i++) {

            listArrayList.add(new DataModel(getTitle[i], getLocation[i], getYear[i], images[i]));
        }

        adapter = new ListViewRecyclerAdapter(getActivity(), listArrayList);

        listRecyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

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

                for (int i = 0; i < 3; i++) {

                    int value = new RandomNumberGenerator().RandomGenerator();

                    listArrayList.add(new DataModel(getTitle[value], getLocation[value], getYear[value], images[value]));
                }
                adapter.notifyDataSetChanged();

                Toast.makeText(getActivity(), "Items Updated.", Toast.LENGTH_SHORT).show();

                bottomLayout.setVisibility(View.GONE);

            }
        }, 5000);
    }
}