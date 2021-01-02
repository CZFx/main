package com.xinhua.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class AddShoppingCart extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shopping_cart );
//全屏Activity操作
        getWindow().setLayout(WindowManager.LayoutParams. FILL_PARENT , WindowManager.LayoutParams. FILL_PARENT );
//QQ分享按钮
        ImageBtn MyIBtn1 = (ImageBtn)findViewById(R.id. MyIBtn_1 );
        MyIBtn1.setImageResource(R.drawable. ic_share_qq );
        MyIBtn1.setText( "QQ" );

        ImageBtn MyIBtn2 = (ImageBtn)findViewById(R.id. MyIBtn_2 );
        MyIBtn2.setImageResource(R.drawable. ic_share_sina );
        MyIBtn2.setText( "微博" );
        ImageBtn MyIBtn3 = (ImageBtn)findViewById(R.id. MyIBtn_3 );
        MyIBtn3.setImageResource(R.drawable. ic_share_wechat );
        MyIBtn3.setText( "微信" );
        ImageBtn MyIBtn4 = (ImageBtn)findViewById(R.id. MyIBtn_4 );
        MyIBtn4.setImageResource(R.drawable. ic_share_wxcircle );
        MyIBtn4.setText( "朋友圈" );
        Button btn_cancel = (Button) this .findViewById(R.id. btn_cancel );
        btn_cancel.setOnClickListener( this );
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id. btn_cancel :
                break ;
            default :
                break ;
        }
        finish();
    }
}

