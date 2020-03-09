package com.example.kotlinrepos.owner_detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.kotlinrepos.MainViewModel;
import com.example.kotlinrepos.MainViewModelFactory;
import com.example.kotlinrepos.R;
import com.example.kotlinrepos.model.User;
import com.example.kotlinrepos.repository.FakeRepository;

import java.util.Objects;

public class OwnerDetailsFragment extends Fragment {

    public static final String TAG = "OwnerDetailsFragment";

    private static final String LOGIN = "login";

    private MainViewModel viewModel;

    private ImageView avatar;
    private TextView name;
    private TextView userName;
    private TextView publicRepos;
    private TextView url;

    private String userLogin;

    public OwnerDetailsFragment() {
        // Required empty public constructor
    }

    public static OwnerDetailsFragment newInstance(String userLogin) {
        OwnerDetailsFragment fragment = new OwnerDetailsFragment();
        Bundle args = new Bundle();
        args.putString(LOGIN, userLogin);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userLogin = getArguments().getString(LOGIN);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_owner_details, container, false);


        MainViewModelFactory factory = new MainViewModelFactory(requireActivity());
        viewModel = new ViewModelProvider(requireActivity(),factory).get(MainViewModel.class);

        avatar = v.findViewById(R.id.ownerAvatar);
        name = v.findViewById(R.id.ownerName);
        userName = v.findViewById(R.id.userName);
        publicRepos = v.findViewById(R.id.numberOfRepos);
        url = v.findViewById(R.id.ghPage);

        url.setOnClickListener(view -> {

            Uri uriUrl = Uri.parse(url.getText().toString());

            Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(intent);
        });

        viewModel.getSelected().observe(getViewLifecycleOwner(), user -> bindUserToView(user));

        return v;
    }

    private void bindUserToView(User user) {

        Glide.with(Objects.requireNonNull(getContext()))
                .load(user.getAvatar())
                .circleCrop()
                .into(avatar);

        name.setText(user.getName());

        String aux = "@"+user.getLogin();

        userName.setText(aux);
        publicRepos.setText(String.valueOf(user.getPublicRepos()));
        url.setText(user.getHtml_url());
    }
}
