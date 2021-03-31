package com.sh.wm.ministry.featuers.userfile.educationalstatus.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentEducationalStatusBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.adapter.EducationalStatusAdapter;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.model.UserEducationalStatus;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.viewmodel.EducationalStatusViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

public class EducationalStatusFragment extends Fragment implements EducationalStatusAdapter.OnEditClickListener {

    private EducationalStatusViewModel mViewModel;
    private FragmentEducationalStatusBinding binding;
    private MaterialButton addButton;
    private TextView title;
    private FloatingActionButton fab;
    private RecyclerView recycler;
    private List<UserEducationalStatus> userEducationalStatus;
    private OnFragmentInteractionListener mListener;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentEducationalStatusBinding.inflate(inflater, container, false);

        addButton = binding.btnAddEductionalstatus;
        title = binding.tvNoEductionalstatus;
        fab = binding.fabAddNewEductionalstatus;
        recycler = binding.rvEductionalstatus;

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EducationalStatusViewModel.class);

        if (NetworkUtils.isOnline(getContext())){
            mViewModel.getEducationalStatusModel().observe(getViewLifecycleOwner(), educationalStatusModel -> { if (educationalStatusModel != null && educationalStatusModel.getStatus() == 0) {
                    binding.progress.setVisibility(View.GONE);
                    recycler.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.VISIBLE);
                    binding.llNoDataContainer.setVisibility(View.GONE);
                    userEducationalStatus = educationalStatusModel.getUserEducationalStatus();
                    EducationalStatusAdapter adapter = new EducationalStatusAdapter(userEducationalStatus , this);
                    recycler.setAdapter(adapter);
                }else {
                    binding.llNoDataContainer.setVisibility(View.VISIBLE);
                    binding.progress.setVisibility(View.GONE);
                }
                addButton.setOnClickListener(view -> {
                    mListener.onFragmentInteraction(51);
                });
                fab.setOnClickListener(view -> {
                    mListener.onFragmentInteraction(51);
                });
            });

        }else {
            binding.llNoDataContainer.setVisibility(View.VISIBLE);
            binding.progress.setVisibility(View.GONE);
            binding.btnAddEductionalstatus.setVisibility(View.GONE);
            binding.tvNoEductionalstatus.setVisibility(View.VISIBLE);


            binding.tvNoEductionalstatus.setText(R.string.no_internet_to_show);
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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onEditClick(UserEducationalStatus userEducationalStatus) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("eduStatus"  , userEducationalStatus);
        mListener.onFragmentInteraction(51,bundle);
    }

    @Override
    public void onClick(UserEducationalStatus userEducationalStatus) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("eduStatus"  , userEducationalStatus);
        bundle.putString("type"  , "view");
        mListener.onFragmentInteraction(51,bundle);

    }
}