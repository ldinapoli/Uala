package com.test.test.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.test.test.Entities.Book;
import com.test.test.R;

import java.util.List;

public class BooksListViewAdapter extends ArrayAdapter<Book> {

    private List<Book> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtName;
    }

    public BooksListViewAdapter(List<Book> data, Context context) {
        super(context, R.layout.books_list_view_row, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Book bookModel = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.books_list_view_row, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtName.setText(bookModel.getName());
        // Return the completed view to render on screen
        return convertView;
    }
}
