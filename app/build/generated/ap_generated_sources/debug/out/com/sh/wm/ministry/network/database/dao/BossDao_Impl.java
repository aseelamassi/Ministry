package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.BossModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BossDao_Impl implements BossDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BossModel> __insertionAdapterOfBossModel;

  private final EntityDeletionOrUpdateAdapter<BossModel> __deletionAdapterOfBossModel;

  public BossDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBossModel = new EntityInsertionAdapter<BossModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `BossModel` (`constructId`,`constantInformative`,`userSn`,`informativeType`,`description`,`visitId`,`type`,`submitAction`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BossModel value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
        if (value.getConstantInformative() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getConstantInformative());
        }
        if (value.getUserSn() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserSn());
        }
        if (value.getInformativeType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getInformativeType());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescription());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getVisitId());
        }
        if (value.getType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getType());
        }
        if (value.getSubmitAction() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSubmitAction());
        }
      }
    };
    this.__deletionAdapterOfBossModel = new EntityDeletionOrUpdateAdapter<BossModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `BossModel` WHERE `visitId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BossModel value) {
        if (value.getVisitId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisitId());
        }
      }
    };
  }

  @Override
  public void addBossModel(final BossModel model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBossModel.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteBossModel(final BossModel model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfBossModel.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<BossModel> getBossModel() {
    final String _sql = "SELECT * FROM BossModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfConstantInformative = CursorUtil.getColumnIndexOrThrow(_cursor, "constantInformative");
      final int _cursorIndexOfUserSn = CursorUtil.getColumnIndexOrThrow(_cursor, "userSn");
      final int _cursorIndexOfInformativeType = CursorUtil.getColumnIndexOrThrow(_cursor, "informativeType");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSubmitAction = CursorUtil.getColumnIndexOrThrow(_cursor, "submitAction");
      final List<BossModel> _result = new ArrayList<BossModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BossModel _item;
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpConstantInformative;
        _tmpConstantInformative = _cursor.getString(_cursorIndexOfConstantInformative);
        final String _tmpUserSn;
        _tmpUserSn = _cursor.getString(_cursorIndexOfUserSn);
        final String _tmpInformativeType;
        _tmpInformativeType = _cursor.getString(_cursorIndexOfInformativeType);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final String _tmpSubmitAction;
        _tmpSubmitAction = _cursor.getString(_cursorIndexOfSubmitAction);
        _item = new BossModel(_tmpConstructId,_tmpConstantInformative,_tmpUserSn,_tmpInformativeType,_tmpDescription,_tmpVisitId,_tmpType,_tmpSubmitAction);
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
    final String _sql = "SELECT COUNT(*) FROM BossModel ";
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
