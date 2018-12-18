package com.example.convenientbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemCListener {


    List<String> list ;

    ConvenientBanner convenientBanner;

    ProgressBar progressBar;

    TextView tv_progress;

    LinearLayout liner;
    LinearLayout linear_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convenientBanner = findViewById(R.id.convenientBanner);
        progressBar = findViewById(R.id.progressBar);
        tv_progress = findViewById(R.id.tv_progress);
        liner = findViewById(R.id.linear);
        linear_2 = findViewById(R.id.linear_2);


        initview();

    }

    private void initview() {

        list = new ArrayList<>();

        list.add("http://hzzll-test-private.oss-cn-shanghai.aliyuncs.com/UploadRoot/1/20180117/009e8592232c425cda28d248e4bd1938.png");
        list.add("http://hzzll-test-private.oss-cn-shanghai.aliyuncs.com/UploadRoot/1/20180210/d3ff1d313e24d4135f2ebd1532cc52de.png");
        list.add("http://hzzll-test-private.oss-cn-shanghai.aliyuncs.com/UploadRoot/1/20180117/009e8592232c425cda28d248e4bd1938.png");
        list.add("http://hzzll-test-private.oss-cn-shanghai.aliyuncs.com/UploadRoot/1/20180210/d3ff1d313e24d4135f2ebd1532cc52de.png");



        convenientBanner.setPages(new CBViewHolderCreator<ImageBannerView>() {
            @Override
            public ImageBannerView createHolder() {
                return new ImageBannerView();}
        }, list);
        convenientBanner.setPageIndicator(new int[]{R.drawable.dot_tab_grey, R.drawable.dot_tab_yellow})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this);

        convenientBanner.setFocusable(true);
        convenientBanner.setFocusableInTouchMode(true);
        convenientBanner.requestFocus();
        convenientBanner.startTurning(3000);


//        progressBar.


        new Thread(){
            @Override
            public void run() {
                int i=0;
                while(i<100){
                    i++;
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final int j=i;
                    progressBar.setProgress(i);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_progress.setText(j+"%");
                        }
                    });
                }
            }
        }.start();


        setGestureListener();



        linear_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear_2.setVisibility(View.GONE);
            }
        });

    }


    @Override
    public void onItemClick(int position) {

    }






    float mPosX;
    float mPosY;
    float mCurPosX;
    float mCurPosY;




    private void setGestureListener(){
        liner.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        mPosX = event.getX();
                        mPosY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mCurPosX = event.getX();
                        mCurPosY = event.getY();

                        break;
                    case MotionEvent.ACTION_UP:
                        if (mCurPosY - mPosY > 0
                                && (Math.abs(mCurPosY - mPosY) > 25)) {
                            //向下滑動

                            linear_2.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this,"向下滑了",Toast.LENGTH_LONG).show();
                        } else if (mCurPosY - mPosY < 0
                                && (Math.abs(mCurPosY - mPosY) > 25)) {

                            linear_2.setVisibility(View.GONE);
                            //向上滑动
//                            collapse();
                        }

                        break;
                }
                return true;
            }

        });
    }









}
