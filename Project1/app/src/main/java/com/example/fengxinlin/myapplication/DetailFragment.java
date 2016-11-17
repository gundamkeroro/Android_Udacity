package com.example.fengxinlin.myapplication;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fengxinlin on 11/15/16.
 */
public class DetailFragment extends Fragment {
    @BindView(R.id.movie_title) TextView title;
    @BindView(R.id.year) TextView year;
    @BindView(R.id.describe) TextView description;
    @BindView(R.id.Ratting) TextView rating;
    @BindView(R.id.image) ImageView img;

    Movie movie;

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();

        if (intent != null && intent.hasExtra("movies_detail")) {
            movie = intent.getParcelableExtra("movies_detail");
            DisplayMovie(view);
        }
        return view;
    }

    private void DisplayMovie(View view) {
        ButterKnife.bind(this, view);

        title.setText(movie.getTitle());
        description.setText(movie.getOverview());
        rating.setText(movie.getVoteAverage() + "/10");
        year.setText(movie.getReleaseDate());
        Picasso.with(getActivity()).load(movie.getPoster()).into(img);
    }
}
