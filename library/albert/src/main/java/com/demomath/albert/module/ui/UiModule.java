package com.demomath.albert.module.ui;

import android.content.Context;

import com.demomath.albert.module.JsModule;
import com.demomath.albert.ui.RenderManager;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

import java.util.ArrayList;
import java.util.List;

public class UiModule extends JsModule {
    @Override
    public String getName() {
        return "$view";
    }

    @Override
    public List<String> getFunctionNames() {
        List<String> functionNames = new ArrayList<>();
        functionNames.add("render");
        return functionNames;
    }

    @Override
    public Object execute(Context context, String functionName, V8Array params) {
        switch (functionName) {
            case "render":
                V8Object param1 = params.getObject(0);
                V8Object rootViewObj = param1.getObject("rootView");
                RenderManager.getInstance().render(rootViewObj);
                break;
        }
        return null;
    }
}