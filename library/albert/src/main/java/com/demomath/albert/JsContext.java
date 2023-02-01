package com.demomath.albert;

import android.util.Log;

import com.eclipsesource.v8.V8;

/**
 * JsContext是对V8引擎的二次封装，用来描述一个JS引擎如何初始化和执行应用JS代码：
 */
public class JsContext {

    private V8 mEngine;

    public JsContext() {
        init();
    }

    private void init() {
        Log.i("albert", "init");
        mEngine = V8.createV8Runtime();
    }

    public V8 getEngine() {
        return mEngine;
    }

    public void runApplication(JsBundle jsBundle) {
        mEngine.executeStringScript(jsBundle.getAppJavaScript());
    }
}
