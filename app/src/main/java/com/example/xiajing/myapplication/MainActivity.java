package com.example.xiajing.myapplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    private static final String TAG ="=================" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG,"onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
    }


    @Override
    protected void onPause() {
        Log.e(TAG,"onPause");
        super.onPause();
    }


    @Override
    protected void onStop() {

        Log.e(TAG,"onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG,"onRestart");
        super.onRestart();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e(TAG,"onConfigurationChanged");
        Log.e(TAG,newConfig.toString());
        super.onConfigurationChanged(newConfig);
    }
}
