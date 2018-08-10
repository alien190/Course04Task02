package com.example.alien.course04task02.ui.common.bulder;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageViewBulder {
    private int id = 0;
    private int imageResource = 0;
    private int layoutWidth = -2;
    private int layoutHeight = -2;
    private ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;

    public ImageViewBulder setId(int id) {
        this.id = id;
        return this;
    }

    public ImageViewBulder setImageResource(int imageResource) {
        this.imageResource = imageResource;
        return this;
    }

    public ImageViewBulder setLayoutWidth(int layoutWidth) {
        this.layoutWidth = layoutWidth;
        return this;
    }

    public ImageViewBulder setLayoutHeight(int layoutHeight) {
        this.layoutHeight = layoutHeight;
        return this;
    }

    public ImageViewBulder setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    public ImageView build(Context context) {
        ImageView imageView = new ImageView(context);
        if (id != 0) imageView.setId(id);
        if (imageResource != 0) imageView.setImageResource(imageResource);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(layoutWidth,
                layoutHeight);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(scaleType);
        return imageView;
    }
}
