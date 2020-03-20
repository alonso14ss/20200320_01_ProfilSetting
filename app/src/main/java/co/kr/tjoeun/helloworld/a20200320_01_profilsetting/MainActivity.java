package co.kr.tjoeun.helloworld.a20200320_01_profilsetting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import co.kr.tjoeun.helloworld.a20200320_01_profilsetting.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private static final int REQUEST_FOR_ALBUM = 1000;

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupEvents();
        setValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("화면 재등장", "다시 나타날때 마다 실행");
    }

    @Override
    public void setupEvents() {

        binding.profilPicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                갤러리에서 사진을 가져오자!
//                안드로이드가 제공하는 화면(갤러리) => intent로 이동!
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, REQUEST_FOR_ALBUM);

            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_FOR_ALBUM) {

            if (resultCode == RESULT_OK) {
                if(data.getData() != null){
                    Log.d("사진가져오기", data.getData().toString());
                }
            }

        }

    }
}
