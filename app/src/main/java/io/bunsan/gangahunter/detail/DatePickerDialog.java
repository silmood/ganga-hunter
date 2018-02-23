package io.bunsan.gangahunter.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import io.bunsan.gangahunter.R;

public class DatePickerDialog extends DialogFragment {

    private DatePicker picker;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.dialog_date_picker,
                        null,
                        false);

        picker = view.findViewById(R.id.picker);

        return new AlertDialog.Builder(getContext())
                .setTitle(R.string.title_date_picker)
                .setView(view)
                .setPositiveButton(R.string.label_accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DatePickerDialog.this.dismiss();
                    }
                })
                .create();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Date date = getDate();

        Fragment fragment = getTargetFragment();
        int code = getTargetRequestCode();

        Intent result = new Intent();
        result.putExtra("date", date);

        fragment.onActivityResult(code, Activity.RESULT_OK, result);

    }

    private Date getDate() {
        int day = picker.getDayOfMonth();
        int month = picker.getMonth();
        int year = picker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);

        return calendar.getTime();
    }
}
