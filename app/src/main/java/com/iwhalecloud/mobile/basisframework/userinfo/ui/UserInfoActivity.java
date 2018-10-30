package com.iwhalecloud.mobile.basisframework.userinfo.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.iwhalecloud.mobile.basisframework.R;
import com.iwhalecloud.mobile.basisframework.app.base.BaseActivity;
import com.iwhalecloud.mobile.basisframework.app.db.bean.User;
import com.iwhalecloud.mobile.basisframework.useradd.ui.UserAddActivity;
import com.iwhalecloud.mobile.basisframework.userinfo.viewmodel.UserInfoViewModel;

import java.util.List;

/**
 * @author MissArisha
 */
public class UserInfoActivity extends BaseActivity<UserInfoViewModel> {

    private TextView tvUserName, tvUserAge, tvUserSex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initView();
    }

    @Override
    protected Class<UserInfoViewModel> getViewModelClass() {
        return UserInfoViewModel.class;
    }

    private void initView() {
        tvUserName = findViewById(R.id.tv_user_name);
        tvUserAge = findViewById(R.id.tv_user_age);
        tvUserSex = findViewById(R.id.tv_user_sex);
        getViewModel().getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                if (users != null && users.size() > 0) {
                    tvUserName.setText(users.get(users.size() - 1).getName());
                    tvUserAge.setText(String.valueOf(users.get(users.size() - 1).getAge()));
                    tvUserSex.setText(users.get(users.size() - 1).getSex());
                }
            }
        });
        findViewById(R.id.btn_jump_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserInfoActivity.this, UserAddActivity.class));
            }
        });
    }
}
