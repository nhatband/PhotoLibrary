package com.example.photolibrary.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.photolibrary.Adapter.Viewadapter;
import com.example.photolibrary.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class HelpFragment extends Fragment
{
    ViewPager viewPager;
    SpringDotsIndicator dot1;
    Viewadapter viewadapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.help_fragment, container, false);
        viewPager = view.findViewById(R.id.view_pager);
        dot1 = view.findViewById(R.id.dot1);
        viewadapter = new Viewadapter(getActivity());
        viewPager.setAdapter(viewadapter);
        dot1.setViewPager(viewPager);
        return view;
    }
}
