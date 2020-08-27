package com.appstone.toolbarmenus;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final EditText mEtUserName = view.findViewById(R.id.et_user_name);
        final EditText mEtUserEmail = view.findViewById(R.id.et_user_email);

        Button mEtButton = view.findViewById(R.id.btn_edit);
        Button mBtnMoveToBottomNav = view.findViewById(R.id.btn_move_bottom_nav);

        mEtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mEtUserName.getText().toString();
                String email = mEtUserEmail.getText().toString();

                Bundle data = new Bundle();
                data.putString("USERNAME", username);
                data.putString("EMAIL", email);

                ViewFragment viewFragment = new ViewFragment();
                viewFragment.setArguments(data);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, viewFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        mBtnMoveToBottomNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mEtUserName.getText().toString();
                String email = mEtUserEmail.getText().toString();

                Intent navIntent = new Intent(getActivity(), BottomNavActivity.class);
                navIntent.putExtra("USERNAME", username);
                navIntent.putExtra("EMAIL", email);

                getActivity().startActivity(navIntent);
            }
        });


    }
}
