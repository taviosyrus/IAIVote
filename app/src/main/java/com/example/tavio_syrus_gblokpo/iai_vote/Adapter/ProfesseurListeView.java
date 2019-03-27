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
import android.widget.TextView;

import com.example.tavio_syrus_gblokpo.iai_vote.Info_professeur;
import com.example.tavio_syrus_gblokpo.iai_vote.R;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.CircleImageView;
import com.squareup.picasso.Picasso;


public class ProfesseurListeView extends ArrayAdapter<String> {
    private String[] NomEt;
    private String[] idEt;
    private String[] type;
    private String[] photo_util_p;


    private Activity context;

    public ProfesseurListeView(Activity context, String[] idEt, String[] NomEt,String[] photo_util_p) {
        super(context, R.layout.activity_list_prof, idEt);
        this.context = context;
        this.idEt = idEt;
        this.NomEt = NomEt;
        this.photo_util_p = photo_util_p;


    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        ProfesseurListeView.ViewHolder viewHolder = null;


        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.activity_list_prof, null, false);
            viewHolder = new ProfesseurListeView.ViewHolder(r);
            r.setTag(viewHolder);

        } else {
            viewHolder = (ProfesseurListeView.ViewHolder) r.getTag();
        }


        viewHolder.idEt.setText(idEt[position]);
        viewHolder.NomEt.setText(NomEt[position]);
        viewHolder.photo=(photo_util_p[position]);
        Picasso.with(getContext()).load("http://192.168.43.12/image/"+viewHolder.photo)
                .placeholder(R.mipmap.ic_picasso_erreur_round)
                .error(R.mipmap.ic_picasso_erreur_round)
                .into(viewHolder.photo_util);


        return r;
    }


    class ViewHolder {
        TextView NomEt;
        CardView cardView;
        TextView idEt;
        TextView id;
        String photo;
        CircleImageView photo_util;


        ViewHolder(View v) {
            NomEt = (TextView) v.findViewById(R.id.nomEt);
            idEt = (TextView) v.findViewById(R.id.idEt);
            id = (TextView) v.findViewById(R.id.idEt);
            photo_util = (CircleImageView)v.findViewById(R.id.photo_util_p);

            cardView = (CardView) v.findViewById(R.id.cardView1);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ir = id.getText().toString();

                    Intent intent = new Intent(v.getContext(), Info_professeur.class);
                    v.getContext().startActivity(intent.putExtra("toto", "" + ir));
                }
            });
        }
    }
}
