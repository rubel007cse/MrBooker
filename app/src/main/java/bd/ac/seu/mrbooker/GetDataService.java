package bd.ac.seu.mrbooker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos() ;

    @POST("/posts")
    @FormUrlEncoded
    Call<POSTData> savePost(
            @Field("title") String title,
            @Field("body") String body,
            @Field("userId") int userId
    );

}
