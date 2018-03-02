package com.example.sulta.fragmentoperation;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnClickListener {
    private RelativeLayout mainFragmentstack;
    private FragmentManager mgr;
    private FragmentTransaction trns;
    private FragmentManager.BackStackEntry backStackEntry;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private int subscreensOnTheStack = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mgr = getFragmentManager();
        mainFragmentstack = (RelativeLayout) findViewById(R.id.main_fragmentstack);
        findViewById(R.id.main_addFragment1).setOnClickListener(MainActivity.this);
        findViewById(R.id.main_addFragment2).setOnClickListener(MainActivity.this);
        findViewById(R.id.main_addFragment3).setOnClickListener(MainActivity.this);
        findViewById(R.id.main_replaceFragment4).setOnClickListener(MainActivity.this);
        findViewById(R.id.main_remove).setOnClickListener(MainActivity.this);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_addFragment1:
                fragment1 = new Fragment1();
                mgr.beginTransaction()
                        .add(R.id.main_fragmentstack, fragment1)
                        .addToBackStack(null)
                        .commit();

                subscreensOnTheStack++;

                break;

            case R.id.main_addFragment2:
                fragment2 = new Fragment2();
                mgr.beginTransaction()
                        .add(R.id.main_fragmentstack, fragment2)
                        .addToBackStack(null)
                        .commit();

                subscreensOnTheStack++;

                break;
            case R.id.main_addFragment3:
                fragment3 = new Fragment3();
                mgr.beginTransaction()
                        .add(R.id.main_fragmentstack, fragment3)
                        .addToBackStack(null)
                        .commit();

                subscreensOnTheStack++;
                break;
            case R.id.main_replaceFragment4:
                fragment4 = new Fragment4();
                mgr.beginTransaction()
                        .replace(R.id.main_fragmentstack, fragment4)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.main_remove:
                if (subscreensOnTheStack > 0)
                    mgr.popBackStackImmediate();
                subscreensOnTheStack--;
                break;
        }
    }


    @Override
    public void onBackPressed() {
        if (subscreensOnTheStack > 0) {
            mgr.popBackStackImmediate();
            subscreensOnTheStack--;
        } else {
            super.onBackPressed();
        }
    }
}
