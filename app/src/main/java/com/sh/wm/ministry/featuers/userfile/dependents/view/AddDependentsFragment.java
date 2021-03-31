package com.sh.wm.ministry.featuers.userfile.dependents.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ConfirmDialog;
import com.sh.wm.ministry.databinding.FragmentAddDependentsBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependent;
import com.sh.wm.ministry.featuers.userfile.dependents.viewmodel.AddDependentsViewModel;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.List;

public class AddDependentsFragment extends Fragment implements ConfirmDialog.Listener {

    private FragmentAddDependentsBinding binding;
    private AddDependentsViewModel mViewModel;

    private UserFileViewModel userFileViewModel;
    private ConfirmDialog confirmDialog;
    private MaterialButton saveButton;
    private OnFragmentInteractionListener mListener;


    public static AddDependentsFragment newInstance() {
        return new AddDependentsFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAddDependentsBinding.inflate(inflater, container, false);
        saveButton = binding.btnSaveNewDependents;
        confirmDialog = new ConfirmDialog(this, getContext(), "");
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddDependentsViewModel.class);
        userFileViewModel = new ViewModelProvider(this).get(UserFileViewModel.class);

        binding.btnSaveNewDependents.setVisibility(View.GONE);

        getBundle();

        saveButton.setOnClickListener(view -> {
            if (!binding.etDependentSn.getText().toString().isEmpty())
                confirmDialog.presentForList(getString(R.string.do_want_to_add_new_dependents));

        });


        binding.btnGetDependentData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnSaveNewDependents.setEnabled(false);

                if (binding.etDependentSn.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), getString(R.string.dependent_empty), Toast.LENGTH_SHORT).show();
                } else {

                    binding.progress.setVisibility(View.VISIBLE);
                    binding.btnSaveNewDependents.setVisibility(View.VISIBLE);
                    //disable user interaction when progress is visible
                    getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                    //get dependent data and see if he is accepted or not
                    mViewModel.getDependentData(SharedPreferneceHelper.getUserSn(getContext()), binding.etDependentSn.getText().toString()).observe(getViewLifecycleOwner(), dependentModel -> {
                        //enable the search button after get the response
                        binding.btnGetDependentData.setEnabled(true);
                        binding.progress.setVisibility(View.GONE);
                        //enable user interaction when progress is visible
                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        if (dependentModel != null) {
                            if (dependentModel.getDependentData() != null) {

                                //display data in the view

                                binding.etFirstName.setText(dependentModel.getDependentData().get(0).getFNAMEARB());
                                binding.etSecondName.setText(dependentModel.getDependentData().get(0).getSNAMEARB());
                                binding.etThirdName.setText(dependentModel.getDependentData().get(0).getTNAMEARB());
                                binding.etFamilyName.setText(dependentModel.getDependentData().get(0).getLNAMEARB());
                                binding.tvBirthDateDependents.setText(dependentModel.getDependentData().get(0).getUSERDEPBIRTHDATE());


                                //get the arabic name of relationship using returned id
                                getConstant("145", dependentModel.getDependentData().get(0).getUSERDEPRELATIONSHIP());

                                if (!dependentModel.getAccepted())//show the reason if the dependent not accepted
                                    Toast.makeText(getContext(), dependentModel.getMsg(), Toast.LENGTH_LONG).show();


                                //Toast.makeText(getContext(), dependentModel.getMessageText(), Toast.LENGTH_LONG).show();

                                //enable and disable add dependent depends on  the acceptance of the  dependent
                                binding.btnSaveNewDependents.setEnabled(dependentModel.getAccepted());
                            }
                        }

                    });
                }

            }
        });

        binding.etDependentSn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //when any change in dependent sn is should to empty all fields
                emptyField();
                if (binding.etDependentSn.getText().toString().length() == 0) {
                    binding.btnSaveNewDependents.setVisibility(View.GONE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    private void emptyField(){
        binding.btnGetDependentData.setEnabled(true);
        binding.etFirstName.setText("");
        binding.etSecondName.setText("");
        binding.etThirdName.setText("");
        binding.etFamilyName.setText("");
        binding.etRelationShip.setText("");
        binding.etRelationShip.setText("");
        binding.tvBirthDateDependents.setText("");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onOk() {
        binding.progress.setVisibility(View.VISIBLE);
        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        mViewModel.addDependent(binding.etDependentSn.getText().toString()).observe(getViewLifecycleOwner(),userWorkerInsertModel -> {

            binding.progress.setVisibility(View.GONE);
            //enable user interaction when progress is visible
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

            if (userWorkerInsertModel != null ){
                Toast.makeText(getContext(), userWorkerInsertModel.getMessageText(), Toast.LENGTH_SHORT).show();
                if (userWorkerInsertModel.isAccepted())
                    mListener.onFragmentInteraction(40);

            }


        });

    }

    @Override
    public void onCancel() {


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


    public void getConstant(String parentId, int id) {
        userFileViewModel.getConstant(parentId).observe(getViewLifecycleOwner(), new Observer<List<Constants>>() {
            @Override
            public void onChanged(List<Constants> constants) {
                if (constants != null) {
                    for (Constants constant : constants)
                        if (constant.getCONSTANTID().equals(String.valueOf(id)))
                            binding.etRelationShip.setText(constant.getCONSTANTARANAME());

                } else {
                    Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getBundle() {
        //setup data from bundle
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            UserDependent userDependent = (UserDependent) bundle.getSerializable("dependent");
            binding.btnSaveNewDependents.setVisibility(View.GONE);

            String[] parts = userDependent.getUSERDEPFULLNAME().split(" ");
            binding.etFirstName.setText(parts[0]);
            binding.etSecondName.setText(parts[1]);
            binding.etThirdName.setText(parts[2]);
            binding.etFamilyName.setText(parts[3]);
            binding.etDependentSn.setText(userDependent.getUSERDEPDOCUMENTID());
            binding.etRelationShip.setText(userDependent.getRELATIONSHIP());
            binding.tvBirthDateDependents.setText(userDependent.getDEPBIRTHDATE());
            binding.etJob.setText(userDependent.getUSERDEPWORKID());


        }
    }




}

