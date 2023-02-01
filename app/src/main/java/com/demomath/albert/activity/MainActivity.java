package com.demomath.albert.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.demomath.albert.Albert;
import com.demomath.albert.R;
import com.demomath.albert.JsBundle;
import com.demomath.albert.utils.AssetsUtil;

public class MainActivity extends Activity {


    private FrameLayout mRootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
        mRootView = findViewById(R.id.root_view);
        Albert albert = Albert.init(this, mRootView);
        JsBundle jsBundle = new JsBundle();
        jsBundle.setAppJavaScript("console.info(\"print some messages!\")");
        albert.run(jsBundle);


        JsBundle jsViewBundle = new JsBundle();
        String jsFromAssets = AssetsUtil.getJsFromAssets(this, "activity/MainActivity.js");
        Log.e("Ablert", jsFromAssets);
        jsViewBundle.setAppJavaScript(jsFromAssets);
        albert.run(jsViewBundle);
    }
}
