package com.example.marian.mercadolibre;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marian.mercadolibre.Models.Article;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Title)
    TextView title;

    @BindView(R.id.Image)
    ImageView image;

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
    }
}
