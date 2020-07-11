package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {


    TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tt = (TextView)findViewById(R.id.textview);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();


        Jasonplaceh jasonplaceh = retrofit.create(Jasonplaceh.class);
        Call<List<Post>> call = jasonplaceh.getposts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()){

                    tt.setText("CODE : " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for(Post pos : posts)
                {
                    String conn = "";
                    conn += "TYPE" + pos.getType() + "\n";

                    tt.append(conn);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            tt.setText(t.getMessage());
            }
        });


    }
}
