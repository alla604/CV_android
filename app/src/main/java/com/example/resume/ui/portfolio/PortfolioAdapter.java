package com.example.resume.ui.portfolio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resume.R;

import java.util.List;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.PortfolioHolder> {
    List<MyWork> myWorks;
    PortfolioFragment portfolioFragment;

    public PortfolioAdapter (List<MyWork> myWorks, PortfolioFragment portfolioFragment) {
        this.myWorks = myWorks;
        this.portfolioFragment = portfolioFragment;
    }

    @NonNull
    @Override
    public PortfolioHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.card_item_portfolio, viewGroup, false);

        return new PortfolioHolder(itemView, itemView.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioHolder holder, int position) {
        holder.titleView.setText(myWorks.get(position).getTitle());
        holder.hashtagView.setText(myWorks.get(position).getHashtag());
        holder.imgView.setImageResource(myWorks.get(position).getImgId());
        holder.currentCardPosition = position;
        holder.portfolioFragment = portfolioFragment;
    }

    @Override
    public int getItemCount() {
        return myWorks.size();
    }

    static class PortfolioHolder extends RecyclerView.ViewHolder {
        public final TextView titleView;
        public final TextView hashtagView;
        public final ImageView imgView;
        int currentCardPosition;
        Context mContext;
        PortfolioFragment portfolioFragment;


        public PortfolioHolder(View itemView, final Context context) {
            super(itemView);
            titleView = itemView.findViewById(R.id.portfolio_title);
            hashtagView = itemView.findViewById(R.id.portfolio_hashtag);
            imgView = itemView.findViewById(R.id.portfolio_mywork_image);

            mContext = context;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    portfolioFragment.onItemClick(currentCardPosition);
                }
            });
        }
    }
}
