package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualification;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EduQualificationDao_Impl implements EduQualificationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EduQualification> __insertionAdapterOfEduQualification;

  public EduQualificationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEduQualification = new EntityInsertionAdapter<EduQualification>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `eduQualification_table` (`qUALIFICATIONID`,`qUALIFICATIONNAME`,`qUALIFICATIONDESC`,`eDUTYPEID`,`fLAGQUALTYPE`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EduQualification value) {
        if (value.qUALIFICATIONID == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.qUALIFICATIONID);
        }
        if (value.qUALIFICATIONNAME == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.qUALIFICATIONNAME);
        }
        if (value.qUALIFICATIONDESC == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.qUALIFICATIONDESC);
        }
        if (value.eDUTYPEID == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.eDUTYPEID);
        }
        if (value.fLAGQUALTYPE == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.fLAGQUALTYPE);
        }
      }
    };
  }

  @Override
  public void addEduQualification(final EduQualification eduQualification) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEduQualification.insert(eduQualification);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<EduQualification>> getAllEduQualification(final String eduTypeId) {
    final String _sql = "SELECT * FROM eduQualification_table where eDUTYPEID = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (eduTypeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, eduTypeId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"eduQualification_table"}, false, new Callable<List<EduQualification>>() {
      @Override
      public List<EduQualification> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfQUALIFICATIONID = CursorUtil.getColumnIndexOrThrow(_cursor, "qUALIFICATIONID");
          final int _cursorIndexOfQUALIFICATIONNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "qUALIFICATIONNAME");
          final int _cursorIndexOfQUALIFICATIONDESC = CursorUtil.getColumnIndexOrThrow(_cursor, "qUALIFICATIONDESC");
          final int _cursorIndexOfEDUTYPEID = CursorUtil.getColumnIndexOrThrow(_cursor, "eDUTYPEID");
          final int _cursorIndexOfFLAGQUALTYPE = CursorUtil.getColumnIndexOrThrow(_cursor, "fLAGQUALTYPE");
          final List<EduQualification> _result = new ArrayList<EduQualification>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EduQualification _item;
            _item = new EduQualification();
            _item.qUALIFICATIONID = _cursor.getString(_cursorIndexOfQUALIFICATIONID);
            _item.qUALIFICATIONNAME = _cursor.getString(_cursorIndexOfQUALIFICATIONNAME);
            _item.qUALIFICATIONDESC = _cursor.getString(_cursorIndexOfQUALIFICATIONDESC);
            _item.eDUTYPEID = _cursor.getString(_cursorIndexOfEDUTYPEID);
            _item.fLAGQUALTYPE = _cursor.getString(_cursorIndexOfFLAGQUALTYPE);
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
    final String _sql = "SELECT COUNT(*) FROM eduQualification_table";
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
