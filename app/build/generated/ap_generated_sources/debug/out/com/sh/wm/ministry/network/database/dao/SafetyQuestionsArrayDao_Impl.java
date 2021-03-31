package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestion;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionArray;
import com.sh.wm.ministry.network.utiels.ModelConverter;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SafetyQuestionsArrayDao_Impl implements SafetyQuestionsArrayDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SafetyQuestionArray> __insertionAdapterOfSafetyQuestionArray;

  private final ModelConverter __modelConverter = new ModelConverter();

  public SafetyQuestionsArrayDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSafetyQuestionArray = new EntityInsertionAdapter<SafetyQuestionArray>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `SafetyQuestions` (`id`,`safetyQuestions1`,`safetyQuestions2`,`safetyQuestions3`,`safetyQuestions4`,`safetyQuestions5`,`safetyQuestions6`,`safetyQuestions7`,`safetyQuestions8`,`safetyQuestions9`,`safetyQuestions10`,`safetyQuestions11`,`safetyQuestions12`,`safetyQuestions13`,`safetyQuestions14`,`safetyQuestions15`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SafetyQuestionArray value) {
        stmt.bindLong(1, value.getId());
        final String _tmp;
        _tmp = __modelConverter.fromCountryLangList(value.getSafetyQuestions1());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = __modelConverter.fromCountryLangList(value.getSafetyQuestions2());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp_1);
        }
        final String _tmp_2;
        _tmp_2 = __modelConverter.fromCountryLangList(value.getSafetyQuestions3());
        if (_tmp_2 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp_2);
        }
        final String _tmp_3;
        _tmp_3 = __modelConverter.fromCountryLangList(value.getSafetyQuestions4());
        if (_tmp_3 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_3);
        }
        final String _tmp_4;
        _tmp_4 = __modelConverter.fromCountryLangList(value.getSafetyQuestions5());
        if (_tmp_4 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_4);
        }
        final String _tmp_5;
        _tmp_5 = __modelConverter.fromCountryLangList(value.getSafetyQuestions6());
        if (_tmp_5 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_5);
        }
        final String _tmp_6;
        _tmp_6 = __modelConverter.fromCountryLangList(value.getSafetyQuestions7());
        if (_tmp_6 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_6);
        }
        final String _tmp_7;
        _tmp_7 = __modelConverter.fromCountryLangList(value.getSafetyQuestions8());
        if (_tmp_7 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, _tmp_7);
        }
        final String _tmp_8;
        _tmp_8 = __modelConverter.fromCountryLangList(value.getSafetyQuestions9());
        if (_tmp_8 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, _tmp_8);
        }
        final String _tmp_9;
        _tmp_9 = __modelConverter.fromCountryLangList(value.getSafetyQuestions10());
        if (_tmp_9 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp_9);
        }
        final String _tmp_10;
        _tmp_10 = __modelConverter.fromCountryLangList(value.getSafetyQuestions11());
        if (_tmp_10 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp_10);
        }
        final String _tmp_11;
        _tmp_11 = __modelConverter.fromCountryLangList(value.getSafetyQuestions12());
        if (_tmp_11 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_11);
        }
        final String _tmp_12;
        _tmp_12 = __modelConverter.fromCountryLangList(value.getSafetyQuestions13());
        if (_tmp_12 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, _tmp_12);
        }
        final String _tmp_13;
        _tmp_13 = __modelConverter.fromCountryLangList(value.getSafetyQuestions14());
        if (_tmp_13 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_13);
        }
        final String _tmp_14;
        _tmp_14 = __modelConverter.fromCountryLangList(value.getSafetyQuestions15());
        if (_tmp_14 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp_14);
        }
      }
    };
  }

  @Override
  public void addSafetyQuestions(final SafetyQuestionArray safetyQuestionArray) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSafetyQuestionArray.insert(safetyQuestionArray);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<SafetyQuestionArray> getSafetyQuestions() {
    final String _sql = "SELECT * FROM SafetyQuestions  ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"SafetyQuestions"}, false, new Callable<SafetyQuestionArray>() {
      @Override
      public SafetyQuestionArray call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSafetyQuestions1 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions1");
          final int _cursorIndexOfSafetyQuestions2 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions2");
          final int _cursorIndexOfSafetyQuestions3 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions3");
          final int _cursorIndexOfSafetyQuestions4 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions4");
          final int _cursorIndexOfSafetyQuestions5 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions5");
          final int _cursorIndexOfSafetyQuestions6 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions6");
          final int _cursorIndexOfSafetyQuestions7 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions7");
          final int _cursorIndexOfSafetyQuestions8 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions8");
          final int _cursorIndexOfSafetyQuestions9 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions9");
          final int _cursorIndexOfSafetyQuestions10 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions10");
          final int _cursorIndexOfSafetyQuestions11 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions11");
          final int _cursorIndexOfSafetyQuestions12 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions12");
          final int _cursorIndexOfSafetyQuestions13 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions13");
          final int _cursorIndexOfSafetyQuestions14 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions14");
          final int _cursorIndexOfSafetyQuestions15 = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyQuestions15");
          final SafetyQuestionArray _result;
          if(_cursor.moveToFirst()) {
            _result = new SafetyQuestionArray();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result.setId(_tmpId);
            final List<SafetyQuestion> _tmpSafetyQuestions1;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfSafetyQuestions1);
            _tmpSafetyQuestions1 = __modelConverter.toCountryLangList(_tmp);
            _result.setSafetyQuestions1(_tmpSafetyQuestions1);
            final List<SafetyQuestion> _tmpSafetyQuestions2;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfSafetyQuestions2);
            _tmpSafetyQuestions2 = __modelConverter.toCountryLangList(_tmp_1);
            _result.setSafetyQuestions2(_tmpSafetyQuestions2);
            final List<SafetyQuestion> _tmpSafetyQuestions3;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfSafetyQuestions3);
            _tmpSafetyQuestions3 = __modelConverter.toCountryLangList(_tmp_2);
            _result.setSafetyQuestions3(_tmpSafetyQuestions3);
            final List<SafetyQuestion> _tmpSafetyQuestions4;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfSafetyQuestions4);
            _tmpSafetyQuestions4 = __modelConverter.toCountryLangList(_tmp_3);
            _result.setSafetyQuestions4(_tmpSafetyQuestions4);
            final List<SafetyQuestion> _tmpSafetyQuestions5;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfSafetyQuestions5);
            _tmpSafetyQuestions5 = __modelConverter.toCountryLangList(_tmp_4);
            _result.setSafetyQuestions5(_tmpSafetyQuestions5);
            final List<SafetyQuestion> _tmpSafetyQuestions6;
            final String _tmp_5;
            _tmp_5 = _cursor.getString(_cursorIndexOfSafetyQuestions6);
            _tmpSafetyQuestions6 = __modelConverter.toCountryLangList(_tmp_5);
            _result.setSafetyQuestions6(_tmpSafetyQuestions6);
            final List<SafetyQuestion> _tmpSafetyQuestions7;
            final String _tmp_6;
            _tmp_6 = _cursor.getString(_cursorIndexOfSafetyQuestions7);
            _tmpSafetyQuestions7 = __modelConverter.toCountryLangList(_tmp_6);
            _result.setSafetyQuestions7(_tmpSafetyQuestions7);
            final List<SafetyQuestion> _tmpSafetyQuestions8;
            final String _tmp_7;
            _tmp_7 = _cursor.getString(_cursorIndexOfSafetyQuestions8);
            _tmpSafetyQuestions8 = __modelConverter.toCountryLangList(_tmp_7);
            _result.setSafetyQuestions8(_tmpSafetyQuestions8);
            final List<SafetyQuestion> _tmpSafetyQuestions9;
            final String _tmp_8;
            _tmp_8 = _cursor.getString(_cursorIndexOfSafetyQuestions9);
            _tmpSafetyQuestions9 = __modelConverter.toCountryLangList(_tmp_8);
            _result.setSafetyQuestions9(_tmpSafetyQuestions9);
            final List<SafetyQuestion> _tmpSafetyQuestions10;
            final String _tmp_9;
            _tmp_9 = _cursor.getString(_cursorIndexOfSafetyQuestions10);
            _tmpSafetyQuestions10 = __modelConverter.toCountryLangList(_tmp_9);
            _result.setSafetyQuestions10(_tmpSafetyQuestions10);
            final List<SafetyQuestion> _tmpSafetyQuestions11;
            final String _tmp_10;
            _tmp_10 = _cursor.getString(_cursorIndexOfSafetyQuestions11);
            _tmpSafetyQuestions11 = __modelConverter.toCountryLangList(_tmp_10);
            _result.setSafetyQuestions11(_tmpSafetyQuestions11);
            final List<SafetyQuestion> _tmpSafetyQuestions12;
            final String _tmp_11;
            _tmp_11 = _cursor.getString(_cursorIndexOfSafetyQuestions12);
            _tmpSafetyQuestions12 = __modelConverter.toCountryLangList(_tmp_11);
            _result.setSafetyQuestions12(_tmpSafetyQuestions12);
            final List<SafetyQuestion> _tmpSafetyQuestions13;
            final String _tmp_12;
            _tmp_12 = _cursor.getString(_cursorIndexOfSafetyQuestions13);
            _tmpSafetyQuestions13 = __modelConverter.toCountryLangList(_tmp_12);
            _result.setSafetyQuestions13(_tmpSafetyQuestions13);
            final List<SafetyQuestion> _tmpSafetyQuestions14;
            final String _tmp_13;
            _tmp_13 = _cursor.getString(_cursorIndexOfSafetyQuestions14);
            _tmpSafetyQuestions14 = __modelConverter.toCountryLangList(_tmp_13);
            _result.setSafetyQuestions14(_tmpSafetyQuestions14);
            final List<SafetyQuestion> _tmpSafetyQuestions15;
            final String _tmp_14;
            _tmp_14 = _cursor.getString(_cursorIndexOfSafetyQuestions15);
            _tmpSafetyQuestions15 = __modelConverter.toCountryLangList(_tmp_14);
            _result.setSafetyQuestions15(_tmpSafetyQuestions15);
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
