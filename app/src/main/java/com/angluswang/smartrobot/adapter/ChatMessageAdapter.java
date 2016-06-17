package com.angluswang.smartrobot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.angluswang.smartrobot.R;
import com.angluswang.smartrobot.bean.ChatMessage;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Jeson on 2016/6/17.
 * 消息适配器
 */

public class ChatMessageAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<ChatMessage> mDatas;

    public ChatMessageAdapter() {

    }

    public ChatMessageAdapter(Context context, List<ChatMessage> datas) {
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position).getType() == ChatMessage.Type.INCOMING) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ChatMessage chatMessage = mDatas.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            switch (getItemViewType(position)) {
                case 0:
                    convertView = mInflater.inflate(R.layout.item_from_msg, parent, false);
                    holder.mDate = (TextView) convertView.findViewById(R.id.id_from_msg_date);
                    holder.mMsg = (TextView) convertView.findViewById(R.id.id_from_msg_info);
                    break;
                case 1:
                    convertView = mInflater.inflate(R.layout.item_to_msg, parent, false);
                    holder.mDate = (TextView) convertView.findViewById(R.id.id_to_msg_date);
                    holder.mMsg = (TextView) convertView.findViewById(R.id.id_to_msg_info);
                    break;
                default:
                    break;
            }
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        holder.mDate.setText(df.format(chatMessage.getDate()));
        holder.mMsg.setText(chatMessage.getMsg());
        return convertView;
    }

    public static class ViewHolder {
        private TextView mMsg;
        private TextView mDate;
    }
}
