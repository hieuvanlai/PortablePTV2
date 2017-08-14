package com.example.hihihahahehe.portablept.details;


import android.hardware.camera2.params.Face;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hihihahahehe.portablept.R;
import com.example.hihihahahehe.portablept.events.OnLoginEvent;
import com.example.hihihahahehe.portablept.models.FaceBookModel;
import com.github.siyamed.shapeimageview.CircularImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClientProfileFragment extends Fragment {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_city)
    EditText edtCity;
    @BindView(R.id.edt_birth)
    EditText edtBirthDay;
    @BindView(R.id.edt_gen)
    EditText edtGen;
    @BindView(R.id.iv_avatar)
    CircularImageView ivAvatar;
    private FaceBookModel faceBookModel;

    public ClientProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client_profile, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        setOnClickItem();
    }

    @Subscribe(sticky = true)
    public void loadInfo(OnLoginEvent onLoginEvent) {
        if(onLoginEvent != null){
            faceBookModel = onLoginEvent.getFaceBookModel();
            edtName.setText(faceBookModel.getLast_Name());
            edtEmail.setText(faceBookModel.getEmail());
            edtBirthDay.setText(faceBookModel.getBirthday());
            edtCity.setText(faceBookModel.getLocation());
            edtGen.setText(faceBookModel.getGender());
        }
    }

    private void setOnClickItem() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
            }
        });
    }
}
