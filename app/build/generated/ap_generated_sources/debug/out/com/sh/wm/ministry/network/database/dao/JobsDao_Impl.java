package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.jobs.Job;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class JobsDao_Impl implements JobsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Job> __insertionAdapterOfJob;

  public JobsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfJob = new EntityInsertionAdapter<Job>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `jobs_table` (`jOBID`,`jOBARNAME`,`jOBENNAME`,`iSDELETE`,`jOBTRICODE`,`iNSERTUSER`,`iNSERTDATE`,`uPDATEUSER`,`uPDATEDATE`,`jOBIDOLD`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Job value) {
        if (value.getJOBID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getJOBID());
        }
        if (value.getJOBARNAME() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getJOBARNAME());
        }
        if (value.getJOBENNAME() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getJOBENNAME());
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getISDELETE());
        }
        if (value.getJOBTRICODE() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getJOBTRICODE());
        }
        if (value.getINSERTUSER() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getINSERTUSER());
        }
        if (value.getINSERTDATE() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getINSERTDATE());
        }
        if (value.getUPDATEUSER() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUPDATEUSER());
        }
        if (value.getUPDATEDATE() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUPDATEDATE());
        }
        if (value.getJOBIDOLD() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getJOBIDOLD());
        }
      }
    };
  }

  @Override
  public void addJob(final Job job) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfJob.insert(job);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Job>> getAllJobs() {
    final String _sql = "SELECT * FROM jobs_table ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"jobs_table"}, false, new Callable<List<Job>>() {
      @Override
      public List<Job> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfJOBID = CursorUtil.getColumnIndexOrThrow(_cursor, "jOBID");
          final int _cursorIndexOfJOBARNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "jOBARNAME");
          final int _cursorIndexOfJOBENNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "jOBENNAME");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final int _cursorIndexOfJOBTRICODE = CursorUtil.getColumnIndexOrThrow(_cursor, "jOBTRICODE");
          final int _cursorIndexOfINSERTUSER = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSERTUSER");
          final int _cursorIndexOfINSERTDATE = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSERTDATE");
          final int _cursorIndexOfUPDATEUSER = CursorUtil.getColumnIndexOrThrow(_cursor, "uPDATEUSER");
          final int _cursorIndexOfUPDATEDATE = CursorUtil.getColumnIndexOrThrow(_cursor, "uPDATEDATE");
          final int _cursorIndexOfJOBIDOLD = CursorUtil.getColumnIndexOrThrow(_cursor, "jOBIDOLD");
          final List<Job> _result = new ArrayList<Job>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Job _item;
            _item = new Job();
            final String _tmpJOBID;
            _tmpJOBID = _cursor.getString(_cursorIndexOfJOBID);
            _item.setJOBID(_tmpJOBID);
            final String _tmpJOBARNAME;
            _tmpJOBARNAME = _cursor.getString(_cursorIndexOfJOBARNAME);
            _item.setJOBARNAME(_tmpJOBARNAME);
            final String _tmpJOBENNAME;
            _tmpJOBENNAME = _cursor.getString(_cursorIndexOfJOBENNAME);
            _item.setJOBENNAME(_tmpJOBENNAME);
            final String _tmpISDELETE;
            _tmpISDELETE = _cursor.getString(_cursorIndexOfISDELETE);
            _item.setISDELETE(_tmpISDELETE);
            final String _tmpJOBTRICODE;
            _tmpJOBTRICODE = _cursor.getString(_cursorIndexOfJOBTRICODE);
            _item.setJOBTRICODE(_tmpJOBTRICODE);
            final String _tmpINSERTUSER;
            _tmpINSERTUSER = _cursor.getString(_cursorIndexOfINSERTUSER);
            _item.setINSERTUSER(_tmpINSERTUSER);
            final String _tmpINSERTDATE;
            _tmpINSERTDATE = _cursor.getString(_cursorIndexOfINSERTDATE);
            _item.setINSERTDATE(_tmpINSERTDATE);
            final String _tmpUPDATEUSER;
            _tmpUPDATEUSER = _cursor.getString(_cursorIndexOfUPDATEUSER);
            _item.setUPDATEUSER(_tmpUPDATEUSER);
            final String _tmpUPDATEDATE;
            _tmpUPDATEDATE = _cursor.getString(_cursorIndexOfUPDATEDATE);
            _item.setUPDATEDATE(_tmpUPDATEDATE);
            final String _tmpJOBIDOLD;
            _tmpJOBIDOLD = _cursor.getString(_cursorIndexOfJOBIDOLD);
            _item.setJOBIDOLD(_tmpJOBIDOLD);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public int getDataCount() {
    final String _sql = "SELECT COUNT(*) FROM jobs_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
