package com.example.tavio_syrus_gblokpo.iai_vote;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.BackgroundTaskInscription;

public class Activity_Inscription extends AppCompatActivity {
    EditText matricule, pseudo, password, confirmation;
    String matriculeS, pseudoS, passwordS, confirmationS;
    Context context;
    String method = "Enreginscription";
    boolean cancel = false;
    View focusView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        context = this;
        matricule = (EditText) findViewById(R.id.Etmatricule);
        pseudo = (EditText) findViewById(R.id.Etpseudo);
        password = (EditText) findViewById(R.id.Etpassword);
        confirmation = (EditText) findViewById(R.id.Etpassword1);
    }
    public void inscription(View view) {
        matriculeS = matricule.getText().toString();
        pseudoS = pseudo.getText().toString();
        passwordS = password.getText().toString();
        confirmationS = confirmation.getText().toString();
        if (matriculeS.isEmpty()) {
            matricule.setError(getString(R.string.erreurMatri));
            focusView = matricule;
            cancel = true;
        } else if (pseudoS.isEmpty()) {
            pseudo.setError(getString(R.string.erreurPseudo));
            focusView = pseudo;
            cancel = true;
        } else if (passwordS.isEmpty()) {
            password.setError(getString(R.string.erreurPass));
            focusView = password;
            cancel = true;
        } else {
            if (confirmationS.isEmpty()) {
                confirmation.setError(getString(R.string.erreurConfir));
                focusView = confirmation;
                cancel = true;
            } else {
                if(passwordS.equals(confirmationS)){
                    BackgroundTaskInscription backgroundTaskInscription = new BackgroundTaskInscription(context);
                    backgroundTaskInscription.execute(method, matriculeS, pseudoS, passwordS);
                } else {
                       password.setText("");
                       confirmation.setText("");
                        password.setError(getString(R.string.error_incorrect_password));
                        focusView = password;
                        cancel = true;
                }
            }
        }
    }

     public void conn(View  view){
       finish();

    }
}
