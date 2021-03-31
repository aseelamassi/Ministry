package com.sh.wm.ministry.network.utiels;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sh.wm.ministry.network.database.dbModels.offlineModes.StartVisitModel;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;

public class NetworkChangeReceiver extends BroadcastReceiver {

    DBRepository dbRepository ;
    static  String type ;
    static  String visitIId ;
    @Override
    public void onReceive(Context context, Intent intent) {



        if (NetworkUtils.isOnline(context)){
            dbRepository = DBRepository.getInstance((Application) context.getApplicationContext());
            List<StartVisitModel> startedVisits = dbRepository.getStartedVisit();
            if (dbRepository.getStartedVisitCount() >0){

                for (StartVisitModel startVisitModel : startedVisits){

                    dbRepository.startVisit(startVisitModel.getVisit_id());
                    dbRepository.deleteStartVisit(startVisitModel);

            }
            }

//            if (intent.getStringExtra("type")!= null && intent.getStringExtra("type").equals("start")){
//                Log.d("hi" , "action");
//                String visitId = intent.getStringExtra("id");
//                dbRepository.startVisit(visitId);
//
//
//
//            }


        }




    }
}
