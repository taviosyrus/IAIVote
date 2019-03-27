package com.example.tavio_syrus_gblokpo.iai_vote;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.CircleImageView;

public class Profil extends AppCompatActivity {
  private static final String TAG = "SearchActivity";

    private static  int REQUEST_CODE=1,SELECT_FILE=0,REQUEST_CAMERA=1;
    private CircleImageView circleImageView,circleImageView1;
    private TextView idEt, nomprenom, tel, adresse, datenaiss, nom;

    private ImageButton button, btnSh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        nomprenom = findViewById(R.id.nomN);
        nom = findViewById(R.id.nom1);
        tel = findViewById(R.id.tel1);
        adresse = findViewById(R.id.adresse1);
        datenaiss = findViewById(R.id.datenaiss1);
        circleImageView = findViewById(R.id.btn_photo_update1);

        circleImageView1 = findViewById(R.id.photo_util_mm);

        circleImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowPhoto.class);
                startActivity(intent);
            }
        });
         circleImageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 verifyPermission();
                 selctImage();
             }
         });
        initData();
    }


    private void verifyPermission(){
        Log.d(TAG,"verifyPermissions:asking user for permissions");
        String[]permissions={
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.MEDIA_CONTENT_CONTROL};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[0])== PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[1])== PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[2])== PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[3])== PackageManager.PERMISSION_GRANTED){

        }else{
            ActivityCompat.requestPermissions(Profil.this,
                    permissions,REQUEST_CODE);
        }

    }
    public void selctImage() {
        final CharSequence[] items = {"Camera", "Galery", "Supprimer cette photo"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Profil.this);
        builder.setTitle("Photo de profil");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (items[i].equals("Camera")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);

                } else if (items[i].equals("Galery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, "Choisir une photo"), SELECT_FILE);


                } else if (items[i].equals("Supprimer cette photo")) {
                    dialog.dismiss();
                }
            }
            });
        builder.show();
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK){
            if(requestCode==REQUEST_CAMERA){
                Bundle bundle = data.getExtras();
                final Bitmap bitmap = (Bitmap) bundle.get("data");
                Toast.makeText(this,""+bitmap,Toast.LENGTH_LONG).show();
                circleImageView1.setImageBitmap(bitmap);
            }else if (requestCode == SELECT_FILE){
                Uri selectedImageUri = data.getData();
                Toast.makeText(this,""+selectedImageUri,Toast.LENGTH_LONG).show();
                circleImageView1.setImageURI(selectedImageUri);
            }
        }
    }

    private void initData () {
            EtudiantDAO etudiantDAO = new EtudiantDAO(getApplicationContext());
            Cursor result = etudiantDAO.getPubDetail("1");
            while (result.moveToNext()) {
                nomprenom.setText(result.getString(1) + " " + result.getString(2));
                nom.setText(result.getString(1) + " " + result.getString(2));
                tel.setText(result.getString(3));
                adresse.setText(result.getString(5));
                datenaiss.setText(result.getString(6));
            }

        }
        @Override
        public boolean onCreateOptionsMenu (android.view.Menu menu){
            getMenuInflater().inflate(R.menu.menu_simple, menu);
            setTitle("Moi");
            return true;
        }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case R.id.editer:
                    Intent intent = new Intent(getApplicationContext(), UpadeProfil.class);
                    startActivity(intent);
            }
            return super.onOptionsItemSelected(item);
        }
    }
