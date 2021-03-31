package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgram;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EduProgramDao_Impl implements EduProgramDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EduProgram> __insertionAdapterOfEduProgram;

  public EduProgramDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEduProgram = new EntityInsertionAdapter<EduProgram>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `edu_programs_table` (`pROGCD`,`pROGDESC`,`iSDELETE`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EduProgram value) {
        if (value.getPROGCD() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPROGCD());
        }
        if (value.getPROGDESC() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPROGDESC());
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getISDELETE());
        }
      }
    };
  }

  @Override
  public void addEduProgram(final EduProgram eduProgram) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEduProgram.insert(eduProgram);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<EduProgram>> getAllEduPrograms() {
    final String _sql = "SELECT * FROM edu_programs_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"edu_programs_table"}, false, new Callable<List<EduProgram>>() {
      @Override
      public List<EduProgram> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPROGCD = CursorUtil.getColumnIndexOrThrow(_cursor, "pROGCD");
          final int _cursorIndexOfPROGDESC = CursorUtil.getColumnIndexOrThrow(_cursor, "pROGDESC");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final List<EduProgram> _result = new ArrayList<EduProgram>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EduProgram _item;
            _item = new EduProgram();
            final String _tmpPROGCD;
            _tmpPROGCD = _cursor.getString(_cursorIndexOfPROGCD);
            _item.setPROGCD(_tmpPROGCD);
            final String _tmpPROGDESC;
            _tmpPROGDESC = _cursor.getString(_cursorIndexOfPROGDESC);
            _item.setPROGDESC(_tmpPROGDESC);
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
    final String _sql = "SELECT COUNT(*) FROM edu_programs_table";
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
