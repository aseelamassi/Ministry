package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WorkStatusDao_Impl implements WorkStatusDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WorkStatus> __insertionAdapterOfWorkStatus;

  public WorkStatusDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWorkStatus = new EntityInsertionAdapter<WorkStatus>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `work_status_table` (`wORKSTATUSID`,`wORKSTATUSNAME`,`iSDELETE`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkStatus value) {
        if (value.getWORKSTATUSID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getWORKSTATUSID());
        }
        if (value.getWORKSTATUSNAME() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWORKSTATUSNAME());
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getISDELETE());
        }
      }
    };
  }

  @Override
  public void addWorkStatus(final WorkStatus workStatus) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkStatus.insert(workStatus);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<WorkStatus>> getAllWorkStatuses() {
    final String _sql = "SELECT * FROM work_status_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"work_status_table"}, false, new Callable<List<WorkStatus>>() {
      @Override
      public List<WorkStatus> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfWORKSTATUSID = CursorUtil.getColumnIndexOrThrow(_cursor, "wORKSTATUSID");
          final int _cursorIndexOfWORKSTATUSNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "wORKSTATUSNAME");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final List<WorkStatus> _result = new ArrayList<WorkStatus>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WorkStatus _item;
            _item = new WorkStatus();
            final String _tmpWORKSTATUSID;
            _tmpWORKSTATUSID = _cursor.getString(_cursorIndexOfWORKSTATUSID);
            _item.setWORKSTATUSID(_tmpWORKSTATUSID);
            final String _tmpWORKSTATUSNAME;
            _tmpWORKSTATUSNAME = _cursor.getString(_cursorIndexOfWORKSTATUSNAME);
            _item.setWORKSTATUSNAME(_tmpWORKSTATUSNAME);
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
    final String _sql = "SELECT COUNT(*) FROM work_status_table";
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
