package com.lacviet.vebrary5.MenuNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lacviet.vebrary5.R;

public class BookMenuFragment extends Fragment {
    private TextView tvOpac,tvThematic;
    public BookMenuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_book,container,false);
        addControl(view);

        addEvent();
        return view;
    }

    private void addEvent() {
        tvOpac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvThematic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void addControl(View view) {
        tvOpac = view.findViewById(R.id.tvOpac);
        tvThematic = view.findViewById(R.id.tvThematic);

    }
}