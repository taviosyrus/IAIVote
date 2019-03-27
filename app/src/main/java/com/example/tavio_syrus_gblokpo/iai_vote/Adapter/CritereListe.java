package com.example.tavio_syrus_gblokpo.iai_vote.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tavio_syrus_gblokpo.iai_vote.R;


public class CritereListe extends ArrayAdapter<String> {
    private String[] idCri;
    private String[] NomCri;




    private Activity context;
    public CritereListe(Activity context, String[] idCri, String [] NomCri){
        super(context, R.layout.activity_list_etud,idCri);
        this.context = context;
        this.idCri = idCri;
        this.NomCri = NomCri;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        View r = convertView;
        CritereListe.ViewHolder viewHolder = null;


        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.critereliste,null,false);
            viewHolder = new CritereListe.ViewHolder(r);
            r.setTag(viewHolder);

        }else{
            viewHolder =(CritereListe.ViewHolder) r.getTag();
        }



        viewHolder.idCri.setText(idCri[position]);
        viewHolder.NomCri.setText(NomCri[position]);



        return r;
    }



    class ViewHolder{
        CardView cardView;
        TextView NomCri;
        TextView idCri;
        TextView id;
        RadioButton rb;


        ViewHolder(View v){
            idCri =(TextView) v.findViewById(R.id.idCri);
            NomCri =(TextView)  v.findViewById(R.id.nomCri);
            id =(TextView) v.findViewById(R.id.idCri);
            rb =(RadioButton) v.findViewById(R.id.rb);

        }
    }
}
