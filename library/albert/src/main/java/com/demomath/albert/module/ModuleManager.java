package com.demomath.albert.module;

import android.content.Context;

import com.demomath.albert.JsBundle;
import com.demomath.albert.JsContext;
import com.demomath.albert.module.fun.ConsoleModule;
import com.demomath.albert.module.ui.UiModule;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final String TAG = "Albert";
    private final List<JsModule> mModuleList = new ArrayList<>();
    private JsContext mJsContext;
    private Context mContext;

    private ModuleManager() {
    }

    private static class Holder {
        private static final ModuleManager INSTANCE = new ModuleManager();
    }

    public static ModuleManager getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context, JsContext jsContext) {
        this.mContext = context;
        this.mJsContext = jsContext;
        this.mModuleList.add(new UiModule());
        this.mModuleList.add(new ConsoleModule());
        registerModules();
    }

    private void registerModules() {
        for (JsModule module : mModuleList) {
            V8Object moduleObj = new V8Object(mJsContext.getEngine());
            for (String functionName : module.getFunctionNames()) {
                moduleObj.registerJavaMethod(new JavaCallback() {
                    @Override
                    public Object invoke(V8Object v8Object, V8Array v8Array) {
                        return module.execute(mContext, functionName, v8Array);
                    }
                }, functionName);
            }
            mJsContext.getEngine().add(module.getName(), moduleObj);
        }
    }

    public void executeStringScript(JsBundle jsBundle) {
        mJsContext.getEngine().executeStringScript(jsBundle.getAppJavaScript());
    }
}
