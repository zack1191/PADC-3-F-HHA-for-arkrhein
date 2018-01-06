package com.hha.heinhtetaung.movieshelf.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.hha.heinhtetaung.movieshelf.R;
import com.hha.heinhtetaung.movieshelf.activities.MovieDetailsActivity;
import com.hha.heinhtetaung.movieshelf.adapters.MovieAdapter;
import com.hha.heinhtetaung.movieshelf.adapters.MovieTrailerAdapter;
import com.hha.heinhtetaung.movieshelf.app.MovieShelfApp;
import com.hha.heinhtetaung.movieshelf.data.vo.Models.MoviesModel;
import com.hha.heinhtetaung.movieshelf.delegate.MoviesActionDelegate;
import com.hha.heinhtetaung.movieshelf.events.LoadedMoviesEvent;
import com.hha.heinhtetaung.movieshelf.viewholders.MovieTrailerViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MoviesActionDelegate {
    @BindView(R.id.rv_movie)
    RecyclerView recyclerView;

    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        movieAdapter = new MovieAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(movieAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Search options are coming soon!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        MoviesModel.getsObjInstance().loadMovies();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapMovieItems() {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTapMovieReview() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoviesLoad(LoadedMoviesEvent event) {
        Log.d(MovieShelfApp.Log_TAG, "onMoviesLoaded:" + event.getMoviesList().size());
        movieAdapter.setMovies(event.getMoviesList());
    }
}
