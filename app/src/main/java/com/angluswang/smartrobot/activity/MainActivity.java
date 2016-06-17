package com.angluswang.smartrobot.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.angluswang.smartrobot.R;
import com.angluswang.smartrobot.adapter.ChatMessageAdapter;
import com.angluswang.smartrobot.bean.ChatMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lvMsgs;
    private List<ChatMessage> mDatas;
    private ChatMessageAdapter mChatMessageAdapter;

    private EditText etInputMsg;
    private Button btSendMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        mDatas = new ArrayList<>();
        mDatas.add(new ChatMessage("你好，我是呵呵哒", ChatMessage.Type.INCOMING, new Date()));
        mDatas.add(new ChatMessage("呵呵", ChatMessage.Type.OUTCOMING, new Date()));
        mDatas.add(new ChatMessage("今天天气真好", ChatMessage.Type.INCOMING, new Date()));
        mChatMessageAdapter = new ChatMessageAdapter(this, mDatas);
        lvMsgs.setAdapter(mChatMessageAdapter);
    }

    private void initView() {
        lvMsgs = (ListView) findViewById(R.id.id_lv_msgs);
        etInputMsg = (EditText) findViewById(R.id.id_input_msg);
        btSendMsg = (Button) findViewById(R.id.id_send_msg);
    }
}
