package org.empires.baham.kac.animelis.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.empires.baham.kac.animelis.R;
import org.empires.baham.kac.animelis.model.ItemCategory;

import java.util.List;

/**
 * Created by Chatofrey on 22/05/2016.
 * chatofrey@gmail.com
 * Animelis
 */
public class ItemCategoryAdapter extends RecyclerView.Adapter<ItemCategoryAdapter.ItemCategoryViewHolder>  {

    private List<ItemCategory> items;
    public ItemCategoryAdapter(List<ItemCategory> items) {
        this.items = items;
    }

    @Override
    public ItemCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_detail_cardview, parent, false);
        return new ItemCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemCategoryViewHolder holder, int position) {
        ItemCategory item = items.get(position);
        holder.animeNameTextView.setText(item.getName());
        holder.publicationDateTextView.setText(item.getPublicationDate().toString());
        holder.ownerTextView.setText(item.getOwner().getName());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemCategoryViewHolder extends RecyclerView.ViewHolder {
        public CardView animeDetailCardview;
        public TextView publicationDateTextView;
        public TextView ownerTextView;
        public TextView animeNameTextView;

        public ItemCategoryViewHolder(View itemView) {
            super(itemView);
            animeDetailCardview = (CardView)itemView.findViewById(R.id.anime_detail_cardview);
            publicationDateTextView = (TextView) itemView.findViewById(R.id.publication_date);
            ownerTextView = (TextView)itemView.findViewById(R.id.owner);
            animeNameTextView = (TextView)itemView.findViewById(R.id.anime_item_name);
        }
    }
}
