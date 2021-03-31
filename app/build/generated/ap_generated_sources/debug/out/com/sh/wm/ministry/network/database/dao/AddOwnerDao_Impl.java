package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddOwnerModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AddOwnerDao_Impl implements AddOwnerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddOwnerModel> __insertionAdapterOfAddOwnerModel;

  private final EntityDeletionOrUpdateAdapter<AddOwnerModel> __deletionAdapterOfAddOwnerModel;

  public AddOwnerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddOwnerModel = new EntityInsertionAdapter<AddOwnerModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AddOwnerModel` (`constructId`,`userSn`,`userId`,`startDate`,`visitId`,`type`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddOwnerModel value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
        if (value.getUserSn() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserSn());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserId());
        }
        if (value.getStartDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStartDate());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getVisitId());
        }
        if (value.getType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getType());
        }
      }
    };
    this.__deletionAdapterOfAddOwnerModel = new EntityDeletionOrUpdateAdapter<AddOwnerModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `AddOwnerModel` WHERE `userSn` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddOwnerModel value) {
        if (value.getUserSn() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserSn());
        }
      }
    };
  }

  @Override
  public void addAddOwnerModel(final AddOwnerModel model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAddOwnerModel.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteOwnerModel(final AddOwnerModel model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfAddOwnerModel.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddOwnerModel> getAddOwner() {
    final String _sql = "SELECT * FROM AddOwnerModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfUserSn = CursorUtil.getColumnIndexOrThrow(_cursor, "userSn");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final List<AddOwnerModel> _result = new ArrayList<AddOwnerModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddOwnerModel _item;
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpUserSn;
        _tmpUserSn = _cursor.getString(_cursorIndexOfUserSn);
        final String _tmpUserId;
        _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
        final String _tmpStartDate;
        _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item = new AddOwnerModel(_tmpConstructId,_tmpUserSn,_tmpUserId,_tmpStartDate,_tmpVisitId,_tmpType);
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
    final String _sql = "SELECT COUNT(*) FROM AddOwnerModel ";
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
