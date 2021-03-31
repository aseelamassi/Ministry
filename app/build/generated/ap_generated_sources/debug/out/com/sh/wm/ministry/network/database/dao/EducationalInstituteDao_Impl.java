package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitute;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EducationalInstituteDao_Impl implements EducationalInstituteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EducationalInstitute> __insertionAdapterOfEducationalInstitute;

  public EducationalInstituteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEducationalInstitute = new EntityInsertionAdapter<EducationalInstitute>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `educational_institutes_table` (`eDUINSTITUTESID`,`eDUINSTITUTESARNAME`,`eDUINSTITUTESENNAME`,`eDUINSTITUTESCOUNTRY`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EducationalInstitute value) {
        if (value.getEDUINSTITUTESID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getEDUINSTITUTESID());
        }
        if (value.getEDUINSTITUTESARNAME() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEDUINSTITUTESARNAME());
        }
        if (value.getEDUINSTITUTESENNAME() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEDUINSTITUTESENNAME());
        }
        if (value.getEDUINSTITUTESCOUNTRY() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEDUINSTITUTESCOUNTRY());
        }
      }
    };
  }

  @Override
  public void addEducationalInstitute(final EducationalInstitute educationalInstitute) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEducationalInstitute.insert(educationalInstitute);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<EducationalInstitute>> getAllEducationalInstitutes() {
    final String _sql = "SELECT * FROM educational_institutes_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"educational_institutes_table"}, false, new Callable<List<EducationalInstitute>>() {
      @Override
      public List<EducationalInstitute> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEDUINSTITUTESID = CursorUtil.getColumnIndexOrThrow(_cursor, "eDUINSTITUTESID");
          final int _cursorIndexOfEDUINSTITUTESARNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "eDUINSTITUTESARNAME");
          final int _cursorIndexOfEDUINSTITUTESENNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "eDUINSTITUTESENNAME");
          final int _cursorIndexOfEDUINSTITUTESCOUNTRY = CursorUtil.getColumnIndexOrThrow(_cursor, "eDUINSTITUTESCOUNTRY");
          final List<EducationalInstitute> _result = new ArrayList<EducationalInstitute>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EducationalInstitute _item;
            _item = new EducationalInstitute();
            final String _tmpEDUINSTITUTESID;
            _tmpEDUINSTITUTESID = _cursor.getString(_cursorIndexOfEDUINSTITUTESID);
            _item.setEDUINSTITUTESID(_tmpEDUINSTITUTESID);
            final String _tmpEDUINSTITUTESARNAME;
            _tmpEDUINSTITUTESARNAME = _cursor.getString(_cursorIndexOfEDUINSTITUTESARNAME);
            _item.setEDUINSTITUTESARNAME(_tmpEDUINSTITUTESARNAME);
            final String _tmpEDUINSTITUTESENNAME;
            _tmpEDUINSTITUTESENNAME = _cursor.getString(_cursorIndexOfEDUINSTITUTESENNAME);
            _item.setEDUINSTITUTESENNAME(_tmpEDUINSTITUTESENNAME);
            final String _tmpEDUINSTITUTESCOUNTRY;
            _tmpEDUINSTITUTESCOUNTRY = _cursor.getString(_cursorIndexOfEDUINSTITUTESCOUNTRY);
            _item.setEDUINSTITUTESCOUNTRY(_tmpEDUINSTITUTESCOUNTRY);
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
    final String _sql = "SELECT COUNT(*) FROM educational_institutes_table";
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
