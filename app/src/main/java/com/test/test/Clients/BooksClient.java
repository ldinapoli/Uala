package com.test.test.Clients;

import com.test.test.Entities.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BooksClient {

    @GET("/test/books")
    Call<List<Book>> books();
}
