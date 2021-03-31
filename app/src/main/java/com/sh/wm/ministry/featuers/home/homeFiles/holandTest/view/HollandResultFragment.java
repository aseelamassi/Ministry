package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentHollandResultBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter.SimilarJobAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.result.HollandResultModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.result.Summary;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel.HollandViewModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.ApiConstent;


public class HollandResultFragment extends Fragment {


    private FragmentHollandResultBinding binding;
    private OnFragmentInteractionListener mListener;
    private HollandViewModel viewModel;

    private HollandResultModel  resultModel;

    public HollandResultFragment() {
        // Required empty public constructor
    }


    public static HollandResultFragment newInstance(String param1, String param2) {
        HollandResultFragment fragment = new HollandResultFragment();

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
        binding=  FragmentHollandResultBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(getActivity()).get(HollandViewModel.class);


        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


        getResult();

        btnListener();

        return binding.getRoot();
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



    private void btnListener(){
        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resultModel != null) {


                    mListener.onFragmentInteraction(180);

                }else {
                    Toast.makeText(getContext(), "يجب الانتظار حتي تحميل البيانات", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                mListener.onFragmentInteraction(186 );
            }
        });


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.saveResultModel(SharedPreferneceHelper.getTestId(getContext())).observe(getViewLifecycleOwner(), new Observer<ActionModel>() {
                    @Override
                    public void onChanged(ActionModel actionModel) {
                        if (actionModel != null){
                            Toast.makeText(getContext(), actionModel.getMessage(), Toast.LENGTH_SHORT).show();

                            // Save testId
                            SharedPreferences.Editor userEditor = getContext().getSharedPreferences(ApiConstent.TEST_ID, getContext().MODE_PRIVATE).edit();
                            userEditor.putString(ApiConstent.TEST_ID,"Empty");
                            userEditor.apply();
                            userEditor.commit();

                            Bundle bundle = new Bundle();
                            bundle.putString("status" , "0");

                            mListener.onFragmentInteraction(180 ,bundle);
                        }
                    }
                });
            }
        });

    }


    private void getResult(){
        viewModel.getHollandResult(SharedPreferneceHelper.getTestId(getContext())).observe(getViewLifecycleOwner(), new Observer<HollandResultModel>() {
            @Override
            public void onChanged(HollandResultModel hollandResultModel) {
                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);                if (hollandResultModel != null){
                    resultModel = hollandResultModel;
                    if (hollandResultModel.getSummary() != null){

                        Summary summary = hollandResultModel.getSummary().get(0);
                        binding.cardViewSelfEvaluationPrivate.tvTitle.setText(getString(R.string.evaluation_private_personal_capabilities));
                        binding.cardViewSelfEvaluationPrivate.tv1.setText(summary.getEVAL21() );
                        binding.cardViewSelfEvaluationPrivate.tv2.setText(summary.getEVAL22());
                        binding.cardViewSelfEvaluationPrivate.tv3.setText(summary.getEVAL23());
                        binding.cardViewSelfEvaluationPrivate.tv4.setText(summary.getEVAL24());
                        binding.cardViewSelfEvaluationPrivate.tv5.setText(summary.getEVAL25());
                        binding.cardViewSelfEvaluationPrivate.tv6.setText(summary.getEVAL26());


                        binding.cardViewSelfEvaluationGeneral.tvTitle.setText(getString(R.string.evaluation_general_personal_capabilities));
                        binding.cardViewSelfEvaluationGeneral.tv1.setText(summary.getEVAL11());
                        binding.cardViewSelfEvaluationGeneral.tv2.setText(summary.getEVAL12());
                        binding.cardViewSelfEvaluationGeneral.tv3.setText(summary.getEVAL13());
                        binding.cardViewSelfEvaluationGeneral.tv4.setText(summary.getEVAL14());
                        binding.cardViewSelfEvaluationGeneral.tv5.setText(summary.getEVAL15());
                        binding.cardViewSelfEvaluationGeneral.tv6.setText(summary.getEVAL16());


                        binding.cardViewActivities.tvTitle.setText(getString(R.string.activities));
                        binding.cardViewActivities.tv1.setText(summary.getACTIVITY1());
                        binding.cardViewActivities.tv2.setText(summary.getACTIVITY2());
                        binding.cardViewActivities.tv3.setText(summary.getACTIVITY3());
                        binding.cardViewActivities.tv4.setText(summary.getACTIVITY4());
                        binding.cardViewActivities.tv5.setText(summary.getACTIVITY5());
                        binding.cardViewActivities.tv6.setText(summary.getACTIVITY6());



                        binding.cardViewSkills.tvTitle.setText(getString(R.string.competencies));
                        binding.cardViewSkills.tv1.setText(summary.getSKILL1());
                        binding.cardViewSkills.tv2.setText(summary.getSKILL2());
                        binding.cardViewSkills.tv3.setText(summary.getSKILL3());
                        binding.cardViewSkills.tv4.setText(summary.getSKILL4());
                        binding.cardViewSkills.tv5.setText(summary.getSKILL5());
                        binding.cardViewSkills.tv6.setText(summary.getSKILL6());

                        binding.cardViewJobs.tvTitle.setText(getString(R.string.careers));
                        binding.cardViewJobs.tv1.setText(summary.getJOB1());
                        binding.cardViewJobs.tv2.setText(summary.getJOB2());
                        binding.cardViewJobs.tv3.setText(summary.getJOB3());
                        binding.cardViewJobs.tv4.setText(summary.getJOB4());
                        binding.cardViewJobs.tv5.setText(summary.getJOB5());
                        binding.cardViewJobs.tv6.setText(summary.getJOB6());

                    }

                    binding.cardViewTotal.tvTitle.setText(getString(R.string.total));
                    binding.cardViewTotal.tv1.setText(String.valueOf(hollandResultModel.getSum1()));
                    binding.cardViewTotal.tv2.setText(String.valueOf(hollandResultModel.getSum2()));
                    binding.cardViewTotal.tv3.setText(String.valueOf(hollandResultModel.getSum3()));
                    binding.cardViewTotal.tv4.setText(String.valueOf(hollandResultModel.getSum4()));
                    binding.cardViewTotal.tv5.setText(String.valueOf(hollandResultModel.getSum5()));
                    binding.cardViewTotal.tv6.setText(String.valueOf(hollandResultModel.getSum6()));


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
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
        viewModel = null;
    }


}