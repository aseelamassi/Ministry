package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class JobListDao_Impl implements JobListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<JobList> __insertionAdapterOfJobList;

  public JobListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfJobList = new EntityInsertionAdapter<JobList>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `job_lists_table` (`Id`,`text`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, JobList value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getText() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getText());
        }
      }
    };
  }

  @Override
  public void addJob(final JobList job) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfJobList.insert(job);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<JobList>> getAllJobs(final String keyword) {
    final String _sql = "SELECT * FROM job_lists_table where text like ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"job_lists_table"}, false, new Callable<List<JobList>>() {
      @Override
      public List<JobList> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
          final List<JobList> _result = new ArrayList<JobList>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final JobList _item;
            _item = new JobList();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpText;
            _tmpText = _cursor.getString(_cursorIndexOfText);
            _item.setText(_tmpText);
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
    final String _sql = "SELECT COUNT(*) FROM job_lists_table";
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
