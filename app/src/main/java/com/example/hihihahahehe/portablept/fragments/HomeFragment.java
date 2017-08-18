package com.example.hihihahahehe.portablept.fragments;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hihihahahehe.portablept.R;
import com.example.hihihahahehe.portablept.adapters.HotCoachesAdapter;
import com.example.hihihahahehe.portablept.adapters.HotSportsAdapter;
import com.example.hihihahahehe.portablept.models.HotCoachesModel;
import com.example.hihihahahehe.portablept.models.HotSportsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.tv_hot)
    TextView tvHot;
    @BindView(R.id.home_pager)
    ViewPager homePager;

    @BindView(R.id.rv_hot_coaches)
    RecyclerView rvHotCoaches;

    @BindView(R.id.tv_hot_sports)
    TextView tvHotSports;
    @BindView(R.id.rv_hot_sports)
    RecyclerView rvHotSports;

    private List<HotCoachesModel> hotCoachesModelList = new ArrayList<>();
    private List<HotSportsModel> hotSportsModelList = new ArrayList<>();

    private HotCoachesAdapter hotCoachesAdapter;
    private HotSportsAdapter hotSportsAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setupUI(view);
        loadData();

        return view;
    }

    private void loadData() {
        hotCoachesAdapter.notifyDataSetChanged();
    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);

        HotCoachesModel hotCoachesModel = new HotCoachesModel();
        hotCoachesModelList.add(hotCoachesModel);


        hotCoachesAdapter = new HotCoachesAdapter(hotCoachesModelList, getContext());
        rvHotCoaches.setAdapter(hotCoachesAdapter);


        hotSportsAdapter = new HotSportsAdapter(hotSportsModelList, getContext());
        rvHotSports.setAdapter(hotSportsAdapter);

        final LinearLayoutManager linearLayoutManagerCoaches = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        final LinearLayoutManager linearLayoutManagerSports = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        rvHotCoaches.setLayoutManager(linearLayoutManagerCoaches);
        rvHotSports.setLayoutManager(linearLayoutManagerSports);
    }
}
