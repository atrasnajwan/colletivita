package mafia.kegiatanmahasiswa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

public class Beranda extends Fragment{

    private SampleFragmentPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private PagerSlidingTabStrip mTab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        mTab = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        mViewPager = (ViewPager) view.findViewById(R.id.pager);
        mAdapter= new SampleFragmentPagerAdapter(getChildFragmentManager());

        mViewPager.setAdapter(mAdapter);

        mTab.setViewPager(mViewPager);


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setHasOptionsMenu(true);
     //   ((AppCompatActivity)getActivity()).getSupportActionBar();



    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
      //  inflater.inflate(R.menu.menu_mhs_home, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            //Do whatever you want to do
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        private final String[] TITLES = { "Sekarang", "Segera", "Terdahulu" };
        public SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }
        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int index) {
            switch (index) {
                case 0:
                    return PostinganPublik.newInstance("Sekarang");
                case 1:
                    return PostinganPublik.newInstance("Segera");
                case 2:
                    return PostinganPublik.newInstance("Terdahulu");
            }
            return null;
        }
    }

}
