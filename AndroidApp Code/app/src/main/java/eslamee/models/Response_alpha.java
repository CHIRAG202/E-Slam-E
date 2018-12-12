package eslamee.models;

import java.util.List;

/**
 * Created by Manjeet Singh on 7/27/2018.
 */

public class Response_alpha {

    private List<FriendListModel> response; // "response" is name of " " from backend and thn right click -> generate -> getter and setter

    public List<FriendListModel> getResponse() {
        return response;
    }

    public void setResponse(List<FriendListModel> response) {
        this.response = response;
    }
}