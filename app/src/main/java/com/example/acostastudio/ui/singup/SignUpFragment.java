package com.example.acostastudio.ui.singup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acostastudio.ConexionSQLite;
import com.example.acostastudio.databinding.FragmentSignUpBinding;
import com.example.acostastudio.MainActivity;
import com.example.acostastudio.R;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        EditText psw1 = root.findViewById(R.id.singUp_psw);
        EditText psw2 = root.findViewById(R.id.singUp_psw2);
        EditText mail = root.findViewById(R.id.singUp_mail);
        Button signupButton = root.findViewById(R.id.btnSingUp);
        ConexionSQLite sql = new ConexionSQLite(getContext());

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mail.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Error: No ha proporcionado un email", Toast.LENGTH_SHORT).show();
                } else if (psw1.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Error: No ha proporcionado una contraseña", Toast.LENGTH_SHORT).show();
                } else if (!psw1.getText().toString().equals(psw2.getText().toString())) {
                    Toast.makeText(getActivity(), "Error: Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
                } else if (psw1.getText().toString().equals(psw2.getText().toString())) {
                    if(sql.verificarMail(mail.getText().toString())){
                        Toast.makeText(getActivity(), "El usuario ya existe", Toast.LENGTH_SHORT).show();
                    }
                    if(sql.insertValues(mail.getText().toString(), psw1.getText().toString())){
                        Navigation.findNavController(v).navigate(R.id.nav_log_In);
                        Toast.makeText(getActivity(), "Usuario registrado correctamente!", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(getActivity(), "El registro ha fallado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}