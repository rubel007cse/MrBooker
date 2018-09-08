package bd.ac.seu.mrbooker;


import com.google.gson.annotations.SerializedName;

public class POSTData {

    @SerializedName("title")

    private String title;
    @SerializedName("body")
    private String body;
    @SerializedName("userId")
    private Integer userId;
    @SerializedName("id")
    private Integer id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Data passed! Data: "+title+", "+body;

        //The toString() method returns the string representation
        // of the object. If you print any object, java compiler
        // internally invokes the toString() method on the object.
        // ... By overriding the toString() method of the Object class,
        // we can return values of the object, so we don't need to
        // write much code.
    }
}