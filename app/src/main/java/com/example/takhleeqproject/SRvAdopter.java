package com.example.takhleeqproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SRvAdopter extends RecyclerView.Adapter<SRvAdopter.MyViewHolder> {

    List<UserInfo> ls;
    Context c;

    public SRvAdopter(List<UserInfo> ls, Context c) {
        this.ls = ls;
        this.c = c;
    }


    @NonNull
    @Override
    public SRvAdopter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(c).inflate(R.layout.layout_user_row,parent,false);
        return new SRvAdopter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SRvAdopter.MyViewHolder holder, int position) {

        UserInfo mUserInfo = ls.get(position);
        holder._srvUsername.setText(mUserInfo.getName());
        holder._srvEmail.setText(mUserInfo.getEmail());
        holder._srvPhone.setText(mUserInfo.getPhone());

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView _srvUsername;
        TextView _srvEmail;
        TextView _srvPhone;
        LinearLayout ll;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            _srvUsername = itemView.findViewById(R.id.srvUsername);
            _srvEmail = itemView.findViewById(R.id.srvEmail);
            _srvPhone = itemView.findViewById(R.id.srvPhone);
            ll = itemView.findViewById(R.id.SearchRowLayout);
        }
    }
}
