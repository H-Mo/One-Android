package in.leob.one.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.leob.one.R;
import in.leob.one.bean.Question;
import in.leob.one.listener.OnItemClickListener;

/**
 * @author H-Mo
 * @time 16/11/10  10:15
 * @desc ${TODD}
 */
public class QuestionAdapter extends RecyclerView.Adapter {

    private List<Question> mData;
    private OnItemClickListener mListener;

    public void setItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public void setData(List<Question> data){
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_question, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Question bean = mData.get(position);
        // 填充数据
        String title = bean.getStrQuestionMarketTime() + "  " + bean.getStrQuestionTitle();
        ((MyViewHolder)holder).text.setText(title);
        // 触发点击事件监听器
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(v,position,bean);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.question_text_tv);
        }
    }

}
