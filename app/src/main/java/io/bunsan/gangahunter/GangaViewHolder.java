package io.bunsan.gangahunter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class GangaViewHolder extends RecyclerView.ViewHolder {

    private TextView labelName;

    public GangaViewHolder(View itemView) {
        super(itemView);

        labelName = itemView.findViewById(R.id.label_name);

    }

    public void setName(String name) {
        labelName.setText(name);
    }
}
