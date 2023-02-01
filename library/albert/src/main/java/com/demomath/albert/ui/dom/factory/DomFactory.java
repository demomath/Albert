package com.demomath.albert.ui.dom.factory;

import com.demomath.albert.ui.RenderManager;
import com.demomath.albert.ui.dom.DomButton;
import com.demomath.albert.ui.dom.DomImage;
import com.demomath.albert.ui.dom.DomText;
import com.demomath.albert.ui.dom.DomVerticalLayout;
import com.demomath.albert.ui.dom.common.DomElement;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class DomFactory {

    public static DomElement create(V8Object rootV8Obj) {
        String type = rootV8Obj.getString("type");
        switch (type) {
            case "text":
                DomText domText = new DomText();
                domText.parse(rootV8Obj);
                return domText;
            case "image":
                DomImage domImage = new DomImage();
                domImage.parse(rootV8Obj);
                return domImage;
            case "button":
                DomButton domButton = new DomButton();
                domButton.parse(rootV8Obj);
                return domButton;
            case "verticalLayout":
                DomVerticalLayout domVerticalLayout = new DomVerticalLayout();
                domVerticalLayout.parse(rootV8Obj);
                return domVerticalLayout;
        }
        return null;
    }
}
