package com.example.acostastudio.ui.inicio;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.example.acostastudio.R;
import com.example.acostastudio.databinding.FragmentInicioBinding;
import com.example.acostastudio.databinding.FragmentSubscriptionBinding;


public class InicioFragment extends Fragment {

    private FragmentInicioBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentInicioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        VideoView video = root.findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.presentacion);
        video.setVideoURI(uri); // Establece la URI del VideoView
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0f, 0f); // Volumen cero en ambos canales
            }
        });
        video.start();

        Button sub = root.findViewById(R.id.btnSub);
        Button btn = root.findViewById(R.id.btnMaps);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri1 = Uri.parse("https://maps.app.goo.gl/BRRgcKtGjdBhRg2W8");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri1);
                startActivity(intent);
            }
        });

        sub.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.nav_subscription));

        return root;
    }

}