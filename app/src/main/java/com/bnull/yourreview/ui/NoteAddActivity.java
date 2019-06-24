package com.bnull.yourreview.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bnull.yourreview.R;
import com.bnull.yourreview.models.Note;

import java.util.Calendar;

import static com.bnull.yourreview.ui.GroupActivity.groupAdapter;
import static com.bnull.yourreview.ui.GroupActivity.groups;
import static com.bnull.yourreview.ui.NoteActivity.changeNote;
import static com.bnull.yourreview.ui.NoteActivity.newNote;

public class NoteAddActivity extends AppCompatActivity implements View.OnClickListener {

    private int color;
    private boolean change;
    private int position;
    private int pos = -1;

    private com.rengwuxian.materialedittext.MaterialEditText titleEditText;
    private com.rengwuxian.materialedittext.MaterialEditText textEditText;
    private RadioGroup typeRadioGroup;
    private Button addNote;
    private TextView mark;
    private TextView main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            position = getIntent().getExtras().getInt("position");
            pos = getIntent().getExtras().getInt("pos");
            change = getIntent().getExtras().getBoolean("change");
            switch (groups.get(position).getColorId()) {
                case 0: super.setTheme(R.style.Red);
                    color = getResources().getColor(R.color.Red);
                    break;
                case 1: super.setTheme(R.style.Pink);
                    color = getResources().getColor(R.color.Pink);
                    break;
                case 2: super.setTheme(R.style.Purple);
                    color = getResources().getColor(R.color.Purple);
                    break;
                case 3: super.setTheme(R.style.DeepPurple);
                    color = getResources().getColor(R.color.DeepPurple);
                    break;
                case 4: super.setTheme(R.style.Indigo);
                    color = getResources().getColor(R.color.Indigo);
                    break;
                case 5: super.setTheme(R.style.Blue);
                    color = getResources().getColor(R.color.Blue);
                    break;
                case 6: super.setTheme(R.style.LightBlue);
                    color = getResources().getColor(R.color.LightBlue);
                    break;
                case 7: super.setTheme(R.style.Cyan);
                    color = getResources().getColor(R.color.Cyan);
                    break;
                case 8: super.setTheme(R.style.Teal);
                    color = getResources().getColor(R.color.Teal);
                    break;
                case 9: super.setTheme(R.style.Green);
                    color = getResources().getColor(R.color.Green);
                    break;
                case 10: super.setTheme(R.style.LightGreen);
                    color = getResources().getColor(R.color.LightGreen);
                    break;
                case 11: super.setTheme(R.style.Lime);
                    color = getResources().getColor(R.color.Lime);
                    break;
                case 12: super.setTheme(R.style.Yellow);
                    color = getResources().getColor(R.color.Yellow);
                    break;
                case 13: super.setTheme(R.style.Amber);
                    color = getResources().getColor(R.color.Amber);
                    break;
                case 14: super.setTheme(R.style.Orange);
                    color = getResources().getColor(R.color.Orange);
                    break;
                case 15: super.setTheme(R.style.DeepOrange);
                    color = getResources().getColor(R.color.DeepOrange);
                    break;
                case 16: super.setTheme(R.style.Brown);
                    color = getResources().getColor(R.color.Brown);
                    break;
                case 17: super.setTheme(R.style.Grey);
                    color = getResources().getColor(R.color.Grey);
                    break;
                case 18: super.setTheme(R.style.BlueGrey);
                    color = getResources().getColor(R.color.BlueGrey);
                    break;
                case 19: super.setTheme(R.style.PurpleGrey);
                    color = getResources().getColor(R.color.PurpleGrey);
                    break;
            }
        }

        setContentView(R.layout.activity_note_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titleEditText = findViewById(R.id.titleEditText);
        textEditText = findViewById(R.id.textEditText);
        typeRadioGroup = findViewById(R.id.typeRadioGroup);
        addNote = findViewById(R.id.addNoteButton);
        addNote.setOnClickListener(this);

        main = findViewById(R.id.textViewMain);
        main.setTextColor(color);
        mark = findViewById(R.id.textViewMark);
        mark.setTextColor(color);

        if(change) {
            getSupportActionBar().setTitle(groups.get(position).getNotes().get(pos).getName());
            titleEditText.setText(groups.get(position).getNotes().get(pos).getName());
            textEditText.setText(groups.get(position).getNotes().get(pos).getText());
            ((RadioButton) typeRadioGroup.getChildAt(groups.get(position).getNotes().get(pos).getType())).setChecked(true);
            addNote.setText(R.string.notechange);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addNoteButton:
                if(titleEditText.getText().length() >= titleEditText.getMinCharacters() && titleEditText.getText().length() <= titleEditText.getMaxCharacters()
                        && textEditText.getText().length() >= textEditText.getMinCharacters() && textEditText.getText().length() <= textEditText.getMaxCharacters()) {
                    Calendar calendar = Calendar.getInstance();
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH);
                    int year = calendar.get(Calendar.YEAR);
                    month++;
                    String date = day + "." + month + "." + year;

                    int radioButtonID = typeRadioGroup.getCheckedRadioButtonId();
                    View radioButton = typeRadioGroup.findViewById(radioButtonID);
                    int idx = typeRadioGroup.indexOfChild(radioButton);

                    Note note = new Note(titleEditText.getText().toString(), textEditText.getText().toString(), date, idx);
                    if(!change)
                        newNote(this, position, 0, note);
                    else {
                        groups.get(position).getNotes().get(pos).setName(titleEditText.getText().toString());
                        groups.get(position).getNotes().get(pos).setText(textEditText.getText().toString());
                        groups.get(position).getNotes().get(pos).setType(idx);
                        changeNote(this, pos);
                    }
                    groupAdapter.notifyDataSetChanged();
                    this.finish();
                }
                else
                    Toast.makeText(NoteAddActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
