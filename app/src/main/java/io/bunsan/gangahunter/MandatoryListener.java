package io.bunsan.gangahunter;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class MandatoryListener implements TextWatcher{

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.length() == 0){
            onError();
        } else {
            onText(charSequence.toString());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {}
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }


    abstract void onError();

    abstract void onText(String text);
}
