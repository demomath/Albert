package com.demomath.albert.module;

import android.content.Context;

import com.eclipsesource.v8.V8Array;

import java.util.List;

public abstract class JsModule {
    public abstract String getName();

    public abstract List<String> getFunctionNames();

    public abstract Object execute(Context context, String functionName, V8Array params);
}
