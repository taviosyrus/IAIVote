package com.example.tavio_syrus_gblokpo.iai_vote;


import android.support.design.widget.AppBarLayout;
import android.support.v4.view.PagerTitleStrip;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;


public class GeneralChart extends AppCompatActivity {
Spinner spinner;
BarChart barChart;
Button button;
    String toto="tot";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_chart);
        spinner = findViewById(R.id.spinerChart);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnerChart,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new function());

if(toto.equals("tot")) {
    chart();
}else{
    chart1();
}



    }


    public class function implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent,View arg1,int pos,long id){
           toto = parent.getItemAtPosition(pos).toString();
            Toast.makeText(getApplicationContext(),toto ,Toast.LENGTH_LONG).show();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


    }
    public void chart1(){

        barChart =  findViewById(R.id.chart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(44,0));
        barEntries.add(new BarEntry(88,1));


        BarDataSet barDataSet = new BarDataSet(barEntries,"Date");


        ArrayList<String> theDate = new ArrayList<>();
        theDate.add("Janvier");
        theDate.add("Fevrier");


        BarData theData = new BarData(theDate,barDataSet);
        barChart.setData(theData);


        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);

    }

    public void chart(){

        barChart =  findViewById(R.id.chart);
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(44,0));
        barEntries.add(new BarEntry(88,1));
        barEntries.add(new BarEntry(50,2));
        barEntries.add(new BarEntry(10,3));
        barEntries.add(new BarEntry(80,4));


        BarDataSet barDataSet = new BarDataSet(barEntries,"Date");


        ArrayList<String> theDate = new ArrayList<>();
        theDate.add("Janvier");
        theDate.add("Fevrier");
        theDate.add("Mars");
        theDate.add("Avril");
        theDate.add("Mai");


        BarData theData = new BarData(theDate,barDataSet);
        barChart.setData(theData);


        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        setTitle("Nos Statistiques");
        getMenuInflater().inflate(R.menu.menu_statistique, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.actualiser:
                Toast.makeText(getApplicationContext()," Actualiser",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
