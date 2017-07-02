package com.example.marian.mercadolibre.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marian.mercadolibre.Models.Article;
import com.example.marian.mercadolibre.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Marian on 2/7/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Article> articles = new ArrayList<Article>(); //instancio una lista de artículos.

    public Adapter (List<Article> articles) {
        this.articles = articles;
    } //constructor del adapter que recibe una lista de artículos.

    @Override
    public int getItemCount() {
        return articles.size();
    } //sobreescribo el método que me devuelve el tamaño de la lista.

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_article, null);
        return new Adapter.ViewHolder(itemLayoutView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = this.articles.get(position);
        holder.title.setText(article.getTitle());
    }

}