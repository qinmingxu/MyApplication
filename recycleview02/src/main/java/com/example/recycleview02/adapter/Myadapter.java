package com.example.recycleview02.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recycleview02.R;
import com.example.recycleview02.net.Databean;


import java.util.List;

/**
 * Created by wan on 2017/12/5.
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder>{
    Context context;
    List<Databean.DataBean> list;
    public Myadapter(Context context, List<Databean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public Myadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item01,null);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Myadapter.ViewHolder holder, int position) {
        holder.text.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

}
