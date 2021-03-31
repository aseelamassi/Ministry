package com.sh.wm.ministry.custem.datepicker;

import android.util.Log;

import androidx.fragment.app.FragmentManager;

import java.util.Calendar;

public class TimeAdder {

    private FragmentManager fragmentManager;
    private Calendar calendar;
    private TimeAdder.Listener listener;
    private TimePickerFragment timePickerFragment;
    private final TimePickerFragment.Listener timeListener = new TimePickerFragment.Listener() {


        @Override
        public void onTimeChosen(int hour, int minute) {

            timePickerFragment.setListener(null);
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);

            listener.onTimeChosen(calendar.getTimeInMillis());
        }
    };

    public TimeAdder(FragmentManager fragmentManager, Listener listener ) {
        this.fragmentManager = fragmentManager;
        calendar = Calendar.getInstance();
        this.listener = listener;
        timePickerFragment = new TimePickerFragment();
    }

    public void show() {
        if (timePickerFragment.isAdded()) {
            return;
        }
        timePickerFragment.setListener(timeListener);
        timePickerFragment.show(fragmentManager, null);
    }

    public void cleanUp() {
        timePickerFragment = null;
    }

    public interface Listener {
        void onTimeChosen(long timeChosen);


    }
}
