package com.example.acostastudio.ui.login;

import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.acostastudio.ConexionSQLite;
import com.example.acostastudio.R;
import com.example.acostastudio.databinding.FragmentLoginBinding;
import com.example.acostastudio.ui.inicio.InicioFragment;

public class loginFragment extends Fragment {

    private FragmentLoginBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        FrameLayout loginLayout = root.findViewById(R.id.login_container);

        Button loginButton = root.findViewById(com.example.acostastudio.R.id.btnLogin);
        TextView forgotten = root.findViewById(R.id.forgottenPassword);
        EditText editMail = root.findViewById(R.id.edit_mail);
        EditText editPsw = root.findViewById(R.id.edit_psw);
        ConexionSQLite sql = new ConexionSQLite(getContext());



        forgotten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_signUp);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correcto = sql.verificarMailPwd(editMail.getText().toString(), editPsw.getText().toString());
                if (correcto){
                    getActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Has iniciado sesión con éxito!", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(v).navigate(R.id.nav_inicio);

                }else{
                    Toast.makeText(getActivity(), "Mail y/o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

}
