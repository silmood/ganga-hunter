package io.bunsan.gangahunter.list;


import android.support.v4.app.Fragment;

import io.bunsan.gangahunter.common.SingleFragmentActivity;

public class GangaListActivity extends SingleFragmentActivity {

    @Override
    public Fragment getFragment() {
        return new GangaListFragment();
    }
}
