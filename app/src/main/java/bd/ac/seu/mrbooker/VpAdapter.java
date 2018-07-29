package bd.ac.seu.mrbooker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class VpAdapter extends FragmentPagerAdapter {

    VpAdapter (FragmentManager fragmentManager){
        super(fragmentManager);
    }


    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new TodaysBookings();

            case 1:
                return new TomoBookings();

            case 2:
                return new TodaysBookings();

            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return 3;
    }
}
