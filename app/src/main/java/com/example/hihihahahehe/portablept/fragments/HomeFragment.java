package com.example.hihihahahehe.portablept.fragments;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hihihahahehe.portablept.R;
import com.example.hihihahahehe.portablept.adapters.HotCoachesAdapter;
import com.example.hihihahahehe.portablept.adapters.HotSportsAdapter;
import com.example.hihihahahehe.portablept.adapters.PackAdapter;
import com.example.hihihahahehe.portablept.models.HotCoachesModel;
import com.example.hihihahahehe.portablept.models.HotSportsModel;
import com.example.hihihahahehe.portablept.models.JSONModel.PackJSONModel;
import com.example.hihihahahehe.portablept.models.JSONModel.SportsJSONModel;
import com.example.hihihahahehe.portablept.models.PackModel;
import com.example.hihihahahehe.portablept.networks.RetrofitFactory;
import com.example.hihihahahehe.portablept.networks.services.GetPacks;
import com.example.hihihahahehe.portablept.networks.services.GetSports;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.tv_hot)
    TextView tvHot;
    @BindView(R.id.iv_cover_photo)
    ImageView ivCoverPhoto;

    RecyclerView rvHotCoaches;

    @BindView(R.id.tv_hot_sports)
    TextView tvHotSports;
    RecyclerView rvHotSports;

    @BindView(R.id.tv_hot_packs)
    TextView tvHotPacks;
    RecyclerView rvHotPacks;

    private List<HotCoachesModel> hotCoachesModelList = new ArrayList<>();
    private List<HotSportsModel> hotSportsModelList = new ArrayList<>();
    private List<PackModel> hotPackModelList = new ArrayList<>();

    private HotCoachesAdapter hotCoachesAdapter;
    private HotSportsAdapter hotSportsAdapter;
    private PackAdapter hotPackAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvHotCoaches = (RecyclerView) view.findViewById(R.id.rv_hot_coaches);
        rvHotSports = (RecyclerView) view.findViewById(R.id.rv_hot_sports);
        rvHotPacks = (RecyclerView) view.findViewById(R.id.rv_hot_packs);

        loadData();
        setupUI(view);

        return view;
    }

    private void loadData() {
        final GetPacks getPacks = RetrofitFactory.getInstance().create(GetPacks.class);
        getPacks.getPacks().enqueue(new Callback<List<PackJSONModel>>() {
            @Override
            public void onResponse(Call<List<PackJSONModel>> call, Response<List<PackJSONModel>> response) {
                for(PackJSONModel packJSONModel : response.body()){
                    HotCoachesModel hotCoachesModel = new HotCoachesModel();
                    hotCoachesModel.setName(packJSONModel.getCoach());
                    hotCoachesModelList.add(hotCoachesModel);

                    PackModel hotPackModel = new PackModel();
                    hotPackModel.setCoachName(packJSONModel.getCoach());
                    hotPackModel.setCost(packJSONModel.getPrice());
                    hotPackModel.setDuration(packJSONModel.getDuration());
                    hotPackModel.setPackName(packJSONModel.getPackName());
                    hotPackModel.setGoal(packJSONModel.getPurpose());
                    hotPackModelList.add(hotPackModel);
                }

                hotCoachesAdapter.notifyDataSetChanged();
                hotPackAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PackJSONModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to load hot coaches into HomeFragment", Toast.LENGTH_SHORT);
            }
        });

        final GetSports getSports = RetrofitFactory.getInstance().create(GetSports.class);
        getSports.getSports().enqueue(new Callback<List<SportsJSONModel>>() {
            @Override
            public void onResponse(Call<List<SportsJSONModel>> call, Response<List<SportsJSONModel>> response) {
                for(SportsJSONModel sportsJSONModel : response.body()){
                    HotSportsModel hotSportsModel = new HotSportsModel();
                    hotSportsModel.setName(sportsJSONModel.getSportsName());
                    hotSportsModel.setImageURL(sportsJSONModel.getImageURL());
                    hotSportsModelList.add(hotSportsModel);
                }
                EventBus.getDefault().postSticky(hotSportsModelList);
                hotSportsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SportsJSONModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to load hot sports into HomeFragment", Toast.LENGTH_SHORT);
            }
        });
    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);

        Picasso.with(getContext())
                .load("https://i.ytimg.com/vi/hVWLn9m6Ezg/maxresdefault.jpg")
                .into(ivCoverPhoto);

        hotCoachesAdapter = new HotCoachesAdapter(hotCoachesModelList, getContext());
        rvHotCoaches.setAdapter(hotCoachesAdapter);

        hotSportsAdapter = new HotSportsAdapter(hotSportsModelList, getContext());
        rvHotSports.setAdapter(hotSportsAdapter);

        hotPackAdapter = new PackAdapter(hotPackModelList, getContext());
        rvHotPacks.setAdapter(hotPackAdapter);

        final GridLayoutManager gridLayoutManagerCoaches = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);
        final GridLayoutManager gridLayoutManagerSports = new GridLayoutManager(getContext(), 2 , GridLayoutManager.HORIZONTAL, false);
        final LinearLayoutManager linearLayoutManagerPacks = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        rvHotCoaches.setLayoutManager(gridLayoutManagerCoaches);
        rvHotSports.setLayoutManager(gridLayoutManagerSports);
        rvHotPacks.setLayoutManager(linearLayoutManagerPacks);
    }
}
