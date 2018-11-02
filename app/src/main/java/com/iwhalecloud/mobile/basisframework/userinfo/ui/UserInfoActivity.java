package com.iwhalecloud.mobile.basisframework.userinfo.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.iwhalecloud.mobile.basisframework.R;
import com.iwhalecloud.mobile.basisframework.app.base.BaseActivity;
import com.iwhalecloud.mobile.basisframework.app.db.bean.User;
import com.iwhalecloud.mobile.basisframework.useradd.ui.UserAddActivity;
import com.iwhalecloud.mobile.basisframework.userinfo.adapter.UserInfoAdapter;
import com.iwhalecloud.mobile.basisframework.userinfo.viewmodel.UserInfoViewModel;

import java.util.List;

/**
 * @author MissArisha
 */
public class UserInfoActivity extends BaseActivity<UserInfoViewModel> {

    private UserInfoAdapter mAdapter;

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
        RecyclerView mUserList = findViewById(R.id.rv_user_list);
        mAdapter = new UserInfoAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mUserList.setLayoutManager(layoutManager);
        mUserList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mUserList.setAdapter(mAdapter);

        getViewModel().getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                mAdapter.setData(users);
            }
        });
        findViewById(R.id.btn_jump_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(UserAddActivity.class);
            }
        });
    }
}
