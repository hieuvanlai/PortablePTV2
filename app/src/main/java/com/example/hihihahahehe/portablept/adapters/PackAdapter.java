package com.example.hihihahahehe.portablept.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.example.hihihahahehe.portablept.R;
import com.example.hihihahahehe.portablept.models.PackModel;

import java.util.List;

/**
 * Created by hihihahahehe on 8/15/17.
 */

public class PackAdapter extends ArrayAdapter<PackModel> {
    private Context context;
    private List<PackModel> packModels;


    public PackAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<PackModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.item_list_pack, null);
        return convertView;
    }
}
