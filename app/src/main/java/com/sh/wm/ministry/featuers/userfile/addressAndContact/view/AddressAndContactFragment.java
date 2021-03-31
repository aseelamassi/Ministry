package com.sh.wm.ministry.featuers.userfile.addressAndContact.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.ToastMsg;
import com.sh.wm.ministry.databinding.FragmentAddressAndContactBinding;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.model.userworkcontact.UserWorkContact;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.viewmodel.AddressAndContactViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddressAndContactFragment extends Fragment {

    private AddressAndContactViewModel mViewModel;
    private FragmentAddressAndContactBinding binding;
    private ShMyDialog dialog;

    private String  eBuilding = "", eMobileNum = "", eFacebookUrl = "", eAddressDetails = "", state, city, distinct, street, nearestPlace, building, telephone, mobile, mobile2, email, facebook, addressDetails;

    public static AddressAndContactFragment newInstance() {
        return new AddressAndContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddressAndContactBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.progress.setVisibility(View.VISIBLE);
        //disable user interaction when progress is visible
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        binding.btnSaveAddressContacts.setEnabled(false);

        //setup viewModel
        mViewModel = new ViewModelProvider(this).get(AddressAndContactViewModel.class);



        //getting user contact and address data from API
        mViewModel.userWorkContactLiveData(SharedPreferneceHelper.getUserId(getContext())).observe(getViewLifecycleOwner(), userWorkContactModel -> {

            if (userWorkContactModel != null) {
                UserWorkContact contactModel = userWorkContactModel.getUserWorkContact();

                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                binding.btnSaveAddressContacts.setEnabled(true);
                state = contactModel.getUSERADDRESSDESC();
                city = contactModel.getUSERCITYDESC();
                distinct = contactModel.getUSERREGIONDESC();
                street = contactModel.getUSERSTREETDESC();
                nearestPlace = contactModel.getUSERADDRESSDETAILS();
                building = contactModel.getUSERBUILDINGDESC();
                telephone = contactModel.getUSERTELEPHONE();
                mobile = contactModel.getUSERMOBILE1();

                mobile2 = contactModel.getUSERMOBILE2();
                email = contactModel.getUSEREMAIL();
                facebook = contactModel.getUSERFACEBOOKURL();
                addressDetails = contactModel.getUSERADDRESSDESCENTRY();


                //display user data
                binding.etStateAddressContact.setText(state);
                binding.etCityAddressContact.setText(city);
                binding.etDistrictAddressContact.setText(distinct);
                binding.etStreetAddressContact.setText(street);

                binding.etNearestPlaceAddressContact.setText(nearestPlace);
                if (building != null)
                    binding.etBuildingAddressContact.setText(building);
                binding.etPhoneAddressContact.setText(telephone);
                if (mobile2 != null)
                    binding.etFirstGradeMobileAddressContact.setText(mobile2);
                binding.etMobileAddressContact.setText(mobile);
                binding.etEmailAddressContact.setText(email);
                if (facebook != null)
                    binding.etFacebookAddressContact.setText(facebook);
                if (addressDetails != null)
                    binding.etAddressDetailsAddressContact.setText(addressDetails);

            } else {
                new ToastMsg(getContext()).toastIconError(getString(R.string.proccess_failed));
                binding.progress.setVisibility(View.GONE);
                //enable user interaction when progress is visible
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


                binding.btnSaveAddressContacts.setEnabled(true);
            }
        });

        binding.btnSaveAddressContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!binding.etBuildingAddressContact.getText().toString().equals("-"))
                    eBuilding = binding.etBuildingAddressContact.getText().toString();
                if (!binding.etFirstGradeMobileAddressContact.getText().toString().equals("-"))
                    eMobileNum = binding.etFirstGradeMobileAddressContact.getText().toString();
                if (!binding.etFacebookAddressContact.getText().toString().equals("-"))
                    eFacebookUrl = binding.etFacebookAddressContact.getText().toString();
                if (!binding.etAddressDetailsAddressContact.getText().toString().equals("-"))
                    eAddressDetails = binding.etAddressDetailsAddressContact.getText().toString();


                if ((eBuilding.equals(building) || binding.etBuildingAddressContact.getText().toString().equals("-")) && (eMobileNum.equals(mobile2) || binding.etFirstGradeMobileAddressContact.getText().toString().equals("-")) && (eFacebookUrl.equals(facebook) || binding.etFacebookAddressContact.getText().toString().equals("-")) && (eAddressDetails.equals(addressDetails) || binding.etAddressDetailsAddressContact.getText().toString().equals("-")))
                    Toast.makeText(getContext(), getString(R.string.edit_field), Toast.LENGTH_LONG).show();
                else {

                    dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                        @Override
                        public void sase(View view) {
                            dialog.dismiss();
                            if (!eFacebookUrl.equals("-") && !eFacebookUrl.isEmpty()) {
                                //Check the facebook url is true or not
                                Pattern mPattern = Pattern.compile("(?:(?:http|https):\\/\\/)?(?:www.)?facebook.com\\/(?:(?:\\w)*#!\\/)?(?:pages\\/)?(?:[?\\w\\-]*\\/)?(?:profile.php\\?id=(?=\\d.*))?([\\w\\-]*)?");
                                Matcher matcher = mPattern.matcher(eFacebookUrl);
                                if (matcher.matches()) { // if the facebook url is true update the data
                                    binding.progress.setVisibility(View.VISIBLE);
                                    //disable user interaction when progress is visible
                                    getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                                    mViewModel.updateUser(telephone, mobile, eMobileNum, eFacebookUrl, eAddressDetails, eBuilding, nearestPlace).observe(getViewLifecycleOwner(), (ActionModel updateUser) -> {
                                        binding.progress.setVisibility(View.GONE);
                                        //enable user interaction when progress is visible
                                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                        if (updateUser != null)
                                            Toast.makeText(getContext(), updateUser.getMessage(), Toast.LENGTH_SHORT).show();
                                    });
                                }
                                else
                                    Toast.makeText(getContext(), getString(R.string.facebook_error), Toast.LENGTH_LONG).show();

                            } else {
                                binding.progress.setVisibility(View.VISIBLE);
                                //disable user interaction when progress is visible
                                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                mViewModel.updateUser(telephone, mobile, eMobileNum, eFacebookUrl, eAddressDetails, eBuilding, nearestPlace).observe(getViewLifecycleOwner(), updateUser -> {
                                    binding.progress.setVisibility(View.GONE);
                                    //enable user interaction when progress is visible
                                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    if (updateUser != null)
                                        Toast.makeText(getContext(), updateUser.getMessage(), Toast.LENGTH_LONG).show();
                                });

                            }
                        }

                        @Override
                        public void edite(View view) {
                            dialog.dismiss();
                        }
                    }, getString(R.string.confirm_address_update), getString(R.string.save), getString(R.string.cancel));

                    dialog.show(getParentFragmentManager(), "tag");


                }
            }

        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}