package com.mycompany.myapplication.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoList extends LinearLayout {
    private ListView listView;
    private List<Photo> list = new ArrayList<>();
    private ItemAdapter itemAdapter;

    public PhotoList(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        listView = (ListView) inflater.inflate(R.layout.photo_list, null);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        addView(listView);
    }

    class ItemAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return list.get(position).getPno();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.photo_item, null);
            }

            ImageView pphoto = (ImageView) convertView.findViewById(R.id.pphoto);
            TextView pname = (TextView) convertView.findViewById(R.id.pname);
            ImageView pstar = (ImageView) convertView.findViewById(R.id.pstar);
            TextView pdesc = (TextView) convertView.findViewById(R.id.pdesc);

            Photo photo = list.get(position);
            pphoto.setImageResource(photo.getPphoto());
            pname.setText(photo.getPname());
            pstar.setImageResource(photo.getPstar());
            pdesc.setText(photo.getPdesc());

            return convertView;
        }
    }

    public void addItem(Photo item) {
        list.add(item);
        itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(Photo item) {
        list.remove(item);
        itemAdapter.notifyDataSetChanged();
    }
}
