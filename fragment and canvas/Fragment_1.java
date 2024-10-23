package com.example.fragmentdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//public class Fragment_1 extends Fragment {
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate your layout
//        View view = inflater.inflate(R.layout.fragment_1, container, false);
//
//        // Find the container where you want to add the drawing
//        ViewGroup drawingContainer = view.findViewById(R.id.drawing_container); // Add this ID to your layout
//
//        // Add the drawing view to the container
//        Draw drawing = new Draw(requireContext());
//        drawingContainer.addView(drawing);
//
//        return view;
//
//
//
//    }
//}

public class Fragment_1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create the Draw view with the correct context
        Draw drawing = new Draw(requireContext());

        // Return the drawing view
        return drawing;
    }
}