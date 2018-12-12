package eslamee.services.home.addfriend;

import eslamee.EslamEHomeResponse;
import eslamee.R;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import eslamee.lib.network.BaseResponse;
import eslamee.lib.network.NetworkLayer;
import eslamee.lib.network.OnNetworkResponseListener;
import eslamee.models.AddressInfoModel;
import eslamee.models.BasicInfoModel;
import eslamee.models.FunInfoModel;
import eslamee.models.TokenModel;
import eslamee.models.TokenResponseModel;
import eslamee.models.TokenResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;
import static eslamee.lib.network.NetworkService.EMERGENCY_API;

/**
 * Created by Manjeet Singh on 7/26/2018.
 */
public class AddInfo extends Fragment implements View.OnClickListener {

    BasicInfoModel model;
    LinearLayout tokenlayout;
    LinearLayout slamlayout;
    FunInfoModel modelfun;
    AddressInfoModel modeladdress;
    DatePicker simpleDatePicker;
    ArrayList<TokenResponseModel> tokenres;
    TokenResultModel tokenresult;
    String tokenmail;
    int finaltoken;
    ImageButton uplo;
    private static int IMAGE = 3000;
    private Context context;
    private NetworkLayer networkLayer;
    EditText eaddress, ecity, ecountry, estate, elandmark, epin, ename, ezodiac, epapa, emum, ebday, ehobby, eaims, emotto, edesc, emob, eemail, efavfood, efavsong, efavmovies, equote, esport, eembarr, efirlv, eopin, eplac, ealien, efive, emomen, eopinme, ebestme, ehappy, etoken;
    Button butu, tokenbutu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        context = inflater.getContext();

        final View view = inflater.inflate(R.layout.add_friend, container, false);

        model = new BasicInfoModel();
        modelfun = new FunInfoModel();
        modeladdress = new AddressInfoModel();
        if (networkLayer == null) {
            networkLayer = new NetworkLayer();
        }

        ename = (EditText) view.findViewById(R.id.name);
        ename.setOnClickListener(this);
        uplo = (ImageButton) view.findViewById(R.id.upload);
        uplo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), IMAGE);


                // your handler code here
            }
        });
        ezodiac = (EditText) view.findViewById(R.id.zodiac);
        ezodiac.setOnClickListener(this);
        epapa = (EditText) view.findViewById(R.id.dad);
        epapa.setOnClickListener(this);
        emum = (EditText) view.findViewById(R.id.mum);
        emum.setOnClickListener(this);

        ehobby = (EditText) view.findViewById(R.id.hobby);
        ehobby.setOnClickListener(this);
        eaims = (EditText) view.findViewById(R.id.aim);
        eaims.setOnClickListener(this);
        tokenlayout = (LinearLayout) view.findViewById(R.id.authlayout);
        slamlayout = (LinearLayout) view.findViewById(R.id.slamlayout);

        emotto = (EditText) view.findViewById(R.id.motto);
        emotto.setOnClickListener(this);
        edesc = (EditText) view.findViewById(R.id.describe);
        edesc.setOnClickListener(this);
        emob = (EditText) view.findViewById(R.id.mobile);
        emob.setOnClickListener(this);
        eemail = (EditText) view.findViewById(R.id.email);
        eemail.setOnClickListener(this);
        elandmark = (EditText) view.findViewById(R.id.landmark);
        elandmark.setOnClickListener(this);
        ecity = (EditText) view.findViewById(R.id.city);
        ecity.setOnClickListener(this);
        estate = (EditText) view.findViewById(R.id.state);
        estate.setOnClickListener(this);
        ecountry = (EditText) view.findViewById(R.id.country);
        ecountry.setOnClickListener(this);
        eaddress = (EditText) view.findViewById(R.id.home);
        eaddress.setOnClickListener(this);
        epin = (EditText) view.findViewById(R.id.pinc);
        epin.setOnClickListener(this);

        efavfood = (EditText) view.findViewById(R.id.food);
        efavfood.setOnClickListener(this);
        efavmovies = (EditText) view.findViewById(R.id.movie);
        efavmovies.setOnClickListener(this);
        efavsong = (EditText) view.findViewById(R.id.song);
        efavsong.setOnClickListener(this);
        esport = (EditText) view.findViewById(R.id.sport);
        esport.setOnClickListener(this);
        eopin = (EditText) view.findViewById(R.id.hardluck);
        eopin.setOnClickListener(this);
        eplac = (EditText) view.findViewById(R.id.place);
        eplac.setOnClickListener(this);
        equote = (EditText) view.findViewById(R.id.quote);
        equote.setOnClickListener(this);
        efirlv = (EditText) view.findViewById(R.id.love);
        efirlv.setOnClickListener(this);
        ealien = (EditText) view.findViewById(R.id.alien);
        ealien.setOnClickListener(this);
        eembarr = (EditText) view.findViewById(R.id.embarr);
        eembarr.setOnClickListener(this);
        eopinme = (EditText) view.findViewById(R.id.opinion);
        eopinme.setOnClickListener(this);
        emomen = (EditText) view.findViewById(R.id.changed);
        emomen.setOnClickListener(this);
        efive = (EditText) view.findViewById(R.id.five);
        efive.setOnClickListener(this);
        ehappy = (EditText) view.findViewById(R.id.happy);
        ehappy.setOnClickListener(this);
        simpleDatePicker = (DatePicker) view.findViewById(R.id.date); // initiate a date picker

        simpleDatePicker.setSpinnersShown(false);


        ebestme = (EditText) view.findViewById(R.id.best);
        ebestme.setOnClickListener(this);
