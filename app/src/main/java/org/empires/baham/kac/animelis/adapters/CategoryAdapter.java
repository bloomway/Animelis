package org.empires.baham.kac.animelis.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.empires.baham.kac.animelis.model.Category;
import org.empires.baham.kac.animelis.utils.Logg;

import java.util.List;

/**
 * Created by Chatofrey on 28/04/2016.
 * chatofrey@gmail.com
 * Animelis
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    List<Category> mCategories;
    private static OnItemClickListener mListener;

    public CategoryAdapter(List<Category> categories) {
        this.mCategories = categories;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View rootView = LayoutInflater.from(parent.getContext())
               .inflate(org.empires.baham.kac.animelis.R.layout.card_layout, parent, false);
        //Logg.d(CategoryAdapter.class.getSimpleName(), ""+viewType);
        return new CategoryViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
            holder.categoryName.setText(mCategories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public CardView categoryCardView;
        public TextView categoryName;

        public CategoryViewHolder(View view){
            super(view);
            categoryCardView = (CardView) view.findViewById(org.empires.baham.kac.animelis.R.id.cardview);
            categoryName = (TextView) view.findViewById(org.empires.baham.kac.animelis.R.id.cv_ctg_name);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View viewClicked) {
                    if(mListener != null) {
                        mListener.onItemClick(viewClicked, getLayoutPosition());
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View viewClicked, int position);
    }
}
