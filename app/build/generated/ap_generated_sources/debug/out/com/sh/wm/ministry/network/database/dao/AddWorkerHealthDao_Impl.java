package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerHealthModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AddWorkerHealthDao_Impl implements AddWorkerHealthDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddWorkerHealthModel> __insertionAdapterOfAddWorkerHealthModel;

  private final EntityDeletionOrUpdateAdapter<AddWorkerHealthModel> __deletionAdapterOfAddWorkerHealthModel;

  public AddWorkerHealthDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddWorkerHealthModel = new EntityInsertionAdapter<AddWorkerHealthModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AddWorkerHealth` (`userId`,`userHealthId`,`details`,`disabilityId`,`disabilityPlace`,`disabilitySize`,`reason`,`userSn`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddWorkerHealthModel value) {
        if (value.getUserId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserId());
        }
        if (value.getUserHealthId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserHealthId());
        }
        if (value.getDetails() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDetails());
        }
        if (value.getDisabilityId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDisabilityId());
        }
        if (value.getDisabilityPlace() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDisabilityPlace());
        }
        if (value.getDisabilitySize() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDisabilitySize());
        }
        if (value.getReason() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReason());
        }
        if (value.getUserSn() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserSn());
        }
      }
    };
    this.__deletionAdapterOfAddWorkerHealthModel = new EntityDeletionOrUpdateAdapter<AddWorkerHealthModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `AddWorkerHealth` WHERE `userSn` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddWorkerHealthModel value) {
        if (value.getUserSn() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserSn());
        }
      }
    };
  }

  @Override
  public void addAddWorkerHealthModel(final AddWorkerHealthModel model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAddWorkerHealthModel.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteAddWorkerHealthModel(final AddWorkerHealthModel model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfAddWorkerHealthModel.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddWorkerHealthModel> getAddWorkerHealth() {
    final String _sql = "SELECT * FROM AddWorkerHealth";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfUserHealthId = CursorUtil.getColumnIndexOrThrow(_cursor, "userHealthId");
      final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
      final int _cursorIndexOfDisabilityId = CursorUtil.getColumnIndexOrThrow(_cursor, "disabilityId");
      final int _cursorIndexOfDisabilityPlace = CursorUtil.getColumnIndexOrThrow(_cursor, "disabilityPlace");
      final int _cursorIndexOfDisabilitySize = CursorUtil.getColumnIndexOrThrow(_cursor, "disabilitySize");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfUserSn = CursorUtil.getColumnIndexOrThrow(_cursor, "userSn");
      final List<AddWorkerHealthModel> _result = new ArrayList<AddWorkerHealthModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddWorkerHealthModel _item;
        final String _tmpUserId;
        _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
        final String _tmpUserHealthId;
        _tmpUserHealthId = _cursor.getString(_cursorIndexOfUserHealthId);
        final String _tmpDetails;
        _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
        final String _tmpDisabilityId;
        _tmpDisabilityId = _cursor.getString(_cursorIndexOfDisabilityId);
        final String _tmpDisabilityPlace;
        _tmpDisabilityPlace = _cursor.getString(_cursorIndexOfDisabilityPlace);
        final String _tmpDisabilitySize;
        _tmpDisabilitySize = _cursor.getString(_cursorIndexOfDisabilitySize);
        final String _tmpReason;
        _tmpReason = _cursor.getString(_cursorIndexOfReason);
        final String _tmpUserSn;
        _tmpUserSn = _cursor.getString(_cursorIndexOfUserSn);
        _item = new AddWorkerHealthModel(_tmpUserId,_tmpUserHealthId,_tmpDetails,_tmpDisabilityId,_tmpDisabilityPlace,_tmpDisabilitySize,_tmpReason,_tmpUserSn);
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
    final String _sql = "SELECT COUNT(*) FROM AddWorkerHealth ";
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
