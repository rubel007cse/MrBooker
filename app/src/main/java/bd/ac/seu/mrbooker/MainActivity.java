package bd.ac.seu.mrbooker;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.bookicon);

        viewPager = findViewById(R.id.myViewPager);
        setupViewPager(viewPager);

        tabLayout =  findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



    }


    private void setupViewPager(ViewPager viewPager) {
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager());


        adapter.addFragment(new TodaysBookings(), "Today");
        adapter.addFragment(new TomoBookings(), "Tomorrow");
        adapter.addFragment(new ThisWeek(), "This Week");


        viewPager.setAdapter(adapter);
    }

}
