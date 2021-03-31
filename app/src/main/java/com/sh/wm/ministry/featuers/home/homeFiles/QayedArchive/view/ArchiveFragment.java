package com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.adapter.CardAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveCard;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveModel;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.UserQayedArchive;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.viewModel.ArchiveViewModel;
import com.sh.wm.ministry.featuers.userfile.travel.adapter.TravelAdapter;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.viewModel.TravelsViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArchiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArchiveFragment extends Fragment {
    private com.sh.wm.ministry.databinding.FragmentArchiveBinding binding ;
    private List<ArchiveCard> cards;
    private ArchiveViewModel viewModel;
    Observer<ArchiveModel> observer;
    CardAdapter adapter ;
    private RecyclerView recycler;

    public ArchiveFragment() {
        // Required empty public constructor
    }

    public static ArchiveFragment newInstance(String param1, String param2) {
        ArchiveFragment fragment = new ArchiveFragment();

        return fragment;
    }//end newInstance

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }//end onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = com.sh.wm.ministry.databinding.FragmentArchiveBinding.inflate(inflater, container, false);
        ///////////////////////////////////////////
        //////////////////////////////set id for request from shared preferences
        //////////"831504"
        recycler = binding.qayedArchive;
        return binding.getRoot();
    }//end onCreateView

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }//END onViewCreated


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ArchiveViewModel.class);
        if (NetworkUtils.isOnline(getContext())){
        viewModel.archiveRequest().observe(getViewLifecycleOwner(), (ArchiveModel archiveModel) -> {
            if (archiveModel.getStatus() == 0) {
                binding.progress.setVisibility(View.INVISIBLE);
                recycler.setVisibility(View.VISIBLE);

                cards = new ArrayList<>();
                List<UserQayedArchive> archive = archiveModel.getUserQayedArchive();
                for (UserQayedArchive request : archive) {
                    ArchiveCard card = new ArchiveCard();
                    card.setQayedDate(request.getQAYEDDATE());
                    card.setWorkStatusDesc(request.getWORKSTATUSDESC());
                    card.setWorkStatusDescDesc(request.getWORKSTATUSDESCDESC());
                    card.setStatus(request.getSTATUS());
                    cards.add(card);
                }
                adapter = new CardAdapter();
                adapter.setCards(cards);
                recycler.setAdapter(adapter);
            } else {
                binding.progress.setVisibility(View.INVISIBLE);
                binding.arcNoCards.setVisibility(View.VISIBLE);
            }



        });}else {
            binding.progress.setVisibility(View.INVISIBLE);
            binding.arcNoCards.setVisibility(View.VISIBLE);
            binding.arcNoCards.setText(getString(R.string.no_internet_to_show));
        }
    }



}