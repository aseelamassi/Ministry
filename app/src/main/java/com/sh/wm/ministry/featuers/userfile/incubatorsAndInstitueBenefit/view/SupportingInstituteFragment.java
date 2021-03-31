package com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentSupportingInstituteBinding;
import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.adapter.SupportingInstituteAdapter;
import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.model.SupportingInstitute;
import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.model.SupportingInstituteModel;
import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.viewModel.SupportingInstituteViewModel;

import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;


public class SupportingInstituteFragment extends Fragment {



    private FragmentSupportingInstituteBinding binding ;
    private SupportingInstituteViewModel mViewModel;
    private RecyclerView recycler;
    private List<SupportingInstitute> supportingInstitutes;

    public SupportingInstituteFragment() {
        // Required empty public constructor
    }

    public static SupportingInstituteFragment newInstance() {
        SupportingInstituteFragment fragment = new SupportingInstituteFragment();

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
        binding = FragmentSupportingInstituteBinding.inflate(inflater, container, false);
        recycler = binding.rvSupportingInstitute;
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(SupportingInstituteViewModel.class);
        binding.progress.setVisibility(View.VISIBLE);
        if (NetworkUtils.isOnline(getContext())){//check if the internet is available
            //get user Supporting Institutes data from API
            mViewModel.getSupportingInstitutes().observe(getViewLifecycleOwner(), (SupportingInstituteModel supportingInstituteModel) -> {
                if (supportingInstituteModel != null && supportingInstituteModel.getStatus() == 0) {
                    binding.progress.setVisibility(View.INVISIBLE);
                    recycler.setVisibility(View.VISIBLE);

                    supportingInstitutes = supportingInstituteModel.getUserBenefitingLoans();
                    //setup adapter
                    SupportingInstituteAdapter supportingInstituteAdapter = new SupportingInstituteAdapter(getContext(),supportingInstitutes);
                    recycler.setAdapter(supportingInstituteAdapter);

                }else {
                    binding.progress.setVisibility(View.INVISIBLE);
                    binding.tvNoSupportingInstitutes.setVisibility(View.VISIBLE);
                }


            });

        }else{
            binding.progress.setVisibility(View.GONE);
            binding.tvNoSupportingInstitutes.setVisibility(View.VISIBLE);
            binding.tvNoSupportingInstitutes.setText(getString(R.string.no_internet_to_show));

        }
    }
}