package com.example.assignmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends BaseActivity {
    GridView grid_profiles;
    List<Integer> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        data = new ArrayList<>();
        data.add(R.drawable.taj);
        data.add(R.drawable.taj2);
        data.add(R.drawable.taj3);
        data.add(R.drawable.taj4);
        data.add(R.drawable.taj5);
        data.add(R.drawable.taj6);

        grid_profiles = findViewById(R.id.grid_profiles);
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_view, data);
        grid_profiles.setAdapter(customAdapter);
    }
}