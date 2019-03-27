package com.example.tavio_syrus_gblokpo.iai_vote.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.tavio_syrus_gblokpo.iai_vote.InfoEtudiant;
import com.example.tavio_syrus_gblokpo.iai_vote.R;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.CircleImageView;
import com.squareup.picasso.Picasso;


public class EtudiantListeView extends ArrayAdapter<String> {
    private String[] idEt;
    private String[] NomEt;
    private String[] photo_util;



    private Activity context;
    public EtudiantListeView(Activity context, String[] idEt, String [] NomEt, String[] photo_util){
        super(context, R.layout.activity_list_etud,idEt);
        this.context = context;
        this.idEt = idEt;
        this.NomEt = NomEt;
        this.photo_util = photo_util;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        View r = convertView;
        EtudiantListeView.ViewHolder viewHolder = null;


        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.activity_list_etud,null,false);
             viewHolder = new EtudiantListeView.ViewHolder(r);
            r.setTag(viewHolder);

        }else{
            viewHolder =(EtudiantListeView.ViewHolder) r.getTag();
        }



        viewHolder.idEt.setText(idEt[position]);
        viewHolder.NomEt.setText(NomEt[position]);
        viewHolder.photo=(photo_util[position]);
        Picasso.with(getContext()).load("http://192.168.43.12/image/"+viewHolder.photo)
                .placeholder(R.mipmap.ic_picasso_erreur_round)
                .error(R.mipmap.ic_picasso_erreur_round)
                .into(viewHolder.photo_util);



        return r;
    }



    class ViewHolder{
        CardView cardView;
        TextView NomEt;
        TextView idEt;
        SearchView rech;
        TextView id;
        String photo;
        CircleImageView photo_util;


        ViewHolder(View v){
            idEt =(TextView) v.findViewById(R.id.idEt);
            NomEt =(TextView)  v.findViewById(R.id.nomEt);
            rech = (SearchView) v.findViewById(R.id.rech);
            id =(TextView) v.findViewById(R.id.idEt);
            cardView=(CardView) v.findViewById(R.id.cardView);
            photo_util = (CircleImageView)v.findViewById(R.id.photo_util);



            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   String ir = id.getText().toString();

                    Intent intent=new Intent(v.getContext(),InfoEtudiant.class);
                    v.getContext().startActivity(intent.putExtra("toto",""+ir));
                }
            });
        }
    }


}
