package bd.ac.seu.mrbooker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TomoBookings extends Fragment {


    // All credit goes to: https://medium.com/@prakash_pun/retrofit-a-simple-android-tutorial-48437e4e5a23

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    View v;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.tomo_fragment,
                container, false);

        Toast.makeText(getActivity(), "Loading..", Toast.LENGTH_SHORT).show();


        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {

                generateDataList(response.body(), v);
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {

                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


        return v;

    }


    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroPhoto> photoList, View v) {
        recyclerView = v.findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(getActivity(), photoList);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}