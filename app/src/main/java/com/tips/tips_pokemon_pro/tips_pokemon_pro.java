package com.tips.tips_pokemon_pro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class tips_pokemon_pro extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_pokemon_pro);

        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void but5(View view) {

        Intent i = new Intent(this, tips_pokemon_pro2.class);
        startActivity(i);
    }

    public void but6(View view) {

        Intent i = new Intent(this, tips_pokemon_pro3.class);
        startActivity(i);
    }

    public void but7(View view) {

        Intent i = new Intent(this, tips_pokemon_pro4.class);
        startActivity(i);
    }

    public void but8(View view) {
        Intent i = new Intent(this, tips_pokemon_pro5.class);
        startActivity(i);
    }

    public void but9(View view) {

        Intent i = new Intent(this, tips_pokemon_pro6.class);
        startActivity(i);
    }

    public void but10(View view) {


    }
}
