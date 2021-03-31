package com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetSearshList;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;

import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.economicSector.EconomicSector;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.jobList.Result;
import com.sh.wm.ministry.network.database.dbModels.languages.Language;
import com.sh.wm.ministry.network.database.dbModels.trainingSide.TrainingSide;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgramsModel;

import java.util.ArrayList;

public class BottomSheetSearchList extends RecyclerView {


    private static ArrayList<?> mList;
    private static BottomSheetDialog bottomSheetDialog;


    public BottomSheetSearchList(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mList = new ArrayList<>();
        bottomSheetDialog = new BottomSheetDialog(context);
    }

    @Override
    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layout) {
        super.setLayoutManager(layout);
    }

    public static BottomSheetDialog getBottomSheetDialog() {
        return bottomSheetDialog;
    }

    public void setBottomSheetDialog(BottomSheetDialog bottomSheetDialog) {
        BottomSheetSearchList.bottomSheetDialog = bottomSheetDialog;
    }

    public void setMyList(ArrayList<?> myList, String key) {
        if (myList != null) {
            mList = myList;
        }
    }

    public static ArrayList<?> getMyList() {
        return mList;
    }


    public static void clerList() {
        mList.clear();


    }


    public static class MyTestAdapter extends RecyclerView.Adapter<MyTestAdapter.MyHolder> {

        private MyTestAdapter.MyClass myclass;
        TextView name;

        public MyTestAdapter(MyTestAdapter.MyClass myclass) {
            this.myclass = myclass;
        }

        @NonNull
        @Override
        public MyTestAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bottomsheet_search, parent, false);
            return new MyTestAdapter.MyHolder(root);
        }

        @Override
        public void onBindViewHolder(@NonNull MyTestAdapter.MyHolder holder, int position) {
            holder.number.setText("");
            if (getMyList().get(position) instanceof TrainingProgram) {
                TrainingProgram trainingProgram = (TrainingProgram) getMyList().get(position);
                holder.name.setText(trainingProgram.getTRAININGPROGRAMARNAME());
            } else if (getMyList().get(position) instanceof TrainingSide) {
                TrainingSide trainingSide = (TrainingSide) getMyList().get(position);
                holder.name.setText(trainingSide.getTRAININGPROGRAMARNAME());
            } else if (getMyList().get(position) instanceof Result) {
                Result result = (Result) getMyList().get(position);
                holder.name.setText(result.getText());
            } else if (getMyList().get(position) instanceof Construct) {
                Construct construct = (Construct) getMyList().get(position);
                holder.name.setText(construct.getCONSTRUCTNAMEUSING());
                holder.number.setText(construct.getCONSTRUCTNUM());
            } else if (getMyList().get(position) instanceof JobList) {
                JobList result = (JobList) getMyList().get(position);
                holder.name.setText(result.getText());
            } else if (getMyList().get(position) instanceof TrainingInstitute) {
                TrainingInstitute result = (TrainingInstitute) getMyList().get(position);
                holder.name.setText(result.getText());
            } else if (getMyList().get(position) instanceof Country) {
                Country result = (Country) getMyList().get(position);
                holder.name.setText(result.getCDARBTR());
            }else if (getMyList().get(position) instanceof Language) {
                Language result = (Language) getMyList().get(position);
                holder.name.setText(result.getLANGUAGEARNAME());
            }else if (getMyList().get(position) instanceof PalLaw) {
                PalLaw result = (PalLaw) getMyList().get(position);
                holder.name.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                holder.name.setText(result.getText());
            }else if (getMyList().get(position) instanceof EconomicSector){
                EconomicSector result = (EconomicSector) getMyList().get(position);
                holder.name.setText(result.getText());
            }else if (getMyList().get(position) instanceof com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.JobList){
                com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.JobList result = (com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.JobList) getMyList().get(position);
                holder.name.setText(result.getJOBARNAME());
            }




            holder.bind(getMyList().get(position), myclass);
        }

        @Override
        public int getItemCount() {
            return getMyList().size();
        }


        public class MyHolder extends RecyclerView.ViewHolder {

            TextView name, number;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.construction_name);

                number = itemView.findViewById(R.id.construction_number);


            }

            public void bind(final Object train, final MyTestAdapter.MyClass myClass) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        myclass.MyMethod(train);
                        getBottomSheetDialog().dismiss();
                        clerList();


                    }
                });
            }


        }

        public interface MyClass {
            void MyMethod(Object train);
        }


    }
}


