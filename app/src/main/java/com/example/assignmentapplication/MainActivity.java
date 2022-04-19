package com.example.assignmentapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.languagelibrary.ChangeLanguage;
import com.example.themechanger.ThemeChanger;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_btn:
                startActivity(new Intent(MainActivity.this, About.class));
                return true;
            case R.id.profile_btn:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                return true;
            case R.id.settings_btn:
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}