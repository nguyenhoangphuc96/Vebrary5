package com.lacviet.vebrary5.MenuNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lacviet.vebrary5.News.EducationNewsActivity;
import com.lacviet.vebrary5.R;

public class NewsMenuFragment extends Fragment {
    private TextView tvEducation,tvActivity,tvMajor;
    public NewsMenuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_news,container,false);
        addControl(view);

        addEvent();
        return view;
    }

    private void addEvent() {
        tvEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startEducationNews();
            }
        });
        tvMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void startEducationNews() {
        Intent intent = new Intent(getActivity(), EducationNewsActivity.class);
        startActivity(intent);
    }

    /*private void startContactActivity() {
        Intent intent = new Intent(getContext(), ContactActivity.class);
        getContext().startActivity(intent);
    }
    private void startIntroActivity() {
        Intent intent = new Intent(getContext(), IntroActivity.class);
        getContext().startActivity(intent);
    }
    private void startHistoryActivity() {
        Intent intent = new Intent(getContext(), HistoryActivity.class);
        getContext().startActivity(intent);
    }
    private void startOrganizationActivity() {
        Intent intent = new Intent(getContext(),OrganizationActivity.class);
        getContext().startActivity(intent);
    }*/

    private void addControl(View view) {
        tvEducation = view.findViewById(R.id.tvEducation);
        tvActivity = view.findViewById(R.id.tvActivity);
        tvMajor = view.findViewById(R.id.tvMajor);

    }
}