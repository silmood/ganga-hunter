package io.bunsan.gangahunter.list;


import android.content.Intent;
import android.support.v4.app.Fragment;

import io.bunsan.gangahunter.common.SingleFragmentActivity;
import io.bunsan.gangahunter.detail.GangaFragment;

public class GangaListActivity extends SingleFragmentActivity {


    @Override
    public Fragment getFragment() {
        return new GangaListFragment();
    }

}
