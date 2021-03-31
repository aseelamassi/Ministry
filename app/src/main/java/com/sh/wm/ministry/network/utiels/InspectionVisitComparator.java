package com.sh.wm.ministry.network.utiels;


import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.DiffUtil;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;

/*
    Comparator for comparing Movie object to avoid duplicates
 */
public class InspectionVisitComparator extends DiffUtil.ItemCallback<InspectionVisit> {
    @Override
    public boolean areItemsTheSame(@NonNull InspectionVisit oldItem, @NonNull InspectionVisit newItem) {
        return oldItem.getINSPECTVID().equals(newItem.getINSPECTVID());
    }

    @Override
    public boolean areContentsTheSame(@NonNull InspectionVisit oldItem, @NonNull InspectionVisit newItem) {
        return oldItem.getINSPECTVID().equals(newItem.getINSPECTVID());
    }
}