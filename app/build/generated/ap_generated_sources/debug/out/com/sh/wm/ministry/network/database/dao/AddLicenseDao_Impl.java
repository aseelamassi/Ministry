package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLicenseData;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AddLicenseDao_Impl implements AddLicenseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddLicenseData> __insertionAdapterOfAddLicenseData;

  private final EntityDeletionOrUpdateAdapter<AddLicenseData> __deletionAdapterOfAddLicenseData;

  public AddLicenseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddLicenseData = new EntityInsertionAdapter<AddLicenseData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AddLicenseData` (`constructId`,`licenseId`,`licenseNumber`,`visitId`,`type`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddLicenseData value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
        if (value.getLicenseId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLicenseId());
        }
        if (value.getLicenseNumber() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLicenseNumber());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getVisitId());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
      }
    };
    this.__deletionAdapterOfAddLicenseData = new EntityDeletionOrUpdateAdapter<AddLicenseData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `AddLicenseData` WHERE `licenseId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddLicenseData value) {
        if (value.getLicenseId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getLicenseId());
        }
      }
    };
  }

  @Override
  public void addLicenseModel(final AddLicenseData model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAddLicenseData.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteLicense(final AddLicenseData model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfAddLicenseData.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddLicenseData> getAddLicenseData(final String type) {
    final String _sql = "SELECT * FROM AddLicenseData where type like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfLicenseId = CursorUtil.getColumnIndexOrThrow(_cursor, "licenseId");
      final int _cursorIndexOfLicenseNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "licenseNumber");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final List<AddLicenseData> _result = new ArrayList<AddLicenseData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddLicenseData _item;
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpLicenseId;
        _tmpLicenseId = _cursor.getString(_cursorIndexOfLicenseId);
        final String _tmpLicenseNumber;
        _tmpLicenseNumber = _cursor.getString(_cursorIndexOfLicenseNumber);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item = new AddLicenseData(_tmpConstructId,_tmpLicenseId,_tmpLicenseNumber,_tmpVisitId,_tmpType);
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
    final String _sql = "SELECT COUNT(*) FROM AddLicenseData ";
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
