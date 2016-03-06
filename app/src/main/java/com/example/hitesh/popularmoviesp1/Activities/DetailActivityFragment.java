package com.example.hitesh.popularmoviesp1.Activities;

import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hitesh.popularmoviesp1.Models.Movie;
import com.example.hitesh.popularmoviesp1.R;
import com.example.hitesh.popularmoviesp1.Utilities.Utility;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;

import static java.security.AccessController.getContext;

/**
 * Created by hitesh on 05-03-2016.
 */
public class DetailActivityFragment extends Fragment {

    public static final String TAG = DetailActivityFragment.class.getSimpleName();
    static final String DETAIL_MOVIE = "DETAIL_MOVIE";

    private Movie mMovie;
    private ImageView mImageView;
    private TextView mTitleView;
    private TextView mOverviewView;
    private TextView mDateView;
    private TextView mVoteAverageView;

    private ScrollView mDetailLayout;
    private Toast mToast;

    public DetailActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {
            mMovie = arguments.getParcelable(DetailActivityFragment.DETAIL_MOVIE);
        }

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        mDetailLayout = (ScrollView) rootView.findViewById(R.id.detail_layout);

        if (mMovie != null) {
            mDetailLayout.setVisibility(View.VISIBLE);
        } else {
            mDetailLayout.setVisibility(View.INVISIBLE);
        }

        mImageView = (ImageView) rootView.findViewById(R.id.detail_image);
        mTitleView = (TextView) rootView.findViewById(R.id.detail_title);
        mOverviewView = (TextView) rootView.findViewById(R.id.detail_overview);
        mDateView = (TextView) rootView.findViewById(R.id.detail_date);
        mVoteAverageView = (TextView) rootView.findViewById(R.id.detail_vote_average);


        if (mMovie != null) {

            String image_url = Utility.buildImageUrl(342, mMovie.getImage2());
            Picasso.with(getContext()).load(image_url).into(mImageView);

            mTitleView.setText(mMovie.getTitle());
            mOverviewView.setText(mMovie.getOverview());

            String movie_date = mMovie.getDate();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                String date = DateUtils.formatDateTime(getActivity(),
                        formatter.parse(movie_date).getTime(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR);
                mDateView.setText(date);
            }catch (java.text.ParseException e) {
                e.printStackTrace();
            }

            mVoteAverageView.setText(Integer.toString(mMovie.getRating()));
        }

        return rootView;
    }





    }
