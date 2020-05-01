package com.example.resume.ui.experience;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.resume.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JobFragment extends Fragment {

    private static Job myJob;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_experience_job, container, false);

        TextView jobTitle = root.findViewById(R.id.title_job);
        jobTitle.setText(myJob.getCompanyName());

        TextView jobData = root.findViewById(R.id.data_job);
        jobData.setText(myJob.getJobData());

        TextView jobProfession = root.findViewById(R.id.profession_job);
        jobProfession.setText(myJob.getProfession());

        TextView jobDescription = root.findViewById(R.id.description_job);
        jobDescription.setText(myJob.getDescription());

        ImageView jobImage = root.findViewById(R.id.company_image);
        jobImage.setImageResource(myJob.getImageId());

        return root;
    }


    public static void setMyJob(Job mJob) {
        myJob = mJob;
    }
}
