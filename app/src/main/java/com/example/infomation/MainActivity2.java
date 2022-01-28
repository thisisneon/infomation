package com.example.infomation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {

    //    private Button btnLoad1;
    private ImageView ivAvatar;
//    String URL = "https://wallpapercave.com/wp/HFsWtAz.jpg";


    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private TextView name, avatar, birthday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //this.setTitle("Activity 2");


//        btnLoad1 = (Button)findViewById(R.id.btnLoad1);
        ivAvatar = (ImageView) findViewById(R.id.ivAvatar);
//        btnLoad1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Glide.with(getApplicationContext()).load(URL).into(imgHinh);
//            }
//        });


        name = (TextView) findViewById(R.id.activity_name2);
        birthday = (TextView) findViewById(R.id.activity_birthday2);

        String name_box = getIntent().getStringExtra("keyname");
        String birthday_box = getIntent().getStringExtra("keybirthday");
        String avatar_box = getIntent().getStringExtra("keyavatar");
        String job_box = getIntent().getStringExtra("keyjob");
        String introduction_box = getIntent().getStringExtra("keyintroduction");


        Glide.with(getApplicationContext()).load(avatar_box).into(ivAvatar);

        name.setText(name_box);
        birthday.setText(birthday_box);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Infomation");

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.setJob(job_box);
        viewPagerAdapter.setInformation(introduction_box);
        mViewPager.setAdapter(viewPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);


    }
}