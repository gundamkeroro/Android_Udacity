package com.example.fengxinlin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by fengxinlin on 11/15/16.
 */
public class DetailFragment extends Fragment {
    private static final String LOG_TAG = DetailFragment.class.getSimpleName();

    Movie movie;

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail, container, false);

        Intent intent = getActivity().getIntent();

        if (intent != null && intent.hasExtra("movies_detail")) {
            movie = (Movie)intent.getParcelableExtra("movies_detail");
            DisplayMovie(view);
        }
        return view;
    }

    private void DisplayMovie(View view) {
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView year = (TextView) view.findViewById(R.id.year);
        TextView description = (TextView) view.findViewById(R.id.describe);
        TextView rating = (TextView) view.findViewById(R.id.Ratting);
        ImageView img = (ImageView) view.findViewById(R.id.image);

        title.setText(movie.getTitle());
        description.setText(movie.getOverview());
        rating.setText(movie.getVoteAverage());
        year.setText(movie.getReleaseDate());
        Picasso.with(getActivity()).load(movie.getPoster()).into(img);
    }
}
