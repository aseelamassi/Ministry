package com.sh.wm.ministry.custem;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter.BottomSheetSearchList;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetSearch extends BottomSheetDialog {

    private Context application;

    private BottomSheetDialog mDialog;
    private BottomSheetSearchInterface mListener;
    private BottomSheetSearchList bottomSheetSearchList;
    private EditText ed_text;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private BottomSheetSearchList.MyTestAdapter myTestAdapter;


    public BottomSheetSearch(@NonNull Context context , BottomSheetSearchInterface mListener) {
        super(context);
        this.mListener = mListener;
        this.setContentView(R.layout.bottom_sheet_training_program);
        ed_text = this.findViewById(R.id.search_view);
        bottomSheetSearchList = this.findViewById(R.id.recycler_view);
        imNoData = this.findViewById(R.id.image_no_data);
        progressBar = this.findViewById(R.id.progressbar);
    }


    public void openDialog(Observer observer) {


        ed_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_text.getText().toString().length() >= 3) {
                    mListener.etLengthMoreThan3(ed_text, observer);
                    progressBar.setVisibility(View.VISIBLE);
                    imNoData.setVisibility(View.GONE);

                } else {
                    progressBar.setVisibility(View.GONE);
                    imNoData.setVisibility(View.VISIBLE);
                    mListener.etLengthLessThan3(ed_text, observer);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

                BottomSheetSearchList.clerList();

            }
        });

        this.show();

        this.setOnDismissListener(dialogInterface -> ed_text.setText(""));

    }


    public void setUpAdapter(List<?> list, FragmentActivity activity) {

        if (list.size() != 0)
            imNoData.setVisibility(View.GONE);
        else
            setViewVisibility();

        bottomSheetSearchList.setLayoutManager(new LinearLayoutManager(activity));
        bottomSheetSearchList.setBottomSheetDialog(this);
        bottomSheetSearchList.setMyList((ArrayList<?>) list, ed_text.getText().toString());

        myTestAdapter = new BottomSheetSearchList.MyTestAdapter(new BottomSheetSearchList.MyTestAdapter.MyClass() {
            @Override
            public void MyMethod(Object object) {
                mListener.observerAction(object);
                ed_text.setText("");
                imNoData.setVisibility(View.VISIBLE);

            }
        });

        progressBar.setVisibility(View.GONE);

        bottomSheetSearchList.setAdapter(myTestAdapter);

    }


    public void notifyAdapter(){
        myTestAdapter.notifyDataSetChanged();
        setViewVisibility();

    }

    public void setViewVisibility(){

        imNoData.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    public interface BottomSheetSearchInterface {

        void observerAction(Object object);

        void etLengthMoreThan3(EditText ed_text , Observer observer);

        void etLengthLessThan3(EditText ed_text, Observer observer);

    }


}
