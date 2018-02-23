package io.bunsan.gangahunter.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import io.bunsan.gangahunter.R;
import io.bunsan.gangahunter.common.MandatoryListener;
import io.bunsan.gangahunter.model.Ganga;
import io.bunsan.gangahunter.model.GangaHistory;


public class GangaFragment extends Fragment {

    public static final String TAG = "ganga_detail";
    private static final String KEY_ID = "key_id";

    private Ganga ganga;

    // Componentes de UI
    private EditText inputName,
            inputPlace,
            inputPrice;

    private Button btnDate;

    public static GangaFragment newInstance(String gangaId) {
        GangaFragment fragment = new GangaFragment();

        Bundle args = new Bundle();
        args.putString(KEY_ID, gangaId);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializar componentes que no se relacionen con la UI
        String id = getArguments().getString(KEY_ID);
        this.ganga = GangaHistory
                .getInstance()
                .findGangaById(id);

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
        inputPlace = view.findViewById(R.id.input_place);
        btnDate = view.findViewById(R.id.btn_date);

        if (ganga != null) {
            setupGanga();
        }

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        setupInputs();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            Date date = (Date) data.getSerializableExtra("date");
            ganga.setDueDate(date);

            setupGanga();
        }
    }

    private void showDatePickerDialog() {
        DatePickerDialog dialog = new DatePickerDialog();
        dialog.setTargetFragment(this, 100);
        dialog.show(getFragmentManager(), "date_picker");
    }

    private void setupGanga() {
        inputName.setText(ganga.getName());
        inputPrice.setText("" + ganga.getPrice());
        inputPlace.setText(ganga.getPlace());

        String labelDateFormat = getContext()
                .getString(R.string.format_date);

        String formattedLabelDate = String.format(labelDateFormat,
                ganga.getDueDateFormatted());

        btnDate.setText(formattedLabelDate);

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
