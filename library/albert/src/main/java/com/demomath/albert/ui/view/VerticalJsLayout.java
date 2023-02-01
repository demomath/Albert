package com.demomath.albert.ui.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.demomath.albert.ui.dom.DomVerticalLayout;
import com.demomath.albert.ui.view.common.JsView;

public class VerticalJsLayout extends JsView<LinearLayout, DomVerticalLayout> {
    @Override
    public String getType() {
        return "verticalLayout";
    }

    @Override
    public LinearLayout createViewInternal(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        return linearLayout;
    }
}
