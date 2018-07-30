package bd.ac.seu.mrbooker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class VpAdapter extends FragmentPagerAdapter {


    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();


    VpAdapter (FragmentManager fragmentManager){
        super(fragmentManager);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }



    @Override
    public Fragment getItem(int position) {

        return mFragmentList.get(position);


    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }


    // to show text in the tabs

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }


}
