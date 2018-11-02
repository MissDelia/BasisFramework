package com.iwhalecloud.mobile.basisframework.useradd.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

import com.iwhalecloud.mobile.basisframework.R;
import com.iwhalecloud.mobile.basisframework.app.base.BaseActivity;
import com.iwhalecloud.mobile.basisframework.app.db.bean.User;
import com.iwhalecloud.mobile.basisframework.app.util.LogUtil;
import com.iwhalecloud.mobile.basisframework.app.util.ToastUtil;
import com.iwhalecloud.mobile.basisframework.useradd.viewmodel.UserAddViewModel;

public class UserAddActivity extends BaseActivity<UserAddViewModel> {

    private EditText etName, etAge, etSex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        initView();
        LogUtil.getInstance().e("我在这里发出了一次吐司");
    }

    private void initView() {
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etSex = findViewById(R.id.et_sex);
        findViewById(R.id.btn_add_user_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User info = new User();
                info.setName(etName.getText().toString());
                info.setAge(Integer.parseInt(etAge.getText().toString()));
                info.setSex(etSex.getText().toString());
                getViewModel().insertUser(info);
                ToastUtil.getInstance().showToast("添加用户成功", Gravity.CENTER);
                etName.setText("");
                etAge.setText("");
                etSex.setText("");
            }
        });
    }

    @Override
    protected Class<UserAddViewModel> getViewModelClass() {
        return UserAddViewModel.class;
    }
}
