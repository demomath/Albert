package com.demomath.albert.ui.view.factory;

import com.demomath.albert.ui.dom.common.DomElement;
import com.demomath.albert.ui.view.ButtonJsView;
import com.demomath.albert.ui.view.ImageJsView;
import com.demomath.albert.ui.view.TextJsView;
import com.demomath.albert.ui.view.VerticalJsLayout;
import com.demomath.albert.ui.view.common.JsView;

public class JsViewFactory {

    public static JsView create(DomElement domElement) {
        String type = domElement.type;
        switch (type) {
            case "text":
                TextJsView textJsView = new TextJsView();
                textJsView.setDomElement(domElement);
                return textJsView;
            case "image":
                ImageJsView imageJsView = new ImageJsView();
                imageJsView.setDomElement(domElement);
                return imageJsView;
            case "button":
                ButtonJsView buttonJsView = new ButtonJsView();
                buttonJsView.setDomElement(domElement);
                return buttonJsView;
            case "verticalLayout":
                VerticalJsLayout verticalJsLayout = new VerticalJsLayout();
                verticalJsLayout.setDomElement(domElement);
                return verticalJsLayout;
        }
        return null;
    }
}
