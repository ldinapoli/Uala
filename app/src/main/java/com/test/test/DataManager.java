package com.test.test;

import android.content.Context;
import android.widget.Toast;

import com.test.test.Clients.BooksClient;
import com.test.test.Entities.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataManager {

    private Context context;
    private OnTaskCompleted onTaskCompleted;

    DataManager(Context context) {
        this.context = context;
        this.onTaskCompleted = (OnTaskCompleted) context;
    }

    public void getBooks() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://qodyhvpf8b.execute-api.us-east-1.amazonaws.com")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit =  builder.build();

        BooksClient booksClient = retrofit.create(BooksClient.class);

        Call<List<Book>> call = booksClient.books();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                onTaskCompleted.onTaskCompleted(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(context, context.getResources().getString(R.string.service_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
