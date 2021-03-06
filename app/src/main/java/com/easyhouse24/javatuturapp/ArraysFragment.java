package com.easyhouse24.javatuturapp;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArraysFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;

    private LoopsFragment loopsFragment;

    private AdvancedFragment advancedFragment;

    private HomeFragment homeFragment;


    public ArraysFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_arrays, container, false);
        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.nav_tutorial_arrays);

        bottomNavigationView.setSelectedItemId(R.id.tutorial_next);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.tutorial_next:

                        SharedPreferences pref = getActivity().getSharedPreferences("IS_ACCEPTED", Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("X_NUMBER","10");
                        editor.commit();


                        askChange();

                        //Toast.makeText(getContext(),"Still to continue filling tutorials",Toast.LENGTH_LONG).show();
                        break;


                    case  R.id.tutorial_back:
                        loopsFragment = new LoopsFragment();
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame_tutorial, loopsFragment, "NewFragmentTag");
                        ft.commit();



                        break;
                }
                return false;
            }
        });

        return view;
    }

    public void askChange(){
        AlertDialog.Builder  builder = new AlertDialog.Builder(getContext());

        builder.setCancelable(false);
        builder.setMessage("Congratulations, you have finished the Basic section Tutorials.You've been awarded a trophy. Move to : ");



        builder.setPositiveButton("Stay here ",null);

        builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getContext(),StartActivity.class);
                startActivity(i);
            }
        });

        builder.setIcon(R.drawable.ic_stars_black_24dp);

        builder.show();

    }

}
