package com.demo.floatwindowdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private Context context;
    public List<ImageView> views;

    public MyPagerAdapter(Context context ,List<ImageView> list) {
        this.context = context;
        views = list;
    }

    @Override
    public int getCount() {
        return views.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        View view = View.inflate(context, R.layout.vp,null);
        ImageView iv = views.get(position);
        container.addView(iv);
        return iv;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container,position,object); 这一句要删除，否则报错
        container.removeView((View)object);
    }
    public void setData(List<ImageView> newList){
    views=newList;

    }



}
