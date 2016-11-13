package in.leob.one.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import in.leob.one.R;
import in.leob.one.bean.Home;
import in.leob.one.listener.OnImageDownloadListener;
import in.leob.one.ui.SmartImageView;
import in.leob.one.util.ImageUtil;

/**
 * Created by lenovo on 2016/11/10.
 */
public class HomeDetailActivity extends Activity implements View.OnClickListener, OnImageDownloadListener {

    private ImageView img_thumb;
    private TextView str_title;
    private TextView str_author;
    private TextView str_content;
    private TextView str_content_author;
    private Home.HpEntityBean mHpEntityBean;
    private ImageView mImgSend;
    private ImageView mImgDown;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        initUI();
        initData();
        initEvent();
    }

    private void initUI() {
        img_thumb = (ImageView)findViewById(R.id.img_thumb);
        str_title = (TextView)findViewById(R.id.str_title);
        str_author = (TextView)findViewById(R.id.str_author);
        str_content = (TextView)findViewById(R.id.str_content);
        str_content_author = (TextView)findViewById(R.id.str_content_author);
        mImgSend = (ImageView) findViewById(R.id.img_send);
        mImgDown = (ImageView) findViewById(R.id.img_down);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_home_detail);
    }

    private void initData() {
        // 取出传递过来的bean
        Intent intent = getIntent();
        mHpEntityBean = (Home.HpEntityBean) intent.getSerializableExtra("ALL");
        // 给控件设置数据
        str_title.setText(mHpEntityBean.getStrAuthor().split("&")[0]);
        str_author.setText(mHpEntityBean.getStrAuthor().split("&")[1]);
        String strContent = mHpEntityBean.getStrContent();
        if(strContent == null){
            strContent = "";
        }
        if(strContent.contains("by")){
            String[] split = strContent.split("by");
            str_content_author.setText("--by "+split[1]);
            strContent = split[0];
        }else if(strContent.contains("from")){
            String[] split = strContent.split("from");
            str_content_author.setText("--from "+split[1]);
            strContent = split[0];
        }
        str_content.setText(strContent);
        Glide.with(this).load(mHpEntityBean.getStrOriginalImgUrl()).into(img_thumb);

    }

    private void initEvent() {
        mImgSend.setOnClickListener(this);
        mImgDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 下载功能
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ImageUtil.saveImage(
                                HomeDetailActivity.this,
                                mHpEntityBean.getStrOriginalImgUrl(),
                                HomeDetailActivity.this);
                    }
                }).start();
            }
        });
    }

    @Override
    public void onClick(View v) {
        // 分享功能
        Intent intent = new Intent(Intent.ACTION_SEND); // 启动分享发送的属性
        intent.setType("text/plain"); // 分享发送的数据类型
        intent.putExtra(Intent.EXTRA_SUBJECT, mHpEntityBean.getStrAuthor().split("&")[0]); // 分享的主题
        String text = mHpEntityBean.getStrAuthor().split("&")[0] + " : " + mHpEntityBean.getSWebLk();
        intent.putExtra(Intent.EXTRA_TEXT, text); // 分享的内容
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, "分享 这个图片 给好友")); // 目标应用选择对话框的标题
    }

    @Override
    public void onDownLoadSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(mRelativeLayout,"图片下载成功",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
