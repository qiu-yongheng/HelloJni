package com.qyh.hellojni;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * @author 邱永恒
 * @time 2018/3/25  15:51
 * @desc ${TODO}
 */


public class MainActivity extends AppCompatActivity{
    static {
        /**
         * 加载动态库libhelloJni.so
         * 加载so文件，不要带上前缀lib和后缀.so
         */
        System.loadLibrary("helloJni");
    }

    /**
     * 定义本地方法接口，这个方法类似虚方法，实现是用c或者c++实现的
     * @return
     */
    public native String get();
    public native void set(String str);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv_hello);
        textView.setText(get());
        set("hello world form MainActivity");
    }
}
