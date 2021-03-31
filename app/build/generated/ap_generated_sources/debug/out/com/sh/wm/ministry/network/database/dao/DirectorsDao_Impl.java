package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.directors.Director;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DirectorsDao_Impl implements DirectorsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Director> __insertionAdapterOfDirector;

  public DirectorsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDirector = new EntityInsertionAdapter<Director>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `directors_table` (`iD`,`nAME`,`iSDELETE`,`oLD`,`cONSTID`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Director value) {
        if (value.getID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getID());
        }
        if (value.getNAME() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNAME());
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getISDELETE());
        }
        if (value.getOLD() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOLD());
        }
        if (value.getCONSTID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCONSTID());
        }
      }
    };
  }

  @Override
  public void addDirector(final Director director) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDirector.insert(director);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Director>> getAllDirectors() {
    final String _sql = "SELECT * FROM directors_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"directors_table"}, false, new Callable<List<Director>>() {
      @Override
      public List<Director> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "iD");
          final int _cursorIndexOfNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "nAME");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final int _cursorIndexOfOLD = CursorUtil.getColumnIndexOrThrow(_cursor, "oLD");
          final int _cursorIndexOfCONSTID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTID");
          final List<Director> _result = new ArrayList<Director>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Director _item;
            _item = new Director();
            final String _tmpID;
            _tmpID = _cursor.getString(_cursorIndexOfID);
            _item.setID(_tmpID);
            final String _tmpNAME;
            _tmpNAME = _cursor.getString(_cursorIndexOfNAME);
            _item.setNAME(_tmpNAME);
            final String _tmpISDELETE;
            _tmpISDELETE = _cursor.getString(_cursorIndexOfISDELETE);
            _item.setISDELETE(_tmpISDELETE);
            final String _tmpOLD;
            _tmpOLD = _cursor.getString(_cursorIndexOfOLD);
            _item.setOLD(_tmpOLD);
            final String _tmpCONSTID;
            _tmpCONSTID = _cursor.getString(_cursorIndexOfCONSTID);
            _item.setCONSTID(_tmpCONSTID);
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
    final String _sql = "SELECT COUNT(*) FROM directors_table";
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
