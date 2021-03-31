package com.sh.wm.ministry.custem;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sh.wm.ministry.network.database.dbModels.constants.Constants;

import java.util.List;

public class RadioButtonCreation {

    Context context;


    public RadioButtonCreation(Context context) {
        this.context = context;
    }

    public void addRadioButtons(RadioGroup radioGroup, List<Constants> constants, String type) {
        int count = 0 ;

        if (type!= null && type.equals("recommendationL"))
             count = 3;
        radioGroup.setOrientation(LinearLayout.VERTICAL);
        //
        for (Constants constant : constants) {
            RadioButton rdbtn = new RadioButton(context);

            rdbtn.setId(count++);
            rdbtn.setTag(constant.getCONSTANTID());


            rdbtn.setText(constant.getCONSTANTARANAME());

            if (type != null && type.equals(constant.getCONSTANTID())){
                rdbtn.setChecked(true);
            }

                radioGroup.addView(rdbtn);
        }
    }

    public void Disable_Or_Enable_RG_Button(RadioGroup radioGroup, boolean enable_or_disable){
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            ((RadioButton) radioGroup.getChildAt(i)).setEnabled(enable_or_disable);
            ((RadioButton) radioGroup.getChildAt(i)).setChecked(false);

        }
    }



}
