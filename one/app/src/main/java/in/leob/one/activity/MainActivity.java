package in.leob.one.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Date;

import in.leob.one.R;
import in.leob.one.fragment.ArticleFragment;
import in.leob.one.fragment.HomeFragment;
import in.leob.one.fragment.QuestionFragment;
import in.leob.one.util.DateUtil;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tab_layout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initView();
    }

    private void initView() {
        initToolBar();
        initViewPager();
        initTabLayout();

    }

    private void initViewPager() {
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);
        viewPager.setOffscreenPageLimit(3);
    }

    private void initTabLayout() {
        //绑定下部的viewpager
        tab_layout.setupWithViewPager(viewPager);
        //让三个指示器平均分配位置
        tab_layout.setTabMode(TabLayout.MODE_FIXED);
    }

    private void initToolBar() {
        //顶部导航
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("一 个");
    }

    private void initUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    //右上角点击进入关于Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    class MyAdapter extends FragmentStatePagerAdapter {
        final int PAGER_COUNT = 3;
        private String[] pagers = new String[]{"首页", "文章", "问答"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Date date = new Date();
            String formateDate = DateUtil.getDate(date);
            Bundle bundle = new Bundle();
            bundle.putString("date", formateDate);
            switch (position) {
                case 0:
                    HomeFragment homeFragment = new HomeFragment();
                    homeFragment.setArguments(bundle);
                    return homeFragment;

                case 1:
                    ArticleFragment articleFragment = new ArticleFragment();
                    articleFragment.setArguments(bundle);
                    return articleFragment;

                case 2:
                    QuestionFragment questionFragment = new QuestionFragment();
                    questionFragment.setArguments(bundle);
                    return questionFragment;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return PAGER_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pagers[position];
        }
    }

    //返回按钮处理--按两次退出
    private long lastTime=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if(System.currentTimeMillis()-lastTime>3000) {
                Snackbar.make(tab_layout,"再按一次即可退出",Snackbar.LENGTH_SHORT).show();
                lastTime=System.currentTimeMillis();
            }else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about :
                // 跳转到关于界面
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
