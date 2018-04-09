package com.bnull.yourreview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static com.bnull.yourreview.GroupActivity.changeGroup;
import static com.bnull.yourreview.GroupActivity.groups;
import static com.bnull.yourreview.GroupActivity.newGroup;

public class GroupAddActivity extends AppCompatActivity implements View.OnClickListener {

    public int position = -1;
    public int color;
    public int icon;

    com.rengwuxian.materialedittext.MaterialEditText title;

    ImageView iconViewRed;
    ImageView iconViewPink;
    ImageView iconViewPurple;
    ImageView iconViewDeepPurple;
    ImageView iconViewIndigo;
    ImageView iconViewBlue;
    ImageView iconViewLightBlue;
    ImageView iconViewCyan;
    ImageView iconViewTeal;
    ImageView iconViewGreen;
    ImageView iconViewLightGreen;
    ImageView iconViewLime;
    ImageView iconViewYellow;
    ImageView iconViewAmber;
    ImageView iconViewOrange;
    ImageView iconViewDeepOrange;
    ImageView iconViewBrown;
    ImageView iconViewGrey;
    ImageView iconViewBlueGrey;
    ImageView iconViewPurpleGrey;

    ImageView imageViewRed;
    ImageView imageViewPink;
    ImageView imageViewPurple;
    ImageView imageViewDeepPurple;
    ImageView imageViewIndigo;
    ImageView imageViewBlue;
    ImageView imageViewLightBlue;
    ImageView imageViewCyan;
    ImageView imageViewTeal;
    ImageView imageViewGreen;
    ImageView imageViewLightGreen;
    ImageView imageViewLime;
    ImageView imageViewYellow;
    ImageView imageViewAmber;
    ImageView imageViewOrange;
    ImageView imageViewDeepOrange;
    ImageView imageViewBrown;
    ImageView imageViewGrey;
    ImageView imageViewBlueGrey;
    ImageView imageViewPurpleGrey;

