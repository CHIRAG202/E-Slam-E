package eslamee.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

import eslamee.lib.network.BaseResponse;

/**
 * Created by Manjeet Singh on 7/26/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResultModel extends BaseResponse {

    ArrayList<TokenResponseModel> token;

    public ArrayList<TokenResponseModel> getToken() {
        return token;
    }

    public void setToken(ArrayList<TokenResponseModel> token) {
        this.token = token;
    }
}
