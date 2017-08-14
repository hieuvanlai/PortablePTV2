package com.example.hihihahahehe.portablept.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hihihahahehe.portablept.R;

import butterknife.BindView;

/**
 * Created by valky on 8/7/2017.
 */

public class RoleFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.tv_question)
    TextView tvQuestion;

    @BindView(R.id.tv_trainer)
    TextView tvTrainer;

    @BindView(R.id.tv_trainee)
    TextView tvTrainee;

    public RoleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_roles, container, false);
    }

    @Override
    public void onClick(View view) {

    }
}
