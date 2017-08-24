package com.example.hihihahahehe.portablept.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hihihahahehe.portablept.R;
import com.example.hihihahahehe.portablept.models.HotSportsModel;
import com.example.hihihahahehe.portablept.utils.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PackFragment extends Fragment {
    public static final String TAG = PackFragment.class.toString();
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    int checkdata=0;
    private List<HotSportsModel> hotSportsModelList;

    public PackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        View view = inflater.inflate(R.layout.fragment_pack, container, false);
        ButterKnife.bind(this, view);
        Utils.addTab(tabLayout,"");
        return view;
    }
    @Subscribe(sticky = true)
    public  void onRecivedPack (List<HotSportsModel>  hotSportsModelList){
        if (checkdata==0){
            this.hotSportsModelList = hotSportsModelList;
            Log.d("TEST",hotSportsModelList.get(1).getName());
            tabLayout.removeAllTabs();
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            for(int i = 0; i < hotSportsModelList.size(); i++){
                Utils.addTab(tabLayout,hotSportsModelList.get(i).getName());
            }
            checkdata=1;
        }


    }

}
