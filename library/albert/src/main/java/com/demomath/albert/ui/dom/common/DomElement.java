package com.demomath.albert.ui.dom.common;

import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;

/**
 * 视图元素可以有公用的属性
 */
public class DomElement {

    public String type;
    public int width;
    public int height;
    public int marginTop;
    public int marginBottom;
    public int marginLeft;
    public int marginRight;
    public V8Function onClick;

    public void parse(V8Object v8Object) {
        for (String key : v8Object.getKeys()) {
            switch (key) {
                case "type":
                    this.type = v8Object.getString("type");
                    break;
                case "width":
                    this.width = v8Object.getInteger("width");
                    break;
                case "height":
                    this.height = v8Object.getInteger("height");
                    break;
                case "marginTop":
                    this.marginTop = v8Object.getInteger("marginTop");
                    break;
                case "marginBottom":
                    this.marginBottom = v8Object.getInteger("marginBottom");
                    break;
                case "marginLeft":
                    this.marginLeft = v8Object.getInteger("marginLeft");
                    break;
                case "marginRight":
                    this.marginRight = v8Object.getInteger("marginRight");
                    break;
                case "onClick":
                    this.onClick = (V8Function) v8Object.get("onClick");
                    break;
                default:
                    break;
            }
        }
    }
}
