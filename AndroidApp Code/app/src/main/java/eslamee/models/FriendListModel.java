package eslamee.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Manjeet Singh on 7/27/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendListModel {

    //private String image_url;
    private String pic;
    private String name;
    private String hobbies;
    private Long contact;
    private String _id;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public FriendListModel(){

        // this.image_url = null;
        this.name = null;
        this.hobbies= null;
        this.contact = null;


    }
    // make till here, then get and set.






    // public String getImage_url() {
//        return image_url;
//    }

    //public void setImage_url(String image_url) {
    //    this.image_url = image_url;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }
}
