package io.bunsan.gangahunter.common;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import io.bunsan.gangahunter.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_fragment);

        //Añadir el fragmento
        if (savedInstanceState == null) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            // Añadir operaciones a la transacción
            transaction
                    .add(R.id.fragment_container, getFragment());

            // Ejecutar la transacción
            transaction.commit();
        }
    }

    public abstract Fragment getFragment();
}
