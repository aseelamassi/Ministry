package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail.EduQualificationDetail;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EduQualificationDetailDao_Impl implements EduQualificationDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EduQualificationDetail> __insertionAdapterOfEduQualificationDetail;

  public EduQualificationDetailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEduQualificationDetail = new EntityInsertionAdapter<EduQualificationDetail>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `eduQualificationDetails_table` (`qUALDETAILSID`,`qUALDETAILSNAME`,`qUALDETAILSEDUTYPEID`,`qUALID`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EduQualificationDetail value) {
        if (value.qUALDETAILSID == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.qUALDETAILSID);
        }
        if (value.qUALDETAILSNAME == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.qUALDETAILSNAME);
        }
        if (value.qUALDETAILSEDUTYPEID == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.qUALDETAILSEDUTYPEID);
        }
        if (value.qUALID == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.qUALID);
        }
      }
    };
  }

  @Override
  public void addEduQualificationDetail(final EduQualificationDetail eduQualificationDetail) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEduQualificationDetail.insert(eduQualificationDetail);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<EduQualificationDetail>> getAllEduQualification(final String eduTypeId) {
    final String _sql = "SELECT * FROM eduQualificationDetails_table where qUALDETAILSEDUTYPEID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (eduTypeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, eduTypeId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"eduQualificationDetails_table"}, false, new Callable<List<EduQualificationDetail>>() {
      @Override
      public List<EduQualificationDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfQUALDETAILSID = CursorUtil.getColumnIndexOrThrow(_cursor, "qUALDETAILSID");
          final int _cursorIndexOfQUALDETAILSNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "qUALDETAILSNAME");
          final int _cursorIndexOfQUALDETAILSEDUTYPEID = CursorUtil.getColumnIndexOrThrow(_cursor, "qUALDETAILSEDUTYPEID");
          final int _cursorIndexOfQUALID = CursorUtil.getColumnIndexOrThrow(_cursor, "qUALID");
          final List<EduQualificationDetail> _result = new ArrayList<EduQualificationDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EduQualificationDetail _item;
            _item = new EduQualificationDetail();
            _item.qUALDETAILSID = _cursor.getString(_cursorIndexOfQUALDETAILSID);
            _item.qUALDETAILSNAME = _cursor.getString(_cursorIndexOfQUALDETAILSNAME);
            _item.qUALDETAILSEDUTYPEID = _cursor.getString(_cursorIndexOfQUALDETAILSEDUTYPEID);
            _item.qUALID = _cursor.getString(_cursorIndexOfQUALID);
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
    final String _sql = "SELECT COUNT(*) FROM eduQualificationDetails_table";
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
