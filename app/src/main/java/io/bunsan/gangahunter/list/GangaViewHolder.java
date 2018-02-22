package io.bunsan.gangahunter.list;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import io.bunsan.gangahunter.R;
import io.bunsan.gangahunter.model.Ganga;

public class GangaViewHolder extends RecyclerView.ViewHolder {

    public static final String FORMAT_PRICE = "$ %.2f";
    public static final String FORMAT_DATE = "dd/MM/yy";
    private TextView labelName;
    private TextView labelPrice;
    private TextView labelPlace;
    private TextView labelDueDate;

    private OnItemClickListener listener = null;


    public GangaViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onItemClicked();
                }
            }
        });

        labelName = itemView.findViewById(R.id.label_name);
        labelPrice = itemView.findViewById(R.id.label_price);
        labelPlace = itemView.findViewById(R.id.label_place);
        labelDueDate = itemView.findViewById(R.id.label_due_date);
    }

    public void setItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setGanga(Ganga ganga) {
        labelName.setText(ganga.getName());
        labelPlace.setText(ganga.getPlace());

        // Formatear precio
        String formattedPrice = String.format(FORMAT_PRICE,
                ganga.getPrice());

        labelPrice.setText(formattedPrice);

        // Formatear fecha
        DateFormat format = new SimpleDateFormat(FORMAT_DATE);
        String formattedDate = format.format(ganga.getDueDate());

        // Formatear etiqueta de texto de fecha
        String labelDateFormat = itemView.getContext()
                .getString(R.string.format_date);

        String formattedLabelDate = String.format(labelDateFormat,
                formattedDate);

        labelDueDate.setText(formattedLabelDate);
    }

    public interface OnItemClickListener {
        void onItemClicked();
    }
}
