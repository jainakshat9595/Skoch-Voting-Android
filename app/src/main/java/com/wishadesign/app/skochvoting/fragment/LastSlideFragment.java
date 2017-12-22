package com.wishadesign.app.skochvoting.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wishadesign.app.skochvoting.R;
import com.wishadesign.app.skochvoting.activity.MainActivity;
import com.wishadesign.app.skochvoting.activity.WebviewActivity;

public class LastSlideFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText mUserNameText;
    private ImageView mConfirmButton;

    public LastSlideFragment() {
    }

    public static LastSlideFragment newInstance(/*String param1, String param2*/) {
        LastSlideFragment fragment = new LastSlideFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_last_slide, container, false);
        initView(rootView);

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mUserNameText.getText().toString().equals("")) {
                    Intent intent = new Intent(getContext(), WebviewActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    Toast.makeText(getContext(), "Please enter the Name.", Toast.LENGTH_LONG).show();
                }
            }
        });

        return rootView;

    }

    private void initView(View rootView) {
        mUserNameText = (EditText) rootView.findViewById(R.id.edit_name);
        mConfirmButton = (ImageView) rootView.findViewById(R.id.confirm_btn);
    }

}
