package com.wishadesign.app.skochvoting.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wishadesign.app.skochvoting.R;
import com.wishadesign.app.skochvoting.activity.MainActivity;

public class SlideFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private int mParam1;

    public SlideFragment() {
    }

    public static SlideFragment newInstance(int param1) {
        SlideFragment fragment = new SlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_SECTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_slide, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.img_placeholder);
        ImageView imageView_login = (ImageView) rootView.findViewById(R.id.loginbtn);
        imageView_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).getViewPager().setCurrentItem(6);
            }
        });
        switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
            case 1:
                Glide.with(getContext()).load(R.drawable.screen1).apply(new RequestOptions().centerCrop()).into(imageView);
                imageView_login.setVisibility(View.GONE);
                break;
            case 2:
                Glide.with(getContext()).load(R.drawable.screen2).apply(new RequestOptions().centerCrop()).into(imageView);
                break;
            case 3:
                Glide.with(getContext()).load(R.drawable.screen3).apply(new RequestOptions().centerCrop()).into(imageView);
                imageView_login.setVisibility(View.GONE);
                break;
            case 4:
                Glide.with(getContext()).load(R.drawable.screen4).apply(new RequestOptions().centerCrop()).into(imageView);
                break;
            case 5:
                Glide.with(getContext()).load(R.drawable.screen5).apply(new RequestOptions().centerCrop()).into(imageView);
                break;
            case 6:
                Glide.with(getContext()).load(R.drawable.screen6).apply(new RequestOptions().centerCrop()).into(imageView);
                break;
        }
        return rootView;
    }

}
