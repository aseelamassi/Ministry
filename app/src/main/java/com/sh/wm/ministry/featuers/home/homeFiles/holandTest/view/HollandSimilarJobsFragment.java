package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentHollandSimilarJobsBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.SimilarJobAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.result.HollandResultModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel.HollandViewModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;

public class HollandSimilarJobsFragment extends Fragment {

    private FragmentHollandSimilarJobsBinding binding ;

    private OnFragmentInteractionListener mListener;
    private HollandViewModel viewModel;
    private String testId;
    private Bundle bundle ;

    public HollandSimilarJobsFragment() {
        // Required empty public constructor
    }


    public static HollandSimilarJobsFragment newInstance(String param1, String param2) {
        HollandSimilarJobsFragment fragment = new HollandSimilarJobsFragment();

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
        binding =  FragmentHollandSimilarJobsBinding.inflate(inflater, container, false);


        viewModel = new ViewModelProvider(getActivity()).get(HollandViewModel.class);

        getBundle();


        btnListener();
        return binding.getRoot();
    }



    private void btnListener(){
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction(180);
            }
        });

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction(187,bundle);
            }
        });


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.saveResultModel(testId).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                    @Override
                    public void onChanged(ActionModel actionModel) {
                        if (actionModel != null){
                            Toast.makeText(getContext(), actionModel.getMessage(), Toast.LENGTH_SHORT).show();

                            Bundle bundle = new Bundle();
                            bundle.putString("status" , "0");
                            mListener.onFragmentInteraction(180 ,bundle);
                        }
                    }
                });
            }
        });



    }
    private void getBundle() {
         bundle = this.getArguments();
        if (bundle != null) {
            if ( bundle.getSerializable("hollandTest")!=null) {
                HollandBasicTabsModel hollandBasicTabsModel = (HollandBasicTabsModel) bundle.getSerializable("hollandTest");
                if (hollandBasicTabsModel != null &&hollandBasicTabsModel.getHollandTest() != null)
                    testId = hollandBasicTabsModel.getHollandTest().getHOLLANDTESTID();
            }

            if (bundle.getSerializable("result") != null){

                 HollandResultModel hollandResultModel = (HollandResultModel) bundle.getSerializable("result");
                 binding.tvHighest.setText(hollandResultModel.getMax1());
                 binding.tvSecond.setText(hollandResultModel.getMax2());
                 binding.tvThird.setText(hollandResultModel.getMax3());

                 if (hollandResultModel.getSimilarJobs() != null && hollandResultModel.getSimilarJobs().size() != 0){
                     binding.rvJobListSimilar.setLayoutManager(new LinearLayoutManager(getContext()));
                     binding.rvJobListSimilar.setAdapter(new SimilarJobAdapter(hollandResultModel.getSimilarJobs()));
                 }else{
                     binding.tvJobListSimilarEmpty.setVisibility(View.GONE);
                     binding.tvJobListSimilarEmpty.setText("لا يوجد أي مهن مشابهة");
                 }

                 if (hollandResultModel.getIdenticalJob() != null)
                     binding.tvJobListIdentical.setText(hollandResultModel.getIdenticalJob());


                 




            }

        }
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


}