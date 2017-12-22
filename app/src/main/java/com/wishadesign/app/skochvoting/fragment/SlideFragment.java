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

import org.w3c.dom.Text;

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
        TextView contentText = (TextView) rootView.findViewById(R.id.content_text);
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
                Glide.with(getContext()).load(R.drawable.screen_2).apply(new RequestOptions().centerCrop()).into(imageView);
                contentText.setVisibility(View.VISIBLE);
                contentText.setText("Skoch Group is a Gurgaon based think tank dealing with socio-economic issues with a focus on inclusive growth since 1997. The group companies include a consulting wing, a media wing and a charitable foundation. Skoch Group is able to bring an Indian felt-needs context to strategies and engages with fortune-500 companies, state owned enterprises, government to SMEs and community-based organisations with equal ease.");
                break;
            case 3:
                Glide.with(getContext()).load(R.drawable.screen_4).apply(new RequestOptions().centerCrop()).into(imageView);
                contentText.setVisibility(View.VISIBLE);
                contentText.setText("Founded in 1997, Skoch Consultancy Services Private Limited is a boutique strategy and management consulting firm. We are engaged by practically all large and serious players who wish to do business in India related to our areas of expertise. We help our client base of Fortune 500 as well as leading transnational and Indian organizations to create, identify, assess and address opportunities better.");
                break;
            case 4:
                Glide.with(getContext()).load(R.drawable.screen_6).apply(new RequestOptions().centerCrop()).into(imageView);
                contentText.setVisibility(View.VISIBLE);
                contentText.setText("Skoch Media is a leading publisher of books, journals, magazines and digital and multi-media content. It is a part of Skoch Group, a Gurgaon-based think tank dealing with socio-economic issues with a focus on inclusive growth since 1997. Over the years, Skoch Media has carved a niche for itself with independent editorial stand, innovative presentation and relentless focus on socio-economic issues.");
                break;
            case 5:
                Glide.with(getContext()).load(R.drawable.screen_5).apply(new RequestOptions().centerCrop()).into(imageView);
                contentText.setVisibility(View.VISIBLE);
                contentText.setText("Established in 2008, Skoch Development Foundation is an autonomous, policy oriented, not for profit policy think tank. The Foundation has been established as a “Not for Profit” Company under Section 25 of the Companies Act, 1956. It does not undertake any commercial activity. The Foundation ensures transparency, accountability and adherence to corporate governance norms.");
                break;
            case 6:
                Glide.with(getContext()).load(R.drawable.screen3).apply(new RequestOptions().centerCrop()).into(imageView);
                imageView_login.setVisibility(View.GONE);
                break;
        }
        return rootView;
    }

}
