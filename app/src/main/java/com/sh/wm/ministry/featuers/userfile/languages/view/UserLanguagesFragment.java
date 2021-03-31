package com.sh.wm.ministry.featuers.userfile.languages.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentUserLanguagesBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.languages.adapter.UserLanguagesAdapter;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguage;
import com.sh.wm.ministry.featuers.userfile.languages.viewmodel.UserLanguagesViewModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

public class UserLanguagesFragment extends Fragment implements UserLanguagesAdapter.OnEditClickListener {

    private UserLanguagesViewModel mViewModel;
    private FragmentUserLanguagesBinding binding;
    private RecyclerView myRecyclerView;
    private OnFragmentInteractionListener mListener;

    public static UserLanguagesFragment newInstance() {
        return new UserLanguagesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentUserLanguagesBinding.inflate(inflater, container, false);

        binding.LLLayoutUserLanguages.setVisibility(View.INVISIBLE);
        binding.fabAddLanguagesUserLanguages.setVisibility(View.INVISIBLE);
        myRecyclerView = binding.rvLanguagesUserLanguages;

        binding.fabAddLanguagesUserLanguages.setOnClickListener(view -> {
            mListener.onFragmentInteraction(91);
        });
        binding.btnAddLanguagesUserLanguages.setOnClickListener(view -> {
            mListener.onFragmentInteraction(91);
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(UserLanguagesViewModel.class);

        if (NetworkUtils.isOnline(getContext())){//check if the internet is available
            //get user language data from API
            mViewModel.getUserLanguages().observe(getViewLifecycleOwner(), userLanguagesModel -> {
                if (userLanguagesModel != null ) {
                    binding.progress.setVisibility(View.INVISIBLE);
                    if (userLanguagesModel.getUserLanguage() != null) {

                        //setup adapter
                        List<UserLanguage> userLanguage = userLanguagesModel.getUserLanguage();
                        UserLanguagesAdapter adapter= new UserLanguagesAdapter(userLanguage, this);

                        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        myRecyclerView.setAdapter(adapter);
                        binding.LLLayoutUserLanguages.setVisibility(View.GONE);
                        binding.fabAddLanguagesUserLanguages.setVisibility(View.VISIBLE);
                    } else {
                        binding.LLLayoutUserLanguages.setVisibility(View.VISIBLE);
                        binding.fabAddLanguagesUserLanguages.setVisibility(View.GONE);
                    }
                }else {
                    binding.progress.setVisibility(View.INVISIBLE);
                }
            });

        }else{
            binding.LLLayoutUserLanguages.setVisibility(View.VISIBLE);
            binding.progress.setVisibility(View.GONE);
            binding.btnAddLanguagesUserLanguages.setVisibility(View.GONE);
            binding.tvNoLanguagesUserLanguages.setVisibility(View.VISIBLE);
            binding.tvNoLanguagesUserLanguages.setText(getString(R.string.no_internet_to_show));
        }
    }

    @Override
    public void onEditClick(UserLanguage userLanguage) {
        //send language data when click on edit icon
        Bundle bundle=new Bundle();
        bundle.putString("language",userLanguage.getLANGUAGENAME());
        bundle.putString("user_lang_Id" , userLanguage.getUSERLANGID());
        bundle.putString("speaking_skill",userLanguage.getUSERLANGCONVERSATIONPER());
        bundle.putString("writing_skill",userLanguage.getUSERLANGWRITEPERCENTAGE());
        bundle.putString("reading_skill",userLanguage.getUSERLANGREADPERCENTAGE());
        bundle.putString("lang_id" ,userLanguage.getUSERLANGLANGID());
        bundle.putString("read_id" ,userLanguage.getUSERLANGREADPERCENTAGEID());
        bundle.putString("write_id" ,userLanguage.getUSERLANGWRITEPERCENTAGEID());
        bundle.putString("speak_id" ,userLanguage.getUSERLANGCONVERSATIONPERID());
        mListener.onFragmentInteraction(92,bundle);
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
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        binding=null;
    }
}