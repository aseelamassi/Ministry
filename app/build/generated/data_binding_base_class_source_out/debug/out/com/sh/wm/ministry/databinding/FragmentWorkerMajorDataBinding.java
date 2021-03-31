// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentWorkerMajorDataBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final AppCompatImageButton btnGetData;

  @NonNull
  public final TextView city;

  @NonNull
  public final TextView etAgeMajorServices;

  @NonNull
  public final TextView etBirthPlaceMajorServices;

  @NonNull
  public final TextView etChildNumberMajorServices;

  @NonNull
  public final TextView etCity;

  @NonNull
  public final TextView etFamilyName;

  @NonNull
  public final TextView etFatherName;

  @NonNull
  public final TextView etFirstNameMajorServices;

  @NonNull
  public final TextView etGenderMajorServices;

  @NonNull
  public final TextView etGrandNameMajorServices;

  @NonNull
  public final TextView etMotherNameMajorServices;

  @NonNull
  public final TextView etNationalityMajorServices;

  @NonNull
  public final TextView etOtherNationalityIdMajorServices;

  @NonNull
  public final TextView etPhone;

  @NonNull
  public final EditText etSn;

  @NonNull
  public final TextView etSocialStatusMajorServices;

  @NonNull
  public final TextView gender;

  @NonNull
  public final TextView phone;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final TextView tvBirthDateMajorServices;

  @NonNull
  public final TextView tvDeathDateMajorServices;

  private FragmentWorkerMajorDataBinding(@NonNull FrameLayout rootView,
      @NonNull AppCompatImageButton btnGetData, @NonNull TextView city,
      @NonNull TextView etAgeMajorServices, @NonNull TextView etBirthPlaceMajorServices,
      @NonNull TextView etChildNumberMajorServices, @NonNull TextView etCity,
      @NonNull TextView etFamilyName, @NonNull TextView etFatherName,
      @NonNull TextView etFirstNameMajorServices, @NonNull TextView etGenderMajorServices,
      @NonNull TextView etGrandNameMajorServices, @NonNull TextView etMotherNameMajorServices,
      @NonNull TextView etNationalityMajorServices,
      @NonNull TextView etOtherNationalityIdMajorServices, @NonNull TextView etPhone,
      @NonNull EditText etSn, @NonNull TextView etSocialStatusMajorServices,
      @NonNull TextView gender, @NonNull TextView phone, @NonNull ProgressBar progress,
      @NonNull TextView tvBirthDateMajorServices, @NonNull TextView tvDeathDateMajorServices) {
    this.rootView = rootView;
    this.btnGetData = btnGetData;
    this.city = city;
    this.etAgeMajorServices = etAgeMajorServices;
    this.etBirthPlaceMajorServices = etBirthPlaceMajorServices;
    this.etChildNumberMajorServices = etChildNumberMajorServices;
    this.etCity = etCity;
    this.etFamilyName = etFamilyName;
    this.etFatherName = etFatherName;
    this.etFirstNameMajorServices = etFirstNameMajorServices;
    this.etGenderMajorServices = etGenderMajorServices;
    this.etGrandNameMajorServices = etGrandNameMajorServices;
    this.etMotherNameMajorServices = etMotherNameMajorServices;
    this.etNationalityMajorServices = etNationalityMajorServices;
    this.etOtherNationalityIdMajorServices = etOtherNationalityIdMajorServices;
    this.etPhone = etPhone;
    this.etSn = etSn;
    this.etSocialStatusMajorServices = etSocialStatusMajorServices;
    this.gender = gender;
    this.phone = phone;
    this.progress = progress;
    this.tvBirthDateMajorServices = tvBirthDateMajorServices;
    this.tvDeathDateMajorServices = tvDeathDateMajorServices;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWorkerMajorDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWorkerMajorDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_worker_major_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWorkerMajorDataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_get_data;
      AppCompatImageButton btnGetData = rootView.findViewById(id);
      if (btnGetData == null) {
        break missingId;
      }

      id = R.id.city;
      TextView city = rootView.findViewById(id);
      if (city == null) {
        break missingId;
      }

      id = R.id.et_age_major_services;
      TextView etAgeMajorServices = rootView.findViewById(id);
      if (etAgeMajorServices == null) {
        break missingId;
      }

      id = R.id.et_birth_place_major_services;
      TextView etBirthPlaceMajorServices = rootView.findViewById(id);
      if (etBirthPlaceMajorServices == null) {
        break missingId;
      }

      id = R.id.et_child_number_major_services;
      TextView etChildNumberMajorServices = rootView.findViewById(id);
      if (etChildNumberMajorServices == null) {
        break missingId;
      }

      id = R.id.et_city;
      TextView etCity = rootView.findViewById(id);
      if (etCity == null) {
        break missingId;
      }

      id = R.id.et_family_name;
      TextView etFamilyName = rootView.findViewById(id);
      if (etFamilyName == null) {
        break missingId;
      }

      id = R.id.et_father_name;
      TextView etFatherName = rootView.findViewById(id);
      if (etFatherName == null) {
        break missingId;
      }

      id = R.id.et_first_name_major_services;
      TextView etFirstNameMajorServices = rootView.findViewById(id);
      if (etFirstNameMajorServices == null) {
        break missingId;
      }

      id = R.id.et_gender_major_services;
      TextView etGenderMajorServices = rootView.findViewById(id);
      if (etGenderMajorServices == null) {
        break missingId;
      }

      id = R.id.et_grand_name_major_services;
      TextView etGrandNameMajorServices = rootView.findViewById(id);
      if (etGrandNameMajorServices == null) {
        break missingId;
      }

      id = R.id.et_mother_name_major_services;
      TextView etMotherNameMajorServices = rootView.findViewById(id);
      if (etMotherNameMajorServices == null) {
        break missingId;
      }

      id = R.id.et_nationality_major_services;
      TextView etNationalityMajorServices = rootView.findViewById(id);
      if (etNationalityMajorServices == null) {
        break missingId;
      }

      id = R.id.et_other_nationality_id_major_services;
      TextView etOtherNationalityIdMajorServices = rootView.findViewById(id);
      if (etOtherNationalityIdMajorServices == null) {
        break missingId;
      }

      id = R.id.et_phone;
      TextView etPhone = rootView.findViewById(id);
      if (etPhone == null) {
        break missingId;
      }

      id = R.id.et_sn;
      EditText etSn = rootView.findViewById(id);
      if (etSn == null) {
        break missingId;
      }

      id = R.id.et_social_status_major_services;
      TextView etSocialStatusMajorServices = rootView.findViewById(id);
      if (etSocialStatusMajorServices == null) {
        break missingId;
      }

      id = R.id.gender;
      TextView gender = rootView.findViewById(id);
      if (gender == null) {
        break missingId;
      }

      id = R.id.phone;
      TextView phone = rootView.findViewById(id);
      if (phone == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.tv_birth_date_major_services;
      TextView tvBirthDateMajorServices = rootView.findViewById(id);
      if (tvBirthDateMajorServices == null) {
        break missingId;
      }

      id = R.id.tv_death_date_major_services;
      TextView tvDeathDateMajorServices = rootView.findViewById(id);
      if (tvDeathDateMajorServices == null) {
        break missingId;
      }

      return new FragmentWorkerMajorDataBinding((FrameLayout) rootView, btnGetData, city,
          etAgeMajorServices, etBirthPlaceMajorServices, etChildNumberMajorServices, etCity,
          etFamilyName, etFatherName, etFirstNameMajorServices, etGenderMajorServices,
          etGrandNameMajorServices, etMotherNameMajorServices, etNationalityMajorServices,
          etOtherNationalityIdMajorServices, etPhone, etSn, etSocialStatusMajorServices, gender,
          phone, progress, tvBirthDateMajorServices, tvDeathDateMajorServices);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
