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
import com.example.tavio_syrus_gblokpo.iai_vote.Text;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.CircleImageView;
import com.squareup.picasso.Picasso;


    public class ClarteList extends ArrayAdapter<String> {
        private String[] idEt;
        private String[] NomEt;
        private String[] photo_util;
        private String[] score;
        private String[] rang;



        private Activity context;
        public ClarteList(Activity context, String[] idEt, String [] NomEt, String[] photo_util, String[] score, String[] rang){
            super(context, R.layout.classement_prof,idEt);
            this.context = context;
            this.idEt = idEt;
            this.NomEt = NomEt;
            this.photo_util = photo_util;
            this.score = score;
            this.rang = rang;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View r = convertView;
            ClarteList.ViewHolder viewHolder = null;


            if(r==null){
                LayoutInflater layoutInflater = context.getLayoutInflater();
                r = layoutInflater.inflate(R.layout.classement_prof,null,false);
                viewHolder = new ClarteList.ViewHolder(r);
                r.setTag(viewHolder);

            }else{
                viewHolder =(ClarteList.ViewHolder) r.getTag();
            }



            viewHolder.idEt.setText(idEt[position]);
            viewHolder.NomEt.setText(NomEt[position]);
            viewHolder.photo=(photo_util[position]);
            viewHolder.rang.setText(String.valueOf(position+1));
            Picasso.with(getContext()).load("http://192.168.43.12/image/"+viewHolder.photo)
                    .placeholder(R.mipmap.ic_picasso_erreur_round)
                    .error(R.mipmap.ic_picasso_erreur_round)
                    .into(viewHolder.photo_util);



            return r;
        }



        class ViewHolder{
            CardView cardView;
            TextView NomEt,rang;
            TextView idEt,score;
            SearchView rech;
            TextView id;
            String photo;
            CircleImageView photo_util;



            ViewHolder(View v){
                idEt =(TextView) v.findViewById(R.id.idEt);
                NomEt =(TextView)  v.findViewById(R.id.nomEt);
                rech = (SearchView) v.findViewById(R.id.rech);
                photo_util = (CircleImageView)v.findViewById(R.id.photo_util_p);
                rang = (TextView) v.findViewById(R.id.rang);
                score =(TextView) v.findViewById(R.id.score);

            }
        }


    }



