package com.mycompany.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017-06-28.
 */

public class Content1 extends LinearLayout {
    private LinearLayout itemContainer;

    public Content1(Context context) {
        super(context);
        this.setOrientation(LinearLayout.VERTICAL);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.content1, null);
        addView(view);
        itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
    }

    public void addItem(Item item) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.content1_item, null);


        ImageView photo = (ImageView) view.findViewById(R.id.photo);
        photo.setImageResource(item.getPhoto());

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(item.getTitle());

        ImageView star = (ImageView) view.findViewById(R.id.star);
        star.setImageResource(item.getStar());

        TextView content = (TextView) view.findViewById(R.id.content);
        content.setText(item.getContent());

        itemContainer.addView(view);
    }
}
