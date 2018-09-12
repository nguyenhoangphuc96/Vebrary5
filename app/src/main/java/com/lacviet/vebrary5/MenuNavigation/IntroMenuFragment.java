package com.lacviet.vebrary5.MenuNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lacviet.vebrary5.R;


public class IntroMenuFragment extends Fragment {
    private TextView tvContact,tvHistory,tvIntro,tvOrganization;
    public IntroMenuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_intro,container,false);
        addControl(view);

        addEvent();
        return view;
    }

    private void addEvent() {
        tvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvOrganization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
        tvContact = view.findViewById(R.id.tvContact);
        tvHistory = view.findViewById(R.id.tvHistory);
        tvIntro = view.findViewById(R.id.tvIntro);
        tvOrganization = view.findViewById(R.id.tvOrganizational);

    }
}