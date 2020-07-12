package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;


public class MainActivity extends AppCompatActivity {


    ListView tt;
    private ArrayList<String> conn = new ArrayList<>();

    ArrayList<Datamodel> dataModels;
    private static Customadap adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tt = (ListView)findViewById(R.id.listview);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();


        Jasonplaceh jasonplaceh = retrofit.create(Jasonplaceh.class);
        Call<List<Post>> call = jasonplaceh.getposts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()){

                    //tt.setText("CODE : " + response.code());
                    return;
                }


                Integer sum = 0;
                List<Post> posts = response.body();
                ArrayList<String> login = new ArrayList<String>();


                dataModels= new ArrayList<>();


                for(Post pos : posts)
                {
                    //String login = pos.getActor().get("login").toString();
                    //tt.append(login);
                    dataModels.add(new Datamodel(Integer.valueOf(pos.getActor().get("id").toString()), pos.getActor().get("login").toString(), pos.getActor().get("display_login").toString(),
                            pos.getActor().get("url").toString() , pos.getActor().get("avatar_url").toString()));
                    //login.add(pos.getActor().get("login").toString());
                }


                adapter= new Customadap(dataModels,getApplicationContext());

                tt.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            //tt.setText(t.getMessage());
            }
        });


    }
}
