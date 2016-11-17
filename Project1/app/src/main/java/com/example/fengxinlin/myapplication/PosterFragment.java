package com.example.fengxinlin.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengxinlin on 11/16/16.
 */
public class PosterFragment extends Fragment {

    private final String STORED_MOVIES = "stored_movies";
    private SharedPreferences prefs;
    private ImageAdapter mMoviePosterAdapter;
    String sortOrder;
    List<Movie> movies = new ArrayList<>();

    public PosterFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        sortOrder = prefs.getString(getString(R.string.display_preferences_sort_order_key),
                getString(R.string.display_preference_sort_default));

        if (savedInstanceState != null) {
            ArrayList<Movie> storedMovies = savedInstanceState.<Movie>getParcelableArrayList(STORED_MOVIES);
            movies.clear();
            movies.addAll(storedMovies);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMoviePosterAdapter =
                new ImageAdapter(
                        getActivity(),
                        R.layout.list_item_poster,
                        R.id.list_item_poster,
                        new ArrayList<String>());

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.main_movie);
        gridView.setAdapter(mMoviePosterAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Movie movie = movies.get(position);
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra("movies_detail", movie);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        String prefSortOrder = prefs.getString(getString(R.string.display_preferences_sort_order_key),
                getString(R.string.display_preference_sort_default));

        if(movies.size() > 0 && prefSortOrder.equals(sortOrder)) {
            updatePosterAdapter();
        }else{
            sortOrder = prefSortOrder;
            getMovies();
        }
    }

    private void updatePosterAdapter() {
        mMoviePosterAdapter.clear();
        for (Movie movie : movies) {
            mMoviePosterAdapter.add(movie.getPoster());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ArrayList<Movie> storedMovies = new ArrayList<>();
        storedMovies.addAll(movies);
        outState.putParcelableArrayList(STORED_MOVIES, storedMovies);
    }

    public void getMovies() {
        MovieAsynTask movieAsynTask = new MovieAsynTask(new AsyncResponse() {
            @Override
            public void onTaskComplete(List<Movie> result) {
                movies.clear();
                movies.addAll(result);
                updatePosterAdapter();
            }
        });
        movieAsynTask.execute(sortOrder);
    }

}