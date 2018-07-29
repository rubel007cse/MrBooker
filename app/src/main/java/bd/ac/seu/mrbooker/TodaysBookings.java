package bd.ac.seu.mrbooker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TodaysBookings extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.today_fragment,
                container, false);


        TextView textView = v.findViewById(R.id.tv);

        textView.setText("Todayyyyyyyyyyyys Fragment");

        return v;
    }
}
