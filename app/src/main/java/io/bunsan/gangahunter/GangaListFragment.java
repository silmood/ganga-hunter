package io.bunsan.gangahunter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GangaListFragment extends Fragment {

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


        ArrayList<Ganga> dummyItems = getDummies();

        GangaListAdapter adapter = new GangaListAdapter();
        adapter.setGangas(dummyItems);

        list.setAdapter(adapter);
    }

    public ArrayList<Ganga> getDummies() {
        ArrayList<Ganga> gangas = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Ganga ganga = new Ganga("Ganga # " + i, 10F);
            gangas.add(ganga);
        }

        return gangas;
    }
}
