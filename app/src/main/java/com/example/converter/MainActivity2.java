package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    //07df5425dc784999ba11c8448eee7590
    float x1,x2,y1,y2;
    //now create list of type slider items
    List<sliderItems> sliderItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.verticalViewPager);
//add some images in sliderItems and pass this list to our adapter...
        for(int i=1;i<=200;i++) {
            sliderItems.add(new sliderItems(R.drawable.ic_launcher_background));

        }
        verticalViewPager.setAdapter(new ViewPagerAdapter( MainActivity2. this, sliderItems));
    }

//    public boolean onTouchEvent(MotionEvent touchEvent){
//        switch(touchEvent.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                x1 = touchEvent.getX();
//                y1 = touchEvent.getY();
//                break;
//            case MotionEvent.ACTION_UP:
//                x2 = touchEvent.getX();
//                y2 = touchEvent.getY();
//                if(x1 < x2){
//                Intent i = new Intent(MainActivity.this, MainActivity2.class);
//                startActivity(i);
//            }else if(x1 > x2){
//                Intent i = new Intent(MainActivity.this, MainActivity3.class);
//                startActivity(i);
//            }
//            break;
//        }
//        return false;
//    }
}


