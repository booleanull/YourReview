package com.bnull.yourreview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.bnull.yourreview.GroupActivity.deleteGroup;
import static com.bnull.yourreview.GroupActivity.newGroup;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private ArrayList<Group> groups;
    private LayoutInflater mInflater;
    private RecyclerView listView;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.group, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.name.setText(groups.get(position).getName());
        holder.size.setText(" " + String.valueOf(groups.get(holder.getAdapterPosition()).getArrayListSize()));
        holder.imageView.setImageResource(groups.get(position).getColor());
        holder.iconImageView.setImageResource(groups.get(position).getIcon());
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v, holder.getAdapterPosition());
            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mInflater.getContext(), NoteActivity.class);
                intent.putExtra("position", holder.getAdapterPosition());
                ((Activity) mInflater.getContext()).startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView name;
        public TextView size;
        public ImageButton more;
        public ImageView imageView;
        public ImageView iconImageView;

        ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            name = itemView.findViewById(R.id.nameTextView);
            size = itemView.findViewById(R.id.sizeTextView);
            more = itemView.findViewById(R.id.moreImageButton);
            imageView = itemView.findViewById(R.id.imageView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
        }
    }

    public GroupAdapter(@NonNull Context context, ArrayList<Group> groups, RecyclerView listView) {
        this.mInflater = LayoutInflater.from(context);
        this.groups = groups;
        this.listView = listView;
    }

    private void showPopupMenu(final View v, final int position) {
        final PopupMenu popupMenu = new PopupMenu(mInflater.getContext(), v);
        popupMenu.inflate(R.menu.group_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        Intent intent = new Intent(mInflater.getContext(), GroupAddActivity.class);
                        intent.putExtra("position", position);
                        ((Activity) mInflater.getContext()).startActivity(intent);
                        return true;
                    case R.id.menu2:
                        final Group group = groups.get(position);
                        Snackbar snackbar = Snackbar
                                .make(listView, mInflater.getContext().getString(R.string.deletemessage), Snackbar.LENGTH_LONG)
                                .setAction(mInflater.getContext().getString(R.string.cancel), new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        newGroup(mInflater.getContext(), position, group);
                                    }
                                });
                        snackbar.show();
                        deleteGroup(mInflater.getContext(), position);
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
            }
        });
        popupMenu.show();
    }
}
