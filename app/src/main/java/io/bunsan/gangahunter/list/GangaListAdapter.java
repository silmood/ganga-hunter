package io.bunsan.gangahunter.list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.bunsan.gangahunter.model.Ganga;
import io.bunsan.gangahunter.R;

public class GangaListAdapter extends RecyclerView.Adapter<GangaViewHolder> {

    private ArrayList<Ganga> gangas = new ArrayList<>();
    private GangaViewHolder.OnItemClickListener listener;

    public GangaListAdapter() {
    }

    public GangaListAdapter(GangaViewHolder.OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public GangaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ganga, parent, false);

        GangaViewHolder holder = new GangaViewHolder(view);

        if (listener != null){
            holder.setItemClickListener(listener);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(GangaViewHolder holder, int position) {
        Ganga currentItem = gangas.get(position);
        holder.setGanga(currentItem);
    }

    @Override
    public int getItemCount() {
        return gangas.size();
    }

    public void setGangas(ArrayList<Ganga> gangas) {
        this.gangas.clear();
        this.gangas.addAll(gangas);
    }

    public void addGanga(Ganga ganga) {
        this.gangas.add(ganga);
        notifyItemInserted(this.gangas.size() - 1);
    }
}
