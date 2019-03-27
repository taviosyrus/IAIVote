package com.example.tavio_syrus_gblokpo.iai_vote;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ShowPhoto extends AppCompatActivity {
    Integer REQUEST_CAMERA = 1, SELECT_FILE = 0;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);
        imageView = (ImageView) findViewById(R.id.photoD);
    }

    @Override
    public boolean onCreateOptionsMenu (android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menu_photoshow, menu);
        setTitle("Photo de profil");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case R.id.editer:
                selectImage();
            case R.id.delete:


        }
        return super.onOptionsItemSelected(item);
    }




    public void selectImage() {
        final CharSequence[] items = {"Camera", "Galery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ShowPhoto.this);
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
                imageView.setImageBitmap(bitmap);
            }else if (requestCode == SELECT_FILE){
                Uri selectedImageUri = data.getData();
                Toast.makeText(this,""+selectedImageUri,Toast.LENGTH_LONG).show();
                imageView.setImageURI(selectedImageUri);
            }
        }
    }

}
