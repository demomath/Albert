package com.demomath.albert;

import android.content.Context;
import android.view.ViewGroup;

import com.demomath.albert.module.ModuleManager;
import com.demomath.albert.ui.RenderManager;

public class Albert {
    private JsContext mJsContext;

    public static Albert init(Context context, ViewGroup containerView) {
        Albert jsApplication = new Albert();
        JsContext jsContext = new JsContext();
        jsApplication.mJsContext = jsContext;
        RenderManager.getInstance().init(context, containerView);
        ModuleManager.getInstance().init(context, jsContext);
        return jsApplication;
    }

    public void run(JsBundle jsBundle) {
        mJsContext.runApplication(jsBundle);
    }

}
