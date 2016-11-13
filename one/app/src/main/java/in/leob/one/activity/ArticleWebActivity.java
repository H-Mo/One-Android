package in.leob.one.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.Serializable;

import in.leob.one.R;
import in.leob.one.bean.Article;

/**
 * @author 曾威
 * @time 2016/11/10  9:50
 * @desc ${TODD}
 */

public class ArticleWebActivity extends AppCompatActivity {
    public static final String BEAN = "bean";
    private Toolbar mToolbar;
    private WebView mArticleWebView;
    private Article.ContentEntityBean mBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        setContentView(R.layout.activity_webview);
        mToolbar = (Toolbar)  findViewById(R.id.toolbar);
        mArticleWebView = (WebView) findViewById(R.id.article_webView);
        setSupportActionBar(mToolbar);
        // 设置标题
        getSupportActionBar().setTitle("一个");
        // 显示那个箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 后退键功能
                onBackPressed();
            }
        });
    }

    private void initData() {
        // 取出数据
        mBean = (Article.ContentEntityBean) getIntent().getSerializableExtra(BEAN);
        // 允许执行js
        mArticleWebView.getSettings().setJavaScriptEnabled(true);
        // 允许本地缓存
        mArticleWebView.getSettings().setAllowFileAccess(true);
        mArticleWebView.getSettings().setDomStorageEnabled(true);
        mArticleWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        // 加载网页
        mArticleWebView.loadUrl("file:///android_asset/article.html");
    }


    private void initEvent() {
        mArticleWebView.setWebViewClient(new WebViewClient() {
            // 设置重定向监听
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            // 监听页面加载完成
            @Override
            public void onPageFinished(WebView view, String url) {
                // 加载测试数据
                mArticleWebView.loadUrl("javascript:setHeaderTitle('"+mBean.getStrContTitle()+"');");
                mArticleWebView.loadUrl("javascript:setContAuthor('作者：" + mBean.getStrContAuthor() + "');");
                mArticleWebView.loadUrl("javascript:setContentBody('" + mBean.getStrContent() + "');");
                mArticleWebView.loadUrl("javascript:setInfo('"+mBean.getStrContAuthorIntroduce()+"');");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case  R.id.action_share:
                // 分享功能
                Intent intent = new Intent(Intent.ACTION_SEND); // 启动分享发送的属性
                intent.setType("text/plain"); // 分享发送的数据类型
                intent.putExtra(Intent.EXTRA_SUBJECT, mBean.getStrContTitle()); // 分享的主题
                String text = mBean.getStrContTitle() + " : " + mBean.getSWebLk();
                intent.putExtra(Intent.EXTRA_TEXT, text); // 分享的内容
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent, "分享 这篇文章 给好友")); // 目标应用选择对话框的标题
                break;
        }
        return true;
    }
}
