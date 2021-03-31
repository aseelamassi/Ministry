package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentHolandTestMainBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.viewModel.HollandViewModel;
import com.sh.wm.ministry.network.utiels.ApiConstent;

public class HolandTestMainFragment extends Fragment {


    private FragmentHolandTestMainBinding binding;
    private HollandViewModel viewModel;
    private OnFragmentInteractionListener mListener;
    private Bundle bundle;



    public HolandTestMainFragment() {
        // Required empty public constructor
    }


    public static HolandTestMainFragment newInstance() {
        HolandTestMainFragment fragment = new HolandTestMainFragment();

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
        binding = FragmentHolandTestMainBinding.inflate(inflater, container, false);

        //setup viewModel
        viewModel = new ViewModelProvider(this).get(HollandViewModel.class);


        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        enable(false);

        if (this.getArguments() != null) {
            Bundle bundle = this.getArguments();
            if (bundle.getString("status") != null) {
                binding.btnResult.setVisibility(View.GONE);
                binding.tvHasUncompleteTest.setVisibility(View.GONE);
            }

        }
        actions();


        btnListener();

        return binding.getRoot();
    }

    private void btnListener() {
        binding.btnMajorServices.setOnClickListener(view -> {

            mListener.onFragmentInteraction(181, bundle);


        });

        binding.btnDreamCareer.setOnClickListener(view -> {

            mListener.onFragmentInteraction(182);

        });


        binding.btnActivities.setOnClickListener(view -> {

            mListener.onFragmentInteraction(183);

        });

        binding.btnCompetencies.setOnClickListener(view -> {

            mListener.onFragmentInteraction(184);

        });

        binding.btnCareers.setOnClickListener(view -> {

            mListener.onFragmentInteraction(185);

        });


        binding.btnSelfEvaluation.setOnClickListener(view -> {

            mListener.onFragmentInteraction(186);

        });


        binding.btnResult.setOnClickListener(view -> {

            mListener.onFragmentInteraction(187);

        });

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


    private void actions() {

        //get holland test basic info
        viewModel.getHollandBasicTabs().observe(getViewLifecycleOwner(), new Observer<HollandBasicTabsModel>() {
            @Override
            public void onChanged(HollandBasicTabsModel hollandBasicTabsModel) {
                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                if (hollandBasicTabsModel != null) {

                    bundle = new Bundle();

                    bundle.putSerializable("hollandTest", hollandBasicTabsModel);


                    //show the alert that he had uncomplete test dependent on the data returned from API
                    if (hollandBasicTabsModel.getHasUncompletedTest()) {
                        binding.btnResult.setVisibility(View.VISIBLE);
                        binding.tvHasUncompleteTest.setVisibility(View.VISIBLE);
                    } else {
                        binding.btnResult.setVisibility(View.GONE);
                        binding.tvHasUncompleteTest.setVisibility(View.GONE);
                    }


                    if (hollandBasicTabsModel.getHollandTest() !=null){
                        // Save testId
                        SharedPreferences.Editor userEditor = getContext().getSharedPreferences(ApiConstent.TEST_ID, getContext().MODE_PRIVATE).edit();
                        userEditor.putString(ApiConstent.TEST_ID,hollandBasicTabsModel.getHollandTest().getHOLLANDTESTID());
                        userEditor.apply();
                        userEditor.commit();

                    }


                    enable(hollandBasicTabsModel.getHasUncompletedTest());


                }
            }
        });



    }


    private void enable(boolean isEnabled) {

        binding.btnDreamCareer.setEnabled(isEnabled);
        binding.btnActivities.setEnabled(isEnabled);
        binding.btnCompetencies.setEnabled(isEnabled);
        binding.btnCareers.setEnabled(isEnabled);
        binding.btnSelfEvaluation.setEnabled(isEnabled);

        if (isEnabled) {
            binding.btnDreamCareer.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.dark_green));
            binding.btnActivities.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.dark_purple));
            binding.btnCompetencies.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.colorPrimary));
            binding.btnCareers.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.gray));
            binding.btnSelfEvaluation.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.light_purple));
        }
    }


    /**
     * Called when the fragment is no longer in use.  This is called
     * after {@link #onStop()} and before {@link #onDetach()}.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
        viewModel = null;
    }
}