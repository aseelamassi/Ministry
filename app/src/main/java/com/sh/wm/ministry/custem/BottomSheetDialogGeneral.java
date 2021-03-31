package com.sh.wm.ministry.custem;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;

public class BottomSheetDialogGeneral extends BottomSheetDialog  {

    private BottomSheetInterface mListener;
    private int count = 0 ;
    private Context context ;
    BottomSheetListView listView;
    MaterialTextView titleTv;


    public BottomSheetDialogGeneral(@NonNull Context context ,BottomSheetInterface mListener ) {
       super(context);
        this.context = context;
        this.mListener= mListener;
        this.setContentView(R.layout.bottom_sheet_view);
        listView = this.findViewById(R.id.listViewBtmSheet);
        titleTv = this.findViewById(R.id.tv_spinner_title_bottom_sheet);
    }




    public void setContext(Context context) {
        this.context = context;
    }

    public void openDialog(ArrayAdapter<?> itemsAdapter, int title, TextView tvChange ) {

        tvChange.setEnabled(false);

        titleTv.setText(context.getString(title));

        listView.setAdapter(itemsAdapter);

        count++;


        if (count == 1 && !this.isShowing()) {
            tvChange.setEnabled(true);
            this.show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvChange.setText(adapterView.getItemAtPosition(i).toString());
                BottomSheetDialogGeneral.this.dismiss();
                mListener.onItemClick(adapterView, view, i, l);

            }
        });


        this.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

                tvChange.setEnabled(true);
                listView.setAdapter(null);
                count = 0;

            }
        });
    }


    public void setmListener(BottomSheetInterface mListener) {
        this.mListener = mListener;
    }

    public interface BottomSheetInterface {


        void onItemClick(AdapterView<?> adapterView, View view, int i, long l);


    }


    public int getCount() {
        return count;
    }
}
