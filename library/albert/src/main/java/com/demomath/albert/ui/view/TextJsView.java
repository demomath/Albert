package com.demomath.albert.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.demomath.albert.ui.dom.DomText;
import com.demomath.albert.ui.view.common.JsView;
import com.demomath.albert.utils.DisplayUtil;

public class TextJsView extends JsView<TextView, DomText> {

    @Override
    public String getType() {
        return "text";
    }

    @Override
    public TextView createViewInternal(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setText(mDomElement.text);
        textView.setTextSize(DisplayUtil.dip2px(context, mDomElement.textSize));
        textView.setTextColor(Color.parseColor(mDomElement.textColor));
        return textView;
    }


}
