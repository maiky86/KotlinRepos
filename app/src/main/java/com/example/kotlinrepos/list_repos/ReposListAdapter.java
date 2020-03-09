package com.example.kotlinrepos.list_repos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.bumptech.glide.Glide;
import com.example.kotlinrepos.MainViewModel;
import com.example.kotlinrepos.R;
import com.example.kotlinrepos.databinding.RepoItemBinding;
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
        return new ReposListViewHolder(
                DataBindingUtil.inflate( LayoutInflater.from( parent.getContext() ), R.layout.repo_item, parent, false)
                , positionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposListViewHolder holder, int position) {

        GHRepo repo = repositories.get(position);
        holder.bindTo(repo, fragmentContext);
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

        private RepoItemBinding binding;

        PositionClickedListener listener;

        public ReposListViewHolder(RepoItemBinding binding, PositionClickedListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
        }

        public void bindTo(GHRepo repo, Context context) {

            binding.setItemRepo(repo);
            binding.getRoot().setOnClickListener(this);
            loadImage(repo.getOwner().getAvatar(), context);

        }

        private void loadImage(String url, Context context) {
            // Image will be set with Glide
            Glide.with(context)
                    .load(url)
                    .circleCrop()
                    .into(binding.avatar);
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


