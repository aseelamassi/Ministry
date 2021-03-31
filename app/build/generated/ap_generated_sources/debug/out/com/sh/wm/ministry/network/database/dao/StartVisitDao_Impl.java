package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.StartVisitModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StartVisitDao_Impl implements StartVisitDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StartVisitModel> __insertionAdapterOfStartVisitModel;

  private final EntityDeletionOrUpdateAdapter<StartVisitModel> __deletionAdapterOfStartVisitModel;

  public StartVisitDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStartVisitModel = new EntityInsertionAdapter<StartVisitModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `StartVisit` (`visit_id`,`isOnline`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StartVisitModel value) {
        if (value.getVisit_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisit_id());
        }
        stmt.bindLong(2, value.getIsOnline());
      }
    };
    this.__deletionAdapterOfStartVisitModel = new EntityDeletionOrUpdateAdapter<StartVisitModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `StartVisit` WHERE `visit_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StartVisitModel value) {
        if (value.getVisit_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisit_id());
        }
      }
    };
  }

  @Override
  public void addVisit(final StartVisitModel model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStartVisitModel.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteVisit(final StartVisitModel model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfStartVisitModel.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<StartVisitModel> getStartedVisits() {
    final String _sql = "SELECT * FROM startvisit where isOnline = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visit_id");
      final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnline");
      final List<StartVisitModel> _result = new ArrayList<StartVisitModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StartVisitModel _item;
        _item = new StartVisitModel();
        final String _tmpVisit_id;
        _tmpVisit_id = _cursor.getString(_cursorIndexOfVisitId);
        _item.setVisit_id(_tmpVisit_id);
        final int _tmpIsOnline;
        _tmpIsOnline = _cursor.getInt(_cursorIndexOfIsOnline);
        _item.setIsOnline(_tmpIsOnline);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getDataCount() {
    final String _sql = "SELECT COUNT(*) FROM startvisit ";
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
