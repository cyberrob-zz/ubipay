package com.ubidel.ubicash.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ubidel.ubicash.R;
import com.ubidel.ubicash.ui.auth.LandingActivity;
import com.ubidel.ubicash.ui.mvp.BaseActivity;
import com.ubidel.ubicash.util.PrefUtils;

import butterknife.BindView;


public class MainActivity extends BaseActivity<MainView, MainPresenter>
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.main_container) ConstraintLayout mainContainer;
    @BindView(R.id.section_text) TextView sectionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().checkAccount();

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            showHomeView();
        } else if (id == R.id.nav_support) {
            showSupportView();
        } else if (id == R.id.nav_cashout_locations) {
            showCashOutLocationView();
        } else if (id == R.id.nav_logout) {
            showLogoutView();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showHomeView() {
        sectionText.setText("HOME");
    }

    @Override
    public void showSupportView() {
        sectionText.setText("SUPPORT");
    }

    @Override
    public void showCashOutLocationView() {
        sectionText.setText("CASHOUT");
    }

    @Override
    public void showLogoutView() {
        getPresenter().clearCredential();
        redirectToSignInView();
    }

    @Override
    public void redirectToSignInView() {
        Intent intent = new Intent(MainActivity.this, LandingActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public void shownAsSignIn() {
        sectionText.setText("Hi!" + PrefUtils.getUserDetails(this).getLastName().toString());
    }

    @Override
    public void showErrorMessage(Context context, String message) {

    }

    @Override
    public void showWaitingDialog(Context context) {

    }

    @Override
    public void hideWaitingDialog() {

    }
}
