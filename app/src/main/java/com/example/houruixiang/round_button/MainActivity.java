package com.example.houruixiang.round_button;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends ActionBarActivity {




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            /**设置图标*/
            final ImageView fabIconNew = new ImageView(this);
            fabIconNew.setScaleX(0.5f);
            fabIconNew.setScaleY(0.5f);
            fabIconNew.setImageDrawable(getResources().getDrawable(R.drawable.btn_selector));

            final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(this)
                    .setContentView(fabIconNew)
                    /**设定按钮的位置*/
                    .setPosition(FloatingActionButton.POSITION_RIGHT_CENTER)
                    .build();

            SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
            ImageView rlIcon1 = new ImageView(this);
            ImageView rlIcon2 = new ImageView(this);
            ImageView rlIcon3 = new ImageView(this);
            ImageView rlIcon4 = new ImageView(this);

            /**设置浮动按妞*/
           /* FloatingActionButton.LayoutParams btn_params = new FloatingActionButton.LayoutParams(50,50);
            btn_params.setMargins(100,300,150,350);
            rLSubBuilder.setLayoutParams(btn_params);*/

            rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.eat));
            rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.friend));
            rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.study));
            rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.play));

            final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this)
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon1).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
                    .attachTo(rightLowerButton)
                    .build();

           /* final FloatingActionButton leftCenterButton = new FloatingActionButton.Builder(this)
                    .setContentView(fabIconStar, fabIconStarParams)
                    .setBackgroundDrawable(R.drawable.button_action_red_selector)
                    .setPosition(FloatingActionButton.POSITION_LEFT_CENTER)
                    .setLayoutParams(starParams)
                    .build();*/

            /**浮动菜单*/
            rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
                @Override
                public void onMenuOpened(FloatingActionMenu menu) {

                    fabIconNew.setRotation(0);
                    /**set 浮动按钮  0--->45*/
                    PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                    ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                    animation.start();
                }

                @Override
                public void onMenuClosed(FloatingActionMenu menu) {
                   /**同上*/
                    fabIconNew.setRotation(45);
                    PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                    ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                    animation.start();
                }
            });

    }
}
