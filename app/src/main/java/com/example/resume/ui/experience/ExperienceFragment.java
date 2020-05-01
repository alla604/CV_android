package com.example.resume.ui.experience;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.resume.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExperienceFragment extends Fragment {
    final String ATTRIBUTE_COMPANY = "title";
    final String ATTRIBUTE_PROFESSION = "profession";
    final String ATTRIBUTE_DATA_EXP = "data_exp";
    final String ATTRIBUTE_IMAGE_EXP = "image_exp";
    private Job myJob;

    private ArrayList<Map<String, Object>> list;
    private String[] company_names;
    private String[] professions;
    private String[] data_experience;
    private String[] descriptions;
    private int[] mImageIds;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_experience, container, false);

        initializeData();

        String[] from = { ATTRIBUTE_COMPANY, ATTRIBUTE_PROFESSION,
                ATTRIBUTE_DATA_EXP, ATTRIBUTE_IMAGE_EXP };

        int[] to = { R.id.title_exp, R.id.text_exp, R.id.data_exp, R.id.list_company_image_exp };

        SimpleAdapter adapter = new SimpleAdapter(
                getContext(),
                list,
                R.layout.list_item_experience,
                from, to
        );

        ListView listView = root.findViewById(R.id.listView_experience);
        listView.setAdapter(adapter);

        final NavController navController = NavHostFragment.findNavController(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myJob = new Job(company_names[position], data_experience[position], professions[position], descriptions[position], mImageIds[position]);
                JobFragment.setMyJob(myJob);
                navController.navigate(R.id.nav_experience_job);
            }
        });

        return root;
    }

    private void initializeData(){

        company_names = getResources().getStringArray(R.array.experience_companies_names);
        professions = getResources().getStringArray(R.array.experience_professions);
        data_experience = getResources().getStringArray(R.array.experience_data);
        descriptions = getResources().getStringArray(R.array.experience_description);

        mImageIds = new int[] {R.drawable.amopix, R.drawable.bb, R.drawable.nordstroi, R.drawable.aquaphor, R.drawable.mcxxi, R.drawable.sakura, R.drawable.taleion, R.drawable.gagarin};

        list = new ArrayList<Map<String, Object>>(
                company_names.length);
        Map<String, Object> m;
        for (int i = 0; i < company_names.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_COMPANY, company_names[i]);
            m.put(ATTRIBUTE_PROFESSION, professions[i]);
            m.put(ATTRIBUTE_DATA_EXP, data_experience[i]);
            m.put(ATTRIBUTE_IMAGE_EXP, mImageIds[i]);
            list.add(m);
        }

    }

}
