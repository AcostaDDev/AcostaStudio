package com.example.acostastudio;

import android.media.Image;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class CreditCardTextWatcher implements TextWatcher {
    private static final char space = ' ';

    private EditText editText;
    private ImageView tick;

    public CreditCardTextWatcher(EditText editText, ImageView tick) {
        this.editText = editText;
        this.tick = tick;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String pattern = "\\d{4} \\d{4} \\d{4} \\d{4}";
        if (s.toString().matches(pattern)) {
            tick.setVisibility(View.VISIBLE);
        } else {
            editText.setError("Número de tarjeta inválido");
            tick.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() > 0 && (s.length() % 5) == 0) {
            final char c = s.charAt(s.length() - 1);
            if (space == c) {
                s.delete(s.length() - 1, s.length());
            }
        }
        if (s.length() > 0 && (s.length() % 5) == 0) {
            char c = s.charAt(s.length() - 1);
            if (Character.isDigit(c) && TextUtils.split(s.toString(), String.valueOf(space)).length <= 3) {
                s.insert(s.length() - 1, String.valueOf(space));
            }
        }
    }
}

