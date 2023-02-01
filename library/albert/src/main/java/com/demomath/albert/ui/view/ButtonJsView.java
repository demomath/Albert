package com.demomath.albert.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.demomath.albert.ui.dom.DomButton;
import com.demomath.albert.ui.view.common.JsView;
import com.demomath.albert.utils.DisplayUtil;
import com.eclipsesource.v8.V8Function;

public class ButtonJsView extends JsView<Button, DomButton> {

    @Override
    public String getType() {
        return "button";
    }

    @Override
    public Button createViewInternal(Context context) {
        Button button = new Button(context);
        button.setGravity(Gravity.CENTER);
        button.setText(mDomElement.text);
        button.setTextSize(DisplayUtil.dip2px(context, mDomElement.textSize));
        button.setTextColor(Color.parseColor(mDomElement.textColor));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                V8Function onClick = mDomElement.onClick;
                if (onClick != null) {
                    onClick.call(null, null);
                }
            }
        });
        return button;
    }
}
