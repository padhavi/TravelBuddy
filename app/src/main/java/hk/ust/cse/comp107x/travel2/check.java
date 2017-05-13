package hk.ust.cse.comp107x.travel2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        Log.d("rashi", " " + NearbyListAdapter.lat);
        String url = "https://www.google.com/maps/dir/";
        for (int i = 0; i < NearbyListAdapter.lat.size() && i < NearbyListAdapter.lng.size(); i++) {
            if (i == NearbyListAdapter.lat.size() - 1)
                url += NearbyListAdapter.lat.get(i) + "," + NearbyListAdapter.lng.get(i);
            else
                url += NearbyListAdapter.lat.get(i) + "," + NearbyListAdapter.lng.get(i) + "/";
        }

        Log.d("rashi", " " + url);


        final Uri gmmIntentUri = Uri.parse(url);


        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);


        }
    }
}

