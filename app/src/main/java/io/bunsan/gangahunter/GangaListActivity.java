package io.bunsan.gangahunter;


import android.support.v4.app.Fragment;

public class GangaListActivity extends SingleFragmentActivity {

    @Override
    Fragment getFragment() {
        return new GangaListFragment();
    }
}
