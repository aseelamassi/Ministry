package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.rxjava3.EmptyResultSetException;
import androidx.room.rxjava3.RxRoom;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import io.reactivex.rxjava3.core.Single;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class InspectionVisitDao_Impl implements InspectionVisitDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InspectionVisit> __insertionAdapterOfInspectionVisit;

  public InspectionVisitDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInspectionVisit = new EntityInsertionAdapter<InspectionVisit>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `InspectionVisit` (`cOUNTROW`,`iNSPECTVID`,`cONSTRUCTID`,`iNSPECTVVISITORID`,`iNSPECTVVISITORID2`,`iNSPECTVVISITORID3`,`iNSPETVISITSTATUS`,`vISITDATE`,`iNSPECTVVISITEVALUATPER`,`iNSPECTVVISITCRITEAPER`,`iNSPECTVVISITCRITEBPER`,`iNSPECTVVISITCRITEEPER`,`iNSPECTPLANID`,`cONSTRUCTGUID`,`cONSTRUCTNAMEUSING`,`cONSTRUCTADDRESSID`,`cONSTRUCTNUM`,`dIRECTORATENAME`,`iNSPECTORENAME`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InspectionVisit value) {
        if (value.getCOUNTROW() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCOUNTROW());
        }
        if (value.getINSPECTVID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getINSPECTVID());
        }
        if (value.getCONSTRUCTID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCONSTRUCTID());
        }
        if (value.getINSPECTVVISITORID() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getINSPECTVVISITORID());
        }
        if (value.getINSPECTVVISITORID2() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getINSPECTVVISITORID2());
        }
        if (value.getINSPECTVVISITORID3() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getINSPECTVVISITORID3());
        }
        if (value.getINSPETVISITSTATUS() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getINSPETVISITSTATUS());
        }
        if (value.getVISITDATE() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getVISITDATE());
        }
        if (value.getINSPECTVVISITEVALUATPER() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getINSPECTVVISITEVALUATPER());
        }
        if (value.getINSPECTVVISITCRITEAPER() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getINSPECTVVISITCRITEAPER());
        }
        if (value.getINSPECTVVISITCRITEBPER() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getINSPECTVVISITCRITEBPER());
        }
        if (value.getINSPECTVVISITCRITEEPER() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getINSPECTVVISITCRITEEPER());
        }
        if (value.getINSPECTPLANID() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getINSPECTPLANID());
        }
        if (value.getCONSTRUCTGUID() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCONSTRUCTGUID());
        }
        if (value.getCONSTRUCTNAMEUSING() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getCONSTRUCTNAMEUSING());
        }
        if (value.getCONSTRUCTADDRESSID() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getCONSTRUCTADDRESSID());
        }
        if (value.getCONSTRUCTNUM() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getCONSTRUCTNUM());
        }
        if (value.getDIRECTORATENAME() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getDIRECTORATENAME());
        }
        if (value.getINSPECTORENAME() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getINSPECTORENAME());
        }
      }
    };
  }

  @Override
  public void insertAll(final List<InspectionVisit> inspectionVisitList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInspectionVisit.insert(inspectionVisitList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Single<List<InspectionVisit>> getInspectionVisit() {
    final String _sql = "SELECT * FROM InspectionVisit ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createSingle(new Callable<List<InspectionVisit>>() {
      @Override
      public List<InspectionVisit> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCOUNTROW = CursorUtil.getColumnIndexOrThrow(_cursor, "cOUNTROW");
          final int _cursorIndexOfINSPECTVID = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVID");
          final int _cursorIndexOfCONSTRUCTID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTID");
          final int _cursorIndexOfINSPECTVVISITORID = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITORID");
          final int _cursorIndexOfINSPECTVVISITORID2 = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITORID2");
          final int _cursorIndexOfINSPECTVVISITORID3 = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITORID3");
          final int _cursorIndexOfINSPETVISITSTATUS = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPETVISITSTATUS");
          final int _cursorIndexOfVISITDATE = CursorUtil.getColumnIndexOrThrow(_cursor, "vISITDATE");
          final int _cursorIndexOfINSPECTVVISITEVALUATPER = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITEVALUATPER");
          final int _cursorIndexOfINSPECTVVISITCRITEAPER = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITCRITEAPER");
          final int _cursorIndexOfINSPECTVVISITCRITEBPER = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITCRITEBPER");
          final int _cursorIndexOfINSPECTVVISITCRITEEPER = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITCRITEEPER");
          final int _cursorIndexOfINSPECTPLANID = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTPLANID");
          final int _cursorIndexOfCONSTRUCTGUID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTGUID");
          final int _cursorIndexOfCONSTRUCTNAMEUSING = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTNAMEUSING");
          final int _cursorIndexOfCONSTRUCTADDRESSID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTADDRESSID");
          final int _cursorIndexOfCONSTRUCTNUM = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTNUM");
          final int _cursorIndexOfDIRECTORATENAME = CursorUtil.getColumnIndexOrThrow(_cursor, "dIRECTORATENAME");
          final int _cursorIndexOfINSPECTORENAME = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTORENAME");
          final List<InspectionVisit> _result = new ArrayList<InspectionVisit>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final InspectionVisit _item;
            _item = new InspectionVisit();
            final String _tmpCOUNTROW;
            _tmpCOUNTROW = _cursor.getString(_cursorIndexOfCOUNTROW);
            _item.setCOUNTROW(_tmpCOUNTROW);
            final String _tmpINSPECTVID;
            _tmpINSPECTVID = _cursor.getString(_cursorIndexOfINSPECTVID);
            _item.setINSPECTVID(_tmpINSPECTVID);
            final String _tmpCONSTRUCTID;
            _tmpCONSTRUCTID = _cursor.getString(_cursorIndexOfCONSTRUCTID);
            _item.setCONSTRUCTID(_tmpCONSTRUCTID);
            final String _tmpINSPECTVVISITORID;
            _tmpINSPECTVVISITORID = _cursor.getString(_cursorIndexOfINSPECTVVISITORID);
            _item.setINSPECTVVISITORID(_tmpINSPECTVVISITORID);
            final String _tmpINSPECTVVISITORID2;
            _tmpINSPECTVVISITORID2 = _cursor.getString(_cursorIndexOfINSPECTVVISITORID2);
            _item.setINSPECTVVISITORID2(_tmpINSPECTVVISITORID2);
            final String _tmpINSPECTVVISITORID3;
            _tmpINSPECTVVISITORID3 = _cursor.getString(_cursorIndexOfINSPECTVVISITORID3);
            _item.setINSPECTVVISITORID3(_tmpINSPECTVVISITORID3);
            final String _tmpINSPETVISITSTATUS;
            _tmpINSPETVISITSTATUS = _cursor.getString(_cursorIndexOfINSPETVISITSTATUS);
            _item.setINSPETVISITSTATUS(_tmpINSPETVISITSTATUS);
            final String _tmpVISITDATE;
            _tmpVISITDATE = _cursor.getString(_cursorIndexOfVISITDATE);
            _item.setVISITDATE(_tmpVISITDATE);
            final String _tmpINSPECTVVISITEVALUATPER;
            _tmpINSPECTVVISITEVALUATPER = _cursor.getString(_cursorIndexOfINSPECTVVISITEVALUATPER);
            _item.setINSPECTVVISITEVALUATPER(_tmpINSPECTVVISITEVALUATPER);
            final String _tmpINSPECTVVISITCRITEAPER;
            _tmpINSPECTVVISITCRITEAPER = _cursor.getString(_cursorIndexOfINSPECTVVISITCRITEAPER);
            _item.setINSPECTVVISITCRITEAPER(_tmpINSPECTVVISITCRITEAPER);
            final String _tmpINSPECTVVISITCRITEBPER;
            _tmpINSPECTVVISITCRITEBPER = _cursor.getString(_cursorIndexOfINSPECTVVISITCRITEBPER);
            _item.setINSPECTVVISITCRITEBPER(_tmpINSPECTVVISITCRITEBPER);
            final String _tmpINSPECTVVISITCRITEEPER;
            _tmpINSPECTVVISITCRITEEPER = _cursor.getString(_cursorIndexOfINSPECTVVISITCRITEEPER);
            _item.setINSPECTVVISITCRITEEPER(_tmpINSPECTVVISITCRITEEPER);
            final String _tmpINSPECTPLANID;
            _tmpINSPECTPLANID = _cursor.getString(_cursorIndexOfINSPECTPLANID);
            _item.setINSPECTPLANID(_tmpINSPECTPLANID);
            final String _tmpCONSTRUCTGUID;
            _tmpCONSTRUCTGUID = _cursor.getString(_cursorIndexOfCONSTRUCTGUID);
            _item.setCONSTRUCTGUID(_tmpCONSTRUCTGUID);
            final String _tmpCONSTRUCTNAMEUSING;
            _tmpCONSTRUCTNAMEUSING = _cursor.getString(_cursorIndexOfCONSTRUCTNAMEUSING);
            _item.setCONSTRUCTNAMEUSING(_tmpCONSTRUCTNAMEUSING);
            final String _tmpCONSTRUCTADDRESSID;
            _tmpCONSTRUCTADDRESSID = _cursor.getString(_cursorIndexOfCONSTRUCTADDRESSID);
            _item.setCONSTRUCTADDRESSID(_tmpCONSTRUCTADDRESSID);
            final String _tmpCONSTRUCTNUM;
            _tmpCONSTRUCTNUM = _cursor.getString(_cursorIndexOfCONSTRUCTNUM);
            _item.setCONSTRUCTNUM(_tmpCONSTRUCTNUM);
            final String _tmpDIRECTORATENAME;
            _tmpDIRECTORATENAME = _cursor.getString(_cursorIndexOfDIRECTORATENAME);
            _item.setDIRECTORATENAME(_tmpDIRECTORATENAME);
            final String _tmpINSPECTORENAME;
            _tmpINSPECTORENAME = _cursor.getString(_cursorIndexOfINSPECTORENAME);
            _item.setINSPECTORENAME(_tmpINSPECTORENAME);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
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
  public Single<List<InspectionVisit>> getInspectionVisitByConstructId(final String constructId) {
    final String _sql = "SELECT * FROM InspectionVisit where cONSTRUCTID like ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (constructId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, constructId);
    }
    return RxRoom.createSingle(new Callable<List<InspectionVisit>>() {
      @Override
      public List<InspectionVisit> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCOUNTROW = CursorUtil.getColumnIndexOrThrow(_cursor, "cOUNTROW");
          final int _cursorIndexOfINSPECTVID = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVID");
          final int _cursorIndexOfCONSTRUCTID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTID");
          final int _cursorIndexOfINSPECTVVISITORID = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITORID");
          final int _cursorIndexOfINSPECTVVISITORID2 = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITORID2");
          final int _cursorIndexOfINSPECTVVISITORID3 = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITORID3");
          final int _cursorIndexOfINSPETVISITSTATUS = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPETVISITSTATUS");
          final int _cursorIndexOfVISITDATE = CursorUtil.getColumnIndexOrThrow(_cursor, "vISITDATE");
          final int _cursorIndexOfINSPECTVVISITEVALUATPER = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITEVALUATPER");
          final int _cursorIndexOfINSPECTVVISITCRITEAPER = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITCRITEAPER");
          final int _cursorIndexOfINSPECTVVISITCRITEBPER = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITCRITEBPER");
          final int _cursorIndexOfINSPECTVVISITCRITEEPER = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTVVISITCRITEEPER");
          final int _cursorIndexOfINSPECTPLANID = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTPLANID");
          final int _cursorIndexOfCONSTRUCTGUID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTGUID");
          final int _cursorIndexOfCONSTRUCTNAMEUSING = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTNAMEUSING");
          final int _cursorIndexOfCONSTRUCTADDRESSID = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTADDRESSID");
          final int _cursorIndexOfCONSTRUCTNUM = CursorUtil.getColumnIndexOrThrow(_cursor, "cONSTRUCTNUM");
          final int _cursorIndexOfDIRECTORATENAME = CursorUtil.getColumnIndexOrThrow(_cursor, "dIRECTORATENAME");
          final int _cursorIndexOfINSPECTORENAME = CursorUtil.getColumnIndexOrThrow(_cursor, "iNSPECTORENAME");
          final List<InspectionVisit> _result = new ArrayList<InspectionVisit>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final InspectionVisit _item;
            _item = new InspectionVisit();
            final String _tmpCOUNTROW;
            _tmpCOUNTROW = _cursor.getString(_cursorIndexOfCOUNTROW);
            _item.setCOUNTROW(_tmpCOUNTROW);
            final String _tmpINSPECTVID;
            _tmpINSPECTVID = _cursor.getString(_cursorIndexOfINSPECTVID);
            _item.setINSPECTVID(_tmpINSPECTVID);
            final String _tmpCONSTRUCTID;
            _tmpCONSTRUCTID = _cursor.getString(_cursorIndexOfCONSTRUCTID);
            _item.setCONSTRUCTID(_tmpCONSTRUCTID);
            final String _tmpINSPECTVVISITORID;
            _tmpINSPECTVVISITORID = _cursor.getString(_cursorIndexOfINSPECTVVISITORID);
            _item.setINSPECTVVISITORID(_tmpINSPECTVVISITORID);
            final String _tmpINSPECTVVISITORID2;
            _tmpINSPECTVVISITORID2 = _cursor.getString(_cursorIndexOfINSPECTVVISITORID2);
            _item.setINSPECTVVISITORID2(_tmpINSPECTVVISITORID2);
            final String _tmpINSPECTVVISITORID3;
            _tmpINSPECTVVISITORID3 = _cursor.getString(_cursorIndexOfINSPECTVVISITORID3);
            _item.setINSPECTVVISITORID3(_tmpINSPECTVVISITORID3);
            final String _tmpINSPETVISITSTATUS;
            _tmpINSPETVISITSTATUS = _cursor.getString(_cursorIndexOfINSPETVISITSTATUS);
            _item.setINSPETVISITSTATUS(_tmpINSPETVISITSTATUS);
            final String _tmpVISITDATE;
            _tmpVISITDATE = _cursor.getString(_cursorIndexOfVISITDATE);
            _item.setVISITDATE(_tmpVISITDATE);
            final String _tmpINSPECTVVISITEVALUATPER;
            _tmpINSPECTVVISITEVALUATPER = _cursor.getString(_cursorIndexOfINSPECTVVISITEVALUATPER);
            _item.setINSPECTVVISITEVALUATPER(_tmpINSPECTVVISITEVALUATPER);
            final String _tmpINSPECTVVISITCRITEAPER;
            _tmpINSPECTVVISITCRITEAPER = _cursor.getString(_cursorIndexOfINSPECTVVISITCRITEAPER);
            _item.setINSPECTVVISITCRITEAPER(_tmpINSPECTVVISITCRITEAPER);
            final String _tmpINSPECTVVISITCRITEBPER;
            _tmpINSPECTVVISITCRITEBPER = _cursor.getString(_cursorIndexOfINSPECTVVISITCRITEBPER);
            _item.setINSPECTVVISITCRITEBPER(_tmpINSPECTVVISITCRITEBPER);
            final String _tmpINSPECTVVISITCRITEEPER;
            _tmpINSPECTVVISITCRITEEPER = _cursor.getString(_cursorIndexOfINSPECTVVISITCRITEEPER);
            _item.setINSPECTVVISITCRITEEPER(_tmpINSPECTVVISITCRITEEPER);
            final String _tmpINSPECTPLANID;
            _tmpINSPECTPLANID = _cursor.getString(_cursorIndexOfINSPECTPLANID);
            _item.setINSPECTPLANID(_tmpINSPECTPLANID);
            final String _tmpCONSTRUCTGUID;
            _tmpCONSTRUCTGUID = _cursor.getString(_cursorIndexOfCONSTRUCTGUID);
            _item.setCONSTRUCTGUID(_tmpCONSTRUCTGUID);
            final String _tmpCONSTRUCTNAMEUSING;
            _tmpCONSTRUCTNAMEUSING = _cursor.getString(_cursorIndexOfCONSTRUCTNAMEUSING);
            _item.setCONSTRUCTNAMEUSING(_tmpCONSTRUCTNAMEUSING);
            final String _tmpCONSTRUCTADDRESSID;
            _tmpCONSTRUCTADDRESSID = _cursor.getString(_cursorIndexOfCONSTRUCTADDRESSID);
            _item.setCONSTRUCTADDRESSID(_tmpCONSTRUCTADDRESSID);
            final String _tmpCONSTRUCTNUM;
            _tmpCONSTRUCTNUM = _cursor.getString(_cursorIndexOfCONSTRUCTNUM);
            _item.setCONSTRUCTNUM(_tmpCONSTRUCTNUM);
            final String _tmpDIRECTORATENAME;
            _tmpDIRECTORATENAME = _cursor.getString(_cursorIndexOfDIRECTORATENAME);
            _item.setDIRECTORATENAME(_tmpDIRECTORATENAME);
            final String _tmpINSPECTORENAME;
            _tmpINSPECTORENAME = _cursor.getString(_cursorIndexOfINSPECTORENAME);
            _item.setINSPECTORENAME(_tmpINSPECTORENAME);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
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
    final String _sql = "SELECT COUNT(*) FROM InspectionVisit";
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
