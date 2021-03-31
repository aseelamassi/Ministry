// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddressAndContactBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final MaterialButton btnSaveAddressContacts;

  @NonNull
  public final TextInputEditText etAddressDetailsAddressContact;

  @NonNull
  public final TextInputEditText etBuildingAddressContact;

  @NonNull
  public final TextView etCityAddressContact;

  @NonNull
  public final TextView etDistrictAddressContact;

  @NonNull
  public final TextView etEmailAddressContact;

  @NonNull
  public final TextInputEditText etFacebookAddressContact;

  @NonNull
  public final TextInputEditText etFirstGradeMobileAddressContact;

  @NonNull
  public final TextInputEditText etMobileAddressContact;

  @NonNull
  public final TextView etNearestPlaceAddressContact;

  @NonNull
  public final TextView etPhoneAddressContact;

  @NonNull
  public final TextView etStateAddressContact;

  @NonNull
  public final TextView etStreetAddressContact;

  @NonNull
  public final ProgressBar progress;

  private FragmentAddressAndContactBinding(@NonNull FrameLayout rootView,
      @NonNull MaterialButton btnSaveAddressContacts,
      @NonNull TextInputEditText etAddressDetailsAddressContact,
      @NonNull TextInputEditText etBuildingAddressContact, @NonNull TextView etCityAddressContact,
      @NonNull TextView etDistrictAddressContact, @NonNull TextView etEmailAddressContact,
      @NonNull TextInputEditText etFacebookAddressContact,
      @NonNull TextInputEditText etFirstGradeMobileAddressContact,
      @NonNull TextInputEditText etMobileAddressContact,
      @NonNull TextView etNearestPlaceAddressContact, @NonNull TextView etPhoneAddressContact,
      @NonNull TextView etStateAddressContact, @NonNull TextView etStreetAddressContact,
      @NonNull ProgressBar progress) {
    this.rootView = rootView;
    this.btnSaveAddressContacts = btnSaveAddressContacts;
    this.etAddressDetailsAddressContact = etAddressDetailsAddressContact;
    this.etBuildingAddressContact = etBuildingAddressContact;
    this.etCityAddressContact = etCityAddressContact;
    this.etDistrictAddressContact = etDistrictAddressContact;
    this.etEmailAddressContact = etEmailAddressContact;
    this.etFacebookAddressContact = etFacebookAddressContact;
    this.etFirstGradeMobileAddressContact = etFirstGradeMobileAddressContact;
    this.etMobileAddressContact = etMobileAddressContact;
    this.etNearestPlaceAddressContact = etNearestPlaceAddressContact;
    this.etPhoneAddressContact = etPhoneAddressContact;
    this.etStateAddressContact = etStateAddressContact;
    this.etStreetAddressContact = etStreetAddressContact;
    this.progress = progress;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddressAndContactBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddressAndContactBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_address_and_contact, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddressAndContactBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_save_address_contacts;
      MaterialButton btnSaveAddressContacts = rootView.findViewById(id);
      if (btnSaveAddressContacts == null) {
        break missingId;
      }

      id = R.id.et_address_details_address_contact;
      TextInputEditText etAddressDetailsAddressContact = rootView.findViewById(id);
      if (etAddressDetailsAddressContact == null) {
        break missingId;
      }

      id = R.id.et_building_address_contact;
      TextInputEditText etBuildingAddressContact = rootView.findViewById(id);
      if (etBuildingAddressContact == null) {
        break missingId;
      }

      id = R.id.et_city_address_contact;
      TextView etCityAddressContact = rootView.findViewById(id);
      if (etCityAddressContact == null) {
        break missingId;
      }

      id = R.id.et_district_address_contact;
      TextView etDistrictAddressContact = rootView.findViewById(id);
      if (etDistrictAddressContact == null) {
        break missingId;
      }

      id = R.id.et_email_address_contact;
      TextView etEmailAddressContact = rootView.findViewById(id);
      if (etEmailAddressContact == null) {
        break missingId;
      }

      id = R.id.et_facebook_address_contact;
      TextInputEditText etFacebookAddressContact = rootView.findViewById(id);
      if (etFacebookAddressContact == null) {
        break missingId;
      }

      id = R.id.et_first_grade_mobile_address_contact;
      TextInputEditText etFirstGradeMobileAddressContact = rootView.findViewById(id);
      if (etFirstGradeMobileAddressContact == null) {
        break missingId;
      }

      id = R.id.et_mobile_address_contact;
      TextInputEditText etMobileAddressContact = rootView.findViewById(id);
      if (etMobileAddressContact == null) {
        break missingId;
      }

      id = R.id.et_nearest_place_address_contact;
      TextView etNearestPlaceAddressContact = rootView.findViewById(id);
      if (etNearestPlaceAddressContact == null) {
        break missingId;
      }

      id = R.id.et_phone_address_contact;
      TextView etPhoneAddressContact = rootView.findViewById(id);
      if (etPhoneAddressContact == null) {
        break missingId;
      }

      id = R.id.et_state_address_contact;
      TextView etStateAddressContact = rootView.findViewById(id);
      if (etStateAddressContact == null) {
        break missingId;
      }

      id = R.id.et_street_address_contact;
      TextView etStreetAddressContact = rootView.findViewById(id);
      if (etStreetAddressContact == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      return new FragmentAddressAndContactBinding((FrameLayout) rootView, btnSaveAddressContacts,
          etAddressDetailsAddressContact, etBuildingAddressContact, etCityAddressContact,
          etDistrictAddressContact, etEmailAddressContact, etFacebookAddressContact,
          etFirstGradeMobileAddressContact, etMobileAddressContact, etNearestPlaceAddressContact,
          etPhoneAddressContact, etStateAddressContact, etStreetAddressContact, progress);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
