package de.eahjena.wi.mae1.fussball;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import de.eahjena.wi.mae1.fussball.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Setzt die Toolbar als ActionBar
        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Konfiguration der AppBar mit allen Top-Level-Zielen
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_table, R.id.nav_results, R.id.nav_quiz)
                .setOpenableLayout(drawer)
                .build();

        // Initialisiere den NavController
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Konfiguriere die ActionBar mit dem NavController
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Handle item selection (navigation from the menu)
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();

            if (id == R.id.nav_home) {
                navController.navigate(R.id.nav_home); // Home Fragment Navigation
            } else if (id == R.id.nav_results) {
                navController.navigate(R.id.nav_results); // Results Fragment Navigation
            } else if (id == R.id.nav_table) {
                navController.navigate(R.id.nav_table); // Table Fragment Navigation
            } else if (id == R.id.nav_quiz) {
                navController.navigate(R.id.nav_quiz); // Quiz Fragment Navigation
            }

            // Close drawer when navigation item is clicked
            drawer.closeDrawers();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Menü zur ActionBar hinzufügen
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle up navigation from the action bar
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
