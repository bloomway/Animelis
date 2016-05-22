package org.empires.baham.kac.animelis.ui.details;

import android.content.ClipData;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.empires.baham.kac.animelis.R;
import org.empires.baham.kac.animelis.adapters.ItemCategoryAdapter;
import org.empires.baham.kac.animelis.model.ItemCategory;
import org.empires.baham.kac.animelis.model.Person;
import org.empires.baham.kac.animelis.ui.AddCategoryDialogFragment;
import org.empires.baham.kac.animelis.utils.Logg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Logg.d(MovieDetailActivity.class.getSimpleName(), "Inside onCreate()");
        final List<ItemCategory> items = dataSet();
        mRecyclerView = (RecyclerView) findViewById(R.id.item_category_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);

        ItemCategoryAdapter adapter = new ItemCategoryAdapter(items);
        mRecyclerView.setAdapter(adapter);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_item_detail);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCategoryDialogFragment dialog = AddCategoryDialogFragment.newInstance();
                dialog.show(getSupportFragmentManager(), MovieDetailActivity.class.getSimpleName());
            }
        });
    }

    private List<ItemCategory> dataSet() {
        List<ItemCategory> items = new ArrayList<>();
        items.add(new ItemCategory("New Girl, S5E20", new Date(), new Person("Anonymous")));
        items.add(new ItemCategory("Rosewood S1E16", new Date(), new Person("Anonymous2")));
        items.add(new ItemCategory("Suits S5E12", new Date(), new Person("Anonymous3")));

        return items;
    }
}
