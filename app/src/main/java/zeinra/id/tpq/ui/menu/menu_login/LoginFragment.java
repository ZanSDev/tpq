package zeinra.id.tpq.ui.menu.menu_login;

import android.app.Fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import zeinra.id.tpq.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends androidx.fragment.app.Fragment implements View.OnClickListener {

    private EditText etUsername, etPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        // Inflate the layout for this fragment

        etUsername = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.et_password);
        view.findViewById(R.id.btn_login).setOnClickListener(this);

        return view;
    }

    private void userLogin(){

        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty())
        {
            etUsername.setError("Username is required");
            etUsername.requestFocus();
            return;
        }
        if (password.isEmpty())
        {
            etPassword.setError("Password required");
            etPassword.requestFocus();
            return;
        }
        if (password.length() <6 )
        {
            etPassword.setError("Password should be atleast 6 character long");
            etPassword.requestFocus();
            return;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_login:
                userLogin();
                break;
        }
    }
}
