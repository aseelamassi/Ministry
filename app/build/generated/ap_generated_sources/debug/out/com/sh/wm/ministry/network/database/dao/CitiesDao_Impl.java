package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.cities.City;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CitiesDao_Impl implements CitiesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<City> __insertionAdapterOfCity;

  public CitiesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCity = new EntityInsertionAdapter<City>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `cities_table` (`rEGIONID`,`rEGIONNAMEAR`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, City value) {
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
      }
    };
  }

  @Override
  public void addCity(final City city) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCity.insert(city);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<City>> getAllCities() {
    final String _sql = "SELECT * FROM cities_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"cities_table"}, false, new Callable<List<City>>() {
      @Override
      public List<City> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfREGIONID = CursorUtil.getColumnIndexOrThrow(_cursor, "rEGIONID");
          final int _cursorIndexOfREGIONNAMEAR = CursorUtil.getColumnIndexOrThrow(_cursor, "rEGIONNAMEAR");
          final List<City> _result = new ArrayList<City>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final City _item;
            _item = new City();
            final String _tmpREGIONID;
            _tmpREGIONID = _cursor.getString(_cursorIndexOfREGIONID);
            _item.setREGIONID(_tmpREGIONID);
            final String _tmpREGIONNAMEAR;
            _tmpREGIONNAMEAR = _cursor.getString(_cursorIndexOfREGIONNAMEAR);
            _item.setREGIONNAMEAR(_tmpREGIONNAMEAR);
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
    final String _sql = "SELECT COUNT(*) FROM cities_table";
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
