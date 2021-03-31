package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.regions.Region;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RegionsDao_Impl implements RegionsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Region> __insertionAdapterOfRegion;

  public RegionsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRegion = new EntityInsertionAdapter<Region>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `regions_table` (`rEGIONID`,`rEGIONNAMEAR`,`directorateId`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Region value) {
        if (value.getREGIONID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getREGIONID());
        }
        if (value.getREGIONNAMEAR() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getREGIONNAMEAR());
        }
        if (value.getDirectorateId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDirectorateId());
        }
      }
    };
  }

  @Override
  public void addRegion(final Region region) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRegion.insert(region);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Region>> getAllRegions(final String directorateID) {
    final String _sql = "SELECT * FROM regions_table where directorateId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (directorateID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, directorateID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"regions_table"}, false, new Callable<List<Region>>() {
      @Override
      public List<Region> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfREGIONID = CursorUtil.getColumnIndexOrThrow(_cursor, "rEGIONID");
          final int _cursorIndexOfREGIONNAMEAR = CursorUtil.getColumnIndexOrThrow(_cursor, "rEGIONNAMEAR");
          final int _cursorIndexOfDirectorateId = CursorUtil.getColumnIndexOrThrow(_cursor, "directorateId");
          final List<Region> _result = new ArrayList<Region>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Region _item;
            _item = new Region();
            final String _tmpREGIONID;
            _tmpREGIONID = _cursor.getString(_cursorIndexOfREGIONID);
            _item.setREGIONID(_tmpREGIONID);
            final String _tmpREGIONNAMEAR;
            _tmpREGIONNAMEAR = _cursor.getString(_cursorIndexOfREGIONNAMEAR);
            _item.setREGIONNAMEAR(_tmpREGIONNAMEAR);
            final String _tmpDirectorateId;
            _tmpDirectorateId = _cursor.getString(_cursorIndexOfDirectorateId);
            _item.setDirectorateId(_tmpDirectorateId);
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
    final String _sql = "SELECT COUNT(*) FROM regions_table";
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
