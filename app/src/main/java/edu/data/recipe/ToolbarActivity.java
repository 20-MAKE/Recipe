package edu.data.recipe;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ToolbarActivity extends AppCompatActivity {

    Switch darkmodeSwitch;
    Switch sizeSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        darkTheme();

//        sizeSwitch = (Switch) findViewById(R.id.size_switch);
//        sizeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked == true){
//
//                    //스위치가 온이면 키움
//                } else {
//
//                    //스위치가 오프면 원래대로
//                }
//            }
//        });


    }


    public void darkTheme(){
        darkmodeSwitch = (Switch) findViewById(R.id.darkmode_switch);
        // 테마 변경하는 스위치 설정
        darkmodeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    //스위치가 온이면 다크모드 실행
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    //스위치가 오프면 다크모드 아닌거 실행
                }
            }
        });
        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        // 무슨 테마인지 확인
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                break;
            // 만약 테마가 다크모드가 아니면 스위치는 그대로

            case Configuration.UI_MODE_NIGHT_YES:
                darkmodeSwitch.setChecked(true) ;
                break;
            // 만약 테마가 다크테마면 스위치를 온으로 변경
        }
    }
}

