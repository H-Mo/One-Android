package in.leob.one.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import in.leob.one.R;
import in.leob.one.activity.QuestionWebActivity;
import in.leob.one.adapter.QuestionAdapter;
import in.leob.one.bean.Question;
import in.leob.one.listener.OnItemClickListener;
import in.leob.one.util.DateUtil;
import in.leob.one.util.OneApi;

/**
 * @author H-Mo
 * @time 16/11/10  9:50
 * @desc ${TODD}
 */
public class QuestionFragment extends Fragment implements OnItemClickListener {

    private RecyclerView mRecyclerView;
    private QuestionAdapter mAdapter;
    private Date mCurDate;
    private List<Question> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_question, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.question_list_rv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
        initEvent();
    }

    private void initDate() {
        // 初始化集合
        mData = new ArrayList<Question>();
        //必须要指定展示的效果，设置一个LayoutManager，不然还是会一片空白
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        // 创建适配器
        mAdapter = new QuestionAdapter();
        // 设置适配器
        mRecyclerView.setAdapter(mAdapter);
        // 请求数据
        AsyncHttpClient client = new AsyncHttpClient();
        //获取当前时间
        mCurDate = new Date(System.currentTimeMillis());
        for(int i = 0; i < 10; i++) {
            String date = DateUtil.getDate(mCurDate);
            String url = OneApi.getOneTodayQuestion(date,i);
            client.get(getActivity(), url, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    if(statusCode == 200){
                        // 解析 Json
                        Question bean = parseJson(responseString);
                        if(bean == null){
                            return;
                        }
                        // 添加到集合
                        mData.add(bean);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // 设置数据，并刷新适配器
                                mAdapter.setData(mData);
                                mAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }

                private Question parseJson(String json){
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        String result = jsonObject.getString("result");
                        if(result.equals("SUCCESS")){
                            // 请求数据成功
                            String questionJson = jsonObject.getString("questionAdEntity");
                            return JSON.parseObject(questionJson, Question.class);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            });
        }

    }


    private void initEvent() {
        // 监听点击事件
        mAdapter.setItemClickListener(this);
    }

    @Override
    public void onItemClick(View v, int position, Object obj) {
        // 跳转到 QuestionWebActivity
        Intent intent = new Intent(getActivity(),QuestionWebActivity.class);
        // 封装数据
        intent.putExtra(QuestionWebActivity.QUESTION_BEAN,(Question)obj);

        Pair<View, String> p1 = Pair.create((View)v, "toolbar");
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation((Activity) getActivity(), p1);
        getActivity().startActivity(intent, options.toBundle());
    }
}
