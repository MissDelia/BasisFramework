package com.iwhalecloud.mobile.basisframework.userinfo.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.iwhalecloud.mobile.basisframework.R;
import com.iwhalecloud.mobile.basisframework.app.db.bean.User;
import com.iwhalecloud.mobile.basisframework.userinfo.viewmodel.UserInfoViewModel;

import java.util.List;

/**
 * @author MissArisha
 */
public class UserInfoActivity extends AppCompatActivity {

    private UserInfoViewModel mUserInfoViewModel;

    private TextView tvUserName, tvUserAge, tvUserSex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        tvUserName = findViewById(R.id.tv_user_name);
        tvUserAge = findViewById(R.id.tv_user_age);
        tvUserSex = findViewById(R.id.tv_user_sex);
        mUserInfoViewModel = ViewModelProviders.of(this).get(UserInfoViewModel.class);
        mUserInfoViewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                if (users != null && users.size() > 0) {
                    tvUserName.setText(users.get(users.size() - 1).getName());
                    tvUserAge.setText(String.valueOf(users.get(users.size() - 1).getAge()));
                    tvUserSex.setText(users.get(users.size() - 1).getSex());
                }
            }
        });
        findViewById(R.id.btn_add_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User info = new User();
                info.setName("赵");
                info.setAge(13);
                info.setSex("女");
                mUserInfoViewModel.insertUser(info);
            }
        });
    }
}
