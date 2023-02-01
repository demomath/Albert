package com.demomath.albert.ui.dom;

import android.text.TextUtils;

import com.demomath.albert.ui.dom.common.DomElement;
import com.eclipsesource.v8.V8Object;

public class DomButton extends DomElement {
    public String text;
    public int textSize;
    public String textColor;

    @Override
    public void parse(V8Object v8Object) {
        super.parse(v8Object);
        for (String key : v8Object.getKeys()) {
            switch (key) {
                case "text":
                    this.text = v8Object.getString("text");
                    break;
                case "textSize":
                    int textSize = v8Object.getInteger("textSize");
                    if (textSize == 0) {
                        textSize = 16;
                    }
                    this.textSize = textSize;
                    break;
                case "textColor":
                    String textColor = v8Object.getString("textColor");
                    if (TextUtils.isEmpty(textColor)) {
                        textColor = "#000000";
                    }
                    this.textColor = textColor;
                    break;
                default:
                    break;
            }
        }
    }
}
