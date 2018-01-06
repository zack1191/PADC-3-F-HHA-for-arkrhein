package com.hha.heinhtetaung.movieshelf.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.movieshelf.R;
import com.hha.heinhtetaung.movieshelf.viewitems.ImagesMovieViewItem;

/**
 * Created by E5 on 12/13/2017.
 */

public class MovieImageAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImagesMovieViewItem view = (ImagesMovieViewItem) layoutInflater.inflate(R.layout.item_movie_images, container, false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
