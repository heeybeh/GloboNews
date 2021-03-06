package com.example.beatrice.globonews;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.beatrice.globonews.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static ViewPager viewPager;
    private static ActionBar actionBar;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_content);

        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_content, new MainFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }


}