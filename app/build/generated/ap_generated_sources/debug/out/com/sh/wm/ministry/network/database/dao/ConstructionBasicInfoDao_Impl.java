package com.sh.wm.ministry.network.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.ConstructionBasicInfo;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ConstructionBasicInfoDao_Impl implements ConstructionBasicInfoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ConstructionBasicInfo> __insertionAdapterOfConstructionBasicInfo;

  private final EntityDeletionOrUpdateAdapter<ConstructionBasicInfo> __deletionAdapterOfConstructionBasicInfo;

  public ConstructionBasicInfoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConstructionBasicInfo = new EntityInsertionAdapter<ConstructionBasicInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ConstructionBasicInfo` (`action`,`constructId`,`addressId`,`constructionNumber`,`visitDate`,`nameUsing`,`nameOfficial`,`municipapiityId`,`regionId`,`streetId`,`streetDetails`,`buldingNo`,`addressDesc`,`xDirection`,`yDirections`,`telephone`,`mobile`,`fax`,`box`,`url`,`email`,`riskLevelId`,`visitId`,`submitAction`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConstructionBasicInfo value) {
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
        if (value.getAddressId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddressId());
        }
        if (value.getConstructionNumber() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getConstructionNumber());
        }
        if (value.getVisitDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getVisitDate());
        }
        if (value.getNameUsing() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNameUsing());
        }
        if (value.getNameOfficial() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNameOfficial());
        }
        if (value.getMunicipapiityId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMunicipapiityId());
        }
        if (value.getRegionId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRegionId());
        }
        if (value.getStreetId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStreetId());
        }
        if (value.getStreetDetails() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getStreetDetails());
        }
        if (value.getBuldingNo() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBuldingNo());
        }
        if (value.getAddressDesc() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getAddressDesc());
        }
        if (value.getXDirection() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getXDirection());
        }
        if (value.getYDirections() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getYDirections());
        }
        if (value.getTelephone() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTelephone());
        }
        if (value.getMobile() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getMobile());
        }
        if (value.getFax() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getFax());
        }
        if (value.getBox() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getBox());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getUrl());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getEmail());
        }
        if (value.getRiskLevelId() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getRiskLevelId());
        }
        if (value.getVisitId() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getVisitId());
        }
        if (value.getSubmitAction() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getSubmitAction());
        }
      }
    };
    this.__deletionAdapterOfConstructionBasicInfo = new EntityDeletionOrUpdateAdapter<ConstructionBasicInfo>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ConstructionBasicInfo` WHERE `visitId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConstructionBasicInfo value) {
        if (value.getVisitId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getVisitId());
        }
      }
    };
  }

  @Override
  public void addConstructionBasicInfo(final ConstructionBasicInfo model) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfConstructionBasicInfo.insert(model);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteConstructionBasicInfo(final ConstructionBasicInfo model) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfConstructionBasicInfo.handle(model);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ConstructionBasicInfo> getConstructionBasicInfo() {
    final String _sql = "SELECT * FROM ConstructionBasicInfo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
      final int _cursorIndexOfConstructId = CursorUtil.getColumnIndexOrThrow(_cursor, "constructId");
      final int _cursorIndexOfAddressId = CursorUtil.getColumnIndexOrThrow(_cursor, "addressId");
      final int _cursorIndexOfConstructionNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "constructionNumber");
      final int _cursorIndexOfVisitDate = CursorUtil.getColumnIndexOrThrow(_cursor, "visitDate");
      final int _cursorIndexOfNameUsing = CursorUtil.getColumnIndexOrThrow(_cursor, "nameUsing");
      final int _cursorIndexOfNameOfficial = CursorUtil.getColumnIndexOrThrow(_cursor, "nameOfficial");
      final int _cursorIndexOfMunicipapiityId = CursorUtil.getColumnIndexOrThrow(_cursor, "municipapiityId");
      final int _cursorIndexOfRegionId = CursorUtil.getColumnIndexOrThrow(_cursor, "regionId");
      final int _cursorIndexOfStreetId = CursorUtil.getColumnIndexOrThrow(_cursor, "streetId");
      final int _cursorIndexOfStreetDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "streetDetails");
      final int _cursorIndexOfBuldingNo = CursorUtil.getColumnIndexOrThrow(_cursor, "buldingNo");
      final int _cursorIndexOfAddressDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "addressDesc");
      final int _cursorIndexOfXDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "xDirection");
      final int _cursorIndexOfYDirections = CursorUtil.getColumnIndexOrThrow(_cursor, "yDirections");
      final int _cursorIndexOfTelephone = CursorUtil.getColumnIndexOrThrow(_cursor, "telephone");
      final int _cursorIndexOfMobile = CursorUtil.getColumnIndexOrThrow(_cursor, "mobile");
      final int _cursorIndexOfFax = CursorUtil.getColumnIndexOrThrow(_cursor, "fax");
      final int _cursorIndexOfBox = CursorUtil.getColumnIndexOrThrow(_cursor, "box");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfRiskLevelId = CursorUtil.getColumnIndexOrThrow(_cursor, "riskLevelId");
      final int _cursorIndexOfVisitId = CursorUtil.getColumnIndexOrThrow(_cursor, "visitId");
      final int _cursorIndexOfSubmitAction = CursorUtil.getColumnIndexOrThrow(_cursor, "submitAction");
      final List<ConstructionBasicInfo> _result = new ArrayList<ConstructionBasicInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ConstructionBasicInfo _item;
        final String _tmpAction;
        _tmpAction = _cursor.getString(_cursorIndexOfAction);
        final String _tmpConstructId;
        _tmpConstructId = _cursor.getString(_cursorIndexOfConstructId);
        final String _tmpAddressId;
        _tmpAddressId = _cursor.getString(_cursorIndexOfAddressId);
        final String _tmpConstructionNumber;
        _tmpConstructionNumber = _cursor.getString(_cursorIndexOfConstructionNumber);
        final String _tmpVisitDate;
        _tmpVisitDate = _cursor.getString(_cursorIndexOfVisitDate);
        final String _tmpNameUsing;
        _tmpNameUsing = _cursor.getString(_cursorIndexOfNameUsing);
        final String _tmpNameOfficial;
        _tmpNameOfficial = _cursor.getString(_cursorIndexOfNameOfficial);
        final String _tmpMunicipapiityId;
        _tmpMunicipapiityId = _cursor.getString(_cursorIndexOfMunicipapiityId);
        final String _tmpRegionId;
        _tmpRegionId = _cursor.getString(_cursorIndexOfRegionId);
        final String _tmpStreetId;
        _tmpStreetId = _cursor.getString(_cursorIndexOfStreetId);
        final String _tmpStreetDetails;
        _tmpStreetDetails = _cursor.getString(_cursorIndexOfStreetDetails);
        final String _tmpBuldingNo;
        _tmpBuldingNo = _cursor.getString(_cursorIndexOfBuldingNo);
        final String _tmpAddressDesc;
        _tmpAddressDesc = _cursor.getString(_cursorIndexOfAddressDesc);
        final String _tmpXDirection;
        _tmpXDirection = _cursor.getString(_cursorIndexOfXDirection);
        final String _tmpYDirections;
        _tmpYDirections = _cursor.getString(_cursorIndexOfYDirections);
        final String _tmpTelephone;
        _tmpTelephone = _cursor.getString(_cursorIndexOfTelephone);
        final String _tmpMobile;
        _tmpMobile = _cursor.getString(_cursorIndexOfMobile);
        final String _tmpFax;
        _tmpFax = _cursor.getString(_cursorIndexOfFax);
        final String _tmpBox;
        _tmpBox = _cursor.getString(_cursorIndexOfBox);
        final String _tmpUrl;
        _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpRiskLevelId;
        _tmpRiskLevelId = _cursor.getString(_cursorIndexOfRiskLevelId);
        final String _tmpVisitId;
        _tmpVisitId = _cursor.getString(_cursorIndexOfVisitId);
        final String _tmpSubmitAction;
        _tmpSubmitAction = _cursor.getString(_cursorIndexOfSubmitAction);
        _item = new ConstructionBasicInfo(_tmpAction,_tmpConstructId,_tmpAddressId,_tmpConstructionNumber,_tmpVisitDate,_tmpNameUsing,_tmpNameOfficial,_tmpMunicipapiityId,_tmpRegionId,_tmpStreetId,_tmpStreetDetails,_tmpBuldingNo,_tmpAddressDesc,_tmpXDirection,_tmpYDirections,_tmpTelephone,_tmpMobile,_tmpFax,_tmpBox,_tmpUrl,_tmpEmail,_tmpRiskLevelId,_tmpVisitId,_tmpSubmitAction);
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
    final String _sql = "SELECT COUNT(*) FROM ConstructionBasicInfo ";
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
