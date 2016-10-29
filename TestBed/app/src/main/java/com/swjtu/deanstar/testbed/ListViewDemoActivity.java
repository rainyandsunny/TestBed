package com.swjtu.deanstar.testbed;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemoActivity extends Activity {

    private ListView mListView;
    private List<String> mData;
    private LayoutInflater mLayoutInflater;
    private final String TAG = "ListViewDemoActivity";

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

        //得到第一个可以看见的位置
        int first = mListView.getFirstVisiblePosition();
        //得到最后一个可以看见的位置
        int last = mListView.getLastVisiblePosition();
       // mListView.setEmptyView(getLayoutInflater().inflate(R.layout.listview_empty_view));
 /*       mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:{
                        Log.d(TAG,"down");
                    }break;
                    case MotionEvent.ACTION_MOVE:{
                        Log.d(TAG,"move");
                    }break;
                    case MotionEvent.ACTION_UP:{
                        Log.d(TAG,"up");
                    }break;
                }
                return false;
            }
        });*/
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                switch (scrollState){

                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:{

                        Log.d(TAG,"SCROLL_STATE_FLING");

                    }break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:{
                        Log.d(TAG,"SCROLL_STATE_IDLE");

                    }break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:{

                        Log.d(TAG,"SCROLL_STATE_TOUCH_SCROLL");
                    }break;

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                Log.d(TAG,"onScroll"+ firstVisibleItem + ":"+visibleItemCount+":"+totalItemCount);
            }
        });
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
