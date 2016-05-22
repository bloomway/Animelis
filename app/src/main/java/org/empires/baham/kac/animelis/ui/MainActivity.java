package org.empires.baham.kac.animelis.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.empires.baham.kac.animelis.R;
import org.empires.baham.kac.animelis.adapters.CategoryAdapter;
import org.empires.baham.kac.animelis.model.Category;
import org.empires.baham.kac.animelis.ui.details.AnimeDetailActivity;
import org.empires.baham.kac.animelis.ui.details.MovieDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton mFab;

    private List<Category> mCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Inside onCreate of " + TAG);
        setContentView(R.layout.main);
        initScreen();

        mCategories = dataSet();
        CategoryAdapter adapter = new CategoryAdapter(mCategories);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View viewClicked, int position) {
                int childPosition = mRecyclerView.indexOfChild(viewClicked);
                final String catName = mCategories.get(position).getName();
                Intent intent = null;
                switch (position){
                    case 0:
                        intent = new Intent(viewClicked.getContext(), AnimeDetailActivity.class);
                        intent.putExtra(Intent.EXTRA_TEXT, "Hello from MainActivity");
                        break;
                    case 2:
                        intent = new Intent(viewClicked.getContext(), MovieDetailActivity.class);
                        intent.putExtra(Intent.EXTRA_TEXT, "Hello from MainActivity");
                        break;
                    default:
                        intent = new Intent(viewClicked.getContext(), CategoryDetailActivity.class);
                        break;
                }
                viewClicked.getContext().startActivity(intent);
                Toast.makeText(MainActivity.this, catName + " at position " + childPosition, Toast.LENGTH_LONG).show();
            }
        });
    }

    /*
        Initialize the screen
     */
    public void initScreen() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView =(RecyclerView) findViewById(R.id.ctg_rv);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCategoryDialogFragment dialog = AddCategoryDialogFragment.newInstance();
                dialog.show(getSupportFragmentManager(), TAG);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private List<Category> dataSet() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Animes"));
        categories.add(new Category("TVShow"));
        categories.add(new Category("Movies"));

        return categories;
    }

}
