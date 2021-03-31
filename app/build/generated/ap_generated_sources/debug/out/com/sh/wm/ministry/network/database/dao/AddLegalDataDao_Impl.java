package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLegalEntityData;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AddLegalDataDao_Impl implements AddLegalDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddLegalEntityData> __insertionAdapterOfAddLegalEntityData;

  private final EntityDeletionOrUpdateAdapter<AddLegalEntityData> __deletionAdapterOfAddLegalEntityData;

  public AddLegalDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddLegalEntityData = new EntityInsertionAdapter<AddLegalEntityData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AddLegalEntityData` (`action`,`constructId`,`bossIdentify`,`bossIdentify2`,`type`,`legalId`,`constructinType`,`ownerShipId`,`mainEconomicActivityId`,`mainDsec`,`sessionId`,`year`,`workStatusSecId`,`foundationNum`,`employeeNum`,`startWork`,`endWork`,`visitId`,`submitAction`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddLegalEntityData value) {
        if (value.getAction() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAction());
        }
        if (value.getConstructId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getConstructId());
        }
        if (value.getBossIdentify() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBossIdentify());
        }
        if (value.getBossIdentify2() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBossIdentify2());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getLegalId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLegalId());
        }
        if (value.getConstructinType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getConstructinType());
        }
        if (value.getOwnerShipId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOwnerShipId());
        }
        if (value.getMainEconomicActivityId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMainEconomicActivityId());
        }
        if (value.getMainDsec() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getMainDsec());
        }
        if (value.getSessionId() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getSessionId());
        }
        if (value.getYear() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getYear());
        }
        if (value.getWorkStatusSecId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getWorkStatusSecId());
        }
        if (value.getFoundationNum() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getFoundationNum());
        }
        if (value.getEmployeeNum() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getEmployeeNum());
        }
        if (value.getStartWork() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getStartWork());
        }
        if (value.getEndWork() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getEndWork());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getVisitId());
        }
        if (value.getSubmitAction() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getSubmitAction());
        }
      }
    };
    this.__deletionAdapterOfAddLegalEntityData = new EntityDeletionOrUpdateAdapter<AddLegalEntityData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `AddLegalEntityData` WHERE `constructId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddLegalEntityData value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
      }
    };
  }

  @Override
  public void addLegalModel(final AddLegalEntityData model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAddLegalEntityData.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteLegalData(final AddLegalEntityData model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfAddLegalEntityData.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddLegalEntityData> getAddLegalData() {
    final String _sql = "SELECT * FROM AddLegalEntityData";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfBossIdentify = CursorUtil.getColumnIndexOrThrow(_cursor, "bossIdentify");
      final int _cursorIndexOfBossIdentify2 = CursorUtil.getColumnIndexOrThrow(_cursor, "bossIdentify2");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfLegalId = CursorUtil.getColumnIndexOrThrow(_cursor, "legalId");
      final int _cursorIndexOfConstructinType = CursorUtil.getColumnIndexOrThrow(_cursor, "constructinType");
      final int _cursorIndexOfOwnerShipId = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerShipId");
      final int _cursorIndexOfMainEconomicActivityId = CursorUtil.getColumnIndexOrThrow(_cursor, "mainEconomicActivityId");
      final int _cursorIndexOfMainDsec = CursorUtil.getColumnIndexOrThrow(_cursor, "mainDsec");
      final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfWorkStatusSecId = CursorUtil.getColumnIndexOrThrow(_cursor, "workStatusSecId");
      final int _cursorIndexOfFoundationNum = CursorUtil.getColumnIndexOrThrow(_cursor, "foundationNum");
      final int _cursorIndexOfEmployeeNum = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeNum");
      final int _cursorIndexOfStartWork = CursorUtil.getColumnIndexOrThrow(_cursor, "startWork");
      final int _cursorIndexOfEndWork = CursorUtil.getColumnIndexOrThrow(_cursor, "endWork");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final int _cursorIndexOfSubmitAction = CursorUtil.getColumnIndexOrThrow(_cursor, "submitAction");
      final List<AddLegalEntityData> _result = new ArrayList<AddLegalEntityData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddLegalEntityData _item;
        final String _tmpAction;
        _tmpAction = _cursor.getString(_cursorIndexOfAction);
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpBossIdentify;
        _tmpBossIdentify = _cursor.getString(_cursorIndexOfBossIdentify);
        final String _tmpBossIdentify2;
        _tmpBossIdentify2 = _cursor.getString(_cursorIndexOfBossIdentify2);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final String _tmpLegalId;
        _tmpLegalId = _cursor.getString(_cursorIndexOfLegalId);
        final String _tmpConstructinType;
        _tmpConstructinType = _cursor.getString(_cursorIndexOfConstructinType);
        final String _tmpOwnerShipId;
        _tmpOwnerShipId = _cursor.getString(_cursorIndexOfOwnerShipId);
        final String _tmpMainEconomicActivityId;
        _tmpMainEconomicActivityId = _cursor.getString(_cursorIndexOfMainEconomicActivityId);
        final String _tmpMainDsec;
        _tmpMainDsec = _cursor.getString(_cursorIndexOfMainDsec);
        final String _tmpSessionId;
        _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
        final String _tmpYear;
        _tmpYear = _cursor.getString(_cursorIndexOfYear);
        final String _tmpWorkStatusSecId;
        _tmpWorkStatusSecId = _cursor.getString(_cursorIndexOfWorkStatusSecId);
        final String _tmpFoundationNum;
        _tmpFoundationNum = _cursor.getString(_cursorIndexOfFoundationNum);
        final String _tmpEmployeeNum;
        _tmpEmployeeNum = _cursor.getString(_cursorIndexOfEmployeeNum);
        final String _tmpStartWork;
        _tmpStartWork = _cursor.getString(_cursorIndexOfStartWork);
        final String _tmpEndWork;
        _tmpEndWork = _cursor.getString(_cursorIndexOfEndWork);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        final String _tmpSubmitAction;
        _tmpSubmitAction = _cursor.getString(_cursorIndexOfSubmitAction);
        _item = new AddLegalEntityData(_tmpAction,_tmpConstructId,_tmpBossIdentify,_tmpBossIdentify2,_tmpType,_tmpLegalId,_tmpConstructinType,_tmpOwnerShipId,_tmpMainEconomicActivityId,_tmpMainDsec,_tmpSessionId,_tmpYear,_tmpWorkStatusSecId,_tmpFoundationNum,_tmpEmployeeNum,_tmpStartWork,_tmpEndWork,_tmpVisitId,_tmpSubmitAction);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getDataCount() {
    final String _sql = "SELECT COUNT(*) FROM AddLegalEntityData ";
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
