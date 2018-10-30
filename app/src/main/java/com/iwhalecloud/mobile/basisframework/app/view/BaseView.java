package com.iwhalecloud.mobile.basisframework.app.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 虽然暂时不知道有什么卵用，但是自定义的View必须继承此类
 * @author MissArisha
 */
public class BaseView extends View {

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

}
