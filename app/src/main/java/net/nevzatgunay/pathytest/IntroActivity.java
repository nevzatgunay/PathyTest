package net.nevzatgunay.pathytest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by Nevzat on 3/17/2017.
 */

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
/*
        addSlide(SampleSlide.newInstance(R.layout.slide_1));
        addSlide(SampleSlide.newInstance(R.layout.slide_2));
        addSlide(SampleSlide.newInstance(R.layout.slide_3));
*/
        addSlide(AppIntroFragment.newInstance("Easily", "find your travel buddy...", R.drawable.snoppy_easy, ContextCompat.getColor(this,R.color.colorPurple)));
        addSlide(AppIntroFragment.newInstance("Cheaper", "share your car and...", R.drawable.snoppy_cheap, ContextCompat.getColor(this,R.color.colorAccent)));
        addSlide(AppIntroFragment.newInstance("Quickly", "go forever where you want...", R.drawable.snoppy_quick, ContextCompat.getColor(this,R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Happy", "be happy like Snoppy :)", R.drawable.snoppy_happy, ContextCompat.getColor(this,R.color.colorPink)));


        //setDepthAnimation();

        setSeparatorColor(Color.parseColor("#FFFFFF"));



    }

    @Override
    public void onSkipPressed(Fragment currentFragment){
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment){
        super.onDonePressed(currentFragment);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment){
        super.onSlideChanged(oldFragment,newFragment);
    }
}
