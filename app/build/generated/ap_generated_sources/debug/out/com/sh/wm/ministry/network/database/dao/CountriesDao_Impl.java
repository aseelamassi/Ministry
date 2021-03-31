package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CountriesDao_Impl implements CountriesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Country> __insertionAdapterOfCountry;

  public CountriesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCountry = new EntityInsertionAdapter<Country>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `countries_table` (`cDTBCD`,`cDCD`,`cDARBTR`,`iSDELETE`,`cDCDNEW`,`cDENGTR`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Country value) {
        if (value.getCDTBCD() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCDTBCD());
        }
        if (value.getCDCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCDCD());
        }
        if (value.getCDARBTR() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCDARBTR());
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getISDELETE());
        }
        if (value.getCDCDNEW() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCDCDNEW());
        }
        if (value.getCDENGTR() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCDENGTR());
        }
      }
    };
  }

  @Override
  public void addCountry(final Country country) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCountry.insert(country);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Country>> getAllCountries() {
    final String _sql = "SELECT * FROM countries_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"countries_table"}, false, new Callable<List<Country>>() {
      @Override
      public List<Country> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCDTBCD = CursorUtil.getColumnIndexOrThrow(_cursor, "cDTBCD");
          final int _cursorIndexOfCDCD = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCD");
          final int _cursorIndexOfCDARBTR = CursorUtil.getColumnIndexOrThrow(_cursor, "cDARBTR");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final int _cursorIndexOfCDCDNEW = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCDNEW");
          final int _cursorIndexOfCDENGTR = CursorUtil.getColumnIndexOrThrow(_cursor, "cDENGTR");
          final List<Country> _result = new ArrayList<Country>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Country _item;
            _item = new Country();
            final String _tmpCDTBCD;
            _tmpCDTBCD = _cursor.getString(_cursorIndexOfCDTBCD);
            _item.setCDTBCD(_tmpCDTBCD);
            final String _tmpCDCD;
            _tmpCDCD = _cursor.getString(_cursorIndexOfCDCD);
            _item.setCDCD(_tmpCDCD);
            final String _tmpCDARBTR;
            _tmpCDARBTR = _cursor.getString(_cursorIndexOfCDARBTR);
            _item.setCDARBTR(_tmpCDARBTR);
            final String _tmpISDELETE;
            _tmpISDELETE = _cursor.getString(_cursorIndexOfISDELETE);
            _item.setISDELETE(_tmpISDELETE);
            final String _tmpCDCDNEW;
            _tmpCDCDNEW = _cursor.getString(_cursorIndexOfCDCDNEW);
            _item.setCDCDNEW(_tmpCDCDNEW);
            final String _tmpCDENGTR;
            _tmpCDENGTR = _cursor.getString(_cursorIndexOfCDENGTR);
            _item.setCDENGTR(_tmpCDENGTR);
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
  public LiveData<List<Country>> getAllCountries(final String countryName) {
    final String _sql = "SELECT * FROM countries_table where cDARBTR like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (countryName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, countryName);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"countries_table"}, false, new Callable<List<Country>>() {
      @Override
      public List<Country> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCDTBCD = CursorUtil.getColumnIndexOrThrow(_cursor, "cDTBCD");
          final int _cursorIndexOfCDCD = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCD");
          final int _cursorIndexOfCDARBTR = CursorUtil.getColumnIndexOrThrow(_cursor, "cDARBTR");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final int _cursorIndexOfCDCDNEW = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCDNEW");
          final int _cursorIndexOfCDENGTR = CursorUtil.getColumnIndexOrThrow(_cursor, "cDENGTR");
          final List<Country> _result = new ArrayList<Country>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Country _item;
            _item = new Country();
            final String _tmpCDTBCD;
            _tmpCDTBCD = _cursor.getString(_cursorIndexOfCDTBCD);
            _item.setCDTBCD(_tmpCDTBCD);
            final String _tmpCDCD;
            _tmpCDCD = _cursor.getString(_cursorIndexOfCDCD);
            _item.setCDCD(_tmpCDCD);
            final String _tmpCDARBTR;
            _tmpCDARBTR = _cursor.getString(_cursorIndexOfCDARBTR);
            _item.setCDARBTR(_tmpCDARBTR);
            final String _tmpISDELETE;
            _tmpISDELETE = _cursor.getString(_cursorIndexOfISDELETE);
            _item.setISDELETE(_tmpISDELETE);
            final String _tmpCDCDNEW;
            _tmpCDCDNEW = _cursor.getString(_cursorIndexOfCDCDNEW);
            _item.setCDCDNEW(_tmpCDCDNEW);
            final String _tmpCDENGTR;
            _tmpCDENGTR = _cursor.getString(_cursorIndexOfCDENGTR);
            _item.setCDENGTR(_tmpCDENGTR);
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
    final String _sql = "SELECT COUNT(*) FROM countries_table";
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

  @Override
  public LiveData<String> getUserCountry(final String countryID) {
    final String _sql = "SELECT cDARBTR FROM countries_table WHERE cDCDNEW = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (countryID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, countryID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"countries_table"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            _result = _cursor.getString(0);
          } else {
            _result = null;
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
}
