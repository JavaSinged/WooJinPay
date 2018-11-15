package com.example.sinjiung.woojinpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

public class section_main extends AppCompatActivity {

    home homeFragment;
    shoppingcart shoppingcartFragment;
    setting settingFragment;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        homeFragment = new home();
        shoppingcartFragment = new shoppingcart();
        settingFragment = new setting();

        bar = getSupportActionBar();
        bar.setTitle("우진상사");
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    bar.setTitle("우진상사");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                    return true;
                case R.id.navigation_dashboard:
                    bar.setTitle("장바구니");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,shoppingcartFragment).commit();
                    return true;
                case R.id.navigation_notifications:
                    bar.setTitle("설정");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFragment).commit();
                    return true;
            }
            return false;
        }
    };

    private void onClickLogout() {
        UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {
                firstdirectSignupActivity();
            }
        });
    }

    protected void firstdirectSignupActivity() {
        onClickLogout();
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void redirectSignupActivity() {
        onClickLogout();
        final Intent intent = new Intent(this, section_main.class);
        startActivity(intent);
        finish();
    }


}
