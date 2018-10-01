package com.example.a3dlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jzp.rotate3d.Rotate3D;

public class MainActivity extends AppCompatActivity {

    Rotate3D rotate;
    private LinearLayout account_login_ll;
    private LinearLayout account_phone_all;
    private LinearLayout parent_ll;
    private TextView no_pass_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account_login_ll=findViewById(R.id.account_login_ll);
        account_phone_all=findViewById(R.id.account_phone_ll);
        parent_ll=findViewById(R.id.parent_ll);
        no_pass_login=findViewById(R.id.no_pass_login);
        rotate=new Rotate3D.Builder(this).
                setParentView(parent_ll).
                setPositiveView(account_login_ll).
                setNegativeView(account_phone_all).create();//创建Rotate3D
        no_pass_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rotate.transform();//启动Rotate3D
                if(rotate.isOpen()){
                    no_pass_login.setText("使用免密登录");
                }else {
                    no_pass_login.setText("使用账户登录");
                }
            }
        });
    }
}
