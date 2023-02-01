package com.demomath.albert.ui.dom;

import com.demomath.albert.ui.dom.common.DomElement;
import com.eclipsesource.v8.V8Object;

public class DomVerticalLayout extends DomElement {

    @Override
    public void parse(V8Object v8Object) {
        super.parse(v8Object);
        for (String key : v8Object.getKeys()) {
            switch (key) {
                default:
                    break;
            }
        }
    }
}
