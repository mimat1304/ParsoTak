package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.collection.CircularArray;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import java.util.List;


public class ViewPagerAdapter extends PagerAdapter {

    VerticalViewPager verticalViewPager ;
    Context context;
    List<sliderItems>sliderItems;
    LayoutInflater mLayoutInflater;
    int newposition;
    float x1,x2;
    public ViewPagerAdapter(Context context,List<sliderItems>sliderItems){
        this.context=context;
        this.sliderItems=sliderItems;
        mLayoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {return sliderItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((LinearLayout)object);
    }

    @NonNull
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView=mLayoutInflater.inflate(R.layout.item_layout,container,false);
        ImageView imageView=itemView.findViewById(R.id.imageView);
        imageView.setImageResource(sliderItems.get(position).getImage());
//        verticalViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                newposition = position;
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        verticalViewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction())
//                {
//                    case MotionEvent.ACTION_DOWN:
//                        x1=event.getX();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        x2=event.getX();
//                        float deltaX=x1-x2;
//                        if(deltaX>300)
//                        {
//                            Intent i=new Intent(context,MainActivity3.class);
//                            if(position==1) {
//                                context.startActivity(i);
//                            }
//                            else context.startActivity(i);
//                        }
//                        break;
//                }
//                return false;
//            }
//        });
        container.addView(itemView);
        return itemView;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
