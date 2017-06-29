package com.mycompany.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Content1 extends LinearLayout {
    private ListView listView;
    private List<Item1> list = new ArrayList<>();

    public Content1(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        listView = (ListView) inflater.inflate(R.layout.content1, null);
        addView(listView);
    }

    class ItemAdapter extends BaseAdapter {

        //데이터 갯수
        @Override
        public int getCount() {
            return list.size();
        }

        //현재 위치에서의 데이터 갯수
        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            if(convertView == null ){
//                //Item UI 객체 생성(Inflation)
//                LayoutInflater inflater = LayoutInflater.from(getContext());
//                View view = inflater.inflate(R.layout.content1_item, null);
//
//            }

            //Item UI 객체 생성(Inflation)
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.content1_item, null);

            //데이터 셋팅
            ImageView photo = (ImageView) view.findViewById(R.id.photo);
            TextView title = (TextView) view.findViewById(R.id.title);
            ImageView star = (ImageView) view.findViewById(R.id.star);
            TextView content = (TextView) view.findViewById(R.id.content);

            Item1 item = list.get(position);
            photo.setImageResource(item.getPhoto());
            title.setText(item.getTitle());
            star.setImageResource(item.getStar());
            content.setText(item.getContent());

            return view;
        }
    }


}
