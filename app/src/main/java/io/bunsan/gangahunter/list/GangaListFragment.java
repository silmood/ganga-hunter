package io.bunsan.gangahunter.list;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.bunsan.gangahunter.R;
import io.bunsan.gangahunter.model.Ganga;
import io.bunsan.gangahunter.model.GangaHistory;

public class GangaListFragment extends Fragment implements GangaViewHolder.OnItemClickListener {

    private ArrayList<Ganga> dummies;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView list = view.findViewById(R.id.list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        list.setLayoutManager(manager);

        ArrayList<Ganga> dummyItems = GangaHistory
                .getInstance()
                .getHistory();

        GangaListAdapter adapter = new GangaListAdapter(this);
        adapter.setGangas(dummyItems);

        list.setAdapter(adapter);


    }

    @Override
    public void onItemClicked() {
        Log.d(GangaListFragment.class.getSimpleName()
                , "It's works!");
    }
}
