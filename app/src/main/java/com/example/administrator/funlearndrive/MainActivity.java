package com.example.administrator.funlearndrive;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Navigation_bespeak_fragment navigation_bespeak_fragment = null;
    private Navigation_smile_fragment navigation_smile_fragment = null;
    private Navigation_evaluate_fragment navigation_evaluate_fragment = null;
    private Navigation_video_fragment navigation_video_fragment = null;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_bespeak:
                    if (navigation_bespeak_fragment!=null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,navigation_bespeak_fragment).commitAllowingStateLoss();
                    }else {
                        navigation_bespeak_fragment = new Navigation_bespeak_fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,navigation_bespeak_fragment).commitAllowingStateLoss();
                    }
                    return true;

                case R.id.navigation_smile:
                    if(navigation_smile_fragment!=null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,navigation_smile_fragment).commitAllowingStateLoss();
                    }else {
                        navigation_smile_fragment = new Navigation_smile_fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,navigation_smile_fragment).commitAllowingStateLoss();
                    }
                    return true;

                case R.id.navigation_evaluate:
                    if(navigation_evaluate_fragment!=null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,navigation_evaluate_fragment).commitAllowingStateLoss();
                    }else {
                        navigation_evaluate_fragment = new Navigation_evaluate_fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,navigation_evaluate_fragment).commitAllowingStateLoss();
                    }
                    return true;

                case R.id.navigation_video:
                    if(navigation_video_fragment!=null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,navigation_video_fragment).commitAllowingStateLoss();
                    }else {
                        navigation_video_fragment = new Navigation_video_fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,navigation_video_fragment).commitAllowingStateLoss();
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation_bespeak_fragment = new Navigation_bespeak_fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,navigation_bespeak_fragment).commitAllowingStateLoss();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
