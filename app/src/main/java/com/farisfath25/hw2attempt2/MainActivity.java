package com.farisfath25.hw2attempt2;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

/*
Faris Fathurrahman - 14050141015
HW#2
CENG427 - Mobile Programming Devices

Resources:
- http://abhiandroid.com/materialdesign/tablayout-example-android-studio.html
- https://www.youtube.com/watch?v=BqMIcugsCFc
- https://stackoverflow.com/questions/24772828/how-to-parse-html-table-using-jsoup
- https://try.jsoup.org/
- https://www.journaldev.com/10416/android-listview-with-custom-adapter-example-tutorial
- https://stackoverflow.com/questions/29743535/android-listview-onclick-open-a-website
- http://wptrafficanalyzer.in/blog/item-long-click-handler-for-listfragment-in-android/
 */

public class MainActivity extends AppCompatActivity {


    FrameLayout simpleFrameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the reference of FrameLayout and TabLayout
        simpleFrameLayout = (FrameLayout) findViewById(R.id.simpleFrameLayout);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);

        // Create a new first Tab
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("Food"); // set the Text for the first Tab
        //firstTab.setIcon(R.drawable.ic_launcher_foreground); // set an icon for the first tab
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout

        // Create a new second Tab
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Announcements"); // set the Text for the second Tab
        //secondTab.setIcon(R.drawable.ic_launcher_foreground); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout

        // Create a new third Tab
        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("News"); // set the Text for the first Tab
        //thirdTab.setIcon(R.drawable.ic_launcher_foreground); // set an icon for the first tab
        tabLayout.addTab(thirdTab); // add  the tab at in the TabLayout

        // perform setOnTabSelectedListener event on TabLayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            // get the current selected tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new FragmentOne();
                        break;
                    case 1:
                        fragment = new FragmentTwo();
                        break;
                    case 2:
                        fragment = new FragmentThree();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
