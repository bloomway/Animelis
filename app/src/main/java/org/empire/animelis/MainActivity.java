package org.empire.animelis;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.empire.animelis.ui.anime.AnimeFragment;
import org.empire.animelis.ui.news.NewsFragment;
import org.empire.animelis.ui.tvshow.TVShowFragment;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Inside onCreate of " + TAG);
        setContentView(R.layout.main);
        initScreen();
    }

    /*
        Initialize the screen
     */
    public void initScreen() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        final ViewPager pager = (ViewPager) findViewById(R.id.viewPager);

        // create a viewPagerAdapter and set it up as an adapter on ViewPager
        final ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(pagerAdapter);

        /*
         * Setup tabLayout with ViewPager
         */
        tabs.setupWithViewPager(pager);

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

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = AnimeFragment.newInstance("animeFragment", "");
                    break;
                case 1:
                    fragment = TVShowFragment.newInstance("TVShowFragment", "");
                    break;
                case 2:
                    fragment = NewsFragment.newInstance("NewsFragment");
                    break;
                default:
                    fragment = AnimeFragment.newInstance("animeFragment", "");
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String tabTitle = "";
            switch(position) {
                case 0:
                    tabTitle = getString(R.string.anime_fragment_title);
                    break;
                case 1:
                    tabTitle = getString(R.string.tvshow_fragment_title);
                    break;
                case 2:
                    tabTitle = getString(R.string.news_fragment_title);
                    break;
            }
            return tabTitle;
        }
    }
}
