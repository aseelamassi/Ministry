package com.sh.wm.ministry.featuers.userfile.userRealty.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentRealtyBinding;
import com.sh.wm.ministry.featuers.userfile.userRealty.adapter.RealtyAdapter;
import com.sh.wm.ministry.featuers.userfile.userRealty.model.UserRealty;
import com.sh.wm.ministry.featuers.userfile.userRealty.model.UserRealtyModel;
import com.sh.wm.ministry.featuers.userfile.userRealty.viewModel.RealtyViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;


public class RealtyFragment extends Fragment {

    private FragmentRealtyBinding binding;
    private RealtyViewModel mViewModel;
    private RecyclerView recycler;
    private List<UserRealty> userRealities;


    public RealtyFragment() {
        // Required empty public constructor
    }


    public static RealtyFragment newInstance(String param1, String param2) {
        RealtyFragment fragment = new RealtyFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRealtyBinding.inflate(inflater, container, false);
        recycler = binding.rvRealty;
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(RealtyViewModel.class);
        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available
            //get user realty data from API
            mViewModel.getUserRealty().observe(getViewLifecycleOwner(), (UserRealtyModel userRealtyModel) -> {
                if (userRealtyModel != null && userRealtyModel.getStatus() == 0) {
                    binding.progress.setVisibility(View.GONE);
                    recycler.setVisibility(View.VISIBLE);

                    userRealities = userRealtyModel.getUserRealty();
                    //setup adapter
                    RealtyAdapter realtyAdapter = new RealtyAdapter(getContext(), userRealities);
                    recycler.setAdapter(realtyAdapter);
                } else {
                    binding.progress.setVisibility(View.INVISIBLE);
                    binding.tvNoRealty.setVisibility(View.VISIBLE);
                }


            });
        } else {
            binding.progress.setVisibility(View.GONE);
            binding.tvNoRealty.setText(getString(R.string.no_internet_to_show));
            binding.tvNoRealty.setVisibility(View.VISIBLE);

        }

    }
}