package com.lacviet.vebrary5.MenuNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lacviet.vebrary5.R;

public class EbookMenuFragment extends Fragment {
    private TextView tvDigitalDocument,tvOnlineMagazine,tvExcerpt,tvChildren;
    public EbookMenuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_ebook,container,false);
        addControl(view);

        addEvent();
        return view;
    }

    private void addEvent() {
        tvDigitalDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvExcerpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvOnlineMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvChildren.setOnClickListener(new View.OnClickListener() {
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
        tvDigitalDocument = view.findViewById(R.id.tvDigitalDocument);
        tvOnlineMagazine = view.findViewById(R.id.tvOnlineMagazine);
        tvExcerpt = view.findViewById(R.id.tvExcerpt);
        tvChildren = view.findViewById(R.id.tvChildren);

    }
}