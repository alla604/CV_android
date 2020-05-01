package com.example.resume.ui.portfolio;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resume.R;

import java.util.ArrayList;
import java.util.List;


public class PortfolioFragment extends Fragment {

    private static List<MyWork> myWorks;
    private RecyclerView rv;
    private String[] titles;
    private String[] hashtags;
    private String[] descriptions;
    private List<Integer> imgIds;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_portfolio, container, false);

        rv = (RecyclerView)root.findViewById(R.id.portfolio_recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        rv.setItemAnimator(itemAnimator);

        initializeData();
        initializeAdapter();

        return root;
    }

    public void onItemClick(int position) {
        final NavController navController = NavHostFragment.findNavController(this);
        MyWork work = myWorks.get(position);
        MyWorkFragment.setMyWork(work);
        navController.navigate(R.id.nav_portfolio_work);
    }

    private void initializeData(){
        myWorks = new ArrayList<>();

        titles = getResources().getStringArray(R.array.portfolio_titles);
        hashtags = getResources().getStringArray(R.array.portfolio_hashtags);
        descriptions = getResources().getStringArray(R.array.portfolio_description);
        imgIds = new ArrayList<>();
        fillImages();

        for (int i = 0; i < titles.length; i++) {
            myWorks.add(new MyWork(titles[i], hashtags[i], descriptions[i], imgIds.get(i)));
        }

    }



    private void initializeAdapter(){
        PortfolioAdapter adapter = new PortfolioAdapter(myWorks, this);
        rv.setAdapter(adapter);

    }

    public void fillImages() {
        imgIds.add(R.drawable.aquaphor_posters);
        imgIds.add(R.drawable.russia_avia);
        imgIds.add(R.drawable.pedro);
        imgIds.add(R.drawable.aquaphor_web);
        imgIds.add(R.drawable.mcxxi_buisnesscard);
        imgIds.add(R.drawable.am_parfume);
        imgIds.add(R.drawable.provance);
        imgIds.add(R.drawable.lp);
    }
}
