package com.example.sinjiung.woojinpay.BottomNaviBar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodSession;
import android.widget.Toast;

import com.example.sinjiung.woojinpay.Login.MainActivity;
import com.example.sinjiung.woojinpay.R;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.UnLinkResponseCallback;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import javax.security.auth.callback.Callback;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutMenu:
                onClickLogout();
                return true;
        }
        return super.onOptionsItemSelected(item);
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
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
