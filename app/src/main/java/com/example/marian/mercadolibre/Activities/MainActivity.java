package com.example.marian.mercadolibre.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marian.mercadolibre.API.API;
import com.example.marian.mercadolibre.Models.Article;
import com.example.marian.mercadolibre.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.appcompat.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Title)
    TextView title;

    @BindView(R.id.Image)
    ImageView image;

    //Agrego un botón para ir a otra activity.
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        API.getArticle("MLA644287324", new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if(response.isSuccessful()) {
                    Article received = response.body();
                    title.setText(received.getTitle());
                    Picasso.with(getApplicationContext()).load(received.getThumbnail()).into(image);
                }
                else {
                    title.setTextColor(Color.RED);
                    title.setBackgroundColor(Color.WHITE);
                    title.setText("No se pudo cargar el artículo.");
                }
            }
            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        });

        //Lanzo el intent hacia la otra activity.
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

    }
}