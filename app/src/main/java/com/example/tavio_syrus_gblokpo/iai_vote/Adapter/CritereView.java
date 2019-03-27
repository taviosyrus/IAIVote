package com.example.tavio_syrus_gblokpo.iai_vote.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Concerner;
import com.example.tavio_syrus_gblokpo.iai_vote.R;

import java.util.ArrayList;
import java.util.List;


public class CritereView extends ArrayAdapter<String> {
    private String[] idC;
    private String[] libC;



    private Activity context;

    public CritereView(Activity context, String[] idC, String [] libC){
        super(context, R.layout.activity_crietre_adapter,idC);
        this.context = context;
        this.idC = idC;
        this.libC = libC;



    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        View r = convertView;
        CritereView.ViewHolder viewHolder = null;


        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.activity_crietre_adapter,null,false);
            viewHolder = new CritereView.ViewHolder(r);
            r.setTag(viewHolder);

        }else{
            viewHolder =(CritereView.ViewHolder) r.getTag();
        }



        viewHolder.idC.setText(idC[position]);
        viewHolder.libC.setText(libC[position]);



        return r;
    }



    class ViewHolder{

        TextView idC;
        TextView libC;
        RadioGroup radioGroup;
        CardView cardView;




        ViewHolder(View v){
            idC =(TextView) v.findViewById(R.id.idC);
            libC =(TextView)  v.findViewById(R.id.libC);
            radioGroup = v.findViewById(R.id.readiogroup);
            cardView =v.findViewById(R.id.cardV);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                }
            });

        }
    }


}
