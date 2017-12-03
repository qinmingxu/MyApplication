package com.example.zhoumolianxi03;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wan on 2017/12/3.
 */

public class CustomView extends LinearLayout{
    int postion;
    private ViewPager pager;
    private LinearLayout linear;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0){
                int currentItem = pager.getCurrentItem();
                pager.setCurrentItem(currentItem+1);
                handler.sendEmptyMessageDelayed(0,2000);
            }
        }
    };
    List<ImageView> imgList = new ArrayList<>();
    private List<ImageView> imagelist;

    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.banner,this);
        pager = (ViewPager) findViewById(R.id.pager);
        linear = (LinearLayout) findViewById(R.id.linear);
    }
    public void setData(List<String> data, final List<String> url){
        for (int i=0;i<data.size();i++){
            ImageView imageView = new ImageView(getContext());
            imgList.add(imageView);
            Glide.with(getContext()).load(data.get(i)).into(imageView);

            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),WebviewActivity.class);
                    intent.putExtra("url",url.get(postion));
                    getContext().startActivity(intent);
                }
            });
        }
        Myadapter myadapter = new Myadapter();
        pager.setAdapter(myadapter);
        pager.setCurrentItem(imgList.size()*10000);
        handler.sendEmptyMessageDelayed(0,2000);
        initDoc();
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<imgList.size();i++){
                    if(i==position%imgList.size()){
                        imagelist.get(i).setImageResource(R.drawable.shape01);
                    }else {
                        imagelist.get(i).setImageResource(R.drawable.shape02);

                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initDoc() {
        imagelist = new ArrayList<>();
        linear.removeAllViews();
        imagelist.clear();
        for (int i=0;i<imgList.size();i++){
            ImageView imageView = new ImageView(getContext());
            if(i==0){
                imageView.setImageResource(R.drawable.shape01);
            }else {
                imageView.setImageResource(R.drawable.shape02);
            }
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.setMargins(5,0,5,0);
            linear.addView(imageView,params);
            imagelist.add(imageView);
        }
    }

    class Myadapter extends PagerAdapter{

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imgList.get(position%imgList.size());
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
