package eslamee;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import eslamee.common.base_activities.BaseHomeActivity;

import eslamee.lib.network.NetworkLayer;
import eslamee.lib.network.OnNetworkResponseListener;
import eslamee.services.home.HomeFragment;
import eslamee.services.home.addfriend.AddInfo;
import eslamee.services.home.getfriend.AlphabetFragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static eslamee.lib.network.NetworkService.EMERGENCY_API;


public class EslamEMainActivity extends BaseHomeActivity {


    private NetworkLayer networkLayer;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if( networkLayer == null ) {
            networkLayer = new NetworkLayer();
        }

        loadData();

    }


    private void loadData() {

        String endpoint = getResources().getString(R.string.url_friend_home);
        HashMap<String, String> headers = new HashMap<String, String>();
        HashMap<String, String> query = new HashMap<String, String>();

        networkLayer.get(EMERGENCY_API, endpoint, headers, query, false, false, new OnNetworkResponseListener(EslamEHomeResponse.class) {
            @Override
            public void onResponse(Object response) {

                handleResponse((EslamEHomeResponse)response);

            }

            @Override
            public void onError(String error, int code) {

                viewUtils.showToast(error);

            }
        });

    }



    private void handleResponse(EslamEHomeResponse eslameeHomeResponse) {

        super.updateCarouselView(eslameeHomeResponse.getHome_image_list());

        List<Fragment> tabFragmentList = getTabFragmentList(eslameeHomeResponse.getTab_list());

        List<String> temp  = new ArrayList<>();
        temp.add("home");
        temp.add("addfriend");
        temp.add("getfriend");

        super.updateViewPager(temp, tabFragmentList);

    }

    private List<Fragment> getTabFragmentList(List<String> tabList) {



        List<Fragment> list = new LinkedList<>();

        for(String tab : tabList) {
            list.add(getFragmentForTab(tab));
        }

        return list;

    }

    private Fragment getFragmentForTab(String tab) {

        Fragment fragment = null;

        switch(tab) {
            case "home":
                fragment = new HomeFragment();
                break;

            case "addfriend":
                fragment = new AddInfo();
                break;

            case "getfriend":
                fragment = new AlphabetFragment();
                break;

            /*case "events":
                fragment = new RecyclerActivityForEventList();
                break;*/

        }

        return fragment;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
