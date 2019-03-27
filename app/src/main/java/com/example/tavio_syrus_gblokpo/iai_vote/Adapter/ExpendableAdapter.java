package com.example.tavio_syrus_gblokpo.iai_vote.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tavio_syrus_gblokpo.iai_vote.GroupeCritere;
import com.example.tavio_syrus_gblokpo.iai_vote.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

public class ExpendableAdapter extends BaseExpandableListAdapter {
    private ArrayList<String> Groupecritere;
    private Map<String, ArrayList<String>> mapChild;
    private Context context;
    private List<RadioGroup> groupP;
    private int i,l;

    public ExpendableAdapter(ArrayList<String> groupecritere, Map<String, ArrayList<String>> mapChild, Context context) {
        Groupecritere = groupecritere;
        this.mapChild = mapChild;
        this.context = context;

        groupP = new ArrayList<>();

        i=0;
        l=0;
    }

    @Override
    public int getGroupCount() {
        for (int i = 0; i <Groupecritere.size() ; i++) {
            groupP.add(new RadioGroup(context));
        }
        return Groupecritere.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapChild.get(Groupecritere.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return Groupecritere.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapChild.get(Groupecritere.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String lituto = (String) getGroup(groupPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_groupe_critere, null);
        TextView libGc = convertView.findViewById(R.id.libGC);
        TextView idGc = convertView.findViewById(R.id.idGC);
        libGc.setText(lituto);
        idGc.setText(lituto);
        return convertView;
    }


    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String item = (String) getChild(groupPosition, childPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_crietre_adapter, null);
        RadioGroup group = convertView.findViewById(R.id.readiogroup);


        if (groupP.get(groupPosition) !=null && groupP.get(childPosition) !=null ){

            group.check(groupP.get(groupPosition).getCheckedRadioButtonId()


            );


     }
      // groupP.add(groupPosition,group);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        groupP.get(groupPosition).check(R.id.radioButton1);
                        return;
                    case R.id.radioButton2:
                        groupP.get(groupPosition).check(R.id.radioButton2);
                        return;
                    case R.id.radioButton3:
                        groupP.get(groupPosition).check(R.id.radioButton3);
                        return;
                    case R.id.radioButton4:
                        groupP.get(groupPosition).check(R.id.radioButton4);
                        break;
                }
            }
        });



        TextView libC = convertView.findViewById(R.id.libC);
        TextView idC = convertView.findViewById(R.id.idC);
        libC.setText(item);
        idC.setText(item);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
