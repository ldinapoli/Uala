package com.test.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.test.test.Adapters.BooksListViewAdapter;
import com.test.test.Entities.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnTaskCompleted {

    private ListView listView;
    private DataManager dataManager;
    private List<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.books_lv);

        dataManager = new DataManager(this);

        dataManager.getBooks();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = bookList.get(position);
                Toast.makeText(MainActivity.this, book.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onTaskCompleted(List<Book> books) {
        bookList = books;
        BooksListViewAdapter adapter = new BooksListViewAdapter(bookList, this);
        listView.setAdapter(adapter);
    }
}

interface OnTaskCompleted {
    void onTaskCompleted(List<Book> books);
}
