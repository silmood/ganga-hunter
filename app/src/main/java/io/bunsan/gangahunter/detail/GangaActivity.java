package io.bunsan.gangahunter.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import io.bunsan.gangahunter.common.SingleFragmentActivity;


public class GangaActivity extends SingleFragmentActivity {

    public static final String EXTRA_ID = "extra_id";

    public static Intent getIntent(Context context, String id) {
        Intent intent = new Intent(context, GangaActivity.class);
        intent.putExtra(GangaActivity.EXTRA_ID, id);

        return intent;
    }

    @Override
    public Fragment getFragment() {

        if (getIntent().hasExtra(EXTRA_ID)){
            String gangaId = getIntent().getStringExtra(EXTRA_ID);
            return GangaFragment.newInstance(gangaId);
        } else {
            throw new IllegalArgumentException("Ganga ID was not provided");
        }

    }
}
