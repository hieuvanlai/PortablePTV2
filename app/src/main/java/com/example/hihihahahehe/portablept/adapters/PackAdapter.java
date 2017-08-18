package com.example.hihihahahehe.portablept.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hihihahahehe.portablept.R;
import com.example.hihihahahehe.portablept.models.PackModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hihihahahehe on 8/15/17.
 */

public class PackAdapter extends RecyclerView.Adapter<PackAdapter.PackViewHolder> {
    private List<PackModel> packModelList;
    private View.OnClickListener onClickListener;

    public PackAdapter(List<PackModel> packModelList) {
        this.packModelList = packModelList;
    }

    public void setOnClick(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @Override
    public PackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_pack, parent, false);
        view.setOnClickListener(onClickListener);
        return new PackAdapter.PackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PackViewHolder holder, int position) {
        holder.setData(packModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return packModelList.size();
    }

    public class PackViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvNamePack;
        @BindView(R.id.tv_duration)
        TextView tvDuration;
        @BindView(R.id.tv_goal)
        TextView tvGoal;
        @BindView(R.id.tv_cost)
        TextView tvCost;
        View view;

        public PackViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            view = itemView;
        }
            public void setData(PackModel packModel){
            if(packModel != null){
                tvNamePack.setText(packModel.getPackName());
                tvDuration.setText(packModel.getDuration());
                tvGoal.setText(packModel.getGoal());
                tvCost.setText(packModel.getCost());

                view.setTag(packModel);
            }
        }
    }
}
