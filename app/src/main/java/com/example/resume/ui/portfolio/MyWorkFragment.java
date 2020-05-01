package com.example.resume.ui.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.resume.R;

public class MyWorkFragment extends Fragment {
    private static MyWork sWork;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_portfolio_mywork, container, false);

        TextView workTitle = root.findViewById(R.id.title_portfolio);
        workTitle.setText(sWork.getTitle());

        TextView workHashtag = root.findViewById(R.id.hashtag_portfolio);
        workHashtag.setText(sWork.getHashtag());


        TextView workDescription = root.findViewById(R.id.description_portfolio);
        workDescription.setText(sWork.getDescription());

        ImageView workImage = root.findViewById(R.id.mywork_image);
        workImage.setImageResource(sWork.getImgId());

        return root;
    }


    public static void setMyWork(MyWork work) {
        sWork = work;
    }
}
