package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLicenseInfo;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AddLicenseInfoDao_Impl implements AddLicenseInfoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddLicenseInfo> __insertionAdapterOfAddLicenseInfo;

  private final EntityDeletionOrUpdateAdapter<AddLicenseInfo> __deletionAdapterOfAddLicenseInfo;

  public AddLicenseInfoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddLicenseInfo = new EntityInsertionAdapter<AddLicenseInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AddLicenseInfo` (`action`,`constructId`,`isPolicy`,`isReg`,`isLicensed`,`insuranceEndDate`,`capital`,`type`,`insuranceId`,`insuranceNum`,`isInternalSys`,`isCertificateYN`,`workHoursSum`,`workTime`,`incomeId`,`visitId`,`submitAction`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddLicenseInfo value) {
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
        if (value.getIsPolicy() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIsPolicy());
        }
        if (value.getIsReg() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIsReg());
        }
        if (value.getIsLicensed() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getIsLicensed());
        }
        if (value.getInsuranceEndDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getInsuranceEndDate());
        }
        if (value.getCapital() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCapital());
        }
        if (value.getType() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getType());
        }
        if (value.getInsuranceId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getInsuranceId());
        }
        if (value.getInsuranceNum() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getInsuranceNum());
        }
        if (value.getIsInternalSys() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getIsInternalSys());
        }
        if (value.getIsCertificateYN() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getIsCertificateYN());
        }
        if (value.getWorkHoursSum() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getWorkHoursSum());
        }
        if (value.getWorkTime() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getWorkTime());
        }
        if (value.getIncomeId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getIncomeId());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getVisitId());
        }
        if (value.getSubmitAction() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSubmitAction());
        }
      }
    };
    this.__deletionAdapterOfAddLicenseInfo = new EntityDeletionOrUpdateAdapter<AddLicenseInfo>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `AddLicenseInfo` WHERE `visitId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddLicenseInfo value) {
        if (value.getVisitId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisitId());
        }
      }
    };
  }

  @Override
  public void addLicenseInfo(final AddLicenseInfo model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAddLicenseInfo.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteLicenseInfo(final AddLicenseInfo model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfAddLicenseInfo.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddLicenseInfo> getAddLicenseInfo() {
    final String _sql = "SELECT * FROM AddLicenseInfo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfIsPolicy = CursorUtil.getColumnIndexOrThrow(_cursor, "isPolicy");
      final int _cursorIndexOfIsReg = CursorUtil.getColumnIndexOrThrow(_cursor, "isReg");
      final int _cursorIndexOfIsLicensed = CursorUtil.getColumnIndexOrThrow(_cursor, "isLicensed");
      final int _cursorIndexOfInsuranceEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "insuranceEndDate");
      final int _cursorIndexOfCapital = CursorUtil.getColumnIndexOrThrow(_cursor, "capital");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfInsuranceId = CursorUtil.getColumnIndexOrThrow(_cursor, "insuranceId");
      final int _cursorIndexOfInsuranceNum = CursorUtil.getColumnIndexOrThrow(_cursor, "insuranceNum");
      final int _cursorIndexOfIsInternalSys = CursorUtil.getColumnIndexOrThrow(_cursor, "isInternalSys");
      final int _cursorIndexOfIsCertificateYN = CursorUtil.getColumnIndexOrThrow(_cursor, "isCertificateYN");
      final int _cursorIndexOfWorkHoursSum = CursorUtil.getColumnIndexOrThrow(_cursor, "workHoursSum");
      final int _cursorIndexOfWorkTime = CursorUtil.getColumnIndexOrThrow(_cursor, "workTime");
      final int _cursorIndexOfIncomeId = CursorUtil.getColumnIndexOrThrow(_cursor, "incomeId");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final int _cursorIndexOfSubmitAction = CursorUtil.getColumnIndexOrThrow(_cursor, "submitAction");
      final List<AddLicenseInfo> _result = new ArrayList<AddLicenseInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddLicenseInfo _item;
        final String _tmpAction;
        _tmpAction = _cursor.getString(_cursorIndexOfAction);
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpIsPolicy;
        _tmpIsPolicy = _cursor.getString(_cursorIndexOfIsPolicy);
        final String _tmpIsReg;
        _tmpIsReg = _cursor.getString(_cursorIndexOfIsReg);
        final String _tmpIsLicensed;
        _tmpIsLicensed = _cursor.getString(_cursorIndexOfIsLicensed);
        final String _tmpInsuranceEndDate;
        _tmpInsuranceEndDate = _cursor.getString(_cursorIndexOfInsuranceEndDate);
        final String _tmpCapital;
        _tmpCapital = _cursor.getString(_cursorIndexOfCapital);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final String _tmpInsuranceId;
        _tmpInsuranceId = _cursor.getString(_cursorIndexOfInsuranceId);
        final String _tmpInsuranceNum;
        _tmpInsuranceNum = _cursor.getString(_cursorIndexOfInsuranceNum);
        final String _tmpIsInternalSys;
        _tmpIsInternalSys = _cursor.getString(_cursorIndexOfIsInternalSys);
        final String _tmpIsCertificateYN;
        _tmpIsCertificateYN = _cursor.getString(_cursorIndexOfIsCertificateYN);
        final String _tmpWorkHoursSum;
        _tmpWorkHoursSum = _cursor.getString(_cursorIndexOfWorkHoursSum);
        final String _tmpWorkTime;
        _tmpWorkTime = _cursor.getString(_cursorIndexOfWorkTime);
        final String _tmpIncomeId;
        _tmpIncomeId = _cursor.getString(_cursorIndexOfIncomeId);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        final String _tmpSubmitAction;
        _tmpSubmitAction = _cursor.getString(_cursorIndexOfSubmitAction);
        _item = new AddLicenseInfo(_tmpAction,_tmpConstructId,_tmpIsPolicy,_tmpIsReg,_tmpIsLicensed,_tmpInsuranceEndDate,_tmpCapital,_tmpType,_tmpInsuranceId,_tmpInsuranceNum,_tmpIsInternalSys,_tmpIsCertificateYN,_tmpWorkHoursSum,_tmpWorkTime,_tmpIncomeId,_tmpVisitId,_tmpSubmitAction);
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
    final String _sql = "SELECT COUNT(*) FROM AddLicenseInfo ";
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
