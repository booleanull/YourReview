package com.bnull.yourreview.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import com.bnull.yourreview.R;
import com.bnull.yourreview.adapters.GroupAdapter;
import com.bnull.yourreview.models.Group;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class GroupActivity extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<Group> groups;
    public static GroupAdapter groupAdapter;
    public static RecyclerView recyclerView;
    public static TextView empty;

    public static void newGroup(Context context, int position, Group group) {
        if(groups.isEmpty())
            empty.setVisibility(View.GONE);
        groups.add(position, group);
        groupAdapter.notifyItemInserted(position);
        recyclerView.scrollToPosition(position);
        SaveData(context);
    }

    public static void deleteGroup(Context context, int position) {
        groups.remove(position);
        groupAdapter.notifyItemRemoved(position);
        SaveData(context);
        if(groups.isEmpty())
            empty.setVisibility(View.VISIBLE);
    }

    public static void changeGroup(Context context, int position) {
        groupAdapter.notifyItemChanged(position);
        SaveData(context);
    }

    public static void SaveData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("YourReview", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(groups);
        editor.putString("Groups", json);
        editor.apply();
    }

    public void LoadData () {
        SharedPreferences sharedPreferences = getSharedPreferences("YourReview", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Groups", null);
        Type type = new TypeToken<ArrayList<Group>>() {}.getType();
        groups = gson.fromJson(json, type);

        if(groups == null) {
            groups = new ArrayList<>();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        FirebaseAnalytics.getInstance(this);
        LoadData();

        empty = findViewById(R.id.emptyTextView);
        if(groups.isEmpty()) {
            empty.setVisibility(View.VISIBLE);
        }
        final FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);
        recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        groupAdapter = new GroupAdapter(this, groups, recyclerView);
        recyclerView.setAdapter(groupAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && floatingActionButton.getVisibility() == View.VISIBLE) {
                    floatingActionButton.hide();
                } else if (dy < 0 && floatingActionButton.getVisibility() != View.VISIBLE) {
                    floatingActionButton.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.google:
                break;
            default:
                String[] TO = {"booleanull@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
                startActivity(Intent.createChooser(emailIntent, "Send"));
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Intent intent = new Intent(GroupActivity.this, GroupAddActivity.class);
                startActivity(intent);
                break;
        }
    }
}
