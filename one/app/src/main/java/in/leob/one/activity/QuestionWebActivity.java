package in.leob.one.activity;

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
import android.widget.Toast;

import in.leob.one.R;
import in.leob.one.bean.Question;

/**
 * @author H-Mo
 * @time 16/11/10  15:19
 * @desc ${TODD}
 */
public class QuestionWebActivity extends AppCompatActivity {

    public static final String QUESTION_BEAN = "question_bean";

    private WebView mWebView;
    private Question mQuestion;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        setContentView(R.layout.activity_question);
        // 找到webView
        mWebView = (WebView) findViewById(R.id.question_webView);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
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
        // 取出传递过来的数据
        mQuestion = (Question) getIntent().getSerializableExtra(QUESTION_BEAN);
        // 允许执行js
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 允许本地缓存
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        // 加载网页
        mWebView.loadUrl("file:///android_asset/question.html");
    }

    private void initEvent() {

        mWebView.setWebViewClient(new WebViewClient() {
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
                mWebView.loadUrl("javascript:setHeaderTitle('"+mQuestion.getStrQuestionTitle()+"');");
                mWebView.loadUrl("javascript:setHeaderBody('" + mQuestion.getStrQuestionContent() + "');");
                mWebView.loadUrl("javascript:setContentTitle('" + mQuestion.getStrAnswerTitle() + "');");
                mWebView.loadUrl("javascript:setContentBody('" + mQuestion.getStrAnswerContent() + "');");
                mWebView.loadUrl("javascript:setInfo('"+mQuestion.getSEditor()+"');");
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
                intent.putExtra(Intent.EXTRA_SUBJECT, mQuestion.getStrQuestionTitle()); // 分享的主题
                String text = mQuestion.getStrQuestionTitle() + " : " + mQuestion.getSWebLk();
                intent.putExtra(Intent.EXTRA_TEXT, text); // 分享的内容
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent, "分享 这篇问答 给好友")); // 目标应用选择对话框的标题
                break;
        }
        return true;
    }
}
