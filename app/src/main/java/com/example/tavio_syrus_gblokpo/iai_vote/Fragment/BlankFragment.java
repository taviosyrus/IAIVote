package com.example.tavio_syrus_gblokpo.iai_vote.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO.EtudiantDAO;
import com.example.tavio_syrus_gblokpo.iai_vote.Classement_suivant_comportement;
import com.example.tavio_syrus_gblokpo.iai_vote.Classement_suivant_leur_clarte;
import com.example.tavio_syrus_gblokpo.iai_vote.Enseignement_bien_anime;
import com.example.tavio_syrus_gblokpo.iai_vote.Enseignements_bien_explique;
import com.example.tavio_syrus_gblokpo.iai_vote.GeneralChart;
import com.example.tavio_syrus_gblokpo.iai_vote.R;
import com.example.tavio_syrus_gblokpo.iai_vote.VoteVrai;


public class BlankFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageButton imageView, imageView1;


    private Context context;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
    }

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button vote = getActivity().findViewById(R.id.btn_voter);
        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(getContext(), VoteGri.class);
                //startActivity(intent);
                message();
            }
        });

        Button statistique = getActivity().findViewById(R.id.statistique);
        statistique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GeneralChart.class);
                startActivity(intent);
            }
        });

        Button autres = getActivity().findViewById(R.id.autres);
        autres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                final View view = getLayoutInflater().inflate(R.layout.dialog_autres, null);
                mBuilder.setView(view);
                final AlertDialog alertDialog = mBuilder.create();

                Button btn1 = view.findViewById(R.id.button1);
                Button btn2 = view.findViewById(R.id.button2);
                Button btn3 = view.findViewById(R.id.button3);
                Button btn4 = view.findViewById(R.id.button4);
                Button btn5 = view.findViewById(R.id.button5);
                Button btn6 = view.findViewById(R.id.cancel);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), Classement_suivant_comportement.class);
                        startActivity(intent);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), Classement_suivant_leur_clarte.class);
                        startActivity(intent);
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), Enseignement_bien_anime.class);
                        startActivity(intent);
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), Enseignements_bien_explique.class);
                        startActivity(intent);
                    }
                });

                btn6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                alertDialog.setCancelable(false);
            }
        });


    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return (networkInfo != null && networkInfo.isConnected());
    }

    public void message() {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        final View view = getLayoutInflater().inflate(R.layout.patientez, null);


        mBuilder.setView(view);
        final AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
        alertDialog.setCancelable(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isConnected()){
                    EtudiantDAO etudiantDAO = new EtudiantDAO(getActivity());
                    etudiantDAO.open();


                }else {
                    Toast.makeText(getContext(), "Pas de connexion", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                    return;
                }
                EtudiantDAO etudiantDAO = new EtudiantDAO(getContext());
                Cursor etudiantCursor = etudiantDAO.getPub();
                if (etudiantCursor != null) {
                    if (etudiantCursor != null) {

                        startActivity(new Intent(getActivity(), VoteVrai.class));
                        alertDialog.dismiss();
                    }
                } else
                {
                    Toast.makeText(getContext(), "Aucun vote n'est disponible pour vous", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }

            }
        }, 2000);
    }


    @Override
    public void onCreateOptionsMenu(android.view.Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_statistique, menu);

    }
}
