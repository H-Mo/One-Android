package in.leob.one.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import in.leob.one.R;

public class AboutActivity extends AppCompatActivity {

  private CollapsingToolbarLayout collapsing_toolbar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
    }

    private void initView() {
        collapsing_toolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        collapsing_toolbar.setTitle("关于");//给actonbar设置标题(actionbar被包含在这个控件里面)
        setSupportActionBar(toolbar);//将toolbar作为actionbar控件
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//给左上角设置返回图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
