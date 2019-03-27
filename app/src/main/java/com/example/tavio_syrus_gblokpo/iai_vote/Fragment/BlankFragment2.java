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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.tavio_syrus_gblokpo.iai_vote.Adapter.EtudiantListeView;
import com.example.tavio_syrus_gblokpo.iai_vote.Adapter.ProfesseurListeView;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.ProfesseurDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Etudiant;
import com.example.tavio_syrus_gblokpo.iai_vote.Profil;
import com.example.tavio_syrus_gblokpo.iai_vote.R;
import com.example.tavio_syrus_gblokpo.iai_vote.Traitement.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ListView listprof;
    private String[] NomEt;
    private String[] idEt;
    private String[]photo_util_p;
    private SearchView rech;
    ProfesseurListeView professeurListeView;
    private CircleImageView imageView;


    private String mParam1;
    private String mParam2;

    private BlankFragment2.OnFragmentInteractionListener mListener;

    public BlankFragment2() {

    }

    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment2 = new BlankFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment2.setArguments(args);
        return fragment2;
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
        professeurListeView = new ProfesseurListeView(getActivity(),idEt, NomEt,photo_util_p);
        listprof.setAdapter(professeurListeView);
        rech =(SearchView) v.findViewById(R.id.rech);
        rech.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ProfesseurDAO professeurDAO = new ProfesseurDAO(getContext());
                Cursor result = professeurDAO.getPubReq(newText);
                int i = 0;
                idEt = new String[result.getCount()];
                NomEt = new String[result.getCount()];
                while (result.moveToNext()) {
                    idEt[i] = result.getString(0);
                    NomEt[i] = (result.getString(1)+" "+result.getString(2));
                    photo_util_p[i] = result.getString(1);
                    i++;
                }
                professeurListeView = new ProfesseurListeView(getActivity(),idEt, NomEt,photo_util_p);
                listprof.setAdapter(professeurListeView);
                return true;
            }});
        return v;
    }


    private void initData() {
        //affichage des Publication

        ProfesseurDAO professeurDAO = new ProfesseurDAO(getContext());
        Cursor result = professeurDAO.getPub();
        int i = 0;
        idEt = new String[result.getCount()];
        NomEt = new String[result.getCount()];
        photo_util_p = new String[result.getCount()];
        while (result.moveToNext()) {
            idEt[i] = result.getString(0);
            NomEt[i] = (result.getString(1)+" "+result.getString(2));
            photo_util_p[i] = result.getString(1);
            i++;
        }


    }



    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
