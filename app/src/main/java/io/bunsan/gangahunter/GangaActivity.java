package io.bunsan.gangahunter;

import android.support.v4.app.Fragment;


public class GangaActivity extends SingleFragmentActivity {

    @Override
    Fragment getFragment() {
        return new GangaFragment();
    }
}
