package com.bnull.yourreview.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bnull.yourreview.R;
import com.bnull.yourreview.models.Note;
import com.bnull.yourreview.ui.NoteAddActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import static com.bnull.yourreview.ui.GroupActivity.groupAdapter;
import static com.bnull.yourreview.ui.NoteActivity.deleteNote;
import static com.bnull.yourreview.ui.NoteActivity.newNote;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> implements Filterable {
    private ArrayList<Note> notes;

    private ArrayList<Note> mFilteredList;
    private LayoutInflater mInflater;
    private RecyclerView listView;

    private int color;
    private int pos;
    private int icon;

    public NoteAdapter(@NonNull Context context, ArrayList<Note> notes, RecyclerView listView, int color, int pos, int icon) {
        this.mInflater = LayoutInflater.from(context);
        this.notes = notes;
        mFilteredList = notes;
        this.listView = listView;
        this.color = color;
        this.pos = pos;
        this.icon = icon;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.title.setText(mFilteredList.get(position).getName());
        holder.text.setText(mFilteredList.get(position).getText());
        holder.date.setText(mFilteredList.get(position).getDate());
        holder.image.setColorFilter(mInflater.getContext().getResources().getColor(mFilteredList.get(position).getColor()));
        holder.icon.setImageResource(icon);

        holder.more.setOnClickListener(v -> showPopupMenu(v, holder.getAdapterPosition()));

        if (holder.text.getLineCount() >= 5) {
            holder.text.setMaxLines(4);
            holder.showText.setVisibility(View.VISIBLE);
            holder.show = true;
        }

        holder.text.post(() -> {
            if (holder.text.getLineCount() >= 5) {
                holder.text.setMaxLines(4);
                holder.showText.setVisibility(View.VISIBLE);
                holder.show = true;
            }
        });

        holder.textLayout.setOnClickListener(v -> {
            if (holder.show) {
                holder.text.setMaxLines(10000000);
                holder.showText.setText(R.string.hide);
                holder.show = false;
            } else {
                holder.text.setMaxLines(4);
                holder.showText.setText(R.string.showall);
                holder.show = true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView text;
        public TextView date;
        public ImageView image;
        public ImageView icon;
        public ImageView more;
        public LinearLayout textLayout;
        public TextView showText;

        public boolean show;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTextView);
            text = itemView.findViewById(R.id.textTextView);
            date = itemView.findViewById(R.id.dateTextView);
            showText = itemView.findViewById(R.id.showTextView);
            textLayout = itemView.findViewById(R.id.textLayout);
            image = itemView.findViewById(R.id.imageView);
            icon = itemView.findViewById(R.id.iconImageView);
            more = itemView.findViewById(R.id.moreImageButton);
        }
    }

    private void showPopupMenu(final View v, final int position) {
        PopupMenu popupMenu = new PopupMenu(mInflater.getContext(), v);
        popupMenu.inflate(R.menu.group_menu);
        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu1:
                    Intent intent = new Intent(mInflater.getContext(), NoteAddActivity.class);
                    intent.putExtra("pos", position);
                    intent.putExtra("position", pos);
                    intent.putExtra("change", true);
                    ((Activity) mInflater.getContext()).startActivityForResult(intent, 2);
                    return true;
                case R.id.menu2:
                    final Note note = mFilteredList.get(position);
                    Snackbar snackbar = Snackbar
                            .make(listView, mInflater.getContext().getString(R.string.deletemessagenotes), Snackbar.LENGTH_LONG)
                            .setAction(mInflater.getContext().getString(R.string.cancel), view -> {
                                newNote(mInflater.getContext(), pos, position, note);
                                groupAdapter.notifyDataSetChanged();
                            });
                    snackbar.show();
                    deleteNote(mInflater.getContext(), pos, position);
                    groupAdapter.notifyDataSetChanged();
                    return true;
                default:
                    return false;
            }
        });

        popupMenu.setOnDismissListener(menu -> {
        });
        popupMenu.show();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mFilteredList = notes;
                } else {
                    ArrayList<Note> filteredList = new ArrayList<>();
                    for (Note note : notes) {
                        if (note.getText().toLowerCase().contains(charString) || note.getName().toLowerCase().contains(charString) || note.getDate().toLowerCase().contains(charString)) {
                            filteredList.add(note);
                        }
                    }
                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Note>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}