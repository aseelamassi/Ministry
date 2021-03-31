package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitle;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class JobTitlesDao_Impl implements JobTitlesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<JobTitle> __insertionAdapterOfJobTitle;

  public JobTitlesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfJobTitle = new EntityInsertionAdapter<JobTitle>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `job_titles_table` (`jOBTITLEID`,`jOBTITLEDESC`,`jOBTITLEJOBID`,`iSDELETE`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, JobTitle value) {
        if (value.getJOBTITLEID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getJOBTITLEID());
        }
        if (value.getJOBTITLEDESC() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getJOBTITLEDESC());
        }
        if (value.getJOBTITLEJOBID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getJOBTITLEJOBID());
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getISDELETE());
        }
      }
    };
  }

  @Override
  public void addJobTitle(final JobTitle jobTitle) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfJobTitle.insert(jobTitle);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<JobTitle>> getAllJobTitles() {
    final String _sql = "SELECT * FROM job_titles_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"job_titles_table"}, false, new Callable<List<JobTitle>>() {
      @Override
      public List<JobTitle> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfJOBTITLEID = CursorUtil.getColumnIndexOrThrow(_cursor, "jOBTITLEID");
          final int _cursorIndexOfJOBTITLEDESC = CursorUtil.getColumnIndexOrThrow(_cursor, "jOBTITLEDESC");
          final int _cursorIndexOfJOBTITLEJOBID = CursorUtil.getColumnIndexOrThrow(_cursor, "jOBTITLEJOBID");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final List<JobTitle> _result = new ArrayList<JobTitle>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final JobTitle _item;
            _item = new JobTitle();
            final String _tmpJOBTITLEID;
            _tmpJOBTITLEID = _cursor.getString(_cursorIndexOfJOBTITLEID);
            _item.setJOBTITLEID(_tmpJOBTITLEID);
            final String _tmpJOBTITLEDESC;
            _tmpJOBTITLEDESC = _cursor.getString(_cursorIndexOfJOBTITLEDESC);
            _item.setJOBTITLEDESC(_tmpJOBTITLEDESC);
            final String _tmpJOBTITLEJOBID;
            _tmpJOBTITLEJOBID = _cursor.getString(_cursorIndexOfJOBTITLEJOBID);
            _item.setJOBTITLEJOBID(_tmpJOBTITLEJOBID);
            final String _tmpISDELETE;
            _tmpISDELETE = _cursor.getString(_cursorIndexOfISDELETE);
            _item.setISDELETE(_tmpISDELETE);
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
    final String _sql = "SELECT COUNT(*) FROM job_titles_table";
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
