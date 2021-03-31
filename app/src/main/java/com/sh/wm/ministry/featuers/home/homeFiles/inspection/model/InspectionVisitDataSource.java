package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model;

import android.content.Context;
import android.util.Log;

import androidx.paging.rxjava3.RxPagingSource;

import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.database.dao.InspectionVisitDao;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class InspectionVisitDataSource extends RxPagingSource<Integer, InspectionVisit> {


    private Context context;
    private String constructId;
    private InspectionVisitDao inspectionVisitDao;


    public InspectionVisitDataSource(Context context, String constructId) {
        this.context = context;
        this.constructId = constructId;

        inspectionVisitDao = DataBase.getInstance(context).inspectionVisitDao();
    }

    @NotNull
    @Override
    public Single<LoadResult<Integer, InspectionVisit>> loadSingle(@NotNull LoadParams<Integer> loadParams) {
        NetworkUtils networkUtils = NetworkUtils.getInstance(true, context);
        try {
            // If page number is already there then init page variable with it otherwise we are loading fist page
            int page = loadParams.getKey() != null ? loadParams.getKey() : 1;


            // Send request to server with page number

            if (NetworkUtils.isOnline(context)) {
                return networkUtils.getApiInterface()
                        .getInspectionVisitsPlan(constructId, page, 10)
                        // Subscribe the result
                        .subscribeOn(Schedulers.io())
                        // Map result top List of movies
                        .map(InspectionVisitModel::getInspectionVisit)
                        // Map result to LoadResult Object
                        .map(inspectionVisits -> toLoadResult(inspectionVisits, page))
                        // when error is there return error
                        .onErrorReturn(LoadResult.Error::new);
            } else {
                if (constructId.isEmpty()) {
                    return inspectionVisitDao.getInspectionVisit()
                            .subscribeOn(Schedulers.io())
                            // Map result to LoadResult Object
                            .map(inspectionVisits -> toLoadResult(inspectionVisits, page))

                            // when error is there return error
                            .onErrorReturn(LoadResult.Error::new);
                } else {
                    return inspectionVisitDao.getInspectionVisitByConstructId(constructId)
                            .subscribeOn(Schedulers.io())
                            // Map result top List of movies

                            // Map result to LoadResult Object
                            .map(inspectionVisits -> toLoadResult(inspectionVisits, page))
                            // when error is there return error
                            .onErrorReturn(LoadResult.Error::new);
                }

            }

        } catch (Exception e) {
            // Request ran into error return error
            return Single.just(new LoadResult.Error(e));
        }
    }

    // Method to map construction inspection visit to LoadResult object
    private LoadResult<Integer, InspectionVisit> toLoadResult(List<InspectionVisit> inspectionVisits, int page) {



        inspectionVisitDao.insertAll(inspectionVisits);


        if (!NetworkUtils.isOnline(context) ||( constructId != null && !constructId.isEmpty())){
            if (page <= inspectionVisits.size() / 10)

                return new LoadResult.Page(inspectionVisits, page == 1 ? null : page - 1, page + 1);
            else
                return new LoadResult.Page(inspectionVisits, page == 1 ? null : page - 1, null);

        }

        return new LoadResult.Page(inspectionVisits, page == 1 ? null : page - 1, page + 1);





    }


}