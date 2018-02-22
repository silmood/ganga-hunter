package io.bunsan.gangahunter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class GangaFragment extends Fragment {

    private Ganga ganga;

    // Componentes de UI
    private EditText inputName;
    private EditText inputPrice;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializar componentes que no se relacionen con la UI
        ganga = new Ganga();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ganga_form, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputName = view.findViewById(R.id.input_name);
        inputPrice = view.findViewById(R.id.input_price);

        setupInputs();
    }

    private void setupInputs() {
        inputName.addTextChangedListener(new MandatoryListener() {
            @Override
            void onError() {
                String error = getString(R.string.error_empty);
                inputName.setError(error);
            }

            @Override
            void onText(String text) {
                ganga.setName(text);
            }
        });

        inputPrice.addTextChangedListener(new MandatoryListener() {
            @Override
            void onError() {
                String error = getString(R.string.error_empty);
                inputPrice.setError(error);
            }

            @Override
            void onText(String text) {
                ganga.setPrice(Float.valueOf(text));
            }
        });
    }

}
