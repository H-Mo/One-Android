package in.leob.one.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cz.msebera.android.httpclient.Header;
import in.leob.one.R;
import in.leob.one.activity.HomeDetailActivity;
import in.leob.one.adapter.HomeItemAdapter;
import in.leob.one.bean.Home;
import in.leob.one.listener.OnItemClickListener;
import in.leob.one.util.DateUtil;
import in.leob.one.util.OneApi;

/**
 * Created by lenovo on 2016/11/10.
 */
public class HomeFragment extends Fragment implements OnItemClickListener {
    private Activity mHomeActivity;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Home.HpEntityBean mHpEntity;
    private HomeItemAdapter mHomeItemAdapter;
    private ArrayList<Home.HpEntityBean> mHpEntityBeen;
    private boolean flag = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initUi();
        setRecyclerView();
        initEvent();

    }

    private void initEvent() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 清空原来的
                mHpEntityBeen.clear();
                // 重新请求数据
                getNetData();
            }
        });
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mHomeItemAdapter);
    }


    private void initUi() {
        mHomeActivity = getActivity();
        mRecyclerView = (RecyclerView) mHomeActivity.findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mHomeActivity.findViewById(R.id.refresh_container);

    }

    private void initData() {
        mHpEntityBeen = new ArrayList<Home.HpEntityBean>();
        mHomeItemAdapter = new HomeItemAdapter(getContext());
        mHomeItemAdapter.setOnItemClickListener(this);
        getNetData();
    }

    private void getNetData() {
        AsyncHttpClient client = new AsyncHttpClient();
        BaseJsonHttpResponseHandler<Home.HpEntityBean> homeResponseHandler =  new BaseJsonHttpResponseHandler<Home.HpEntityBean>() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Home.HpEntityBean response) {
                mHpEntityBeen.add(response);
                mHomeItemAdapter.setData(mHpEntityBeen);
                mHomeItemAdapter.notifyDataSetChanged();
                if(mHpEntityBeen.size() >= 10){
                    mSwipeRefreshLayout.setRefreshing(false);
                    if(flag){
                        flag = false;
                        return;
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Snackbar.make(mRecyclerView,"刷新成功",Snackbar.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Home.HpEntityBean errorResponse) {

            }

            @Override
            protected Home.HpEntityBean parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                JSONObject jsonObject = new JSONObject(rawJsonData);
                Home.HpEntityBean hpEntity = JSON.parseObject(jsonObject.getString("hpEntity"), Home.HpEntityBean.class);
                return hpEntity;

            }
        };

        Date date = new Date(System.currentTimeMillis());
        for(int i=0;i<10;i++){
            String url = OneApi.getOneTodayHome(DateUtil.getDate(date));
            client.get(url, homeResponseHandler);
            date=getNextDay(date);
        }
    }

    public  Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    @Override
    public void onItemClick(final View v, int position, final Object obj) {

        ImageView strThumbnailUrl = (ImageView) v.findViewById(R.id.img_item_thumb);
        TextView strAuthor = (TextView) v.findViewById(R.id.str_item_title);

        Intent intent = new Intent(getActivity(), HomeDetailActivity.class);
        intent.putExtra("ALL",(Home.HpEntityBean)obj);

        Pair<View, String> p1 = Pair.create((View)strAuthor, "name");
        Pair<View, String> p2 = Pair.create((View)strThumbnailUrl, "iv_content");
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation((Activity) getActivity(), p1, p2);
        getActivity().startActivity(intent, options.toBundle());

    }

}


