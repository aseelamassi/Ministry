package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionVisitResult;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class InspectionVisitResultDao_Impl implements InspectionVisitResultDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InspectionVisitResult> __insertionAdapterOfInspectionVisitResult;

  private final EntityDeletionOrUpdateAdapter<InspectionVisitResult> __deletionAdapterOfInspectionVisitResult;

  public InspectionVisitResultDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInspectionVisitResult = new EntityInsertionAdapter<InspectionVisitResult>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `InspectionVisitResult` (`constructId`,`actionId`,`recommendationId`,`placementId`,`date`,`reason`,`machineName`,`visitId`,`userId`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InspectionVisitResult value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
        if (value.getActionId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getActionId());
        }
        if (value.getRecommendationId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecommendationId());
        }
        if (value.getPlacementId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPlacementId());
        }
        if (value.getDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDate());
        }
        if (value.getReason() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReason());
        }
        if (value.getMachineName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMachineName());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getVisitId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUserId());
        }
      }
    };
    this.__deletionAdapterOfInspectionVisitResult = new EntityDeletionOrUpdateAdapter<InspectionVisitResult>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `InspectionVisitResult` WHERE `visitId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InspectionVisitResult value) {
        if (value.getVisitId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisitId());
        }
      }
    };
  }

  @Override
  public void addResult(final InspectionVisitResult model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInspectionVisitResult.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteResult(final InspectionVisitResult model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfInspectionVisitResult.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<InspectionVisitResult> getResults() {
    final String _sql = "SELECT * FROM InspectionVisitResult";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfActionId = CursorUtil.getColumnIndexOrThrow(_cursor, "actionId");
      final int _cursorIndexOfRecommendationId = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendationId");
      final int _cursorIndexOfPlacementId = CursorUtil.getColumnIndexOrThrow(_cursor, "placementId");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMachineName = CursorUtil.getColumnIndexOrThrow(_cursor, "machineName");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final List<InspectionVisitResult> _result = new ArrayList<InspectionVisitResult>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InspectionVisitResult _item;
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpActionId;
        _tmpActionId = _cursor.getString(_cursorIndexOfActionId);
        final String _tmpRecommendationId;
        _tmpRecommendationId = _cursor.getString(_cursorIndexOfRecommendationId);
        final String _tmpPlacementId;
        _tmpPlacementId = _cursor.getString(_cursorIndexOfPlacementId);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        final String _tmpReason;
        _tmpReason = _cursor.getString(_cursorIndexOfReason);
        final String _tmpMachineName;
        _tmpMachineName = _cursor.getString(_cursorIndexOfMachineName);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        final String _tmpUserId;
        _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
        _item = new InspectionVisitResult(_tmpConstructId,_tmpActionId,_tmpRecommendationId,_tmpPlacementId,_tmpDate,_tmpReason,_tmpMachineName,_tmpVisitId,_tmpUserId);
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
    final String _sql = "SELECT COUNT(*) FROM InspectionVisitResult ";
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
