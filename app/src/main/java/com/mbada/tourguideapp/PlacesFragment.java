package com.mbada.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PlacesFragment extends Fragment implements mAdapter.OnItemClickListener{
    private ArrayList<Attraction> places;
    private int gridViewSpan;

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onItemClick(int position) {
        Attraction attraction = places.get(position);
        int imageId = attraction.getImageId();
        String name = attraction.getTitle();
        String description = getResources().getString(R.string.lorem);
        Intent intent = new Intent(getContext(), AttractionActivity.class);
        intent.putExtra(Tags.ATTRACTION_NAME, name);
        intent.putExtra(Tags.ATTRACTION_DESCRIPTION, description);
        intent.putExtra(Tags.IMAGE_URL, imageId);
        startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gridViewSpan = Utilities.getSpanCount(getContext());
        places = new ArrayList<>();
        String about = getResources().getString(R.string.lorem);
        String[] stringResource = getResources().getStringArray(R.array.places);
        places.add(new Attraction(stringResource[0],
                R.drawable.place_cape_wine_farms_small, about));
        places.add(new Attraction(stringResource[1],
                R.drawable.place_south_african_museum_small, about));
        places.add(new Attraction(stringResource[2],
                R.drawable.place_robben_island_small, about));
        places.add(new Attraction(stringResource[3],
                R.drawable.place_south_african_astronomical_observatory_small, about));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        RecyclerView mRecyclerView = view.findViewById(R.id.categoryRecyclerView);
        mAdapter mAdapter = new mAdapter(places,this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), gridViewSpan);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new mItemDecorator(
                getContext().getResources().getDimension(R.dimen.list_item_margin)));
        return view;
    }
}
