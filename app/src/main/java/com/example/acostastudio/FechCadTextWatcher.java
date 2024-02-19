package com.example.acostastudio;

import android.media.Image;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class FechCadTextWatcher implements TextWatcher {
    private static final char space = '/';

    private EditText editText;
    private ImageView imageView;

    public FechCadTextWatcher(EditText editText, ImageView imageView) {
        this.editText = editText;
        this.imageView = imageView;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String pattern = "\\d{2}/\\d{2}";
        if(s.length() == 5){
            int month = Integer.parseInt(s.toString().substring(0,2));
            int year = Integer.parseInt(s.toString().substring(3));
            if (s.toString().matches(pattern) && month <= 12 && year >= 24) {
                imageView.setVisibility(View.VISIBLE);
            } else {
                editText.setError("Fecha de caducidad erronea");
                imageView.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() > 0 && (s.length() % 3) == 0) {
            final char c = s.charAt(s.length() - 1);
            if (space == c) {
                s.delete(s.length() - 1, s.length());
            }
        }
        if (s.length() > 0 && (s.length() % 3) == 0) {
            char c = s.charAt(s.length() - 1);
            if (Character.isDigit(c) && TextUtils.split(s.toString(), String.valueOf(space)).length <= 3) {
                s.insert(s.length() - 1, String.valueOf(space));
            }
        }
    }
}

