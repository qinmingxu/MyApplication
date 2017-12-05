package com.example.recycleview03.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.recycleview03.MainActivity;
import com.example.recycleview03.R;
import com.example.recycleview03.net.Databean;

import java.util.List;

/**
 * Created by wan on 2017/12/5.
 */
public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE1 = 0;
    private static final int TYPE2 = 1;
    Context context;
    List<Databean.DataBean> list;
    public Myadapter(Context context, List<Databean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case TYPE1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item01, parent,false);
                holder=new Viewholder1(view1);
                break;
            case TYPE2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.item02, parent,false);
                holder=new Viewholder2(view2);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TYPE1:
                Viewholder1 holder1 = (Viewholder1) holder;
                holder1.text.setText(list.get(position).getName());
                Glide.with(context).load(list.get(position).getIcon()).into(holder1.image);
                break;
            case TYPE2:
                Viewholder2 holder2 = (Viewholder2) holder;
                holder2.text.setText(list.get(position).getName());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position%2==0?TYPE1:TYPE2;
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView text;

        public Viewholder1(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
    public class Viewholder2 extends RecyclerView.ViewHolder {


        private final TextView text;

        public Viewholder2(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

}
