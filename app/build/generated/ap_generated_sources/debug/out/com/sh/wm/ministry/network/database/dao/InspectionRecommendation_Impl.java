package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionRecommendationModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class InspectionRecommendation_Impl implements InspectionRecommendation {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InspectionRecommendationModel> __insertionAdapterOfInspectionRecommendationModel;

  private final EntityDeletionOrUpdateAdapter<InspectionRecommendationModel> __deletionAdapterOfInspectionRecommendationModel;

  public InspectionRecommendation_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInspectionRecommendationModel = new EntityInsertionAdapter<InspectionRecommendationModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Recommendation` (`constructId`,`recommendationId`,`adptedId`,`actionId`,`machineName`,`actionDate`,`userId`,`visitId`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InspectionRecommendationModel value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
        if (value.getRecommendationId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRecommendationId());
        }
        if (value.getAdptedId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAdptedId());
        }
        if (value.getActionId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActionId());
        }
        if (value.getMachineName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMachineName());
        }
        if (value.getActionDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getActionDate());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserId());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getVisitId());
        }
      }
    };
    this.__deletionAdapterOfInspectionRecommendationModel = new EntityDeletionOrUpdateAdapter<InspectionRecommendationModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Recommendation` WHERE `visitId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InspectionRecommendationModel value) {
        if (value.getVisitId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisitId());
        }
      }
    };
  }

  @Override
  public void addVisit(final InspectionRecommendationModel model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInspectionRecommendationModel.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteRecommendation(final InspectionRecommendationModel model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfInspectionRecommendationModel.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<InspectionRecommendationModel> getRecommendations() {
    final String _sql = "SELECT * FROM Recommendation ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfRecommendationId = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendationId");
      final int _cursorIndexOfAdptedId = CursorUtil.getColumnIndexOrThrow(_cursor, "adptedId");
      final int _cursorIndexOfActionId = CursorUtil.getColumnIndexOrThrow(_cursor, "actionId");
      final int _cursorIndexOfMachineName = CursorUtil.getColumnIndexOrThrow(_cursor, "machineName");
      final int _cursorIndexOfActionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "actionDate");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final List<InspectionRecommendationModel> _result = new ArrayList<InspectionRecommendationModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InspectionRecommendationModel _item;
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpRecommendationId;
        _tmpRecommendationId = _cursor.getString(_cursorIndexOfRecommendationId);
        final String _tmpAdptedId;
        _tmpAdptedId = _cursor.getString(_cursorIndexOfAdptedId);
        final String _tmpActionId;
        _tmpActionId = _cursor.getString(_cursorIndexOfActionId);
        final String _tmpMachineName;
        _tmpMachineName = _cursor.getString(_cursorIndexOfMachineName);
        final String _tmpActionDate;
        _tmpActionDate = _cursor.getString(_cursorIndexOfActionDate);
        final String _tmpUserId;
        _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        _item = new InspectionRecommendationModel(_tmpConstructId,_tmpRecommendationId,_tmpAdptedId,_tmpActionId,_tmpMachineName,_tmpActionDate,_tmpVisitId,_tmpUserId);
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
    final String _sql = "SELECT COUNT(*) FROM Recommendation ";
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
