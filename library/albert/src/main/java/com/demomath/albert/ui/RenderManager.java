package com.demomath.albert.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.demomath.albert.ui.dom.common.DomElement;
import com.demomath.albert.ui.dom.factory.DomFactory;
import com.demomath.albert.ui.view.common.JsView;
import com.demomath.albert.ui.view.factory.JsViewFactory;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class RenderManager {

    private Context mContext;
    private ViewGroup mContainerView;

    private RenderManager() {
    }

    private static class Holder {
        private static final RenderManager INSTANCE = new RenderManager();
    }

    public static RenderManager getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context, ViewGroup containerView) {
        mContext = context;
        mContainerView = containerView;
    }

    public void render(V8Object rootViewObj) {
        DomElement rootDomElement = DomFactory.create(rootViewObj);
        JsView rootJsView = JsViewFactory.create(rootDomElement);
        if (rootJsView != null) {
            View rootView = rootJsView.createView(mContext, mContainerView);
            V8Array childrens = rootViewObj.getArray("children");
            if (rootView instanceof ViewGroup && childrens != null && childrens.length() != 0) {
                for (int i = 0; i < childrens.length(); i++) {
                    V8Object object = childrens.getObject(i);
                    render((ViewGroup) rootView, object);
                }
            }
        }
    }

    public void render(ViewGroup parent, V8Object rootViewObj) {
        DomElement rootDomElement = DomFactory.create(rootViewObj);
        JsView rootJsView = JsViewFactory.create(rootDomElement);
        if (rootJsView != null) {
            View rootView = rootJsView.createView(mContext, parent);
        }
    }
}
