package com.example.acostastudio.ui.info;


import android.animation.LayoutTransition;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;


import com.example.acostastudio.R;
import com.example.acostastudio.databinding.FragmentInfoBinding;
import com.example.acostastudio.ui.adapter.VPAdapter;
import com.example.acostastudio.ui.item.ViewPagerItem;

import java.util.ArrayList;

public class InfoFragment extends Fragment {
    private FragmentInfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button = root.findViewById(com.example.acostastudio.R.id.buttonSub);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_subscription);
            }
        });


        ViewPager2 viewPager2 = root.findViewById(R.id.viewPager);
        ArrayList<ViewPagerItem> viewPagerItemArrayList = new ArrayList<>();
        String[] titulos = {getResources().getString(R.string.titulo1)
                            ,getResources().getString(R.string.titulo2)};

        String[] contenidos = {getResources().getString(R.string.historia_detras_empresa)
                                ,getResources().getString(R.string.contenido2)};

        for (int i = 0; i < titulos.length; i++) {
            ViewPagerItem viewPagerItem = new ViewPagerItem(titulos[i],contenidos[i]);
            viewPagerItemArrayList.add(viewPagerItem);
        }

        VPAdapter vpAdapter = new VPAdapter(viewPagerItemArrayList);
        viewPager2.setAdapter(vpAdapter);



        return root;

    }

}