    ImageView imageView0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView imageView17;
    ImageView imageView18;
    ImageView imageView19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title = findViewById(R.id.title);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);

        iconViewRed = findViewById(R.id.iconViewRed);
        imageViewRed = findViewById(R.id.imageViewRed);
        imageViewRed.setOnClickListener(this);
        iconViewPink = findViewById(R.id.iconViewPink);
        imageViewPink = findViewById(R.id.imageViewPink);
        imageViewPink.setOnClickListener(this);
        iconViewPurple = findViewById(R.id.iconViewPurple);
        imageViewPurple = findViewById(R.id.imageViewPurple);
        imageViewPurple.setOnClickListener(this);
        iconViewDeepPurple = findViewById(R.id.iconViewDeepPurple);
        imageViewDeepPurple = findViewById(R.id.imageViewDeepPurple);
        imageViewDeepPurple.setOnClickListener(this);
        iconViewIndigo = findViewById(R.id.iconViewIndigo);
        imageViewIndigo = findViewById(R.id.imageViewIndigo);
        imageViewIndigo.setOnClickListener(this);
        iconViewBlue = findViewById(R.id.iconViewBlue);
        imageViewBlue = findViewById(R.id.imageViewBlue);
        imageViewBlue.setOnClickListener(this);
        iconViewLightBlue = findViewById(R.id.iconViewLightBlue);
        imageViewLightBlue = findViewById(R.id.imageViewLightBlue);
        imageViewLightBlue.setOnClickListener(this);
        iconViewCyan = findViewById(R.id.iconViewCyan);
        imageViewCyan = findViewById(R.id.imageViewCyan);
        imageViewCyan.setOnClickListener(this);
        iconViewTeal = findViewById(R.id.iconViewTeal);
        imageViewTeal = findViewById(R.id.imageViewTeal);
        imageViewTeal.setOnClickListener(this);
        iconViewGreen = findViewById(R.id.iconViewGreen);
        imageViewGreen = findViewById(R.id.imageViewGreen);
        imageViewGreen.setOnClickListener(this);
        iconViewLightGreen = findViewById(R.id.iconViewLightGreen);
        imageViewLightGreen = findViewById(R.id.imageViewLightGreen);
        imageViewLightGreen.setOnClickListener(this);
        iconViewLime = findViewById(R.id.iconViewLime);
        imageViewLime = findViewById(R.id.imageViewLime);
        imageViewLime.setOnClickListener(this);
        iconViewYellow = findViewById(R.id.iconViewYellow);
        imageViewYellow = findViewById(R.id.imageViewYellow);
        imageViewYellow.setOnClickListener(this);
        iconViewAmber = findViewById(R.id.iconViewAmber);
        imageViewAmber = findViewById(R.id.imageViewAmber);
        imageViewAmber.setOnClickListener(this);
        iconViewOrange = findViewById(R.id.iconViewOrange);
        imageViewOrange = findViewById(R.id.imageViewOrange);
        imageViewOrange.setOnClickListener(this);
        iconViewDeepOrange = findViewById(R.id.iconViewDeepOrange);
        imageViewDeepOrange = findViewById(R.id.imageViewDeepOrange);
        imageViewDeepOrange.setOnClickListener(this);
        iconViewBrown = findViewById(R.id.iconViewBrown);
        imageViewBrown = findViewById(R.id.imageViewBrown);
        imageViewBrown.setOnClickListener(this);
        iconViewGrey = findViewById(R.id.iconViewGrey);
        imageViewGrey = findViewById(R.id.imageViewGrey);
        imageViewGrey.setOnClickListener(this);
        iconViewBlueGrey = findViewById(R.id.iconViewBlueGrey);
        imageViewBlueGrey = findViewById(R.id.imageViewBlueGrey);
        imageViewBlueGrey.setOnClickListener(this);
        iconViewPurpleGrey = findViewById(R.id.iconViewPurpleGrey);
        imageViewPurpleGrey = findViewById(R.id.imageViewPurpleGrey);
        imageViewPurpleGrey.setOnClickListener(this);

        imageView0 = findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);
        imageView16 = findViewById(R.id.imageView16);
        imageView17 = findViewById(R.id.imageView17);
        imageView18 = findViewById(R.id.imageView18);
        imageView19 = findViewById(R.id.imageView19);

        imageView0.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);
        imageView8.setOnClickListener(this);
        imageView9.setOnClickListener(this);
        imageView10.setOnClickListener(this);
        imageView11.setOnClickListener(this);
        imageView12.setOnClickListener(this);
        imageView13.setOnClickListener(this);
        imageView14.setOnClickListener(this);
        imageView15.setOnClickListener(this);
        imageView16.setOnClickListener(this);
        imageView17.setOnClickListener(this);
        imageView18.setOnClickListener(this);
        imageView19.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            position = getIntent().getExtras().getInt("position");
            title.setText(groups.get(position).getName());
            setColorGroup(groups.get(position).getColorId());
            setIconGroup(groups.get(position).getIconId());
            button.setText(R.string.groupchange);
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

    private void setColorGroup(int pos) {
        switch (color) {
            case 0:
                iconViewRed.setVisibility(View.GONE);
                break;
            case 1:
                iconViewPink.setVisibility(View.GONE);
                break;
            case 2:
                iconViewPurple.setVisibility(View.GONE);
                break;
            case 3:
                iconViewDeepPurple.setVisibility(View.GONE);
                break;
            case 4:
                iconViewIndigo.setVisibility(View.GONE);
                break;
            case 5:
                iconViewBlue.setVisibility(View.GONE);
                break;
            case 6:
                iconViewLightBlue.setVisibility(View.GONE);
                break;
            case 7:
                iconViewCyan.setVisibility(View.GONE);
                break;
            case 8:
                iconViewTeal.setVisibility(View.GONE);
                break;
            case 9:
                iconViewGreen.setVisibility(View.GONE);
                break;
            case 10:
                iconViewLightGreen.setVisibility(View.GONE);
                break;
            case 11:
                iconViewLime.setVisibility(View.GONE);
                break;
            case 12:
                iconViewYellow.setVisibility(View.GONE);
                break;
            case 13:
                iconViewAmber.setVisibility(View.GONE);
                break;
            case 14:
                iconViewOrange.setVisibility(View.GONE);
                break;
            case 15:
                iconViewDeepOrange.setVisibility(View.GONE);
                break;
            case 16:
                iconViewBrown.setVisibility(View.GONE);
                break;
            case 17:
                iconViewGrey.setVisibility(View.GONE);
                break;
            case 18:
                iconViewBlueGrey.setVisibility(View.GONE);
                break;
            case 19:
                iconViewPurpleGrey.setVisibility(View.GONE);
                break;
        }

        switch (pos) {
            case 0:
                iconViewRed.setVisibility(View.VISIBLE);
                break;
            case 1:
                iconViewPink.setVisibility(View.VISIBLE);
                break;
            case 2:
                iconViewPurple.setVisibility(View.VISIBLE);
                break;
            case 3:
                iconViewDeepPurple.setVisibility(View.VISIBLE);
                break;
            case 4:
                iconViewIndigo.setVisibility(View.VISIBLE);
                break;
            case 5:
                iconViewBlue.setVisibility(View.VISIBLE);
                break;
            case 6:
                iconViewLightBlue.setVisibility(View.VISIBLE);
                break;
            case 7:
                iconViewCyan.setVisibility(View.VISIBLE);
                break;
            case 8:
                iconViewTeal.setVisibility(View.VISIBLE);
                break;
            case 9:
                iconViewGreen.setVisibility(View.VISIBLE);
                break;
            case 10:
                iconViewLightGreen.setVisibility(View.VISIBLE);
                break;
            case 11:
                iconViewLime.setVisibility(View.VISIBLE);
                break;
            case 12:
                iconViewYellow.setVisibility(View.VISIBLE);
                break;
            case 13:
                iconViewAmber.setVisibility(View.VISIBLE);
                break;
            case 14:
                iconViewOrange.setVisibility(View.VISIBLE);
                break;
            case 15:
                iconViewDeepOrange.setVisibility(View.VISIBLE);
                break;
            case 16:
                iconViewBrown.setVisibility(View.VISIBLE);
                break;
            case 17:
                iconViewGrey.setVisibility(View.VISIBLE);
                break;
            case 18:
                iconViewBlueGrey.setVisibility(View.VISIBLE);
                break;
            case 19:
                iconViewPurpleGrey.setVisibility(View.VISIBLE);
                break;
        }

        color = pos;
    }

    private void setIconGroup(int pos) {
        switch (icon) {
            case 0:
                imageView0.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 1:
                imageView1.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 2:
                imageView2.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 3:
                imageView3.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 4:
                imageView4.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 5:
                imageView5.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 6:
                imageView6.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 7:
                imageView7.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 8:
                imageView8.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 9:
                imageView9.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 10:
                imageView10.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 11:
                imageView11.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 12:
                imageView12.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 13:
                imageView13.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 14:
                imageView14.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 15:
                imageView15.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 16:
                imageView16.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 17:
                imageView17.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 18:
                imageView18.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 19:
                imageView19.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.Grey), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
        }

        switch (pos) {
            case 0:
                imageView0.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 1:
                imageView1.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 2:
                imageView2.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 3:
                imageView3.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 4:
                imageView4.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 5:
                imageView5.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 6:
                imageView6.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 7:
                imageView7.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 8:
                imageView8.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 9:
                imageView9.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 10:
                imageView10.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 11:
                imageView11.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 12:
                imageView12.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 13:
                imageView13.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 14:
                imageView14.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 15:
                imageView15.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 16:
                imageView16.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 17:
                imageView17.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 18:
                imageView18.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
            case 19:
                imageView19.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                break;
        }

        icon = pos;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if(title.getText().length() >= title.getMinCharacters() && title.getText().length() <= title.getMaxCharacters()) {
                    if(position == -1) {
                        Group group = new Group(title.getText().toString(), color, icon);
                        newGroup(this, 0, group);
                    }
                    else {
                        groups.get(position).setName(title.getText().toString());
                        groups.get(position).setColor(color);
                        groups.get(position).setIcon(icon);
                        changeGroup(this, position);
                    }
                    this.finish();
                }
                else
                    Toast.makeText(GroupAddActivity.this, R.string.error, Toast.LENGTH_LONG).show();
                break;
            case R.id.imageViewRed:
                setColorGroup(0);
                break;
            case R.id.imageViewPink:
                setColorGroup(1);
                break;
            case R.id.imageViewPurple:
                setColorGroup(2);
                break;
            case R.id.imageViewDeepPurple:
                setColorGroup(3);
                break;
            case R.id.imageViewIndigo:
                setColorGroup(4);
                break;
            case R.id.imageViewBlue:
                setColorGroup(5);
                break;
            case R.id.imageViewLightBlue:
                setColorGroup(6);
                break;
            case R.id.imageViewCyan:
                setColorGroup(7);
                break;
            case R.id.imageViewTeal:
                setColorGroup(8);
                break;
            case R.id.imageViewGreen:
                setColorGroup(9);
                break;
            case R.id.imageViewLightGreen:
                setColorGroup(10);
                break;
            case R.id.imageViewLime:
                setColorGroup(11);
                break;
            case R.id.imageViewYellow:
                setColorGroup(12);
                break;
            case R.id.imageViewAmber:
                setColorGroup(13);
                break;
            case R.id.imageViewOrange:
                setColorGroup(14);
                break;
            case R.id.imageViewDeepOrange:
                setColorGroup(15);
                break;
            case R.id.imageViewBrown:
                setColorGroup(16);
                break;
            case R.id.imageViewGrey:
                setColorGroup(17);
                break;
            case R.id.imageViewBlueGrey:
                setColorGroup(18);
                break;
            case R.id.imageViewPurpleGrey:
                setColorGroup(19);
                break;
            case R.id.imageView0:
                setIconGroup(0);
                break;
            case R.id.imageView1:
                setIconGroup(1);
                break;
            case R.id.imageView2:
                setIconGroup(2);
                break;
            case R.id.imageView3:
                setIconGroup(3);
                break;
            case R.id.imageView4:
                setIconGroup(4);
                break;
            case R.id.imageView5:
                setIconGroup(5);
                break;
            case R.id.imageView6:
                setIconGroup(6);
                break;
            case R.id.imageView7:
                setIconGroup(7);
                break;
            case R.id.imageView8:
                setIconGroup(8);
                break;
            case R.id.imageView9:
                setIconGroup(9);
                break;
            case R.id.imageView10:
                setIconGroup(10);
                break;
            case R.id.imageView11:
                setIconGroup(11);
                break;
            case R.id.imageView12:
                setIconGroup(12);
                break;
            case R.id.imageView13:
                setIconGroup(13);
                break;
            case R.id.imageView14:
                setIconGroup(14);
                break;
            case R.id.imageView15:
                setIconGroup(15);
                break;
            case R.id.imageView16:
                setIconGroup(16);
                break;
            case R.id.imageView17:
                setIconGroup(17);
                break;
            case R.id.imageView18:
                setIconGroup(18);
                break;
            case R.id.imageView19:
                setIconGroup(19);
                break;
        }
    }
}
