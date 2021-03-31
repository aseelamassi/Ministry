package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AddWorkerDao_Impl implements AddWorkerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddWorkerModel> __insertionAdapterOfAddWorkerModel;

  private final EntityDeletionOrUpdateAdapter<AddWorkerModel> __deletionAdapterOfAddWorkerModel;

  public AddWorkerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddWorkerModel = new EntityInsertionAdapter<AddWorkerModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AddWorker` (`constructId`,`workerSn`,`perExam`,`primExam`,`haveCertificate`,`workTypeId`,`workTypeDescId`,`workTypeDescDescId`,`startDate`,`endDate`,`leaveDate`,`leaveReason`,`currencyId`,`salary`,`payId`,`jobId`,`skillLevelId`,`contractId`,`visitId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddWorkerModel value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
        if (value.getWorkerSn() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWorkerSn());
        }
        if (value.getPerExam() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPerExam());
        }
        if (value.getPrimExam() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPrimExam());
        }
        if (value.getHaveCertificate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHaveCertificate());
        }
        if (value.getWorkTypeId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWorkTypeId());
        }
        if (value.getWorkTypeDescId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getWorkTypeDescId());
        }
        if (value.getWorkTypeDescDescId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getWorkTypeDescDescId());
        }
        if (value.getStartDate() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartDate());
        }
        if (value.getEndDate() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEndDate());
        }
        if (value.getLeaveDate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getLeaveDate());
        }
        if (value.getLeaveReason() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLeaveReason());
        }
        if (value.getCurrencyId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCurrencyId());
        }
        if (value.getSalary() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSalary());
        }
        if (value.getPayId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getPayId());
        }
        if (value.getJobId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getJobId());
        }
        if (value.getSkillLevelId() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSkillLevelId());
        }
        if (value.getContractId() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getContractId());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getVisitId());
        }
      }
    };
    this.__deletionAdapterOfAddWorkerModel = new EntityDeletionOrUpdateAdapter<AddWorkerModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `AddWorker` WHERE `workerSn` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddWorkerModel value) {
        if (value.getWorkerSn() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getWorkerSn());
        }
      }
    };
  }

  @Override
  public void addAddWorkerModel(final AddWorkerModel model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAddWorkerModel.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteAddWorkerModel(final AddWorkerModel model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfAddWorkerModel.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddWorkerModel> getAddWorker() {
    final String _sql = "SELECT * FROM AddWorker";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfWorkerSn = CursorUtil.getColumnIndexOrThrow(_cursor, "workerSn");
      final int _cursorIndexOfPerExam = CursorUtil.getColumnIndexOrThrow(_cursor, "perExam");
      final int _cursorIndexOfPrimExam = CursorUtil.getColumnIndexOrThrow(_cursor, "primExam");
      final int _cursorIndexOfHaveCertificate = CursorUtil.getColumnIndexOrThrow(_cursor, "haveCertificate");
      final int _cursorIndexOfWorkTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workTypeId");
      final int _cursorIndexOfWorkTypeDescId = CursorUtil.getColumnIndexOrThrow(_cursor, "workTypeDescId");
      final int _cursorIndexOfWorkTypeDescDescId = CursorUtil.getColumnIndexOrThrow(_cursor, "workTypeDescDescId");
      final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
      final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
      final int _cursorIndexOfLeaveDate = CursorUtil.getColumnIndexOrThrow(_cursor, "leaveDate");
      final int _cursorIndexOfLeaveReason = CursorUtil.getColumnIndexOrThrow(_cursor, "leaveReason");
      final int _cursorIndexOfCurrencyId = CursorUtil.getColumnIndexOrThrow(_cursor, "currencyId");
      final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
      final int _cursorIndexOfPayId = CursorUtil.getColumnIndexOrThrow(_cursor, "payId");
      final int _cursorIndexOfJobId = CursorUtil.getColumnIndexOrThrow(_cursor, "jobId");
      final int _cursorIndexOfSkillLevelId = CursorUtil.getColumnIndexOrThrow(_cursor, "skillLevelId");
      final int _cursorIndexOfContractId = CursorUtil.getColumnIndexOrThrow(_cursor, "contractId");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final List<AddWorkerModel> _result = new ArrayList<AddWorkerModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddWorkerModel _item;
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpWorkerSn;
        _tmpWorkerSn = _cursor.getString(_cursorIndexOfWorkerSn);
        final String _tmpPerExam;
        _tmpPerExam = _cursor.getString(_cursorIndexOfPerExam);
        final String _tmpPrimExam;
        _tmpPrimExam = _cursor.getString(_cursorIndexOfPrimExam);
        final String _tmpHaveCertificate;
        _tmpHaveCertificate = _cursor.getString(_cursorIndexOfHaveCertificate);
        final String _tmpWorkTypeId;
        _tmpWorkTypeId = _cursor.getString(_cursorIndexOfWorkTypeId);
        final String _tmpWorkTypeDescId;
        _tmpWorkTypeDescId = _cursor.getString(_cursorIndexOfWorkTypeDescId);
        final String _tmpWorkTypeDescDescId;
        _tmpWorkTypeDescDescId = _cursor.getString(_cursorIndexOfWorkTypeDescDescId);
        final String _tmpStartDate;
        _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
        final String _tmpEndDate;
        _tmpEndDate = _cursor.getString(_cursorIndexOfEndDate);
        final String _tmpLeaveDate;
        _tmpLeaveDate = _cursor.getString(_cursorIndexOfLeaveDate);
        final String _tmpLeaveReason;
        _tmpLeaveReason = _cursor.getString(_cursorIndexOfLeaveReason);
        final String _tmpCurrencyId;
        _tmpCurrencyId = _cursor.getString(_cursorIndexOfCurrencyId);
        final String _tmpSalary;
        _tmpSalary = _cursor.getString(_cursorIndexOfSalary);
        final String _tmpPayId;
        _tmpPayId = _cursor.getString(_cursorIndexOfPayId);
        final String _tmpJobId;
        _tmpJobId = _cursor.getString(_cursorIndexOfJobId);
        final String _tmpSkillLevelId;
        _tmpSkillLevelId = _cursor.getString(_cursorIndexOfSkillLevelId);
        final String _tmpContractId;
        _tmpContractId = _cursor.getString(_cursorIndexOfContractId);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        _item = new AddWorkerModel(_tmpConstructId,_tmpWorkerSn,_tmpPerExam,_tmpPrimExam,_tmpHaveCertificate,_tmpWorkTypeId,_tmpWorkTypeDescId,_tmpWorkTypeDescDescId,_tmpStartDate,_tmpEndDate,_tmpLeaveDate,_tmpLeaveReason,_tmpCurrencyId,_tmpSalary,_tmpPayId,_tmpJobId,_tmpSkillLevelId,_tmpContractId,_tmpVisitId);
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
    final String _sql = "SELECT COUNT(*) FROM AddWorker ";
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
