package com.bnull.yourreview.models;

import com.bnull.yourreview.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {

    private ArrayList<Note> notes;
    private String name;
    private int color;
    private int icon;

    public Group(String name, int color, int icon) {
        this.notes = new ArrayList<>();
        this.name = name;
        this.color = color;
        this.icon = icon;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public int getArrayListSize() {
        return notes.size();
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        switch (color) {
            case 0: return R.color.Red;
            case 1: return R.color.Pink;
            case 2: return R.color.Purple;
            case 3: return R.color.DeepPurple;
            case 4: return R.color.Indigo;
            case 5: return R.color.Blue;
            case 6: return R.color.LightBlue;
            case 7: return R.color.Cyan;
            case 8: return R.color.Teal;
            case 9: return R.color.Green;
            case 10: return R.color.LightGreen;
            case 11: return R.color.Lime;
            case 12: return R.color.Yellow;
            case 13: return R.color.Amber;
            case 14: return R.color.Orange;
            case 15: return R.color.DeepOrange;
            case 16: return R.color.Brown;
            case 17: return R.color.Grey;
            case 18: return R.color.BlueGrey;
            case 19: return R.color.PurpleGrey;
            default: return R.color.Red;
        }
    }

    public int getColorId() {
        return color;
    }

    public int getIcon() {
        switch (icon) {
            case 0: return R.drawable.ic_book_black_24dp;
            case 1: return R.drawable.ic_extension_black_24dp;
            case 2: return R.drawable.ic_face_black_24dp;
            case 3: return R.drawable.ic_favorite_black_24dp;
            case 4: return R.drawable.ic_filter_vintage_black_24dp;
            case 5: return R.drawable.ic_fitness_center_black_24dp;
            case 6: return R.drawable.ic_language_black_24dp;
            case 7: return R.drawable.ic_layers_black_24dp;
            case 8: return R.drawable.ic_local_bar_black_24dp;
            case 9: return R.drawable.ic_local_pizza_black_24dp;
            case 10: return R.drawable.ic_movie_black_24dp;
            case 11: return R.drawable.ic_music_note_black_24dp;
            case 12: return R.drawable.ic_near_me_black_24dp;
            case 13: return R.drawable.ic_school_black_24dp;
            case 14: return R.drawable.ic_shop_black_24dp;
            case 15: return R.drawable.ic_store_black_24dp;
            case 16: return R.drawable.ic_terrain_black_24dp;
            case 17: return R.drawable.ic_verified_user_black_24dp;
            case 18: return R.drawable.ic_whatshot_black_24dp;
            case 19: return R.drawable.ic_work_black_24dp;
            default: return R.drawable.ic_book_black_24dp;
        }
    }

    public int getIconId() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
