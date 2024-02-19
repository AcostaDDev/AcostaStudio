package com.example.acostastudio.ui.subscription;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.acostastudio.databinding.FragmentSubscriptionBinding;
import com.example.acostastudio.CreditCardTextWatcher;
import com.example.acostastudio.FechCadTextWatcher;
import com.example.acostastudio.R;

public class SubscriptionFragment extends Fragment {

    private FragmentSubscriptionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSubscriptionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        EditText fechCad = root.findViewById(R.id.txtFechCad);
        EditText cardNumber = root.findViewById(R.id.txtCardNumber);
        EditText name = root.findViewById(R.id.txtName);
        EditText cvv = root.findViewById(R.id.txtCVV);

        ImageView imageView2 = root.findViewById(R.id.imageTickFech);
        ImageView imageView = root.findViewById(R.id.imageTickCard);

        Button button = root.findViewById(R.id.btnPay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!cardNumber.getText().toString().isEmpty() && !fechCad.getText().toString().isEmpty() && !name.getText().toString().isEmpty() && !cvv.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Pago realizado", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(v).navigate(R.id.nav_info);
                }else Toast.makeText(getActivity(), "Hay datos sin rellenar", Toast.LENGTH_SHORT).show();

            }
        });

        cardNumber.addTextChangedListener(new CreditCardTextWatcher(cardNumber, imageView));
        fechCad.addTextChangedListener(new FechCadTextWatcher(fechCad, imageView2));



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}