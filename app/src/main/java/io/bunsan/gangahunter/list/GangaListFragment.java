package io.bunsan.gangahunter.list;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.bunsan.gangahunter.R;
import io.bunsan.gangahunter.detail.GangaActivity;
import io.bunsan.gangahunter.model.Ganga;
import io.bunsan.gangahunter.model.GangaHistory;

public class GangaListFragment extends Fragment implements GangaViewHolder.OnItemClickListener {

    public static final int CODE_EDIT_GANGA = 101;
    public static final String KEY_POSITION = "ganga_position";

    private ArrayList<Ganga> dummies;

    private GangaListAdapter adapter;

    private int lastItemEdited = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Ganga ganga = GangaHistory.getInstance(getContext()).createGanga();
            adapter.addGanga(ganga);

            lastItemEdited = adapter.getItemCount() - 1;
            launchGangaForm(ganga.getId());

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView list = view.findViewById(R.id.list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        list.setLayoutManager(manager);

        ArrayList<Ganga> dummyItems = GangaHistory
                .getInstance(getContext())
                .getHistory();

        adapter = new GangaListAdapter(this);
        adapter.setGangas(dummyItems);

        list.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();

        if (lastItemEdited != -1) {
            adapter.notifyItemChanged(lastItemEdited);
            lastItemEdited = - 1;
        }
    }

    @Override
    public void onItemClicked(int position, Ganga ganga) {
        lastItemEdited = position;
        launchGangaForm(ganga.getId());
    }

    private void launchGangaForm(String id) {
        Intent intent = GangaActivity.getIntent(getContext(), id);
        startActivity(intent);
    }
}
