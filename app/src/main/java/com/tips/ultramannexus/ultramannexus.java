package com.tips.ultramannexus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ultramannexus extends AppCompatActivity {



    // firebase
    private DatabaseReference mdatabaseref;

    String mbtn1 ;
    String mbtn2 ;
    String mbtn3 ;
    String adsUrl;




    private ProgressDialog mProgressDialog ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultramannexus);








        //  progressdialog  ...
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Load..");
        mProgressDialog.setMessage("wait ...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();



        mdatabaseref  = FirebaseDatabase.getInstance().getReference();
        mdatabaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mbtn1 = dataSnapshot.child("btn1").getValue().toString();
                mbtn2 = dataSnapshot.child("btn2").getValue().toString();
                mbtn3 = dataSnapshot.child("btn3").getValue().toString();

                adsUrl = dataSnapshot.child("ads_inter").getValue().toString();

                // for prograsdialog
                if (dataSnapshot.exists()){


                    // method  start appodel ads
                   startads();


                    //do something
                    mProgressDialog.dismiss();
                }




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {



                mProgressDialog.dismiss();
            }
        });



    }

    private void startads() {

        // appodeal
        String appKey = "e44cf1b6c0ceaf7b91671b10fedba0ddd84bf0e1c0f00c39";
        Appodeal.setBannerViewId(R.id.appodealBannerView);
        Appodeal.initialize(this, adsUrl, Appodeal.INTERSTITIAL | Appodeal.NON_SKIPPABLE_VIDEO | Appodeal.BANNER);


            Appodeal.show(this, Appodeal.BANNER_VIEW);

    }


    public void but5(View view) {

        Intent i = new Intent(this, ultramannexus2.class);
        startActivity(i);

        if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)){
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        }


    }

    public void but6(View view) {

        Intent i = new Intent(this, ultramannexus3.class);
        startActivity(i);

        if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)){
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        }


    }

    public void but7(View view) {

        Intent i = new Intent(this, ultramannexus4.class);
        startActivity(i);

        if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)){
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        }


    }

    public void but8(View view) {
        Intent i = new Intent(this, ultramannexus5.class);
        startActivity(i);

        if (Appodeal.isLoaded(Appodeal.NON_SKIPPABLE_VIDEO)){
            Appodeal.show(this, Appodeal.NON_SKIPPABLE_VIDEO);
        }

    }

    public void but9(View view) {

        Intent i = new Intent(this, ultramannexus6.class);
        startActivity(i);

        if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)){
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        }

    }




    public void but10(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
       intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(mbtn1));
        startActivity(intent);

    }

    public void but11(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(mbtn2));
        startActivity(intent);
    }



    public void but12(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(mbtn3));
        startActivity(intent);
    }
}
