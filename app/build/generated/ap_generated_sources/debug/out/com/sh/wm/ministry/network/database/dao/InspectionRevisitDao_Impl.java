package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionRevisit;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class InspectionRevisitDao_Impl implements InspectionRevisitDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InspectionRevisit> __insertionAdapterOfInspectionRevisit;

  private final EntityDeletionOrUpdateAdapter<InspectionRevisit> __deletionAdapterOfInspectionRevisit;

  public InspectionRevisitDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInspectionRevisit = new EntityInsertionAdapter<InspectionRevisit>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `InspectionRevisit` (`constructId`,`violationRemoval`,`actionId`,`recommendationId`,`placmentId`,`machineName`,`reason`,`date`,`visitId`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InspectionRevisit value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
        if (value.getViolationRemoval() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getViolationRemoval());
        }
        if (value.getActionId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getActionId());
        }
        if (value.getRecommendationId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecommendationId());
        }
        if (value.getPlacmentId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPlacmentId());
        }
        if (value.getMachineName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMachineName());
        }
        if (value.getReason() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReason());
        }
        if (value.getDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDate());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getVisitId());
        }
      }
    };
    this.__deletionAdapterOfInspectionRevisit = new EntityDeletionOrUpdateAdapter<InspectionRevisit>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `InspectionRevisit` WHERE `visitId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InspectionRevisit value) {
        if (value.getVisitId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisitId());
        }
      }
    };
  }

  @Override
  public void addRevisit(final InspectionRevisit model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInspectionRevisit.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteRevisit(final InspectionRevisit model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfInspectionRevisit.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<InspectionRevisit> getRevisits() {
    final String _sql = "SELECT * FROM InspectionRevisit";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfViolationRemoval = CursorUtil.getColumnIndexOrThrow(_cursor, "violationRemoval");
      final int _cursorIndexOfActionId = CursorUtil.getColumnIndexOrThrow(_cursor, "actionId");
      final int _cursorIndexOfRecommendationId = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendationId");
      final int _cursorIndexOfPlacmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "placmentId");
      final int _cursorIndexOfMachineName = CursorUtil.getColumnIndexOrThrow(_cursor, "machineName");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final List<InspectionRevisit> _result = new ArrayList<InspectionRevisit>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InspectionRevisit _item;
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpViolationRemoval;
        _tmpViolationRemoval = _cursor.getString(_cursorIndexOfViolationRemoval);
        final String _tmpActionId;
        _tmpActionId = _cursor.getString(_cursorIndexOfActionId);
        final String _tmpRecommendationId;
        _tmpRecommendationId = _cursor.getString(_cursorIndexOfRecommendationId);
        final String _tmpPlacmentId;
        _tmpPlacmentId = _cursor.getString(_cursorIndexOfPlacmentId);
        final String _tmpMachineName;
        _tmpMachineName = _cursor.getString(_cursorIndexOfMachineName);
        final String _tmpReason;
        _tmpReason = _cursor.getString(_cursorIndexOfReason);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        _item = new InspectionRevisit(_tmpConstructId,_tmpViolationRemoval,_tmpActionId,_tmpRecommendationId,_tmpPlacmentId,_tmpMachineName,_tmpReason,_tmpDate,_tmpVisitId);
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
    final String _sql = "SELECT COUNT(*) FROM InspectionRevisit ";
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
