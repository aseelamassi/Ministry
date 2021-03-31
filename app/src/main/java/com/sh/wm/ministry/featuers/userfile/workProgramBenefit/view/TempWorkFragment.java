package com.sh.wm.ministry.featuers.userfile.workProgramBenefit.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentTempWorkBinding;
import com.sh.wm.ministry.featuers.userfile.workProgramBenefit.adapter.TempWorkAdapter;
import com.sh.wm.ministry.featuers.userfile.workProgramBenefit.model.TempWork;
import com.sh.wm.ministry.featuers.userfile.workProgramBenefit.model.TempWorkModel;
import com.sh.wm.ministry.featuers.userfile.workProgramBenefit.viewModel.TempWorkViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;


public class TempWorkFragment extends Fragment {

    FragmentTempWorkBinding binding;

    private TempWorkViewModel mViewModel;
    private RecyclerView recycler;
    private List<TempWork> tempWorks;


    public TempWorkFragment() {
        // Required empty public constructor
    }


    public static TempWorkFragment newInstance() {
        TempWorkFragment fragment = new TempWorkFragment();

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
        binding = FragmentTempWorkBinding.inflate(inflater, container, false);
        recycler = binding.rvTempWork;
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(TempWorkViewModel.class);
        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available
            //get userTemp work data
            mViewModel.getTempWorks().observe(getViewLifecycleOwner(), (TempWorkModel tempWorkModel) -> {
                if (tempWorkModel != null && tempWorkModel.getStatus() == 0) {
                    binding.tvNoTempWork.setVisibility(View.INVISIBLE);
                    binding.progress.setVisibility(View.INVISIBLE);
                    recycler.setVisibility(View.VISIBLE);

                    tempWorks = tempWorkModel.getTempWork();
                    //setup adapter
                    TempWorkAdapter tempWorkAdapter = new TempWorkAdapter(getContext(), tempWorks);
                    recycler.setAdapter(tempWorkAdapter);
                } else {
                    binding.progress.setVisibility(View.INVISIBLE);
                    binding.tvNoTempWork.setVisibility(View.VISIBLE);
                }


            });
        } else {
            binding.tvNoTempWork.setVisibility(View.VISIBLE);

            binding.progress.setVisibility(View.GONE);
            binding.tvNoTempWork.setText(getString(R.string.no_internet_to_show));
        }

    }

}