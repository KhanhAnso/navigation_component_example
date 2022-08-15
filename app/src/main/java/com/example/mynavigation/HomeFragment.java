package com.example.mynavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //Truyền dữ liệu với arg
        HomeFragmentDirections.ActionHomeFragmentToProfileFragment action =
                HomeFragmentDirections.actionHomeFragmentToProfileFragment("userViewModel.getUserName(getContext())");
        view.findViewById(R.id.btn_view_profile).setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(action);
        });
    }
}