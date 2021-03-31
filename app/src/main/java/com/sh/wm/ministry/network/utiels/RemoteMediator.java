package com.sh.wm.ministry.network.utiels;

import android.content.Context;
import android.widget.Switch;

import androidx.paging.ExperimentalPagingApi;
import androidx.paging.LoadType;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxRemoteMediator;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisitModel;
import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.database.dao.InspectionVisitDao;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.RemoteKeys;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.OptIn;
import kotlin.UseExperimental;
import retrofit2.HttpException;

@OptIn(markerClass = ExperimentalPagingApi.class)
public class RemoteMediator /*extends RxRemoteMediator<Integer, InspectionVisit>*/ {

//    private String constructId;
//    private NetworkUtils networkService;
//    private DataBase database;
//    private InspectionVisitDao inspectionVisitDao;
//    private Context context;
//
//    private final int nextPage = 1;
//
//    RemoteMediator(
//            Context context,
//            String constructId
//    ) {
//        this.context = context;
//        this.constructId = constructId;
//        networkService = NetworkUtils.getInstance(true, context);
//        database = DataBase.getInstance(context);
//        inspectionVisitDao = database.inspectionVisitDao();
//    }
//
//
//    @NotNull
//    @Override
//    public Single<MediatorResult> loadSingle(@NotNull LoadType loadType, @NotNull PagingState<Integer, InspectionVisit> pagingState) {
//        String loadKey = null;
//        switch (loadType) {
//            case REFRESH:
//                break;
//            case PREPEND:
//                // In this example, you never need to prepend, since REFRESH will always
//                // load the first page in the list. Immediately return, reporting end of
//                // pagination.
//                return Single.just(new MediatorResult.Success(true));
//            case APPEND:
//                InspectionVisit lastItem = pagingState.lastItemOrNull();
//
//                // You must explicitly check if the last item is null when appending,
//                // since passing null to networkService is only valid for initial load.
//                // If lastItem is null it means no items were loaded after the initial
//                // REFRESH and there are no more items to load.
//                if (lastItem == null) {
//                    return Single.just(new MediatorResult.Success(true));
//                }
//
//                loadKey = lastItem.getINSPECTVID();
//                break;
//        }
//
//        return networkService.getApiInterface().getInspectionVisitsPlan(constructId , nextPage , 10)
//                .subscribeOn(Schedulers.io())
//                .map((Function<InspectionVisitModel, MediatorResult>) response -> {
//                    database.runInTransaction(() -> {
//                        if (loadType == LoadType.REFRESH) {
//                            inspectionVisitDao.clearData();
//                        }
//
//                        // Insert new users into database, which invalidates the current
//                        // PagingData, allowing Paging to present the updates in the DB.
//                        inspectionVisitDao.insertAll(response.getInspectionVisit());
//                    });
//
//                   // return new MediatorResult.Success(response.getNextKey() == null);
//                })
//                .onErrorResumeNext(e -> {
//                    if (e instanceof IOException || e instanceof HttpException) {
//                         Single.just(new MediatorResult.Error(e));
//                    }
//
//                    return Single.error(e);
//                });
//    }
}
