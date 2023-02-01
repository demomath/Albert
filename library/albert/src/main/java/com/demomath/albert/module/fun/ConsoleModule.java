package com.demomath.albert.module.fun;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.demomath.albert.module.JsModule;
import com.demomath.albert.module.ModuleManager;
import com.eclipsesource.v8.V8Array;

import java.util.ArrayList;
import java.util.List;

public class ConsoleModule extends JsModule {

    @Override
    public String getName() {
        return "console";
    }

    @Override
    public List<String> getFunctionNames() {
        List<String> functions = new ArrayList<>();
        functions.add("info");
        functions.add("toast");
        return functions;
    }

    @Override
    public Object execute(Context context, String functionName, V8Array params) {
        switch (functionName) {
            case "info":
                Log.i(ModuleManager.TAG, params.getString(0));
                break;
            case "toast":
                Toast.makeText(context, params.getString(0), Toast.LENGTH_SHORT).show();
                break;
        }
        return null;
    }
}
