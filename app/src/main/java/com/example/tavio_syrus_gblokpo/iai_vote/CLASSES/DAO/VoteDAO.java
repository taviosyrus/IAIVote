package com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL.DAOBase;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.VoteContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.SIMPLE.Vote;

/**
 * Created by TAVIO-SYRUS-GBLOKPO on 21/03/2018.
 */

public class VoteDAO extends DAOBase {
    public VoteDAO(Context context) {
        super(context);
    }

    public void add(Vote vote) {
        ContentValues values = new ContentValues();
        values.put(VoteContent.idVote, vote.getIdVote());
        values.put(VoteContent.libVote, vote.getLibVote());
        values.put(VoteContent.DateDebut, vote.getDateDebut());
        values.put(VoteContent.DateFin, vote.getDateFin());
        values.put(VoteContent.etatVote, vote.getEtatVote());
        values.put(VoteContent.anonymat, vote.getAnonymat());
        myDb.insert(VoteContent.NAME, null, values);
    }

    public void update(Vote vote) {
        ContentValues values = new ContentValues();
        values.put(VoteContent.idVote, vote.getIdVote());
        values.put(VoteContent.libVote, vote.getLibVote());
        values.put(VoteContent.DateDebut, vote.getDateDebut());
        values.put(VoteContent.DateFin, vote.getDateFin());
        values.put(VoteContent.etatVote, vote.getEtatVote());
        values.put(VoteContent.anonymat, vote.getAnonymat());


        myDb.update(VoteContent.NAME, values, VoteContent.idVote + " = ?", new String[]
                {String.valueOf(vote.getIdVote())});
    }
}
