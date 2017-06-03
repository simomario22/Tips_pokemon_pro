package com.tips.tips_pokemon_pro;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class tips_pokemon_pro1 extends AppCompatActivity {

    private AdView mAdView;

    //ads interctitiall
    private InterstitialAd interstitial;

    // fire

    public FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_pokemon_pro1);

        // ads
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(tips_pokemon_pro1.this);

        // loude
        interstitial = new InterstitialAd(getApplicationContext());
        interstitial.setAdUnitId(getString(R.string.admob_interstetial_ad));
        adRequest = new AdRequest.Builder().build();
        interstitial.loadAd(adRequest);
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                if (interstitial.isLoaded()) {
                    interstitial.show();
                }
            }
        });

        // remot config


        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);
        long cacheExpiration = 0; //1 hour = 3600 in seconds
        if(mFirebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled())
        {
            cacheExpiration = 0;
        }
        mFirebaseRemoteConfig.fetch(cacheExpiration)
                .addOnCompleteListener(new OnCompleteListener<Void>(){
                    @Override
                    public void onComplete(@NonNull Task<Void> task){
                        if(task.isSuccessful()){
                            mFirebaseRemoteConfig.activateFetched();
                        } else {

                        }
                    }
                });

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

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(mFirebaseRemoteConfig.getString("Pokimona")));
        startActivity(intent);

    }

    public void but11(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(mFirebaseRemoteConfig.getString("Pokimonb")));
        startActivity(intent);
    }



    public void but12(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(mFirebaseRemoteConfig.getString("Pokimonc")));
        startActivity(intent);
    }
}
