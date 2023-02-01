package com.demomath.albert.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.demomath.albert.ui.dom.DomImage;
import com.demomath.albert.ui.view.common.JsView;
import com.demomath.imageloader.ImageLoader;

public class ImageJsView extends JsView<ImageView, DomImage> {
    @Override
    public String getType() {
        return "image";
    }

    @Override
    public ImageView createViewInternal(Context context) {
        ImageView imageView = new ImageView(context);
        ImageLoader.loadImageView(context, mDomElement.url, imageView);
        return imageView;
    }
}
