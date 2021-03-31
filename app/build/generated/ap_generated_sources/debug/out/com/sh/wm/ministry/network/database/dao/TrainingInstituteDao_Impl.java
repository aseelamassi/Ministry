package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TrainingInstituteDao_Impl implements TrainingInstituteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TrainingInstitute> __insertionAdapterOfTrainingInstitute;

  public TrainingInstituteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrainingInstitute = new EntityInsertionAdapter<TrainingInstitute>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `training_institutes_table` (`Id`,`text`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TrainingInstitute value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getText() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getText());
        }
      }
    };
  }

  @Override
  public void addTrainingInstitute(final TrainingInstitute trainingInstitute) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrainingInstitute.insert(trainingInstitute);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<TrainingInstitute>> getAllTrainingInstitutes() {
    final String _sql = "SELECT * FROM training_institutes_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"training_institutes_table"}, false, new Callable<List<TrainingInstitute>>() {
      @Override
      public List<TrainingInstitute> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
          final List<TrainingInstitute> _result = new ArrayList<TrainingInstitute>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TrainingInstitute _item;
            _item = new TrainingInstitute();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpText;
            _tmpText = _cursor.getString(_cursorIndexOfText);
            _item.setText(_tmpText);
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
  public int getDataCount() {
    final String _sql = "SELECT COUNT(*) FROM training_institutes_table";
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
