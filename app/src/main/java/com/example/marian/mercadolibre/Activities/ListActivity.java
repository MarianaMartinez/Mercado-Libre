package com.example.marian.mercadolibre.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.marian.mercadolibre.Adapters.Adapter;
import com.example.marian.mercadolibre.Models.Article;
import com.example.marian.mercadolibre.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Marian on 2/7/2017.
 */

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        recyclerViewMethod(); //método que configura mi recycler view.

    }

    private void recyclerViewMethod() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<Article> articles = getListArticles(); //obtengo la lista de articulos.

        adapter = new Adapter(articles); //le paso al adapter la lista obtenida.
        recyclerView.setAdapter(adapter);
    }

    private List<Article> getListArticles() {
      List<Article> articles = new ArrayList<Article>();
        for (int i=1 ; i<=100 ; i ++) {
            Article article = new Article();
            article.setTitle("Artículo N° " + i);
            articles.add(article);
        }
        return articles;
    } //lleno una lista de artículos con un foreach.
}