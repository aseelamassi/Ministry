package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MunicipalitiesDao_Impl implements MunicipalitiesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Municipality> __insertionAdapterOfMunicipality;

  public MunicipalitiesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMunicipality = new EntityInsertionAdapter<Municipality>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `municipalities_table` (`mUNICIPALITYID`,`mUNICIPALITYNAMEAR`,`directorId`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Municipality value) {
        if (value.getMUNICIPALITYID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMUNICIPALITYID());
        }
        if (value.getMUNICIPALITYNAMEAR() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMUNICIPALITYNAMEAR());
        }
        if (value.getDirectorId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDirectorId());
        }
      }
    };
  }

  @Override
  public void addMunicipality(final Municipality municipality) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMunicipality.insert(municipality);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Municipality>> getAllMunicipalities(final String directorId) {
    final String _sql = "SELECT * FROM municipalities_table where directorId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (directorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, directorId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"municipalities_table"}, false, new Callable<List<Municipality>>() {
      @Override
      public List<Municipality> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMUNICIPALITYID = CursorUtil.getColumnIndexOrThrow(_cursor, "mUNICIPALITYID");
          final int _cursorIndexOfMUNICIPALITYNAMEAR = CursorUtil.getColumnIndexOrThrow(_cursor, "mUNICIPALITYNAMEAR");
          final int _cursorIndexOfDirectorId = CursorUtil.getColumnIndexOrThrow(_cursor, "directorId");
          final List<Municipality> _result = new ArrayList<Municipality>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Municipality _item;
            _item = new Municipality();
            final String _tmpMUNICIPALITYID;
            _tmpMUNICIPALITYID = _cursor.getString(_cursorIndexOfMUNICIPALITYID);
            _item.setMUNICIPALITYID(_tmpMUNICIPALITYID);
            final String _tmpMUNICIPALITYNAMEAR;
            _tmpMUNICIPALITYNAMEAR = _cursor.getString(_cursorIndexOfMUNICIPALITYNAMEAR);
            _item.setMUNICIPALITYNAMEAR(_tmpMUNICIPALITYNAMEAR);
            final String _tmpDirectorId;
            _tmpDirectorId = _cursor.getString(_cursorIndexOfDirectorId);
            _item.setDirectorId(_tmpDirectorId);
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
    final String _sql = "SELECT COUNT(*) FROM municipalities_table";
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
