// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLegalActionBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final ImageView btnAddLegalAction;

  @NonNull
  public final Button btnSaveLegalAction;

  @NonNull
  public final CardViewSearshShBinding cardViewSearchShLegalAction;

  @NonNull
  public final RecyclerView edArticleNumberLegalAction;

  @NonNull
  public final TextView edDateAction;

  @NonNull
  public final TextView edDateVisit;

  @NonNull
  public final EditText edMachineStopWork;

  @NonNull
  public final TextView edMember1;

  @NonNull
  public final TextView edMember2;

  @NonNull
  public final TextView edMember3;

  @NonNull
  public final TextView edNuFacilityLegalAction;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final RadioGroup radio;

  @NonNull
  public final RadioButton radioButton1;

  @NonNull
  public final RadioButton radioButton2;

  @NonNull
  public final RadioButton radioButton3;

  @NonNull
  public final TextView tvArticleNumberLegalAction;

  @NonNull
  public final TextView tvDateAction;

  @NonNull
  public final TextView tvDateVisit;

  @NonNull
  public final TextView tvMachineStopWork;

  @NonNull
  public final TextView tvMember1;

  @NonNull
  public final TextView tvMember2;

  @NonNull
  public final TextView tvMember3;

  @NonNull
  public final TextView tvNuFacilityLegalAction;

  @NonNull
  public final TextView tvText;

  @NonNull
  public final TextView tvView1;

  @NonNull
  public final TextView tvView2;

  private FragmentLegalActionBinding(@NonNull ScrollView rootView,
      @NonNull ImageView btnAddLegalAction, @NonNull Button btnSaveLegalAction,
      @NonNull CardViewSearshShBinding cardViewSearchShLegalAction,
      @NonNull RecyclerView edArticleNumberLegalAction, @NonNull TextView edDateAction,
      @NonNull TextView edDateVisit, @NonNull EditText edMachineStopWork,
      @NonNull TextView edMember1, @NonNull TextView edMember2, @NonNull TextView edMember3,
      @NonNull TextView edNuFacilityLegalAction, @NonNull Guideline guideline,
      @NonNull ProgressBar progress, @NonNull RadioGroup radio, @NonNull RadioButton radioButton1,
      @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3,
      @NonNull TextView tvArticleNumberLegalAction, @NonNull TextView tvDateAction,
      @NonNull TextView tvDateVisit, @NonNull TextView tvMachineStopWork,
      @NonNull TextView tvMember1, @NonNull TextView tvMember2, @NonNull TextView tvMember3,
      @NonNull TextView tvNuFacilityLegalAction, @NonNull TextView tvText,
      @NonNull TextView tvView1, @NonNull TextView tvView2) {
    this.rootView = rootView;
    this.btnAddLegalAction = btnAddLegalAction;
    this.btnSaveLegalAction = btnSaveLegalAction;
    this.cardViewSearchShLegalAction = cardViewSearchShLegalAction;
    this.edArticleNumberLegalAction = edArticleNumberLegalAction;
    this.edDateAction = edDateAction;
    this.edDateVisit = edDateVisit;
    this.edMachineStopWork = edMachineStopWork;
    this.edMember1 = edMember1;
    this.edMember2 = edMember2;
    this.edMember3 = edMember3;
    this.edNuFacilityLegalAction = edNuFacilityLegalAction;
    this.guideline = guideline;
    this.progress = progress;
    this.radio = radio;
    this.radioButton1 = radioButton1;
    this.radioButton2 = radioButton2;
    this.radioButton3 = radioButton3;
    this.tvArticleNumberLegalAction = tvArticleNumberLegalAction;
    this.tvDateAction = tvDateAction;
    this.tvDateVisit = tvDateVisit;
    this.tvMachineStopWork = tvMachineStopWork;
    this.tvMember1 = tvMember1;
    this.tvMember2 = tvMember2;
    this.tvMember3 = tvMember3;
    this.tvNuFacilityLegalAction = tvNuFacilityLegalAction;
    this.tvText = tvText;
    this.tvView1 = tvView1;
    this.tvView2 = tvView2;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLegalActionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLegalActionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_legal_action, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLegalActionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_add_legal_action;
      ImageView btnAddLegalAction = rootView.findViewById(id);
      if (btnAddLegalAction == null) {
        break missingId;
      }

      id = R.id.btn_save_legal_action;
      Button btnSaveLegalAction = rootView.findViewById(id);
      if (btnSaveLegalAction == null) {
        break missingId;
      }

      id = R.id.card_view_search_sh_Legal_action;
      View cardViewSearchShLegalAction = rootView.findViewById(id);
      if (cardViewSearchShLegalAction == null) {
        break missingId;
      }
      CardViewSearshShBinding binding_cardViewSearchShLegalAction = CardViewSearshShBinding.bind(cardViewSearchShLegalAction);

      id = R.id.ed_article_number_legal_action;
      RecyclerView edArticleNumberLegalAction = rootView.findViewById(id);
      if (edArticleNumberLegalAction == null) {
        break missingId;
      }

      id = R.id.ed_date_action;
      TextView edDateAction = rootView.findViewById(id);
      if (edDateAction == null) {
        break missingId;
      }

      id = R.id.ed_date_visit;
      TextView edDateVisit = rootView.findViewById(id);
      if (edDateVisit == null) {
        break missingId;
      }

      id = R.id.ed_machine_stop_Work;
      EditText edMachineStopWork = rootView.findViewById(id);
      if (edMachineStopWork == null) {
        break missingId;
      }

      id = R.id.ed_member_1;
      TextView edMember1 = rootView.findViewById(id);
      if (edMember1 == null) {
        break missingId;
      }

      id = R.id.ed_member_2;
      TextView edMember2 = rootView.findViewById(id);
      if (edMember2 == null) {
        break missingId;
      }

      id = R.id.ed_member_3;
      TextView edMember3 = rootView.findViewById(id);
      if (edMember3 == null) {
        break missingId;
      }

      id = R.id.ed_nu_facility_legal_action;
      TextView edNuFacilityLegalAction = rootView.findViewById(id);
      if (edNuFacilityLegalAction == null) {
        break missingId;
      }

      id = R.id.guideline;
      Guideline guideline = rootView.findViewById(id);
      if (guideline == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.radio;
      RadioGroup radio = rootView.findViewById(id);
      if (radio == null) {
        break missingId;
      }

      id = R.id.radio_button_1;
      RadioButton radioButton1 = rootView.findViewById(id);
      if (radioButton1 == null) {
        break missingId;
      }

      id = R.id.radio_button_2;
      RadioButton radioButton2 = rootView.findViewById(id);
      if (radioButton2 == null) {
        break missingId;
      }

      id = R.id.radio_button_3;
      RadioButton radioButton3 = rootView.findViewById(id);
      if (radioButton3 == null) {
        break missingId;
      }

      id = R.id.tv_article_number_legal_action;
      TextView tvArticleNumberLegalAction = rootView.findViewById(id);
      if (tvArticleNumberLegalAction == null) {
        break missingId;
      }

      id = R.id.tv_date_action;
      TextView tvDateAction = rootView.findViewById(id);
      if (tvDateAction == null) {
        break missingId;
      }

      id = R.id.tv_date_visit;
      TextView tvDateVisit = rootView.findViewById(id);
      if (tvDateVisit == null) {
        break missingId;
      }

      id = R.id.tv_machine_stop_work;
      TextView tvMachineStopWork = rootView.findViewById(id);
      if (tvMachineStopWork == null) {
        break missingId;
      }

      id = R.id.tv_member_1;
      TextView tvMember1 = rootView.findViewById(id);
      if (tvMember1 == null) {
        break missingId;
      }

      id = R.id.tv_member_2;
      TextView tvMember2 = rootView.findViewById(id);
      if (tvMember2 == null) {
        break missingId;
      }

      id = R.id.tv_member_3;
      TextView tvMember3 = rootView.findViewById(id);
      if (tvMember3 == null) {
        break missingId;
      }

      id = R.id.tv_nu_facility_legal_action;
      TextView tvNuFacilityLegalAction = rootView.findViewById(id);
      if (tvNuFacilityLegalAction == null) {
        break missingId;
      }

      id = R.id.tv_text;
      TextView tvText = rootView.findViewById(id);
      if (tvText == null) {
        break missingId;
      }

      id = R.id.tv_view1;
      TextView tvView1 = rootView.findViewById(id);
      if (tvView1 == null) {
        break missingId;
      }

      id = R.id.tv_view2;
      TextView tvView2 = rootView.findViewById(id);
      if (tvView2 == null) {
        break missingId;
      }

      return new FragmentLegalActionBinding((ScrollView) rootView, btnAddLegalAction,
          btnSaveLegalAction, binding_cardViewSearchShLegalAction, edArticleNumberLegalAction,
          edDateAction, edDateVisit, edMachineStopWork, edMember1, edMember2, edMember3,
          edNuFacilityLegalAction, guideline, progress, radio, radioButton1, radioButton2,
          radioButton3, tvArticleNumberLegalAction, tvDateAction, tvDateVisit, tvMachineStopWork,
          tvMember1, tvMember2, tvMember3, tvNuFacilityLegalAction, tvText, tvView1, tvView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
