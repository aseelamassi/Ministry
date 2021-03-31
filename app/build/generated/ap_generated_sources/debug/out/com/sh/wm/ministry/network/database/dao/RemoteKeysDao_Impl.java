package com.sh.wm.ministry.network.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.RemoteKeys;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RemoteKeysDao_Impl implements RemoteKeysDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RemoteKeys> __insertionAdapterOfRemoteKeys;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRemoteKeys;

  public RemoteKeysDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRemoteKeys = new EntityInsertionAdapter<RemoteKeys>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `RemoteKeys` (`visitId`,`nextKeys`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RemoteKeys value) {
        if (value.getVisitId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisitId());
        }
        if (value.getNextKeys() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNextKeys());
        }
      }
    };
    this.__preparedStmtOfDeleteRemoteKeys = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from RemoteKeys";
        return _query;
      }
    };
  }

  @Override
  public void addRemoteKeys(final RemoteKeys model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRemoteKeys.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteRemoteKeys() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRemoteKeys.acquire();
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteRemoteKeys.release(_stmt);
    }
  }
}
