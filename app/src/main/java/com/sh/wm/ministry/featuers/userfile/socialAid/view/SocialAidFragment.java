package com.sh.wm.ministry.featuers.userfile.socialAid.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentSocialAidBinding;
import com.sh.wm.ministry.featuers.userfile.socialAid.adapter.SocialAidAdapter;
import com.sh.wm.ministry.featuers.userfile.socialAid.model.SocialAid;
import com.sh.wm.ministry.featuers.userfile.socialAid.model.SocialAidModel;
import com.sh.wm.ministry.featuers.userfile.socialAid.viewModel.SocialAidViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SocialAidFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SocialAidFragment extends Fragment {

    private FragmentSocialAidBinding binding;
    private SocialAidViewModel mViewModel;
    private RecyclerView recycler;
    private List<SocialAid> socialAids;

    public SocialAidFragment() {
        // Required empty public constructor
    }


    public static SocialAidFragment newInstance() {
        SocialAidFragment fragment = new SocialAidFragment();

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
        binding = FragmentSocialAidBinding.inflate(inflater, container, false);
        recycler = binding.rvSocialAid;
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(SocialAidViewModel.class);

        if (NetworkUtils.isOnline(getContext())) {//check if the internet is available
            //get user social aid
            mViewModel.getSocialAid().observe(getViewLifecycleOwner(), (SocialAidModel socialAidModel) -> {
                if (socialAidModel!= null && socialAidModel.getStatus() == 0) {
                    binding.progress.setVisibility(View.GONE);
                    recycler.setVisibility(View.VISIBLE);

                    socialAids = socialAidModel.getUserRealty();
                    //setup adapter
                    SocialAidAdapter socialAidAdapter = new SocialAidAdapter(getContext(), socialAids);
                    recycler.setAdapter(socialAidAdapter);
                } else {
                    binding.progress.setVisibility(View.INVISIBLE);
                    binding.tvNoSocialAid.setVisibility(View.VISIBLE);
                }


            });
        } else {

            binding.tvNoSocialAid.setVisibility(View.VISIBLE);
            binding.progress.setVisibility(View.GONE);
            binding.tvNoSocialAid.setText(getString(R.string.no_internet_to_show));
        }
    }
}