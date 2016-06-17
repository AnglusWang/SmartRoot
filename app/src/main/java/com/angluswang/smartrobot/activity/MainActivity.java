package com.angluswang.smartrobot.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.angluswang.smartrobot.R;
import com.angluswang.smartrobot.adapter.ChatMessageAdapter;
import com.angluswang.smartrobot.bean.ChatMessage;
import com.angluswang.smartrobot.utils.HttpUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lvMsgs;
    private List<ChatMessage> mDatas;
    private ChatMessageAdapter mChatMessageAdapter;

    private EditText etInputMsg;
    private Button btSendMsg;

    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //用于等待接收 子线程数据的返回
            ChatMessage fromMessage= (ChatMessage) msg.obj;
            mDatas.add(fromMessage);
            mChatMessageAdapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initListener() {

        btSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String toMsg = etInputMsg.getText().toString();
                if (TextUtils.isEmpty(toMsg)) {
                    Toast.makeText(MainActivity.this, "你输入的消息中包含有无效字符",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                ChatMessage toMessage = new ChatMessage();
                toMessage.setDate(new Date());
                toMessage.setMsg(toMsg);
                toMessage.setType(ChatMessage.Type.OUTCOMING);
                mDatas.add(toMessage);
                mChatMessageAdapter.notifyDataSetChanged();

                //清空输入框数据
                etInputMsg.setText("");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ChatMessage fromMessage = HttpUtils.sendMessage(toMsg);
                        Message msg = Message.obtain();
                        msg.obj = fromMessage;
                        mhandler.sendMessage(msg);
                    }
                }).start();

            }
        });
    }

    private void initData() {
        mDatas = new ArrayList<>();
        mDatas.add(new ChatMessage("你好，我是呵呵哒", ChatMessage.Type.INCOMING, new Date()));
        mChatMessageAdapter = new ChatMessageAdapter(this, mDatas);
        lvMsgs.setAdapter(mChatMessageAdapter);
    }

    private void initView() {
        lvMsgs = (ListView) findViewById(R.id.id_lv_msgs);
        etInputMsg = (EditText) findViewById(R.id.id_input_msg);
        btSendMsg = (Button) findViewById(R.id.id_send_msg);
    }
}
