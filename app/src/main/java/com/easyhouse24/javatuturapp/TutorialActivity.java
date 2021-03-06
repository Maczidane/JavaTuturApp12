package com.easyhouse24.javatuturapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class TutorialActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private FrameLayout frameLayout;

    private IntroFragment introFragment;

    private BasicSyntaxFragment basicSyntaxFragment;

    private DateFragment dateFragment;

    private ObjectsFragment objectsFragment;

    private VariablesFragment variablesFragment;

    private DataTypesFragment dataTypesFragment;

    private NumberFragment numberFragment;

    private CharactersFragment charactersFragment;

    private StringFragment stringFragment;

    private BasicFragment basicFragment;

    private LoopsFragment loopsFragment;

    private ArraysFragment arraysFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        toolbar = (Toolbar) findViewById(R.id.toolbar_tutorials);

        frameLayout = (FrameLayout) findViewById(R.id.frame_tutorial);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        introFragment = new IntroFragment();
        basicSyntaxFragment = new BasicSyntaxFragment();

        dateFragment = new DateFragment();

        numberFragment = new NumberFragment();

        objectsFragment = new ObjectsFragment();

        variablesFragment = new VariablesFragment();
        dataTypesFragment = new DataTypesFragment();

        charactersFragment = new CharactersFragment();

        stringFragment = new StringFragment();

        loopsFragment = new LoopsFragment();

        arraysFragment = new ArraysFragment();

        //setFragment(introFragment);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle s = getIntent().getExtras();

        if (s != null) {
            String frag = s.getString("Fragment");

            switch (frag) {
                case "Introduction":
                    setFragment(introFragment);
                    break;
                case "Basic Syntax":
                    setFragment(basicSyntaxFragment);
                    break;
                case "Date":
                    setFragment(dateFragment);
                    break;
                case "Objects":

                    setFragment(objectsFragment);
                    break;
                case "Variables":
                    setFragment(variablesFragment);
                    break;
                case "Data types":
                    setFragment(dataTypesFragment);
                    break;
                case "Numbers":
                    setFragment(numberFragment);
                    break;
                case "Characters":
                    setFragment(charactersFragment);
                    break;

                case "String":
                    setFragment(stringFragment);

                    break;

                case "Loops":
                    setFragment(loopsFragment);
                    break;
                case "Arrays":
                    setFragment(arraysFragment);
                    break;
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

               basicFragment = new BasicFragment();
               setFragment(basicFragment);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_tutorial, fragment);
        fragmentTransaction.commit();

    }
}
