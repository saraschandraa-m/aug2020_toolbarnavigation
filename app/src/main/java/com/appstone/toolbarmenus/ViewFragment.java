package com.appstone.toolbarmenus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView mTvUserName = view.findViewById(R.id.tv_user_name);
        TextView mTvUserEmail = view.findViewById(R.id.tv_user_email);

        Button mBtnGoBack = view.findViewById(R.id.btn_back);

        Bundle data = getArguments();

        if (data != null) {
            String username = data.getString("USERNAME");
            String email = data.getString("EMAIL");

            mTvUserName.setText(username);
            mTvUserEmail.setText(email);
        }


        mBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }
}
