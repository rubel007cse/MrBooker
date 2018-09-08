package bd.ac.seu.mrbooker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class TodaysBookings extends Fragment {

    GetDataService service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.today_fragment,
                container, false);


        final EditText title = v.findViewById(R.id.posttitle);
        final EditText pbody = v.findViewById(R.id.postbody);
        Button addpost = v.findViewById(R.id.addpost);

        service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        addpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // sending data
                sendPost(title.getText().toString() , pbody.getText().toString());


            }
        });

        return v;
    }



    public void sendPost(String title, String body) {
        service.savePost(title, body, 1).enqueue(new Callback<POSTData>() {
            @Override
            public void onResponse(Call<POSTData> call, Response<POSTData> response) {

                if(response.isSuccessful()) {

                    Log.d("Response","Response: "+response.body().toString());
                    Log.d(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<POSTData> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }


}
