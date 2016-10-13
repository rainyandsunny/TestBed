package com.swjtu.deanstar.testbed;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemoActivity extends Activity {

    private ListView mListView;
    private List<String> mData;
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        mLayoutInflater = getLayoutInflater();
        mData = new ArrayList<String>();
        for(int i=0;i<100;i++){
            mData.add("我是第"+i+"个");
        }
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(new MyAdapter());
    }



    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if(null == convertView){

                holder = new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.viewholder_item,null);
                holder.mTextView = (TextView) convertView.findViewById(R.id.textview);
                convertView.setTag(holder);
            }else{

                holder = (ViewHolder) convertView.getTag();
            }
            holder.mTextView.setText(mData.get(position));
            return convertView;
        }


        private final class ViewHolder{

            private TextView mTextView;
        }
    }
}
