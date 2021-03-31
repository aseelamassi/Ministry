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
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ConstantsDao_Impl implements ConstantsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Constants> __insertionAdapterOfConstants;

  private final EntityDeletionOrUpdateAdapter<Constants> __deletionAdapterOfConstants;

  public ConstantsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConstants = new EntityInsertionAdapter<Constants>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `constants_table` (`cONSTANTID`,`cONSTANTPARENTID`,`cONSTANTARANAME`,`cONSTANTENGNAME`,`iNSERTUSERSN`,`iNSERTDATE`,`uPDATEUSERSN`,`iSDELETE`,`oLDID`,`cONSTANTPARENTTBL`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Constants value) {
        if (value.getCONSTANTID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCONSTANTID());
        }
        if (value.getCONSTANTPARENTID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCONSTANTPARENTID());
        }
        if (value.getCONSTANTARANAME() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCONSTANTARANAME());
        }
        if (value.getCONSTANTENGNAME() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCONSTANTENGNAME());
        }
        if (value.getINSERTUSERSN() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getINSERTUSERSN());
        }
        if (value.getINSERTDATE() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getINSERTDATE());
        }
        if (value.getUPDATEUSERSN() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUPDATEUSERSN());
        }
        if (value.getISDELETE() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getISDELETE());
        }
        if (value.getOLDID() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getOLDID());
        }
        if (value.getCONSTANTPARENTTBL() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCONSTANTPARENTTBL());
        }
      }
    };
    this.__deletionAdapterOfConstants = new EntityDeletionOrUpdateAdapter<Constants>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `constants_table` WHERE `cONSTANTID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Constants value) {
        if (value.getCONSTANTID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCONSTANTID());
        }
      }
    };
  }

  @Override
  public void addConstant(final Constants constants) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfConstants.insert(constants);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteConstants(final Constants constants) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfConstants.handle(constants);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Constants>> getAllConstants() {
    final String _sql = "SELECT * FROM constants_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"constants_table"}, false, new Callable<List<Constants>>() {
      @Override
      public List<Constants> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCONSTANTID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTID");
          final int _cursorIndexOfCONSTANTPARENTID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTPARENTID");
          final int _cursorIndexOfCONSTANTARANAME = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTARANAME");
          final int _cursorIndexOfCONSTANTENGNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTENGNAME");
          final int _cursorIndexOfINSERTUSERSN = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSERTUSERSN");
          final int _cursorIndexOfINSERTDATE = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSERTDATE");
          final int _cursorIndexOfUPDATEUSERSN = CursorUtil.getColumnIndexOrThrow(_cursor, "uPDATEUSERSN");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final int _cursorIndexOfOLDID = CursorUtil.getColumnIndexOrThrow(_cursor, "oLDID");
          final int _cursorIndexOfCONSTANTPARENTTBL = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTPARENTTBL");
          final List<Constants> _result = new ArrayList<Constants>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Constants _item;
            _item = new Constants();
            final String _tmpCONSTANTID;
            _tmpCONSTANTID = _cursor.getString(_cursorIndexOfCONSTANTID);
            _item.setCONSTANTID(_tmpCONSTANTID);
            final String _tmpCONSTANTPARENTID;
            _tmpCONSTANTPARENTID = _cursor.getString(_cursorIndexOfCONSTANTPARENTID);
            _item.setCONSTANTPARENTID(_tmpCONSTANTPARENTID);
            final String _tmpCONSTANTARANAME;
            _tmpCONSTANTARANAME = _cursor.getString(_cursorIndexOfCONSTANTARANAME);
            _item.setCONSTANTARANAME(_tmpCONSTANTARANAME);
            final String _tmpCONSTANTENGNAME;
            _tmpCONSTANTENGNAME = _cursor.getString(_cursorIndexOfCONSTANTENGNAME);
            _item.setCONSTANTENGNAME(_tmpCONSTANTENGNAME);
            final String _tmpINSERTUSERSN;
            _tmpINSERTUSERSN = _cursor.getString(_cursorIndexOfINSERTUSERSN);
            _item.setINSERTUSERSN(_tmpINSERTUSERSN);
            final String _tmpINSERTDATE;
            _tmpINSERTDATE = _cursor.getString(_cursorIndexOfINSERTDATE);
            _item.setINSERTDATE(_tmpINSERTDATE);
            final String _tmpUPDATEUSERSN;
            _tmpUPDATEUSERSN = _cursor.getString(_cursorIndexOfUPDATEUSERSN);
            _item.setUPDATEUSERSN(_tmpUPDATEUSERSN);
            final String _tmpISDELETE;
            _tmpISDELETE = _cursor.getString(_cursorIndexOfISDELETE);
            _item.setISDELETE(_tmpISDELETE);
            final String _tmpOLDID;
            _tmpOLDID = _cursor.getString(_cursorIndexOfOLDID);
            _item.setOLDID(_tmpOLDID);
            final String _tmpCONSTANTPARENTTBL;
            _tmpCONSTANTPARENTTBL = _cursor.getString(_cursorIndexOfCONSTANTPARENTTBL);
            _item.setCONSTANTPARENTTBL(_tmpCONSTANTPARENTTBL);
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
  public LiveData<List<Constants>> getConstants(final String parentID) {
    final String _sql = "SELECT * FROM constants_table WHERE cONSTANTPARENTID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (parentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parentID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"constants_table"}, false, new Callable<List<Constants>>() {
      @Override
      public List<Constants> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCONSTANTID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTID");
          final int _cursorIndexOfCONSTANTPARENTID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTPARENTID");
          final int _cursorIndexOfCONSTANTARANAME = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTARANAME");
          final int _cursorIndexOfCONSTANTENGNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTENGNAME");
          final int _cursorIndexOfINSERTUSERSN = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSERTUSERSN");
          final int _cursorIndexOfINSERTDATE = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSERTDATE");
          final int _cursorIndexOfUPDATEUSERSN = CursorUtil.getColumnIndexOrThrow(_cursor, "uPDATEUSERSN");
          final int _cursorIndexOfISDELETE = CursorUtil.getColumnIndexOrThrow(_cursor, "iSDELETE");
          final int _cursorIndexOfOLDID = CursorUtil.getColumnIndexOrThrow(_cursor, "oLDID");
          final int _cursorIndexOfCONSTANTPARENTTBL = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTANTPARENTTBL");
          final List<Constants> _result = new ArrayList<Constants>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Constants _item;
            _item = new Constants();
            final String _tmpCONSTANTID;
            _tmpCONSTANTID = _cursor.getString(_cursorIndexOfCONSTANTID);
            _item.setCONSTANTID(_tmpCONSTANTID);
            final String _tmpCONSTANTPARENTID;
            _tmpCONSTANTPARENTID = _cursor.getString(_cursorIndexOfCONSTANTPARENTID);
            _item.setCONSTANTPARENTID(_tmpCONSTANTPARENTID);
            final String _tmpCONSTANTARANAME;
            _tmpCONSTANTARANAME = _cursor.getString(_cursorIndexOfCONSTANTARANAME);
            _item.setCONSTANTARANAME(_tmpCONSTANTARANAME);
            final String _tmpCONSTANTENGNAME;
            _tmpCONSTANTENGNAME = _cursor.getString(_cursorIndexOfCONSTANTENGNAME);
            _item.setCONSTANTENGNAME(_tmpCONSTANTENGNAME);
            final String _tmpINSERTUSERSN;
            _tmpINSERTUSERSN = _cursor.getString(_cursorIndexOfINSERTUSERSN);
            _item.setINSERTUSERSN(_tmpINSERTUSERSN);
            final String _tmpINSERTDATE;
            _tmpINSERTDATE = _cursor.getString(_cursorIndexOfINSERTDATE);
            _item.setINSERTDATE(_tmpINSERTDATE);
            final String _tmpUPDATEUSERSN;
            _tmpUPDATEUSERSN = _cursor.getString(_cursorIndexOfUPDATEUSERSN);
            _item.setUPDATEUSERSN(_tmpUPDATEUSERSN);
            final String _tmpISDELETE;
            _tmpISDELETE = _cursor.getString(_cursorIndexOfISDELETE);
            _item.setISDELETE(_tmpISDELETE);
            final String _tmpOLDID;
            _tmpOLDID = _cursor.getString(_cursorIndexOfOLDID);
            _item.setOLDID(_tmpOLDID);
            final String _tmpCONSTANTPARENTTBL;
            _tmpCONSTANTPARENTTBL = _cursor.getString(_cursorIndexOfCONSTANTPARENTTBL);
            _item.setCONSTANTPARENTTBL(_tmpCONSTANTPARENTTBL);
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
  public int getDataCount(final String parentID) {
    final String _sql = "SELECT COUNT(*) FROM constants_table WHERE cONSTANTPARENTID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (parentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, parentID);
    }
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
  public LiveData<String> getConstantName(final String constantId) {
    final String _sql = "Select cONSTANTARANAME from constants_table where cONSTANTID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (constantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, constantId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"constants_table"}, false, new Callable<String>() {
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
