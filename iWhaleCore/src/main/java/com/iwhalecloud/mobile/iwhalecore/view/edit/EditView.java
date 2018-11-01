package com.iwhalecloud.mobile.iwhalecore.view.edit;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class EditView extends AppCompatEditText {
    public EditView(Context context) {
        super(context);
    }

    public EditView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
