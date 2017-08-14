package com.example.hihihahahehe.portablept.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hihihahahehe.portablept.R;
import com.example.hihihahahehe.portablept.details.ClientProfileFragment;
import com.example.hihihahahehe.portablept.events.OnLoginEvent;
import com.example.hihihahahehe.portablept.utils.RealmHandle;
import com.example.hihihahahehe.portablept.utils.ScreenManager;
import com.example.hihihahahehe.portablept.models.FaceBookModel;
import com.github.siyamed.shapeimageview.CircularImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {
    private static final String TAG = PersonFragment.class.toString();
    @BindView(R.id.cv_information)
    CardView cvInformation;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_avatar)
    CircularImageView ivAvatar;
    private ClientProfileFragment clientProfile;
    private FaceBookModel faceBookModel;

    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        initView(view);
        return view;
    }

    public void initView(View view) {
        ButterKnife.bind(this, view);
        setOnClickItem();
        loadData();
    }

    public void loadData() {
        if (RealmHandle.getData() != null) {
            faceBookModel = RealmHandle.getData();
            String firstName;
            String lastName;
            if (faceBookModel.getFirst_Name() == null) {
                firstName = "";
            } else firstName = faceBookModel.getFirst_Name();

            if (faceBookModel.getLast_Name() == null) {
                lastName = "";
            } else lastName = faceBookModel.getLast_Name();
            tvName.setText(lastName + " " + firstName);
        }
    }

    public void setOnClickItem() {
        cvInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clientProfile = new ClientProfileFragment();
                ScreenManager.replaceFragment(getActivity().getSupportFragmentManager(), clientProfile, R.id.layout_container, true);
            }
        });
    }
}
