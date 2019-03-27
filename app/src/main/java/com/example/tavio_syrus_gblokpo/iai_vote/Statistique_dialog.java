package com.example.tavio_syrus_gblokpo.iai_vote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 06/04/2018.
 */

public class Statistique_dialog extends AppCompatActivity {
    private Button sat1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        sat1.findViewById(R.id.sat1);
        sat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), GeneralChart.class);
                startActivity(intent);
            }
        });
    }
}
