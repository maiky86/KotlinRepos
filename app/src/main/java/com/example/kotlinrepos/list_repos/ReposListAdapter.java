package com.example.kotlinrepos.list_repos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.kotlinrepos.R;
import com.example.kotlinrepos.model.GHRepo;

import java.util.ArrayList;
import java.util.List;

public class ReposListAdapter extends Adapter<ReposListAdapter.ReposListViewHolder>{

    private ArrayList<GHRepo> repositories = new ArrayList<>();
    private RepoClickedListener listener;

    private PositionClickedListener positionListener = new PositionClickedListener() {
        @Override
        public void itemClicked(int position) {
            GHRepo repo = repositories.get(position);
            listener.repoClicked(repo.getOwner().getLogin());
        }
    };

    public ReposListAdapter(RepoClickedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ReposListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.repo_item, parent, false );
        return new ReposListViewHolder(v, positionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposListViewHolder holder, int position) {

        GHRepo repo = repositories.get(position);
        holder.bind(repo);
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public void addRepos(List<GHRepo> repos) {
        this.repositories.addAll(repos);
        notifyDataSetChanged();
    }

    class ReposListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView avatar;
        TextView repoName;
        TextView repoDesc;
        TextView repoOwner;
        TextView forks;
        TextView stars;
        TextView watchers;

        PositionClickedListener listener;

        public ReposListViewHolder(@NonNull View itemView, PositionClickedListener listener) {
            super(itemView);

            avatar = itemView.findViewById(R.id.avatar);
            repoName = itemView.findViewById(R.id.repoName);
            repoDesc = itemView.findViewById(R.id.repoDescription);
            repoOwner = itemView.findViewById(R.id.repoOwnerLogin);
            forks = itemView.findViewById(R.id.repoForks);
            stars = itemView.findViewById(R.id.repoStars);
            watchers = itemView.findViewById(R.id.repoWatchers);

            itemView.setOnClickListener(this);

            this.listener = listener;
        }

        public void bind(GHRepo repo) {

            // Image will be set with Glide

            repoName.setText(repo.getName());
            repoDesc.setText(repo.getDescription());

            String ownerLogin = "@"+repo.getOwner().getLogin();

            repoOwner.setText(ownerLogin);
            forks.setText(numberToText(repo.getForks()));
            stars.setText(numberToText(repo.getStars()));
            watchers.setText(numberToText(repo.getWatchers()));
        }

        private String numberToText(int value) {

            if (value < 1000) {
                return String.valueOf(value);
            } else {
                float aux = value / 1000F;
                return aux + "k";
            }
        }

        @Override
        public void onClick(View view) {
            listener.itemClicked(getAdapterPosition());
        }
    }

    interface PositionClickedListener {
        void itemClicked(int position);
    }
}


