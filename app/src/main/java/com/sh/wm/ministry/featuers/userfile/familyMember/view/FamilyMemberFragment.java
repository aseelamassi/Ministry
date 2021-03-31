package com.sh.wm.ministry.featuers.userfile.familyMember.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentFamilyMemberBinding;
import com.sh.wm.ministry.featuers.userfile.familyMember.adapter.FamilyMemberAdapter;
import com.sh.wm.ministry.featuers.userfile.familyMember.model.UserFamily;
import com.sh.wm.ministry.featuers.userfile.familyMember.model.UserFamilyModel;
import com.sh.wm.ministry.featuers.userfile.familyMember.viewModel.FamilyMemberViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;


public class FamilyMemberFragment extends Fragment {

    FragmentFamilyMemberBinding binding;
    private FamilyMemberViewModel mViewModel;
    private RecyclerView recycler;
    private List<UserFamily> userFamilies;


    public FamilyMemberFragment() {
        // Required empty public constructor
    }

    public static FamilyMemberFragment newInstance(String param1, String param2) {
        FamilyMemberFragment fragment = new FamilyMemberFragment();

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

        binding = FragmentFamilyMemberBinding.inflate(inflater, container, false);
        recycler = binding.rvFamilyMembers;
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(FamilyMemberViewModel.class);

        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available
            //get user family data
            mViewModel.getUserFamilyMember().observe(getViewLifecycleOwner(), (UserFamilyModel userFamilyModel) -> {
                binding.progress.setVisibility(View.INVISIBLE);
                if (userFamilyModel != null && userFamilyModel.getStatus() == 0) {
                    recycler.setVisibility(View.VISIBLE);

                    userFamilies = userFamilyModel.getUserFamily();
                    //setup adapter
                    FamilyMemberAdapter familyMemberAdapter = new FamilyMemberAdapter(getContext(), userFamilies);
                    recycler.setAdapter(familyMemberAdapter);
                } else {
                    binding.tvNoFamilyMembers.setVisibility(View.VISIBLE);
                }


            });

        } else {
            binding.tvNoFamilyMembers.setText(getString(R.string.no_internet_to_show));
            binding.tvNoFamilyMembers.setVisibility(View.VISIBLE);
            binding.progress.setVisibility(View.GONE);
        }
    }

}