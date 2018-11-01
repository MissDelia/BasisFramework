package com.iwhalecloud.mobile.basisframework.app.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * @author MissArisha
 */
public class ToastTextView extends AppCompatTextView {
    public ToastTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init(Color.argb(200, 60, 60, 60));
    }

    public ToastTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(Color.argb(200, 60, 60, 60));
    }

    public ToastTextView(Context context) {
        super(context);
        this.init(Color.argb(200, 60, 60, 60));
    }

    public ToastTextView(Context context, int color) {
        super(context);
        this.init(color);
    }

    private void init(int color) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(color);
        drawable.setCornerRadius(8.0F);
        this.setBackground(drawable);
        this.setPadding(15, 15, 15, 15);
        this.setTextColor(-1);
    }
}
