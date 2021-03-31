package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.languages.Language;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LanguagesDao_Impl implements LanguagesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Language> __insertionAdapterOfLanguage;

  private final EntityDeletionOrUpdateAdapter<Language> __deletionAdapterOfLanguage;

  private final EntityDeletionOrUpdateAdapter<Language> __updateAdapterOfLanguage;

  public LanguagesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLanguage = new EntityInsertionAdapter<Language>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `languages_table` (`lANGUAGEID`,`lANGUAGEARNAME`,`lANGUAGEENNAME`,`iSDELETE`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Language value) {
        if (value.getLANGUAGEID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getLANGUAGEID());
        }
        if (value.getLANGUAGEARNAME() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLANGUAGEARNAME());
        }
        if (value.getLANGUAGEENNAME() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLANGUAGEENNAME());
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getISDELETE());
        }
      }
    };
    this.__deletionAdapterOfLanguage = new EntityDeletionOrUpdateAdapter<Language>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `languages_table` WHERE `lANGUAGEID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Language value) {
        if (value.getLANGUAGEID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getLANGUAGEID());
        }
      }
    };
    this.__updateAdapterOfLanguage = new EntityDeletionOrUpdateAdapter<Language>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `languages_table` SET `lANGUAGEID` = ?,`lANGUAGEARNAME` = ?,`lANGUAGEENNAME` = ?,`iSDELETE` = ? WHERE `lANGUAGEID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Language value) {
        if (value.getLANGUAGEID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getLANGUAGEID());
        }
        if (value.getLANGUAGEARNAME() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLANGUAGEARNAME());
        }
        if (value.getLANGUAGEENNAME() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLANGUAGEENNAME());
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getISDELETE());
        }
        if (value.getLANGUAGEID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLANGUAGEID());
        }
      }
    };
  }

  @Override
  public void addLanguage(final Language language) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLanguage.insert(language);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteAllLanguage(final Language language) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfLanguage.handle(language);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateAllLanguage(final Language language) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfLanguage.handle(language);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Language>> getAllLanguages(final String keyword) {
    final String _sql = "SELECT * FROM languages_table where lANGUAGEARNAME LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"languages_table"}, false, new Callable<List<Language>>() {
      @Override
      public List<Language> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLANGUAGEID = CursorUtil.getColumnIndexOrThrow(_cursor, "lANGUAGEID");
          final int _cursorIndexOfLANGUAGEARNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "lANGUAGEARNAME");
          final int _cursorIndexOfLANGUAGEENNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "lANGUAGEENNAME");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final List<Language> _result = new ArrayList<Language>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Language _item;
            _item = new Language();
            final String _tmpLANGUAGEID;
            _tmpLANGUAGEID = _cursor.getString(_cursorIndexOfLANGUAGEID);
            _item.setLANGUAGEID(_tmpLANGUAGEID);
            final String _tmpLANGUAGEARNAME;
            _tmpLANGUAGEARNAME = _cursor.getString(_cursorIndexOfLANGUAGEARNAME);
            _item.setLANGUAGEARNAME(_tmpLANGUAGEARNAME);
            final String _tmpLANGUAGEENNAME;
            _tmpLANGUAGEENNAME = _cursor.getString(_cursorIndexOfLANGUAGEENNAME);
            _item.setLANGUAGEENNAME(_tmpLANGUAGEENNAME);
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
  public LiveData<List<Language>> getAllLanguages() {
    final String _sql = "SELECT * FROM languages_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"languages_table"}, false, new Callable<List<Language>>() {
      @Override
      public List<Language> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLANGUAGEID = CursorUtil.getColumnIndexOrThrow(_cursor, "lANGUAGEID");
          final int _cursorIndexOfLANGUAGEARNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "lANGUAGEARNAME");
          final int _cursorIndexOfLANGUAGEENNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "lANGUAGEENNAME");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final List<Language> _result = new ArrayList<Language>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Language _item;
            _item = new Language();
            final String _tmpLANGUAGEID;
            _tmpLANGUAGEID = _cursor.getString(_cursorIndexOfLANGUAGEID);
            _item.setLANGUAGEID(_tmpLANGUAGEID);
            final String _tmpLANGUAGEARNAME;
            _tmpLANGUAGEARNAME = _cursor.getString(_cursorIndexOfLANGUAGEARNAME);
            _item.setLANGUAGEARNAME(_tmpLANGUAGEARNAME);
            final String _tmpLANGUAGEENNAME;
            _tmpLANGUAGEENNAME = _cursor.getString(_cursorIndexOfLANGUAGEENNAME);
            _item.setLANGUAGEENNAME(_tmpLANGUAGEENNAME);
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
  public boolean checkAllLanguages() {
    final String _sql = "SELECT EXISTS(SELECT * FROM languages_table)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getDataCount() {
    final String _sql = "SELECT COUNT(*) FROM languages_table";
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
