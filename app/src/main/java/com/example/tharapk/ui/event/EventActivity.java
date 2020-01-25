package com.example.tharapk.ui.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tharapk.adapters.EventCategoryAdapter;
import com.example.tharapk.models.EventCategory;
import com.example.tharapk.ui.home.Home2Activity;
import com.example.tharapk.R;
import com.example.tharapk.ui.feed.FeedActivity;
import com.example.tharapk.ui.notification.NotificationActivity;
import com.example.tharapk.ui.profile.ProfileActivity;

import java.util.ArrayList;
import java.util.List;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class EventActivity extends AppCompatActivity {

    private Context mContext = EventActivity.this;

    private List<EventCategory> mCategoryList;

    private RecyclerView mEventCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        setActivityNavigation();

        setEventCategoryList();

    }

   void setEventCategoryList(){

       mEventCategories = findViewById(R.id.Rv_events);

       mCategoryList = new ArrayList<>();

       //   ADDING CATEGORIES TO THE RECYCLER VIEW LIST
       mCategoryList.add(
               new EventCategory(
                       "Robotics",
                       R.drawable.background
               )
       );

       mCategoryList.add(
               new EventCategory(
                       "Robotics",
                       R.drawable.background
               )
       );
       mCategoryList.add(
               new EventCategory(
                       "Robotics",
                       R.drawable.background
               )
       );

       //   SETTING ADAPTER FOR THE RECYCLER VIEW
       EventCategoryAdapter adapter = new EventCategoryAdapter(mContext,mCategoryList);
       mEventCategories.setAdapter(adapter);

       //   SETTING ORIENTATION FOR THE RECYCLER VIEW
       mEventCategories.setLayoutManager(
               new LinearLayoutManager(
                       mContext,
                       RecyclerView.VERTICAL,
                       false)
       );
    }


    //  SETUP ACTIVITY NAVIGATION BAR
    void setActivityNavigation(){

        // SETTING BOTTOM NAVIGATION
        SmoothBottomBar bottomNavigation;
        bottomNavigation = findViewById(R.id.bottomBar);

        bottomNavigation.setActiveItem(1);
        bottomNavigation.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelect(int i) {

                switch(i){

                    case 0 :
                        Intent i1 = new Intent(mContext, Home2Activity.class);
                        i1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        i1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i1);
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case 2 :
                        Intent i2 = new Intent(mContext, FeedActivity.class);
                        i2.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        i2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i2);
                        overridePendingTransition(0,0);
                        finish();
                        break;
                }

            }
        });


        //SETTING TOP TOOLBAR
        ImageView ivNotification, ivProfile;

        ivNotification = findViewById(R.id.iv_notification);
        ivProfile = findViewById(R.id.iv_profile);

        ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;intent = new Intent(mContext, NotificationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(0,0);

            }
        });

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, ProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(0,0);

            }
        });




    }


}