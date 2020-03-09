package com.example.kotlinrepos.list_repos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.bumptech.glide.Glide;
import com.example.kotlinrepos.MainViewModel;
import com.example.kotlinrepos.R;
import com.example.kotlinrepos.model.GHRepo;

import java.util.ArrayList;
import java.util.List;

public class ReposListAdapter extends Adapter<ReposListAdapter.ReposListViewHolder>{

    private ArrayList<GHRepo> repositories = new ArrayList<>();
    private Context fragmentContext;
    private MainViewModel viewModel;

    private PositionClickedListener positionListener;

    public ReposListAdapter(MainViewModel mainViewModel, Context context) {
        this.viewModel = mainViewModel;
        this.fragmentContext = context;
        this.positionListener = position -> {
            GHRepo repo = repositories.get(position);
            viewModel.repoSelected(repo);
        };
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
        holder.bind(repo, fragmentContext);
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

        public void bind(GHRepo repo, Context context) {

            // Image will be set with Glide
            Glide.with(context)
                    .load(repo.getOwner().getAvatar())
                    .circleCrop()
                    .into(avatar);

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


