package hiefie.com.tabbardemo;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hiefie.com.tabbardemo.R;
import hiefie.com.tabbardemo.fragment_one;
import hiefie.com.tabbardemo.fragment_two;
import hiefie.com.tabbardemo.fragment_three;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the toolbar and set up the support action bar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Method to remove the back arrow from the title.
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        //Initialize the view pager and set it up.
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        //Initialize the tab layout and set it up
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Function to set up the tab icons.
        setupTabIcons();
    }

    //Set up the tab icons using custom text view.
    private void setupTabIcons() {

        //Declare and inflate the text view.
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("One"); //Set the text.
        tabOne.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_favorite_white_24dp, 0, 0, 0); //Set the position of the icon.
        tabLayout.getTabAt(0).setCustomView(tabOne); //Set the textview as a tab at first position.

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Two");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_language_white_24dp, 0, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Three");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_grade_white_24dp, 0, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment_one(), "ONE");
        adapter.addFragment(new fragment_two(), "TWO");
        adapter.addFragment(new fragment_three(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<android.support.v4.app.Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position)
        {
            return  mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(android.support.v4.app.Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
