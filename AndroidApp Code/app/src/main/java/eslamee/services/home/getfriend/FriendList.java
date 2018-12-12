package eslamee.services.home.getfriend;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import eslamee.R;
import eslamee.models.FriendListModel;
import eslamee.models.Response_alpha;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Manjeet Singh on 7/27/2018.
 */

public class FriendList extends AppCompatActivity implements Callback<Response_alpha> {
    RecyclerView alpha;

    Response_alpha res;
    List<FriendListModel> list;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.alphaemp);
        alpha = (RecyclerView) findViewById(R.id.alpharec);
        context  = getApplicationContext();

        // or just use getApplication context
        getdata();

    }
    public void getdata() {
        // Bundle bundle1 = getArguments();
        //String email = bundle1.getString("email",null);
        SharedPreferences shrd  = getSharedPreferences(getResources().getString(R.string.app_name),Context.MODE_PRIVATE);
        String email = shrd.getString("email",null);


        String endPoint = "";
        String attach = String.valueOf(AlphabetFragment.selected) + "&" + email;
        endPoint = endPoint.concat(attach);
        //endPoint = endPoint.concat("/" + email);


        //   loading = ProgressDialog.show(context,"Data Loading","Please wait .. ");

        Retrofit retrofit = new Retrofit.Builder()// R hits the link.. and converts the raw to iss type. widout R fit. no converter.
                .baseUrl("https://e-slam-ee.herokuapp.com/friends/find_by_initial/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        API_alpha api = retrofit.create(API_alpha.class);
        Call<Response_alpha> call = api.getRes(endPoint);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Response_alpha> call, Response<Response_alpha> response) { // call response functions.

        if(response==null) {
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
        } else {
            try {
                res = response.body();
                list = res.getResponse();
                showData();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showData() {
        alpha.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this); // manager which will help in making adapter.
        llm.setOrientation(LinearLayoutManager.VERTICAL);  // orientation
        alpha.setLayoutManager(llm);
        alpha.setAdapter(new FriendListAdapter(list,context)); // call addapter.
    }

    @Override
    public void onFailure(Call<Response_alpha> call, Throwable t) {

        Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();

    }
}
