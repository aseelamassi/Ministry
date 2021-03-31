package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.QuestionsAnswer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QuestionsAnswerDao_Impl implements QuestionsAnswerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QuestionsAnswer> __insertionAdapterOfQuestionsAnswer;

  private final EntityDeletionOrUpdateAdapter<QuestionsAnswer> __deletionAdapterOfQuestionsAnswer;

  public QuestionsAnswerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuestionsAnswer = new EntityInsertionAdapter<QuestionsAnswer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `QuestionsAnswer` (`constructId`,`visitId`,`answers`,`userId`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuestionsAnswer value) {
        if (value.getConstructId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConstructId());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getVisitId());
        }
        if (value.getAnswers() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAnswers());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserId());
        }
      }
    };
    this.__deletionAdapterOfQuestionsAnswer = new EntityDeletionOrUpdateAdapter<QuestionsAnswer>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `QuestionsAnswer` WHERE `visitId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuestionsAnswer value) {
        if (value.getVisitId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisitId());
        }
      }
    };
  }

  @Override
  public void addQuestionsAnswer(final QuestionsAnswer model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfQuestionsAnswer.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteQuestionsAnswer(final QuestionsAnswer model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfQuestionsAnswer.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<QuestionsAnswer> getQuestionsAnswer() {
    final String _sql = "SELECT * FROM QuestionsAnswer";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final int _cursorIndexOfAnswers = CursorUtil.getColumnIndexOrThrow(_cursor, "answers");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final List<QuestionsAnswer> _result = new ArrayList<QuestionsAnswer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final QuestionsAnswer _item;
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        final String _tmpAnswers;
        _tmpAnswers = _cursor.getString(_cursorIndexOfAnswers);
        final String _tmpUserId;
        _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
        _item = new QuestionsAnswer(_tmpConstructId,_tmpVisitId,_tmpAnswers,_tmpUserId);
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
    final String _sql = "SELECT COUNT(*) FROM QuestionsAnswer ";
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
