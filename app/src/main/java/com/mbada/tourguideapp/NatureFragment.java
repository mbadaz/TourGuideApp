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

public class NatureFragment extends Fragment implements mAdapter.OnItemClickListener {

    private ArrayList<Attraction> nature;
    private int gridViewSpan;

    public NatureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onItemClick(int position) {
        Attraction attraction = nature.get(position);
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
        String[] stringResource = getResources().getStringArray(R.array.nature);
        nature = new ArrayList<>();
        String about = getResources().getString(R.string.lorem);
        stringResource = getResources().getStringArray(R.array.nature);
        nature.add(new Attraction(stringResource[0],
                R.drawable.nature_bontebok_national_park_small, about));
        nature.add(new Attraction(stringResource[1],
                R.drawable.nature_boulders_beach_small, about));
        nature.add(new Attraction(stringResource[2],
                R.drawable.nature_skeleton_gorge_hike_small, about));
        nature.add(new Attraction(stringResource[3],
                R.drawable.nature_table_mountain_park_small, about));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        RecyclerView mRecyclerView = view.findViewById(R.id.categoryRecyclerView);
        mAdapter mAdapter = new mAdapter(nature,this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), gridViewSpan);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new mItemDecorator(
                getContext().getResources().getDimension(R.dimen.list_item_margin)));
        return view;
    }
}
