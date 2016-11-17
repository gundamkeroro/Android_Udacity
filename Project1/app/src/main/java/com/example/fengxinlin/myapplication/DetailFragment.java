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

/**
 * Created by fengxinlin on 11/15/16.
 */
public class DetailFragment extends Fragment {

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
        TextView title = (TextView) view.findViewById(R.id.movie_title);
        TextView year = (TextView) view.findViewById(R.id.year);
        TextView description = (TextView) view.findViewById(R.id.describe);
        TextView rating = (TextView) view.findViewById(R.id.Ratting);
        ImageView img = (ImageView) view.findViewById(R.id.image);


        title.setText(movie.getTitle());
        description.setText(movie.getOverview());
        rating.setText(movie.getVoteAverage() + "/10");
        year.setText(movie.getReleaseDate());
        Picasso.with(getActivity()).load(movie.getPoster()).into(img);
    }
}
