package com.sh.wm.ministry.featuers.userfile.partner.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentPartnerBinding;
import com.sh.wm.ministry.featuers.userfile.partner.adapter.PartnerAdapter;
import com.sh.wm.ministry.featuers.userfile.partner.model.Partner;
import com.sh.wm.ministry.featuers.userfile.partner.model.PartnerModel;
import com.sh.wm.ministry.featuers.userfile.partner.model.UserPartner;
import com.sh.wm.ministry.featuers.userfile.partner.viewModel.PartnerViewModel;
import com.sh.wm.ministry.featuers.userfile.travel.adapter.TravelAdapter;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.viewModel.TravelsViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

import retrofit2.http.PATCH;
import retrofit2.http.Part;

public class PartnerFragment extends Fragment {

    private FragmentPartnerBinding binding;
    private RecyclerView recycler ;
    private PartnerViewModel mViewModel;
    private List<UserPartner> partners;


    public PartnerFragment() {
        // Required empty public constructor
    }


    public static PartnerFragment newInstance() {
        PartnerFragment fragment = new PartnerFragment();

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
        binding =  FragmentPartnerBinding.inflate(inflater, container, false);
        recycler = binding.rvPartner;
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //set up viewModel
        mViewModel = new ViewModelProvider(this).get(PartnerViewModel.class);
        binding.progress.setVisibility(View.VISIBLE);
        if (NetworkUtils.isOnline(getContext())){//check if the internet is available
            //get user partner data from API
            mViewModel.getPartners().observe(getViewLifecycleOwner(), (PartnerModel partnerModel) -> {
                binding.progress.setVisibility(View.GONE);
                if (partnerModel != null &&partnerModel.getStatus() == 0) {

                    recycler.setVisibility(View.VISIBLE);
                    partners = partnerModel.getUserPartners();
                    //setup adapter
                    PartnerAdapter partnerAdapter = new PartnerAdapter(getContext(),partners);
                    recycler.setAdapter(partnerAdapter);
                }else {

                    binding.tvNoPartners.setVisibility(View.VISIBLE);
                }


            });

        }else {
            binding.progress.setVisibility(View.GONE);
            binding.tvNoPartners.setVisibility(View.VISIBLE);
            binding.tvNoPartners.setText(getString(R.string.no_internet_to_show));
        }
    }
}