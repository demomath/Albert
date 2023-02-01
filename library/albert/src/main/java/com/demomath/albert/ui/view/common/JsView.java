package com.demomath.albert.ui.view.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.demomath.albert.ui.dom.common.DomElement;
import com.demomath.albert.utils.DisplayUtil;

public abstract class JsView<V extends View, D extends DomElement> {

    protected D mDomElement;
    protected V mNativeView;

    public void setDomElement(DomElement domElement) {
        mDomElement = (D) domElement;
    }

    public abstract String getType();

    public abstract V createViewInternal(Context context);

    public void settingViewLayoutParams(Context context, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) layoutParams;
            if (mDomElement.width >= 0) {
                layoutParams.width = DisplayUtil.dip2px(context, mDomElement.width);
            } else {
                layoutParams.width = mDomElement.width;
            }
            if (mDomElement.height >= 0) {
                layoutParams.height = DisplayUtil.dip2px(context, mDomElement.height);
            } else {
                layoutParams.height = mDomElement.height;
            }
            p.setMargins(DisplayUtil.dip2px(context, mDomElement.marginLeft),
                    DisplayUtil.dip2px(context, mDomElement.marginTop),
                    DisplayUtil.dip2px(context, mDomElement.marginRight),
                    DisplayUtil.dip2px(context, mDomElement.marginBottom));
            view.setLayoutParams(p);
        }
    }

    public V createView(Context context, ViewGroup parent) {
        V view = createViewInternal(context);
        parent.addView(view);
        settingViewLayoutParams(context, view);
        mNativeView = view;
        return view;
    }
}