package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TrainingProgramDao_Impl implements TrainingProgramDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TrainingProgram> __insertionAdapterOfTrainingProgram;

  public TrainingProgramDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrainingProgram = new EntityInsertionAdapter<TrainingProgram>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `training_programs_table` (`tRAININGPROGRAMID`,`tRAININGPROGRAMARNAME`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TrainingProgram value) {
        if (value.getTRAININGPROGRAMID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTRAININGPROGRAMID());
        }
        if (value.getTRAININGPROGRAMARNAME() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTRAININGPROGRAMARNAME());
        }
      }
    };
  }

  @Override
  public void addTrainingProgram(final TrainingProgram trainingProgram) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrainingProgram.insert(trainingProgram);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<TrainingProgram>> getAllTrainingPrograms(final String keyword) {
    final String _sql = "SELECT * FROM training_programs_table where  tRAININGPROGRAMARNAME LIKE ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"training_programs_table"}, false, new Callable<List<TrainingProgram>>() {
      @Override
      public List<TrainingProgram> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTRAININGPROGRAMID = CursorUtil.getColumnIndexOrThrow(_cursor, "tRAININGPROGRAMID");
          final int _cursorIndexOfTRAININGPROGRAMARNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "tRAININGPROGRAMARNAME");
          final List<TrainingProgram> _result = new ArrayList<TrainingProgram>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TrainingProgram _item;
            _item = new TrainingProgram();
            final String _tmpTRAININGPROGRAMID;
            _tmpTRAININGPROGRAMID = _cursor.getString(_cursorIndexOfTRAININGPROGRAMID);
            _item.setTRAININGPROGRAMID(_tmpTRAININGPROGRAMID);
            final String _tmpTRAININGPROGRAMARNAME;
            _tmpTRAININGPROGRAMARNAME = _cursor.getString(_cursorIndexOfTRAININGPROGRAMARNAME);
            _item.setTRAININGPROGRAMARNAME(_tmpTRAININGPROGRAMARNAME);
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
    final String _sql = "SELECT COUNT(*) FROM training_programs_table";
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
