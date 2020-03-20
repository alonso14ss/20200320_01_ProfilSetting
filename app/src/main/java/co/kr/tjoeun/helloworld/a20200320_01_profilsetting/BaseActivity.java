package co.kr.tjoeun.helloworld.a20200320_01_profilsetting;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext = this;
    public abstract void setupEvents();
    public abstract void setValues();

}
