package com.test.test.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.test.Entities.Book;
import com.test.test.R;

import java.util.List;

public class BooksListViewAdapter extends ArrayAdapter<Book> {

    private List<Book> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtName;
        TextView txtAuthor;
        TextView txtpopularity;
        TextView txtavailability;
        ImageView ivImage;
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
            viewHolder.txtAuthor = (TextView) convertView.findViewById(R.id.author);
            viewHolder.txtavailability = (TextView) convertView.findViewById(R.id.availability);
            viewHolder.txtpopularity = (TextView) convertView.findViewById(R.id.popularity);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.image);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtName.setText(bookModel.getName());
        viewHolder.txtAuthor.setText("Autor: " + bookModel.getAuthor());
        viewHolder.txtpopularity.setText("Popularidad: " + bookModel.getPopularity());
        if (bookModel.isAvailability()) {
            viewHolder.txtavailability.setText("DISPONIBLE");
        } else {
            viewHolder.txtavailability.setText("NO DISPONIBLE");
        }

        if (!bookModel.getImage().equals(""))
            Picasso.get()
                    .load(bookModel.getImage())
                    .resize(150, 150)
                    .centerCrop()
                    .into(viewHolder.ivImage);

        return convertView;
    }
}