//--------------------------------------------------------------
        // Mandates.
        // favfood = (TextView) findViewById(R.id.favFoodT);
        // favfood.setOnClickListener(this);
        // favmovies = (TextView) findViewById(R.id.favMoviesT);
        //favmovies.setOnClickListener(this);
        //favsong = (TextView) findViewById(R.id.favSongT);
        // favsong.setOnClickListener(this);
        // sport = (TextView) findViewById(R.id.sportT);
        // sport.setOnClickListener(this);
        // momen = (TextView) findViewById(R.id.momenT);
        // momen.setOnClickListener(this);
        // email = (TextView) findViewById(R.id.emailT);
        // email.setOnClickListener(this);
        // bday = (TextView) findViewById(R.id.BdayT);
        // bday.setOnClickListener(this);
        // name = (TextView) findViewById(R.id.NameT);
        // name.setOnClickListener(this);
        butu = (Button) view.findViewById(R.id.filledbutton);
        butu.setOnClickListener(this);
        tokenbutu = (Button) view.findViewById(R.id.tokenbutton);
        tokenbutu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String endpoint = getResources().getString(R.string.url_check_token) + "/" + etoken.getText().toString();
                HashMap<String, String> headers = new HashMap<String, String>();
                HashMap<String, String> query = new HashMap<String, String>();

                networkLayer.get(EMERGENCY_API, endpoint, headers, query, false, false, new OnNetworkResponseListener(TokenResultModel.class) {
                    @Override
                    public void onResponse(Object response) {

                        tokenresult = (TokenResultModel) response;
                        if (tokenresult.getToken().size() != 0) {
                            tokenres = tokenresult.getToken();
                            TokenResponseModel tokenresponse = tokenres.get(0);
                            tokenmail = tokenresponse.getEmail();
                            finaltoken = tokenresponse.getToken();
                            Toast.makeText(context, "Token Successfully Authenticated", Toast.LENGTH_SHORT).show();

                            tokenlayout.setVisibility(View.GONE);
                            model = new BasicInfoModel();
                            modeladdress = new AddressInfoModel();
                            modelfun = new FunInfoModel();
                            eaddress.getText().clear();
                            ecity.getText().clear();
                            esport.getText().clear();
                            efavfood.getText().clear();
                            etoken.getText().clear();
                            efirlv.getText().clear();
                            eaims.getText().clear();
                            ealien.getText().clear();
                            ebestme.getText().clear();
                            ecountry.getText().clear();
                            edesc.getText().clear();
                            eemail.getText().clear();
                            efavmovies.getText().clear();
                            efavsong.getText().clear();
                            efive.getText().clear();
                            ehappy.getText().clear();
                            eembarr.getText().clear();
                            elandmark.getText().clear();
                            emob.getText().clear();
                            ehobby.getText().clear();
                            ezodiac.getText().clear();
                            estate.getText().clear();
                            esport.getText().clear();
                            equote.getText().clear();
                            eplac.getText().clear();
                            epin.getText().clear();
                            eplac.getText().clear();
                            emomen.getText().clear();
                            emotto.getText().clear();
                            ename.getText().clear();
                            eopinme.getText().clear();
                            eopin.getText().clear();
                            epapa.getText().clear();
                            emum.getText().clear();

                            slamlayout.setVisibility(View.VISIBLE);


                        } else {
                            Toast.makeText(context, "Invalid Token, Try Again", Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onError(String error, int code) {

                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();

                    }
                });


                // your handler code here
            }
        });
        etoken = (EditText) view.findViewById(R.id.token);
        etoken.setOnClickListener(this);


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) { //
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE) {
                if (data != null) {
                    Uri imageUri = data.getData();
                    if (imageUri != null) {
                        Toast.makeText(context, " Image mil gai", Toast.LENGTH_SHORT).show();
                        get(imageUri);
                    }
                }
            }
        }
    }

    @SuppressWarnings("VisibleForTests")
    private void get(Uri imageUri) {
        StorageReference mStorageRef;
        mStorageRef = FirebaseStorage.getInstance().getReference();

        //Uri file = Uri.fromFile(new File(imageUri.toString()));
        int Min = 1;
        int Max = 1000000;
        int c = Min + (int) (Math.random() * ((Max - Min) + 1));
        StorageReference riversRef = mStorageRef.child("images" + c);

        riversRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        final Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        String urll = downloadUrl.toString();
                        model.setPic(urll);
                        //Toast.makeText(getBaseContext(), downloadUrl.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(context, "Bakchodi ho gai", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.filledbutton) {
//            model.setBday(ebday.getText().toString());
//            model.setEmail(eemail.getText().toString());
//            model.setFav_food(efavfood.getText().toString());
//            model.setFav_song(efavsong.getText().toString());
//            model.setHappy_moment(emomen.getText().toString());
//            model.setName(ename.getText().toString());
//            model.setFav_movie(efavmovies.getText().toString());
//            model.setFav_sport(esport.getText().toString());

            if (ename != null && !ename.getText().toString().equals("")) {


            } else {
                Toast.makeText(context, "Name is Mandatory", Toast.LENGTH_SHORT).show();
                return;
            }
            if (eemail != null && !eemail.getText().toString().equals("")) {


            } else {
                Toast.makeText(context, "E-Mail is Mandatory", Toast.LENGTH_SHORT).show();
                return;
            }
            if (efavfood != null && !efavfood.getText().toString().equals("")) {


            } else {
                Toast.makeText(context, "Favourite Food is Mandatory", Toast.LENGTH_SHORT).show();
                return;
            }
            if (efavmovies != null && !efavmovies.getText().toString().equals("")) {


            } else {
                Toast.makeText(context, "Favourite Movie is Mandatory", Toast.LENGTH_SHORT).show();
                return;
            }
            if (efavsong != null && !efavsong.getText().toString().equals("")) {


            } else {
                Toast.makeText(context, "Favourite Song is Mandatory", Toast.LENGTH_SHORT).show();
                return;
            }
            if (esport != null && !esport.getText().toString().equals("")) {


            } else {
                Toast.makeText(context, "Favourite Sport is Mandatory", Toast.LENGTH_SHORT).show();
                return;
            }
            if (ehappy != null && !ehappy.getText().toString().equals("")) {


            } else {
                Toast.makeText(context, "Happiest Moment is Mandatory", Toast.LENGTH_SHORT).show();
                return;
            }


            model.setName(ename.getText().toString());
            model.setSun_sign(ezodiac.getText().toString());
            model.setFathers_name(epapa.getText().toString());
            model.setMothers_name(emum.getText().toString());
            model.setHobbies(ehobby.getText().toString());
            model.setAim_in_life(eaims.getText().toString());
            model.setMotto(emotto.getText().toString());
            model.setDescribe_urslf(edesc.getText().toString());
            model.setContact(Integer.parseInt(emob.getText().toString()));
            modeladdress.setAddress(eaddress.getText().toString());
            modeladdress.setCity(ecity.getText().toString());
            modeladdress.setLandmark(elandmark.getText().toString());
            modeladdress.setCountry(ecountry.getText().toString());
            modeladdress.setState(estate.getText().toString());
            modeladdress.setPin_code(Integer.parseInt(epin.getText().toString()));
            model.setMail_id(eemail.getText().toString());
            modelfun.setFav_movie(efavmovies.getText().toString());
            modelfun.setFav_sport(esport.getText().toString());
            modelfun.setFav_food(efavfood.getText().toString());
            modelfun.setFav_song(efavsong.getText().toString());
            modelfun.setFav_quote(equote.getText().toString());
            modelfun.setThree_places(eplac.getText().toString());
            modelfun.setAlien_xist(ealien.getText().toString());
            modelfun.setBest_mom_me(ebestme.getText().toString());
            modelfun.setHappy_moment(ehappy.getText().toString());
            modelfun.setHw_lck_reaz(eopin.getText().toString());
            modelfun.setFiv_now(efive.getText().toString());
            modelfun.setPast_change(emomen.getText().toString());
            modelfun.setOpinion_me(eopinme.getText().toString());
            modelfun.setEmbarr_moment(eembarr.getText().toString());
            modelfun.setFirst_love(efirlv.getText().toString());
            SharedPreferences pref = this.getActivity().getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
            model.setUser_id(tokenmail);
            model.setFun_info(modelfun);
            model.setAddress(modeladdress);
            String day = "Day = " + simpleDatePicker.getDayOfMonth();
            String month = "Month = " + (simpleDatePicker.getMonth() + 1);
            String year = "Year = " + simpleDatePicker.getYear();
            String final_date = Integer.toString(simpleDatePicker.getDayOfMonth()) + "/" + Integer.toString((simpleDatePicker.getMonth() + 1)) + "/" + Integer.toString(simpleDatePicker.getYear());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            Date date1 = null;
            try {
                date1 = dateFormat.parse(final_date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            model.setDob(date1);
            String apiEndPointQuery = getResources().getString(R.string.url_add_friend);

            HashMap<String, String> headers = new HashMap<>();
            HashMap<String, String> query = new HashMap<>();

            networkLayer.post(EMERGENCY_API, apiEndPointQuery, headers, query, model,
                    new OnNetworkResponseListener(BaseResponse.class) {
                        @Override
                        public void onResponse(Object response) {


                            Toast.makeText(context, "Success Posting", Toast.LENGTH_SHORT).show();
                            butu.setEnabled(false);
                            String resp = "Thank You So Much :)";
                            butu.setText(resp);

                            slamlayout.setVisibility(View.GONE);
                            tokenlayout.setVisibility(View.VISIBLE);


                        }

                        @Override
                        public void onError(String error, int code) {

                            Toast.makeText(context, "Error Posting", Toast.LENGTH_SHORT).show();

                        }
                    });

        }
    }
}
