package com.sh.wm.ministry.featuers.userfile.travel.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentTravelBinding;

import com.sh.wm.ministry.featuers.userfile.travel.adapter.TravelAdapter;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelData;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.viewModel.TravelsViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;


public class TravelFragment extends Fragment {

    private FragmentTravelBinding binding ;
    private TravelsViewModel mViewModel;
    private RecyclerView recycler;
    private List<UserTravelData> userTravelDataList;



    public TravelFragment() {

    }


    public static TravelFragment newInstance() {
        TravelFragment fragment = new TravelFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTravelBinding.inflate(inflater, container, false);
        recycler = binding.rvTravel;
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(TravelsViewModel.class);

        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available
            //get user travel data from API
            mViewModel.getTravelData().observe(getViewLifecycleOwner(), (UserTravelDataModel userTravelDataModel) -> {
                if (userTravelDataModel!= null && userTravelDataModel.getStatus() == 0) {
                    binding.progress.setVisibility(View.GONE);
                    recycler.setVisibility(View.VISIBLE);

                    userTravelDataList = userTravelDataModel.getUserTravelData();
                    //setup adapter
                    TravelAdapter travelAdapter = new TravelAdapter(getContext(), userTravelDataList);
                    recycler.setAdapter(travelAdapter);
                } else {
                    binding.progress.setVisibility(View.GONE);
                    binding.tvNoTravels.setVisibility(View.VISIBLE);
                }


            });
        }else {
            binding.progress.setVisibility(View.GONE);
            binding.tvNoTravels.setText(getString(R.string.no_internet_to_show));
            binding.tvNoTravels.setVisibility(View.VISIBLE);

        }

    }
}