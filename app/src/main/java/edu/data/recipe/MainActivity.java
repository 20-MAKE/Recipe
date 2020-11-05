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

import org.json.*;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
                    // 검색 실행하는 부분

                    CallAPI postReq = new CallAPI(new CallAPI.AsyncResponse() {
                        @Override
                        public void processFinish(String res) {
                            try {

                                JSONObject obj = new JSONObject(res);
                                JSONArray recipes_arr = obj.getJSONArray("result");
                                if (recipes_arr.length() == 0) {
                                    showRecipe(null);
                                }
                                RecipeData[] recipes = new RecipeData[recipes_arr.length()];

                                for (int i = 0; i < recipes_arr.length(); i++) {
                                    JSONObject recipeobj = recipes_arr.getJSONObject(i);
                                    RecipeData recipe = new RecipeData();

                                    recipe.setTitle(recipeobj.getString("name"));
                                    recipe.setURL(recipeobj.getString("img"));

                                    JSONArray desc_arr = recipeobj.getJSONArray("making");
                                    String[] description = new String[desc_arr.length()];
                                    for (int j = 0; j < desc_arr.length(); j++) {
                                        description[j] = desc_arr.getString(j);
                                    }
                                    recipe.setDescription(description);

                                    JSONArray ingred_arr = recipeobj.getJSONArray("ing");
                                    String[] ingreds = new String[ingred_arr.length()];
                                    for (int j = 0; j < ingred_arr.length(); j++) {
                                        ingreds[j] = ingred_arr.getString(j);
                                    }
                                    recipe.setIngreds(ingreds);

                                    Log.d("recipe", recipe.toString());
                                    recipes[i] = recipe;

                                }
                                showRecipe(recipes[0]);
                            } catch (Exception e) {

                            }
                        }});
                    Log.d("posting data", searchBar.getText().toString());
                    postReq.execute("http://iinsu.kro.kr:3002/search/recipe_search", "list=" + searchBar.getText().toString());
//                    RecipeData tmpdata = new RecipeData();
//                    tmpdata.setTitle((String)searchBar.getText().toString());
//                    tmpdata.setDescription("tmpData Recipe Description");
//                    printRecipe(tmpdata);

                    return true;
                }
                return false;
            }
        });

        CallAPI postReq = new CallAPI(new CallAPI.AsyncResponse() {
            @Override
            public void processFinish(String res) {
                try {

                    JSONObject obj = new JSONObject(res);
                    JSONArray recipes_arr = obj.getJSONArray("result");
                    RecipeData[] recipes = new RecipeData[recipes_arr.length()];

                    for (int i = 0; i < recipes_arr.length(); i++) {
                        JSONObject recipeobj = recipes_arr.getJSONObject(i);
                        RecipeData recipe = new RecipeData();

                        recipe.setTitle(recipeobj.getString("name"));
                        recipe.setURL(recipeobj.getString("img"));

                        JSONArray desc_arr = recipeobj.getJSONArray("making");
                        String[] description = new String[desc_arr.length()];
                        for (int j = 0; j < desc_arr.length(); j++) {
                            description[j] = desc_arr.getString(j);
                        }
                        recipe.setDescription(description);

                        JSONArray ingred_arr = recipeobj.getJSONArray("ing");
                        String[] ingreds = new String[ingred_arr.length()];
                        for (int j = 0; j < ingred_arr.length(); j++) {
                            ingreds[j] = ingred_arr.getString(j);
                        }
                        recipe.setIngreds(ingreds);

                        Log.d("recipe", recipe.toString());
                        recipes[i] = recipe;

                    }
                    showRecipe(recipes[0]);
                } catch (Exception e) {

                }
            }});
        postReq.execute("http://iinsu.kro.kr:3002/recipe/getall", "");

        Button chBtn = findViewById(R.id.setting_btn);
        chBtn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent first_intent = new Intent(MainActivity.this, ToolbarActivity.class);
                        startActivity(first_intent);
                    }
                }
        );
    }

//    public RecipeData[] getAllRecipe() {
//
//
//
//    }

    protected void showRecipe(RecipeData recipe) { // RecipeData 클래스를 인자로 받고 레시피 데이터를 사용자에게 보여주는 메소드
//        TextView resultView = findViewById(R.id.resultView);
//        String tmp;
//        if (recipe == null) {
//            tmp = "결과값이 없습니다.";
//        } else {
//            tmp = (String)recipe.getTitle() + " " + (String)recipe.getStringDescription();
//        }
//        resultView.setText(tmp);
    }


//    protected RecipeData[] requestAll() {
//
//    }


}