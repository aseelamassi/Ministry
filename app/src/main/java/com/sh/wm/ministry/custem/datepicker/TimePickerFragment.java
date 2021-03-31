package com.sh.wm.ministry.custem.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.sh.wm.ministry.R;

import java.util.Calendar;

public class TimePickerFragment  extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        mListener.onTimeChosen(hour,minute);
    }

    private final TimePickerFragment.Listener DUMMY_LISTENER = new TimePickerFragment.Listener() {

        @Override
        public  void onTimeChosen(int hour, int minute) {

        }

    };
    private Listener mListener = DUMMY_LISTENER;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        // Create a new instance of DatePickerDialog and return it
        return new TimePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_NoActionBar ,this, hour, minute, false);
    }

    public void setListener(TimePickerFragment.Listener listener) {
        mListener = (listener == null) ? DUMMY_LISTENER : listener;
    }


    public interface Listener {
        void onTimeChosen(int hour, int minute);

    }
}
