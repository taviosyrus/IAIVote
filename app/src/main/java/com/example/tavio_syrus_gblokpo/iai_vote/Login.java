package com.example.tavio_syrus_gblokpo.iai_vote;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SERVICES.EtudiantServ;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.BackgroundTaskConnection;

public class Login extends AppCompatActivity {
    EditText pseudo, password;
    String pseudoS,passwordS;
    TextView text;
    Context context;
    boolean cancel = false;
    View focusView = null;
    private Button QRC_btn;

    String method = "connection";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        text =(TextView)findViewById(R.id.text);
        pseudo = (EditText)findViewById(R.id.ETpseudo);
        password = (EditText)findViewById(R.id.Etpassword);




        // Etudiant//
       EtudiantServ tester = new EtudiantServ(getApplicationContext());
        EtudiantDAO etudiantDAO = new EtudiantDAO(this);
        etudiantDAO.open();


        String type11 ="etudiant";
        tester.execute(type11, etudiantDAO.count()+" ", "5");
        Toast.makeText(this, etudiantDAO.count(), Toast.LENGTH_SHORT).show();
        ///



    }

   public void valider(View view){
        pseudoS = pseudo.getText().toString();
        passwordS = password.getText().toString();
        if(pseudoS.length()==0){
            pseudo.setError(getString(R.string.erreurPseudo));
            focusView = pseudo;
            cancel = true;
        }else
            if(passwordS.length()==0){
                password.setError(getString(R.string.erreurPass));
                focusView = password;
                cancel = true;     }
                else{
        BackgroundTaskConnection backgroundTaskConnection = new BackgroundTaskConnection(context);
        backgroundTaskConnection.execute(method,pseudoS,passwordS);
            }
    }
    public void inscri(View  view){
        Intent intent=new Intent(getApplicationContext(),Activity_Inscription.class);
        startActivity(intent);

    }


}
