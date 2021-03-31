package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.convertors.DBConverter;
import com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompany;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class InsuranceCompanyDao_Impl implements InsuranceCompanyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InsuranceCompany> __insertionAdapterOfInsuranceCompany;

  private final DBConverter __dBConverter = new DBConverter();

  public InsuranceCompanyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInsuranceCompany = new EntityInsertionAdapter<InsuranceCompany>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `InsuranceCompany` (`pOLICYCD`,`pOLICYDESC`,`fLAG`,`iSDELETE`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InsuranceCompany value) {
        if (value.getPOLICYCD() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPOLICYCD());
        }
        if (value.getPOLICYDESC() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPOLICYDESC());
        }
        final String _tmp;
        _tmp = __dBConverter.toJson(value.getFLAG());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getISDELETE());
        }
      }
    };
  }

  @Override
  public void addInsuranceCompany(final InsuranceCompany insuranceCompanyModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInsuranceCompany.insert(insuranceCompanyModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<InsuranceCompany>> getAllInsuranceCompany() {
    final String _sql = "SELECT * FROM InsuranceCompany";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"InsuranceCompany"}, false, new Callable<List<InsuranceCompany>>() {
      @Override
      public List<InsuranceCompany> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPOLICYCD = CursorUtil.getColumnIndexOrThrow(_cursor, "pOLICYCD");
          final int _cursorIndexOfPOLICYDESC = CursorUtil.getColumnIndexOrThrow(_cursor, "pOLICYDESC");
          final int _cursorIndexOfFLAG = CursorUtil.getColumnIndexOrThrow(_cursor, "fLAG");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final List<InsuranceCompany> _result = new ArrayList<InsuranceCompany>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final InsuranceCompany _item;
            _item = new InsuranceCompany();
            final String _tmpPOLICYCD;
            _tmpPOLICYCD = _cursor.getString(_cursorIndexOfPOLICYCD);
            _item.setPOLICYCD(_tmpPOLICYCD);
            final String _tmpPOLICYDESC;
            _tmpPOLICYDESC = _cursor.getString(_cursorIndexOfPOLICYDESC);
            _item.setPOLICYDESC(_tmpPOLICYDESC);
            final Object _tmpFLAG;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfFLAG);
            _tmpFLAG = __dBConverter.fromJson(_tmp);
            _item.setFLAG(_tmpFLAG);
            final String _tmpISDELETE;
            _tmpISDELETE = _cursor.getString(_cursorIndexOfISDELETE);
            _item.setISDELETE(_tmpISDELETE);
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
    final String _sql = "SELECT COUNT(*) FROM InsuranceCompany";
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
