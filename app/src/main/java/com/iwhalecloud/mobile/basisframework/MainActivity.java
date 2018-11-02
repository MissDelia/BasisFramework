package com.iwhalecloud.mobile.basisframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iwhalecloud.mobile.basisframework.app.base.BaseActivity;
import com.iwhalecloud.mobile.basisframework.userinfo.ui.UserInfoActivity;

/**
 * @author MissArisha
 */
public class MainActivity extends BaseActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGoUserInfo = findViewById(R.id.btn_go_user_info);
        btnGoUserInfo.setText(this.stringFromJNI());
        btnGoUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO --Now go to info interface
                goActivity(UserInfoActivity.class);
            }
        });
    }

    @Override
    protected Class getViewModelClass() {
        return null;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
