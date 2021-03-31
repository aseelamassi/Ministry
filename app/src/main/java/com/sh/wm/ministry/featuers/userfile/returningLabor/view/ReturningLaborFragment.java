package com.sh.wm.ministry.featuers.userfile.returningLabor.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentReturningLaborBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.returningLabor.adapter.ReturningLaborAdapter;
import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLabor;
import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLaborModel;
import com.sh.wm.ministry.featuers.userfile.returningLabor.viewModel.ReturningLaborViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReturningLaborFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReturningLaborFragment extends Fragment implements ReturningLaborAdapter.OnEditClickListener {


    private FragmentReturningLaborBinding binding;
    private ReturningLaborViewModel mViewModel;
    private RecyclerView myRecyclerView;
    private OnFragmentInteractionListener mListener;
    private UserFileViewModel userFileViewModel;

    public ReturningLaborFragment() {
        // Required empty public constructor
    }


    public static ReturningLaborFragment newInstance() {
        ReturningLaborFragment fragment = new ReturningLaborFragment();

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
        binding = FragmentReturningLaborBinding.inflate(inflater, container, false);
        binding.LLLayoutReturningLabor.setVisibility(View.INVISIBLE);
        binding.fabAddReturningLabor.setVisibility(View.INVISIBLE);
        myRecyclerView = binding.rvReturningLabor;

        binding.fabAddReturningLabor.setOnClickListener(view -> {
            mListener.onFragmentInteraction(172);
        });
        binding.btnAddReturningLabor.setOnClickListener(view -> {
            mListener.onFragmentInteraction(172);
        });


        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(ReturningLaborViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);

        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available
            mViewModel.getReturningLabor().observe(getViewLifecycleOwner(), (ReturningLaborModel returningLaborModel) -> {
                if (returningLaborModel != null) {
                    if (returningLaborModel.getUserReturningLabor() != null) {
                        binding.progress.setVisibility(View.GONE);

                        //setup adapter
                        List<ReturningLabor> returningLabors = returningLaborModel.getUserReturningLabor();
                        ReturningLaborAdapter adapter = new ReturningLaborAdapter(getContext(), returningLabors, this);
                        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        myRecyclerView.setAdapter(adapter);

                        binding.LLLayoutReturningLabor.setVisibility(View.GONE);
                        binding.fabAddReturningLabor.setVisibility(View.VISIBLE);
                    } else {
                        binding.LLLayoutReturningLabor.setVisibility(View.VISIBLE);
                        binding.fabAddReturningLabor.setVisibility(View.GONE);
                    }
                }
            });

        } else {
            binding.LLLayoutReturningLabor.setVisibility(View.VISIBLE);
            binding.btnAddReturningLabor.setVisibility(View.GONE);
            binding.progress.setVisibility(View.GONE);
            binding.tvNoReturningLabor.setText(getString(R.string.no_internet_to_show));
            binding.tvNoReturningLabor.setVisibility(View.VISIBLE);

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
    public void onEditClick(ReturningLabor returningLabor) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("returningLabor", returningLabor);
        bundle.putString("action", "edit");
        bundle.putString("skill", skill);
        mListener.onFragmentInteraction(172, bundle);
    }

    private String skill;

    @Override
    public void onClick(ReturningLabor returningLabor) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "view");
        bundle.putString("skill", skill);
        bundle.putSerializable("returningLabor", returningLabor);
        mListener.onFragmentInteraction(172, bundle);

    }

    @Override
    public void getConstantName(String constantId, String parentId, TextView tvChange) {

        userFileViewModel.getConstantName(constantId, parentId).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s != null) {
                    skill = s;
                    tvChange.setText(s);
                }
            }
        });
    }

}