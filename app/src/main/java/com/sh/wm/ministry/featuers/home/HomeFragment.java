package com.sh.wm.ministry.featuers.home;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentHomeBinding;
import com.sh.wm.ministry.featuers.home.model.CertificateRequest;
import com.sh.wm.ministry.featuers.home.viewModel.HomeViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private OnHomeFragmentInteractionListener mListener;
    private OnFragmentInteractionListener mlistener;

    private ShMyDialog dialog;
    private Dialog successDialog;
    Observer<CertificateRequest> certificateRequestObserver;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //enable user interaction when progress is visible
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();





        if (SharedPreferneceHelper.getUserRole(getContext()) == 0) {
            binding.cvVisitsServices.cvWorkerComplaint.setVisibility(View.GONE);
            binding.llLegalProcedures.setVisibility(View.GONE);
        } else {
            binding.cvVisitsServices.cvWorkerComplaint.setVisibility(View.VISIBLE);
            binding.llLegalProcedures.setVisibility(View.VISIBLE);
        }

        //bind main card title
        binding.cvWorkerComplaint.tvTitleHomeCard.setText(getString(R.string.worker_complaint));
        binding.cvRequestCalculateLaborRights.tvTitleHomeCard.setText(getString(R.string.request_calculate_labor_rights));
        binding.cvRequsetRegisterCertification.tvTitleHomeCard.setText(getString(R.string.requset_register_certification));
        binding.cvVisitsServices.tvTitleHomeCard.setText(getString(R.string.facility_services));
        binding.cvBreakdownStatement.tvTitleHomeCard.setText(getString(R.string.breakdown_statement));
        binding.cvHolandTest.tvTitleHomeCard.setText(getString(R.string.holand_test));

        //bind main card icon
        binding.cvWorkerComplaint.ivHomeCard.setImageResource(R.drawable.ic_workers_complaint);
        binding.cvRequestCalculateLaborRights.ivHomeCard.setImageResource(R.drawable.ic_calculate_financial_rights);
        binding.cvRequsetRegisterCertification.ivHomeCard.setImageResource(R.drawable.ic_policy);
        binding.cvVisitsServices.ivHomeCard.setImageResource(R.drawable.ic_visiting_services);
        binding.cvBreakdownStatement.ivHomeCard.setImageResource(R.drawable.ic_breakdown);
        binding.cvHolandTest.ivHomeCard.setImageResource(R.drawable.ic_xmlid_1203_);

        //bind slide card view tint
        binding.cvReportNewWorkPlace.viewAccent.setBackgroundColor(getResources().getColor(R.color.mercury));
        binding.cvLegalAction.viewAccent.setBackgroundColor(getResources().getColor(R.color.mercury));
        binding.cvCreateSeizureReport.viewAccent.setBackgroundColor(getResources().getColor(R.color.mercury));

        //bind facility services card
        binding.btnMoveFacility.tvTitleSlideCardHome.setText(getString(R.string.move_facility));
        binding.cvReportNewWorkPlace.tvTitleSlideCardHome.setText(getString(R.string.report_at_new_work_place));
        binding.cvReportLeftWorkInPlace.tvTitleSlideCardHome.setText(getString(R.string.report_left_work_place));

        //bind facility legal procedures
        binding.cvAlertTemplate.tvTitleSlideCardHome.setText(getString(R.string.alert_template));
        binding.cvCloseFacility.tvTitleSlideCardHome.setText(getString(R.string.close_facility));
        binding.cvLegalAction.tvTitleSlideCardHome.setText(getString(R.string.legal_action));
        binding.cvCreateSeizureReport.tvTitleSlideCardHome.setText(getString(R.string.create_seizure_report));


        binding.cvWorkerComplaint.cvWorkerComplaint.setOnClickListener(view1 -> {
            mListener.onHomeFragmentInteraction(3);
        });

        binding.cvRequestCalculateLaborRights.cvWorkerComplaint.setOnClickListener(view1 -> {
            mListener.onHomeFragmentInteraction(2);
        });


        binding.cvVisitsServices.cvWorkerComplaint.setOnClickListener(view1 -> {
            mListener.onHomeFragmentInteraction(4);
        });

        binding.cvHolandTest.cvWorkerComplaint.setOnClickListener(view1 -> mListener.onHomeFragmentInteraction(5));

        /////////// /////  طلب شهادةالقيج //////////////////////////
        binding.cvRequsetRegisterCertification.cvWorkerComplaint.setOnClickListener(view19 -> {
            if (NetworkUtils.isOnline(getContext()))
            registrationCertificateDialog();
            else
                Toast.makeText(getContext(), getString(R.string.no_internet_to_show), Toast.LENGTH_SHORT).show();
        });
        binding.cvBreakdownStatement.cvWorkerComplaint.setOnClickListener(view20 ->{

            Bundle bundle = new Bundle();
            bundle.putSerializable("type" , "download");
            mlistener.onFragmentInteraction(101,bundle);
        } );

        //
        binding.btnMoveFacility.moveFacilityHomeFragmrnt.setOnClickListener(view12 -> mlistener.onHomeSlideNav(1));
        binding.cvReportNewWorkPlace.moveFacilityHomeFragmrnt.setOnClickListener(view13 -> mlistener.onHomeSlideNav(2));
        binding.cvReportLeftWorkInPlace.moveFacilityHomeFragmrnt.setOnClickListener(view14 -> mlistener.onHomeSlideNav(3));
        //
        binding.cvAlertTemplate.moveFacilityHomeFragmrnt.setOnClickListener(view15 -> mlistener.onHomeSlideNav(4));
        binding.cvLegalAction.moveFacilityHomeFragmrnt.setOnClickListener(view16 -> mlistener.onHomeSlideNav(5));
        binding.cvCloseFacility.moveFacilityHomeFragmrnt.setOnClickListener(view17 -> mlistener.onHomeSlideNav(6));
        binding.cvCreateSeizureReport.moveFacilityHomeFragmrnt.setOnClickListener(view18 -> mlistener.onHomeSlideNav(7));


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeFragmentInteractionListener) {
            mListener = (OnHomeFragmentInteractionListener) context;
            mlistener = (OnFragmentInteractionListener) context;

        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        certificateRequestObserver = new Observer<CertificateRequest>() {
            @Override
            public void onChanged(CertificateRequest certificateRequest) {
                if (certificateRequest != null) {
                    binding.progress.setVisibility(View.GONE);
                    enable(true);
                    Toast.makeText(getActivity(), certificateRequest.getMessageText(), Toast.LENGTH_SHORT).show();
                } else {
                    binding.progress.setVisibility(View.GONE);
                    enable(true);
                }
            }
        };
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public interface OnHomeFragmentInteractionListener {
        void onHomeFragmentInteraction(int cardPos);
    }


    public void registrationCertificateDialog() {

        dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
            @Override
            public void sase(View view) {
                binding.progress.setVisibility(View.VISIBLE);
                enable(false);
                //"12584"
                homeViewModel.requestCertificate(SharedPreferneceHelper.getUserId(getContext())).observe(getViewLifecycleOwner(), certificateRequestObserver);
                dialog.dismiss();
            }

            @Override
            public void edite(View view) {
                dialog.dismiss();
            }
        }, getString(R.string.registration_certificate), getString(R.string.emphasis), getString(R.string.Cancel));
        dialog.show(getParentFragmentManager(), "home Fragment");
    }



    public void enable(boolean status) {
        binding.btnMoveFacility.moveFacilityHomeFragmrnt.setEnabled(status);
        binding.cvReportNewWorkPlace.moveFacilityHomeFragmrnt.setEnabled(status);
        binding.cvReportLeftWorkInPlace.moveFacilityHomeFragmrnt.setEnabled(status);
        binding.cvAlertTemplate.moveFacilityHomeFragmrnt.setEnabled(status);
        binding.cvLegalAction.moveFacilityHomeFragmrnt.setEnabled(status);
        binding.cvCloseFacility.moveFacilityHomeFragmrnt.setEnabled(status);
        binding.cvCreateSeizureReport.moveFacilityHomeFragmrnt.setEnabled(status);

        binding.cvWorkerComplaint.tvTitleHomeCard.setEnabled(status);
        binding.cvRequestCalculateLaborRights.tvTitleHomeCard.setEnabled(status);
        binding.cvRequsetRegisterCertification.tvTitleHomeCard.setEnabled(status);
        binding.cvVisitsServices.tvTitleHomeCard.setEnabled(status);
        binding.cvBreakdownStatement.tvTitleHomeCard.setEnabled(status);

    }






}