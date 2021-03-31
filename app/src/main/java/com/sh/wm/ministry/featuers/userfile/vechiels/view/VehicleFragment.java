package com.sh.wm.ministry.featuers.userfile.vechiels.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentVehicleBinding;
import com.sh.wm.ministry.featuers.userfile.vechiels.adapter.VehicleAdapter;
import com.sh.wm.ministry.featuers.userfile.vechiels.model.UserVehicle;
import com.sh.wm.ministry.featuers.userfile.vechiels.model.UserVehicleModel;
import com.sh.wm.ministry.featuers.userfile.vechiels.viewModel.UserVehicleViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

public class VehicleFragment extends Fragment {


    FragmentVehicleBinding binding;
    private UserVehicleViewModel mViewModel;
    private RecyclerView recycler;
    private List<UserVehicle> userVehicles;


    public VehicleFragment() {
        // Required empty public constructor
    }


    public static VehicleFragment newInstance() {
        VehicleFragment fragment = new VehicleFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVehicleBinding.inflate(inflater, container, false);
        recycler = binding.rvVehicle;
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(UserVehicleViewModel.class);

        if (NetworkUtils.isOnline(getContext())) { //check if the internet is available
            //get user vehicle data
            mViewModel.getUserVehicle().observe(getViewLifecycleOwner(), (UserVehicleModel userVehicleModel) -> {
                binding.progress.setVisibility(View.GONE);
                if (userVehicleModel!= null &&userVehicleModel.getStatus() == 0) {

                    recycler.setVisibility(View.VISIBLE);

                    userVehicles = userVehicleModel.getUserVehicle();
                    //setup adapter
                    VehicleAdapter travelAdapter = new VehicleAdapter(getContext(), userVehicles);
                    recycler.setAdapter(travelAdapter);
                } else {
                    binding.tvNoVehicle.setVisibility(View.VISIBLE);
                }


            });
        } else {
            binding.tvNoVehicle.setVisibility(View.VISIBLE);

            binding.progress.setVisibility(View.GONE);
            binding.tvNoVehicle.setText(getString(R.string.no_internet_to_show));
        }

    }

}