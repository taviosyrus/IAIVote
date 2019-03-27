package com.example.tavio_syrus_gblokpo.iai_vote.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.tavio_syrus_gblokpo.iai_vote.Adapter.EtudiantListeView;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.Profil;
import com.example.tavio_syrus_gblokpo.iai_vote.R;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment3 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ListView listprof;
    private String[] NomEt;
    private String[] idEt;
    private String[]photo_util;
    private SearchView rech;
    EtudiantListeView etudiantListeView;
    private CircleImageView imageView;


    private String mParam1;
    private String mParam2;

    private BlankFragment3.OnFragmentInteractionListener mListener;

    public BlankFragment3() {

    }

    public static BlankFragment3 newInstance(String param1, String param2) {
        BlankFragment3 fragment3 = new BlankFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment3.setArguments(args);
        return fragment3;
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank3, container, false);
        listprof = (ListView) v.findViewById(R.id.Profil_Liste_View);
        initData();
        etudiantListeView = new EtudiantListeView(getActivity(),idEt, NomEt,photo_util);
        listprof.setAdapter(etudiantListeView);

        rech =(SearchView) v.findViewById(R.id.rech);

        rech.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                EtudiantDAO etudiantDAO = new EtudiantDAO(getContext());
                Cursor result = etudiantDAO.getPubReq(newText);
                int i = 0;
                idEt = new String[result.getCount()];

                while (result.moveToNext()) {
                    idEt[i] = result.getString(0);
                    NomEt[i] =(result.getString(1)+" "+result.getString(2));;
                    photo_util[i] = result.getString(3);


                    i++;
                }
                etudiantListeView = new EtudiantListeView(getActivity(),idEt, NomEt,photo_util);
                listprof.setAdapter(etudiantListeView);
                return true;
            }});
        return v;
    }


    private void initData() {
        //affichage des Publication

        EtudiantDAO etudiantDAO = new EtudiantDAO(getContext());
        Cursor result = etudiantDAO.getPub();
        int i = 0;
        idEt = new String[result.getCount()];
        NomEt = new String[result.getCount()];
        photo_util = new String[result.getCount()];
        while (result.moveToNext()) {
            idEt[i] = result.getString(0);
            NomEt[i] = (result.getString(1)+" "+result.getString(2));
            photo_util[i] = result.getString(3);

            i++;
        }


    }



    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
