package io.bunsan.gangahunter.detail;

import android.support.v4.app.Fragment;

import io.bunsan.gangahunter.common.SingleFragmentActivity;


public class GangaActivity extends SingleFragmentActivity {

    @Override
    public Fragment getFragment() {
        return new GangaFragment();
    }
}
