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
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import in.leob.one.R;
import in.leob.one.activity.ArticleWebActivity;
import in.leob.one.bean.Article;
import in.leob.one.listener.EndlessRecyclerOnScrollListener;
import in.leob.one.listener.OnItemClickListener;
import in.leob.one.util.OneApi;

/**
 * @author 曾威
 * @time 2016/11/10  9:28
 * @desc 文章的Fragment
 */

public class ArticleFragment extends Fragment implements OnItemClickListener {

    private RecyclerView mRecycler_article;
    private OnItemClickListener mListener;
    private String mDate;//当天日期
    private int count = 1;
    private ArticleAdapter mArticleAdapter;
    private ArrayList<Article> mArticleList = new ArrayList<>();
    private AsyncHttpClient client = new AsyncHttpClient();
    private BaseJsonHttpResponseHandler mHandler = new BaseJsonHttpResponseHandler<Article>() {

        @Override
        public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Article response) {
            Article.ContentEntityBean entity = response.getContentEntity();
            String contAuthor = entity.getStrContAuthor();//作者
            String marketTime = entity.getStrContMarketTime();//文章时间
            String contTitle = entity.getStrContTitle();//文章标题
            String sWebLk = entity.getSWebLk();//文章链接
            String gw = entity.getsGW();//内容摘要
            String strContAuthorIntroduce = entity.getStrContAuthorIntroduce();//责任编辑
            String strContent = entity.getStrContent();//内容

            Article.ContentEntityBean contentEntityBean = new Article.ContentEntityBean(strContent,sWebLk,
                    contTitle,contAuthor,marketTime,gw,strContAuthorIntroduce);
            Article article = new Article(contentEntityBean);
            mArticleList.add(article);
            mArticleAdapter.notifyDataSetChanged();//刷新适配器
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Article errorResponse) {
            Log.e("Failure", "Something wrong...");
        }

        @Override
        protected Article parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
            JSONObject jsonObject = new JSONObject(rawJsonData);
            JSONObject contentEntity = jsonObject.getJSONObject("contentEntity");
            String strContMarketTime = contentEntity.getString("strContMarketTime");
            String strContTitle = contentEntity.getString("strContTitle");
            String sAuth = contentEntity.getString("sAuth");
            String sWebLk = contentEntity.getString("sWebLk");
            String sGW = contentEntity.getString("sGW");
            String strContent = contentEntity.getString("strContent");
            String strContAuthorIntroduce = contentEntity.getString("strContAuthorIntroduce");
            Article.ContentEntityBean contentEntityBean = new Article.ContentEntityBean(strContent,sWebLk,strContTitle,sAuth,strContMarketTime,
                    sGW,strContAuthorIntroduce);
            Article article = new Article(contentEntityBean);
            return article;
        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mDate = bundle.getString("date");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /**----------使用RecyclerView来做布局----------**/

        initUI();
        initData();
        setUpArticleData();
    }

    private void initUI() {
        mRecycler_article = (RecyclerView) getActivity().findViewById(R.id.recycler_article);
    }

    private void initData() {
        mArticleAdapter = new ArticleAdapter(mArticleList);
        mArticleAdapter.setOnItemClickListener(this);
        mRecycler_article.setAdapter(mArticleAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecycler_article.setLayoutManager(linearLayoutManager);
        mRecycler_article.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            //加载更多
            public void onLoadMore(int current_page) {
                //设置最新的次数count
                count = count + 1;
                client.get(getContext(), OneApi.getOneTodayArticle(mDate, count), mHandler);
            }
        });
    }

    private void setUpArticleData() {
        for (int i = 1; i <= 3; i++) {
            client.get(getActivity(), OneApi.getOneTodayArticle(mDate, count), mHandler);
            count++;
        }
    }

    @Override
    public void onItemClick(View v, int position, Object obj) {



        Intent intent = new Intent(getActivity(), ArticleWebActivity.class);
        intent.putExtra(ArticleWebActivity.BEAN,(Article.ContentEntityBean)obj);

        Pair<View, String> p1 = Pair.create((View)v, "toolbar");
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation((Activity) getActivity(), p1);
        getActivity().startActivity(intent, options.toBundle());
    }

    private class ArticleAdapter extends RecyclerView.Adapter {

        public ArticleAdapter(ArrayList<Article> articleList) {
            mArticleList = articleList;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_article, parent, false);
            return new ArticleViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            //裁剪发布时间的字符串
            final Article.ContentEntityBean bean = mArticleList.get(position).getContentEntity();
            String [] contMarketTime = bean.getStrContMarketTime().split(" ");
            String marketTime = contMarketTime[0];
            //裁剪发布作者的字符串
            String[] conAuthors = bean.getStrContAuthor().split("。 ");
            String conAuthor = conAuthors[0];
            //调整发布内容的字符串
            String content = bean.getStrContent().replaceAll("<br>", " ");
            ((ArticleViewHolder) holder).tv_article_title.setText(mArticleList.get(position).getContentEntity().getStrContTitle());
            ((ArticleViewHolder) holder).tv_author.setText(conAuthor);
            ((ArticleViewHolder) holder).tv_date.setText(marketTime);
            ((ArticleViewHolder) holder).mTv_content.setText(content);
            ((ArticleViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(v, position, bean);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mArticleList.size();
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            mListener = listener;
        }

    }

    private class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_date;
        private TextView tv_author;
        private TextView tv_article_title;
        private TextView mTv_content;


        public ArticleViewHolder(View itemView) {
            super(itemView);
            tv_article_title = (TextView) itemView.findViewById(R.id.tv_article_title);
            tv_author = (TextView) itemView.findViewById(R.id.tv_author);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            mTv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
