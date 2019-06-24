package com.bnull.yourreview.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bnull.yourreview.R;
import com.bnull.yourreview.adapters.NoteAdapter;
import com.bnull.yourreview.models.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.bnull.yourreview.ui.GroupActivity.SaveData;
import static com.bnull.yourreview.ui.GroupActivity.groups;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener {

    public static NoteAdapter noteAdapter;
    public static RecyclerView recyclerView;
    public static TextView empty;

    public static void newNote(Context context, int group, int position, Note note) {
        if (groups.get(group).getNotes().isEmpty())
            empty.setVisibility(View.GONE);
        groups.get(group).getNotes().add(position, note);
        noteAdapter.notifyItemInserted(position);
        recyclerView.scrollToPosition(position);
        SaveData(context);
    }

    public static void deleteNote(Context context, int group, int position) {
        groups.get(group).getNotes().remove(position);
        noteAdapter.notifyItemRemoved(position);
        SaveData(context);
        if (groups.get(group).getNotes().isEmpty())
            empty.setVisibility(View.VISIBLE);
    }

    public static void changeNote(Context context, int position) {
        noteAdapter.notifyItemChanged(position);
        SaveData(context);
    }

    int position;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            position = getIntent().getExtras().getInt("position");
            switch (groups.get(position).getColorId()) {
                case 0:
                    super.setTheme(R.style.Red);
                    color = getResources().getColor(R.color.Red);
                    break;
                case 1:
                    super.setTheme(R.style.Pink);
                    color = getResources().getColor(R.color.Pink);
                    break;
                case 2:
                    super.setTheme(R.style.Purple);
                    color = getResources().getColor(R.color.Purple);
                    break;
                case 3:
                    super.setTheme(R.style.DeepPurple);
                    color = getResources().getColor(R.color.DeepPurple);
                    break;
                case 4:
                    super.setTheme(R.style.Indigo);
                    color = getResources().getColor(R.color.Indigo);
                    break;
                case 5:
                    super.setTheme(R.style.Blue);
                    color = getResources().getColor(R.color.Blue);
                    break;
                case 6:
                    super.setTheme(R.style.LightBlue);
                    color = getResources().getColor(R.color.LightBlue);
                    break;
                case 7:
                    super.setTheme(R.style.Cyan);
                    color = getResources().getColor(R.color.Cyan);
                    break;
                case 8:
                    super.setTheme(R.style.Teal);
                    color = getResources().getColor(R.color.Teal);
                    break;
                case 9:
                    super.setTheme(R.style.Green);
                    color = getResources().getColor(R.color.Green);
                    break;
                case 10:
                    super.setTheme(R.style.LightGreen);
                    color = getResources().getColor(R.color.LightGreen);
                    break;
                case 11:
                    super.setTheme(R.style.Lime);
                    color = getResources().getColor(R.color.Lime);
                    break;
                case 12:
                    super.setTheme(R.style.Yellow);
                    color = getResources().getColor(R.color.Yellow);
                    break;
                case 13:
                    super.setTheme(R.style.Amber);
                    color = getResources().getColor(R.color.Amber);
                    break;
                case 14:
                    super.setTheme(R.style.Orange);
                    color = getResources().getColor(R.color.Orange);
                    break;
                case 15:
                    super.setTheme(R.style.DeepOrange);
                    color = getResources().getColor(R.color.DeepOrange);
                    break;
                case 16:
                    super.setTheme(R.style.Brown);
                    color = getResources().getColor(R.color.Brown);
                    break;
                case 17:
                    super.setTheme(R.style.Grey);
                    color = getResources().getColor(R.color.Grey);
                    break;
                case 18:
                    super.setTheme(R.style.BlueGrey);
                    color = getResources().getColor(R.color.BlueGrey);
                    break;
                case 19:
                    super.setTheme(R.style.PurpleGrey);
                    color = getResources().getColor(R.color.PurpleGrey);
                    break;
            }
        }
        setContentView(R.layout.activity_note);
        getSupportActionBar().setTitle(groups.get(position).getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        empty = findViewById(R.id.emptyTextView);
        if (groups.get(position).getNotes().isEmpty())
            empty.setVisibility(View.VISIBLE);

        final FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);
        recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(this, groups.get(position).getNotes(), recyclerView, color, position, groups.get(position).getIcon());
        recyclerView.setAdapter(noteAdapter);

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
        getMenuInflater().inflate(R.menu.note_search, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        Search(searchView);
        return true;
    }

    private void Search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (noteAdapter != null) {
                    noteAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Intent intent = new Intent(NoteActivity.this, NoteAddActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("change", false);
                startActivity(intent);
                break;
        }
    }
}
