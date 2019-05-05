package com.example.jr.lab_4_expandedactivity;

import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.prefs.PreferencesFactory;

public class MainActivity extends AppCompatActivity {
    private static final int menu_setting = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.app.FragmentManager frangmentManager = getFragmentManager();
        android.app.FragmentTransaction transaction = frangmentManager.beginTransaction();
        PreFragment preFragment = new PreFragment();

        transaction.replace(android.R.id.content, preFragment).addToBackStack(null);
        transaction.commit();
    }
}
