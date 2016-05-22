package org.empires.baham.kac.animelis.ui.details;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.empires.baham.kac.animelis.R;
import org.empires.baham.kac.animelis.adapters.ItemCategoryAdapter;
import org.empires.baham.kac.animelis.model.ItemCategory;
import org.empires.baham.kac.animelis.model.Person;
import org.empires.baham.kac.animelis.ui.AddCategoryDialogFragment;
import org.empires.baham.kac.animelis.utils.Logg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Chatofrey on 22/05/2016.
 * chatofrey@gmail.com
 * Animelis
 */
public class AnimeDetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<ItemCategory> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.item_category_rv);
        Logg.d(AnimeDetailActivity.class.getSimpleName(), "Inside onCreate()");
        items = dataSet();
        assert items != null;

        final ItemCategoryAdapter adapter = new ItemCategoryAdapter(items);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(adapter);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_item_detail);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCategoryDialogFragment dialog = AddCategoryDialogFragment.newInstance();
                dialog.show(getSupportFragmentManager(), AnimeDetailActivity.class.getSimpleName());
            }
        });
    }

    private List<ItemCategory> dataSet() {
        List<ItemCategory> items = new ArrayList<>();
        items.add(new ItemCategory("Boku No Hero Academia", new Date(), new Person("Anonymous")));
        items.add(new ItemCategory("Koutetsujou No Kabaneri", new Date(), new Person("Anonymous2")));
        items.add(new ItemCategory("Jojo's Bizare Adventure", new Date(), new Person("Anonymous3")));

        return items;
    }
}
