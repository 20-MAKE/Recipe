package edu.data.recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.searchBar);
        searchBar.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_UP)) {
                    // 검색 실행하는 부
                    RecipeData tmpdata = new RecipeData();
                    tmpdata.setTitle((String)searchBar.getText().toString());
                    tmpdata.setDescription("tmpData Recipe Description");
                    printRecipe(tmpdata);

                    return true;
                }
                return false;
            }
        });

        Button chBtn = findViewById(R.id.setting_btn);
        chBtn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("DATA_SNS","asdasd");

                        Intent first_intent = new Intent(MainActivity.this, ToolbarActivity.class);
                        startActivity(first_intent);
                    }
                }
        );
    }

    protected void printRecipe(RecipeData recipe) { // RecipeData 클래스를 인자로 받고 레시피 데이터를 사용자에게 보여주는 메소
        TextView resultView = findViewById(R.id.resultView);
        String tmp = (String)recipe.getTitle() + " " + (String)recipe.getDescription();
         resultView.setText(tmp);
    }


}