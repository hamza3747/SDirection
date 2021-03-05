package com.example.sdirection;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.example.sdirection.fragments.AddUserFragment;
import com.example.sdirection.fragments.UserManagementFragment;
import com.example.sdirection.fragments.WelcomePageFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavigationDrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*To make status bar transparent for all of the pages
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(     //Add All fragments here//
                R.id.welcome_page_Fragment, R.id.user_mgt_Fragment, R.id.class_mgt_Fragment, R.id.course_mgt_Fragment,
                R.id.timetable_mgt_Fragment, R.id.make_announcement_Fragment, R.id.generate_result_card_Fragment,
                R.id.activity_mgt_Fragment, R.id.attendance_mgt_Fragment, R.id.digital_diary_Fragment,
                R.id.evaluation_center_Fragment, R.id.notes_center_Fragment, R.id.chat_box_Fragment, R.id.performance_scale_Fragment).setDrawerLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);   //We are changing all fragments here with the default fragment//
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        /*Adding Fragments here that are to be replaced*/

        WelcomePageFragment welcomePageFragment = new WelcomePageFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.nav_host_fragment, welcomePageFragment).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}