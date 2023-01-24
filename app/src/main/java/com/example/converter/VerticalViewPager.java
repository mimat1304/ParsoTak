package com.example.converter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class VerticalViewPager extends ViewPager {

    public static Object setOnTouchListener;

    public VerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setPageTransformer(true,new VerticalPageTransformer());
       setOverScrollMode(OVER_SCROLL_NEVER);
    }
        private class VerticalPageTransformer implements ViewPager.PageTransformer{
        @Override
        public void transformPage(@NonNull View page, float position) {
        if(position<-1){
            page.setAlpha(0);
        }
        else if(position<=0)
        {
            page.setAlpha(1);
            page.setTranslationX(page.getWidth()*-position);
            float yposition=position*page.getHeight();
            page.setTranslationY(yposition);
            page.setScaleX(1);
            page.setScaleY(1);
        }
        else if(position<=1)
        {
            page.setTranslationX(page.getWidth()*-position);
            float scale=0.75f+(1-0.75f)*(1-Math.abs(position));
            page.setScaleX(scale);
            page.setScaleY(scale);
        }
        else{
            page.setAlpha(0);
        }
            
        }
    }
    private MotionEvent swapXYCoordinates(MotionEvent event){
        float width=getWidth();
        float height=getHeight();
        float newX=(event.getY()/height)*width;
        float newY=(event.getX()/width)*height;
        event.setLocation(newX,newY);
        return event;
    }
    public boolean onInterceptTouchEvent(MotionEvent ev){
        boolean intercepted =super.onInterceptTouchEvent((swapXYCoordinates(ev)));
        swapXYCoordinates(ev);
        return intercepted;
    }
    public boolean onTouchEvent(MotionEvent ev)
    {
        return super.onTouchEvent(swapXYCoordinates(ev));

    }
}
