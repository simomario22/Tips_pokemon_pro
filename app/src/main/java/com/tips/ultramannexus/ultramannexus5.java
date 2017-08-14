package com.tips.ultramannexus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appodeal.ads.Appodeal;


public class ultramannexus5 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultramannexus5);

        Appodeal.show(this, Appodeal.BANNER_BOTTOM);

    }
}
