package com.bnull.yourreview.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bnull.yourreview.ui.GroupAddActivity;
import com.bnull.yourreview.ui.NoteActivity;
import com.bnull.yourreview.R;
import com.bnull.yourreview.models.Group;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import static com.bnull.yourreview.ui.GroupActivity.deleteGroup;
import static com.bnull.yourreview.ui.GroupActivity.newGroup;

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
        holder.size.setText(String.format(" %s", String.valueOf(groups.get(holder.getAdapterPosition()).getArrayListSize())));
        holder.imageView.setImageResource(groups.get(position).getColor());
        holder.iconImageView.setImageResource(groups.get(position).getIcon());
        holder.more.setOnClickListener((v) -> showPopupMenu(v, holder.getAdapterPosition()));
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(mInflater.getContext(), NoteActivity.class);
            intent.putExtra("position", holder.getAdapterPosition());
            mInflater.getContext().startActivity(intent);
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
        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu1:
                    Intent intent = new Intent(mInflater.getContext(), GroupAddActivity.class);
                    intent.putExtra("position", position);
                    mInflater.getContext().startActivity(intent);
                    return true;
                case R.id.menu2:
                    final Group group = groups.get(position);
                    Snackbar snackbar = Snackbar
                            .make(listView, mInflater.getContext().getString(R.string.deletemessage), Snackbar.LENGTH_LONG)
                            .setAction(mInflater.getContext().getString(R.string.cancel), view -> newGroup(mInflater.getContext(), position, group));
                    snackbar.show();
                    deleteGroup(mInflater.getContext(), position);
                    return true;
                default:
                    return false;
            }
        });

        popupMenu.setOnDismissListener(menu -> {
        });
        popupMenu.show();
    }
}
