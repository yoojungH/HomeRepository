package com.mycompany.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoListFragment extends Fragment {

        private static final String TAG = "PhotoListFragment";
        private ListView listView;
        private List<Photo> list = new ArrayList<>();
        private com.mycompany.myapplication.fragment.PhotoListFragment.ItemAdapter itemAdapter;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            listView = (ListView) inflater.inflate(R.layout.fragment_photo_list, container, false);
            itemAdapter = new com.mycompany.myapplication.fragment.PhotoListFragment.ItemAdapter();
            listView.setAdapter(itemAdapter);
            listView.setOnItemClickListener(itemClickListener);
            return listView;
        }

        @Override
        public void onStart() {
            super.onStart();
            for(int i=1; i<=10; i++) {
                Photo photo = new Photo();
                photo.setPno(i);
                photo.setPname("여행"+i);
                photo.setPphoto(getResources().getIdentifier("photo"+i, "drawable", getContext().getPackageName()));
                photo.setPstar(getResources().getIdentifier("star"+i, "drawable", getContext().getPackageName()));
                photo.setPdesc("여기 가보고 싶어요.");
                addItem(photo);
            }
        }

        private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Photo photo = (Photo) itemAdapter.getItem(position);
                Log.i(TAG, photo.getPname());

            }
        };

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
