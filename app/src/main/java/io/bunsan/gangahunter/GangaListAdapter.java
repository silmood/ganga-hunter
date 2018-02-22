package io.bunsan.gangahunter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class GangaListAdapter extends RecyclerView.Adapter<GangaViewHolder> {

    private ArrayList<Ganga> gangas = new ArrayList<>();

    @Override
    public GangaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ganga, parent, false);

        return new GangaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GangaViewHolder holder, int position) {
        Ganga currentItem = gangas.get(position);
        holder.setName(currentItem.getName());
    }

    @Override
    public int getItemCount() {
        return gangas.size();
    }

    public void setGangas(ArrayList<Ganga> gangas) {
        this.gangas.clear();
        this.gangas.addAll(gangas);
    }
}
