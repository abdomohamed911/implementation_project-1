package com.example.automatedhealthtrack;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);

        // Load the default fragment (Dashboard)
        if (savedInstanceState == null) {
            loadFragment(new DashboardFragment()); // Assuming DashboardFragment exists
        }

        // Handle Bottom Navigation item selections
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_dashboard) { // Use actual ID
                selectedFragment = new DashboardFragment();
            } else if (itemId == R.id.navigation_ranking) { // Use actual ID
                selectedFragment = new RankingFragment(); // Assuming RankingFragment exists
            } else if (itemId == R.id.navigation_profile) { // Use actual ID
                selectedFragment = new ProfileFragment(); // Assuming ProfileFragment exists
            }

            if (selectedFragment != null) {
                loadFragment(selectedFragment);
                return true;
            }
            return false;
        });

        // Set default selected item (optional, if you want Dashboard selected initially)
        // bottomNavigationView.setSelectedItemId(R.id.navigation_dashboard_placeholder); // Placeholder ID
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        // fragmentTransaction.addToBackStack(null); // Optional: Add to back stack if needed
        fragmentTransaction.commit();
    }
}

