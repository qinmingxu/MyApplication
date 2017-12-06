package com.example.recycleview04.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.recycleview04.MainActivity;
import com.example.recycleview04.R;
import com.example.recycleview04.net.Databean;

import java.util.List;

/**
 * Created by wan on 2017/12/5.
 */
public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<String> list;
    private final int width;
    private final int height;
    private Myonitem  myonitem;
    public Myadapter(Context context, List<String> list) {
       this.context=context;
        this.list=list;
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();

    }
    public void setMyonitem(Myonitem myonitem){
        this.myonitem=myonitem;
    }
    public interface Myonitem{
        void onitemClick(int position);
        void onitemLongClick();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(context).load(list.get(position)).into(holder1.image);
        holder1.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myonitem.onitemClick(position);
            }
        });
        holder1.image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myonitem.onitemLongClick();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width / 3, (int) (200 + Math.random() * 100));
            image.setLayoutParams(layoutParams);
        }
    }
    public void add(){
        list.add(1,"http://img.my.csdn.net/uploads/201407/26/1406382862_1748.jpg");
        notifyItemInserted(1);
    }
    public void remove(){
        list.remove(1);
        notifyItemRemoved(1);
    }

}
