package com.bawei.weektwomn.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weektwomn.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Disposable mDisposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvCountDown = findViewById(R.id.tv_time);

        // 倒计时 10s
        mDisposable = Flowable.intervalRange(0, 4, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d(TAG, "倒计时");

                        tvCountDown.setText("倒计时 " + String.valueOf(3 - aLong) + " 秒");
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "倒计时完毕");
                        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }
                })
                .subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
