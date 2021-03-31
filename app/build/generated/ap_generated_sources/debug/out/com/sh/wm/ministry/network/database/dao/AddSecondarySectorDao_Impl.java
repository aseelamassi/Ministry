package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddSecondarySector;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AddSecondarySectorDao_Impl implements AddSecondarySectorDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddSecondarySector> __insertionAdapterOfAddSecondarySector;

  private final EntityDeletionOrUpdateAdapter<AddSecondarySector> __deletionAdapterOfAddSecondarySector;

  public AddSecondarySectorDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddSecondarySector = new EntityInsertionAdapter<AddSecondarySector>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AddSecondarySector` (`constructId`,`sectorId`,`sectorDescription`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddSecondarySector value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
        if (value.getSectorId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSectorId());
        }
        if (value.getSectorDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSectorDescription());
        }
      }
    };
    this.__deletionAdapterOfAddSecondarySector = new EntityDeletionOrUpdateAdapter<AddSecondarySector>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `AddSecondarySector` WHERE `sectorId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddSecondarySector value) {
        if (value.getSectorId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSectorId());
        }
      }
    };
  }

  @Override
  public void addSecondarySector(final AddSecondarySector model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAddSecondarySector.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteSecondarySector(final AddSecondarySector model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfAddSecondarySector.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddSecondarySector> getSecondarySector() {
    final String _sql = "SELECT * FROM AddSecondarySector";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfSectorId = CursorUtil.getColumnIndexOrThrow(_cursor, "sectorId");
      final int _cursorIndexOfSectorDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "sectorDescription");
      final List<AddSecondarySector> _result = new ArrayList<AddSecondarySector>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddSecondarySector _item;
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpSectorId;
        _tmpSectorId = _cursor.getString(_cursorIndexOfSectorId);
        final String _tmpSectorDescription;
        _tmpSectorDescription = _cursor.getString(_cursorIndexOfSectorDescription);
        _item = new AddSecondarySector(_tmpConstructId,_tmpSectorId,_tmpSectorDescription);
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
    final String _sql = "SELECT COUNT(*) FROM AddSecondarySector ";
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
