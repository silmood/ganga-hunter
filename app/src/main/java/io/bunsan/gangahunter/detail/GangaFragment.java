package io.bunsan.gangahunter.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import io.bunsan.gangahunter.R;
import io.bunsan.gangahunter.common.MandatoryListener;
import io.bunsan.gangahunter.model.Ganga;


public class GangaFragment extends Fragment {

    public static final String TAG = "ganga_detail";

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void setupInputs() {
        inputName.addTextChangedListener(new MandatoryListener() {
            @Override
            public void onError() {
                String error = getString(R.string.error_empty);
                inputName.setError(error);
            }

            @Override
            public void onText(String text) {
                ganga.setName(text);
            }
        });

        inputPrice.addTextChangedListener(new MandatoryListener() {
            @Override
            public void onError() {
                String error = getString(R.string.error_empty);
                inputPrice.setError(error);
            }

            @Override
            public void onText(String text) {
                ganga.setPrice(Float.valueOf(text));
            }
        });
    }

}
