package com.example.hihihahahehe.portablept.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hihihahahehe.portablept.R;
import com.example.hihihahahehe.portablept.models.PackModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valky on 8/10/2017.
 */

public class PackAdapter extends RecyclerView.Adapter<PackAdapter.PackViewHolder> {

    private List<PackModel> packModelList = new ArrayList<>();
    private Context context;
    private View.OnClickListener onClickListener;

    public void setOnItemClick(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public PackAdapter(List<PackModel> packModelList, Context context) {
        this.packModelList = packModelList;
        this.context = context;
    }

    @Override
    public PackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //TODO add custom list pack
        View view = null;
        return new PackViewHolder(view);
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
        ImageView ivIcon;
        TextView tvPackName;
        TextView tvCoach;
        View view;

        public PackViewHolder(View itemView) {
            super(itemView);
//            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
//            tvPackName = (TextView) itemView.findViewById(R.id.tv_pack_name);
//            tvCoach = itemView.findViewById(R.id.tv_coach);
            view = itemView;
        }

        public void setData(PackModel packModel) {
            if (packModel != null) {
//                Picasso.with(context).load(packModel.getImageURL()).into(ivIcon);
                tvPackName.setText(packModel.getPackName());
                tvCoach.setText(packModel.getCoachName());
                view.setTag(packModel);
            }
        }
    }
}
