package com.sh.wm.ministry.featuers.userfile.trainingprograms.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentTrainingProgramsBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.languages.adapter.UserLanguagesAdapter;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguage;
import com.sh.wm.ministry.featuers.userfile.languages.viewmodel.UserLanguagesViewModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.TrainingProgramsAdapter;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.UserTrainingProgram;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.viewmodel.TrainingProgramsViewModel;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;


public class TrainingProgramsFragment extends Fragment implements TrainingProgramsAdapter.OnEditClickListener {

    private FragmentTrainingProgramsBinding binding;
    private TrainingProgramsViewModel mViewModel ;
    private UserFileViewModel viewModel ;
    private RecyclerView myRecyclerView;
    private OnFragmentInteractionListener mListener;
    private String trainEntity ;




    public TrainingProgramsFragment() {
        // Required empty public constructor
    }

    public static TrainingProgramsFragment newInstance(){return new TrainingProgramsFragment();}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTrainingProgramsBinding.inflate(inflater, container, false);
        binding.LLLayoutUserLanguages.setVisibility(View.INVISIBLE);
        binding.fabAddTrainingPrograms.setVisibility(View.INVISIBLE);
        myRecyclerView = binding.rvTrainingPrograms;

        binding.fabAddTrainingPrograms.setOnClickListener(view -> {

            AddTrainingProgramsFragment addTrainingProgramsFragment = new AddTrainingProgramsFragment();
             mListener.onFragmentInteraction(61);
        });
        binding.btnAddTrainingPrograms.setOnClickListener(view -> {
            mListener.onFragmentInteraction(61);
        });



        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(TrainingProgramsViewModel.class);
        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);

        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available
            //get training program data from API
            mViewModel.getTrainingPrograms().observe(getViewLifecycleOwner(), trainingProgramsModel -> {
                if (trainingProgramsModel != null) {
                    binding.progress.setVisibility(View.GONE);
                    if (trainingProgramsModel.getUserTrainingPrograms() != null) {
                        //setup adapter
                        List<UserTrainingProgram> trainingPrograms = trainingProgramsModel.getUserTrainingPrograms();
                        TrainingProgramsAdapter adapter = new TrainingProgramsAdapter(trainingPrograms, this);
                        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        myRecyclerView.setAdapter(adapter);
                        binding.LLLayoutUserLanguages.setVisibility(View.GONE);
                        binding.fabAddTrainingPrograms.setVisibility(View.VISIBLE);
                    } else {
                        binding.LLLayoutUserLanguages.setVisibility(View.VISIBLE);
                        binding.fabAddTrainingPrograms.setVisibility(View.GONE);
                        binding.progress.setVisibility(View.GONE);
                    }
                }
            });
        }else {
            binding.tvNoTrainingPrograms.setVisibility(View.VISIBLE);
            binding.LLLayoutUserLanguages.setVisibility(View.VISIBLE);
            binding.progress.setVisibility(View.GONE);
            binding.btnAddTrainingPrograms.setVisibility(View.GONE);
            binding.tvNoTrainingPrograms.setText(getString(R.string.no_internet_to_show));
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


    @Override
    public void onEditClick(UserTrainingProgram trainingProgram) {
        Bundle bundle=new Bundle();
        trainingProgram.setTRAINENTITY(trainEntity);
        bundle.putSerializable("trainingProgram" , trainingProgram);
        bundle.putString("type" , "edit");
        mListener.onFragmentInteraction(61,bundle);




    }

    @Override
    public void onClick(UserTrainingProgram trainingProgram) {
        Bundle bundle=new Bundle();
        trainingProgram.setTRAINENTITY(trainEntity);
        bundle.putSerializable("trainingProgram" , trainingProgram);

        bundle.putString("type", "view");
        mListener.onFragmentInteraction(61,bundle);
    }

    @Override
    public void getConstantName(String trainEntityId , TextView textView) {
        MutableLiveData<String> name = new MutableLiveData<>();
        viewModel.getConstantName(trainEntityId, "140").observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s != null) {
                    textView.setText(s);
                    trainEntity = s ;

                }
            }
        });
    }


}