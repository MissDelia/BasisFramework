package com.iwhalecloud.mobile.basisframework.userinfo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iwhalecloud.mobile.basisframework.R;
import com.iwhalecloud.mobile.basisframework.app.db.bean.User;

import java.util.List;

/**
 * 用户列表Adapter
 * @author MissArisha
 */
public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder> {

    private List<User> mList;

    public void setData(List<User> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_info, viewGroup, false);

        return new UserInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserInfoViewHolder viewHolder, int i) {
        if (mList != null) {
            User info = mList.get(i);
            viewHolder.tvUserName.setText(info.getName());
            viewHolder.tvUserAge.setText(String.valueOf(info.getAge()));
            viewHolder.tvUserSex.setText(info.getSex());
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class UserInfoViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserName, tvUserAge, tvUserSex;

        UserInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.item_user_name);
            tvUserAge = itemView.findViewById(R.id.item_user_age);
            tvUserSex = itemView.findViewById(R.id.item_user_sex);
        }
    }

}
