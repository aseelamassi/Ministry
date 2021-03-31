package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.PostDataMoveFacility;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.StreetGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoveFacilityRepository {

    private MutableLiveData<StreetGroup> streetMutableLiveData;

    MutableLiveData<ConstructByName> constructByNameMutableLiveData;
    private MutableLiveData<PostDataMoveFacility> poastDataMoveFacilityMutableLiveData;
    private NetworkUtils networkUtils;
    private Application application;
    private static MoveFacilityRepository mInstance;
    public static final String TAG = MoveFacilityRepository.class.getSimpleName();

    private MoveFacilityRepository(Application application) {

        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        streetMutableLiveData = new MutableLiveData<>();
        constructByNameMutableLiveData = new MutableLiveData<>();
        poastDataMoveFacilityMutableLiveData = new MutableLiveData<>();
    }

    public static MoveFacilityRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new MoveFacilityRepository(application);

        }
        return mInstance;
    }

    public LiveData<StreetGroup> getAllStreet() {
        Call<StreetGroup> call = networkUtils.getApiInterface().getAllStreets();
        call.enqueue(new Callback<StreetGroup>() {
            @Override
            public void onResponse(Call<StreetGroup> call, Response<StreetGroup> response) {
                if (response.isSuccessful()) {

                    Log.d(TAG, "onResponse: " + response.body().getStreets().get(1).getSTREETID());

                }
                streetMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<StreetGroup> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return streetMutableLiveData;
    }

    /*
        public LiveData<Construction> getConstructiondata(String num_construction) {
            Call<ConstructionGroup> call = networkUtils.getApiInterface().getDataConstruction(num_construction);
            call.enqueue(new Callback<ConstructionGroup>() {
                @Override
                public void onResponse(@NotNull Call<ConstructionGroup> call, @NotNull Response<ConstructionGroup> response) {

                    if (response.body().getStatus() != 1) {
                        if (response.isSuccessful()) {
                            Gson gson = new Gson();
                            Type type = new TypeToken<Construction>() {
                            }.getType();
                            // assert response.body() != null;
                            Construction construction = gson.fromJson(gson.toJson(response.body().getConstruction()), type);
                            Log.d(TAG, "onResponse: sh " + construction.getCONSTRUCTNUM());
                            Log.d(TAG, "onResponse: sh " + response.body().toString());

                            constructionMutableLiveData.setValue(response.body().getConstruction());
                        } else {
                            Log.d(TAG, "onResponse: no data her");
                            constructionMutableLiveData.setValue(null);
                        }
                    } else {
                        Log.d(TAG, "onResponse: null data her");
                        constructionMutableLiveData.setValue(null);

                    }
                }

                @Override
                public void onFailure(@NotNull Call<ConstructionGroup> call, @NotNull Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                    constructionMutableLiveData.setValue(null);
                }
            });
            return constructionMutableLiveData;

        }
    */

    public LiveData<ConstructByName> getConstruct(String number) {
        networkUtils.getApiInterface().getConstructByName(number).enqueue(new Callback<ConstructByName>() {
            @Override
            public void onResponse(Call<ConstructByName> call, Response<ConstructByName> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: 1 " + response.body());
                    constructByNameMutableLiveData.setValue(response.body());
                } else {
                    Log.d(TAG, "onResponse:  2" + " no data");
                    constructByNameMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ConstructByName> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                constructByNameMutableLiveData.setValue(null);
            }
        });

        return constructByNameMutableLiveData;
    }


    public LiveData<PostDataMoveFacility> postdata(String cnstruction_id, String address_id, String municipapiity_id, String region_id,
                                                   String street_id, String bulding_no, String address_desc, String x_direction, String y_direction,
                                                   String construction_tele, String construction_mobile, String construction_fax, String construction_box,
                                                   String construction_url, String email) {

        Call<PostDataMoveFacility> call = networkUtils.getApiInterface().CheangePlace(cnstruction_id, address_id, municipapiity_id, region_id, street_id, bulding_no, address_desc, x_direction, y_direction, construction_tele, construction_mobile, construction_fax, construction_box, construction_url, email);
        call.enqueue(new Callback<PostDataMoveFacility>() {
            @Override
            public void onResponse(Call<PostDataMoveFacility> call, Response<PostDataMoveFacility> response) {

                if (response.isSuccessful()) {

                    Log.d(TAG, "onResponse: ' " + response.body().getMessageText());
                 //   Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();

                    poastDataMoveFacilityMutableLiveData.setValue(response.body());
                } else {
                    Log.d(TAG, "onResponse: '  Failure");
                    poastDataMoveFacilityMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PostDataMoveFacility> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                poastDataMoveFacilityMutableLiveData.setValue(null);
            }
        });
        return poastDataMoveFacilityMutableLiveData;

    }


}
