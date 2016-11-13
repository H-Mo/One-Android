package in.leob.one.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import in.leob.one.R;
import in.leob.one.bean.Home;
import in.leob.one.listener.OnItemClickListener;
import in.leob.one.ui.SmartImageView;

/**
 * Created by lenovo on 2016/11/10.
 */
public class HomeItemAdapter extends RecyclerView.Adapter  {
   private  OnItemClickListener mClickListener;
    private ArrayList<Home.HpEntityBean> mData;
    private Context mContext;



    public HomeItemAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<Home.HpEntityBean> datas) {
        mData = datas;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home, parent, false);
        return new MyViewHolder(view);
    }
    public void setOnItemClickListener(OnItemClickListener clickListener){
        mClickListener=clickListener;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Home.HpEntityBean hpEntityBean = mData.get(position);

        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.strAuthor.setText(hpEntityBean.getStrAuthor().split("&")[0]);
        viewHolder.strHpTitle.setText(hpEntityBean.getStrHpTitle());
        Glide.with(mContext).load(hpEntityBean.getStrThumbnailUrl()).into(viewHolder.strThumbnailUrl);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v,position,hpEntityBean);
            }
        });
    }

        @Override
        public int getItemCount () {
            return mData != null ? mData.size() : 0;
        }


        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView strAuthor;
            private TextView strHpTitle;
            private ImageView strThumbnailUrl;

            public MyViewHolder(View itemView) {
                super(itemView);
                strThumbnailUrl = (ImageView) itemView.findViewById(R.id.img_item_thumb);
                strAuthor = (TextView) itemView.findViewById(R.id.str_item_title);
                strHpTitle = (TextView) itemView.findViewById(R.id.str_item_hptitle);
            }


        }


}

