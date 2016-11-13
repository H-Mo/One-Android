package in.leob.one.bean;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;

/**
 * @author leobin
 * @time 2016/11/10  14:25
 * @desc 首页数据封装
 */
public class Home extends RecyclerView.ViewHolder {

    private HpEntityBean hpEntity;
    private String result;

    public Home(View itemView) {
        super(itemView);
    }

    public HpEntityBean getHpEntity() {
        return hpEntity;
    }

    public void setHpEntity(HpEntityBean hpEntity) {
        this.hpEntity = hpEntity;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static class HpEntityBean implements Serializable{
        private String strHpTitle;//标题
        private String strOriginalImgUrl;//图片路径
        private String strAuthor;//作者
        private String strContent;//内容
        private String strMarketTime;//日期
        private String strThumbnailUrl;

        private String sWebLk;

        public String getSWebLk() {
            return sWebLk;
        }

        public void setSWebLk(String sWebLk) {
            this.sWebLk = sWebLk;
        }

        @Override
        public String toString() {
            return "HpEntityBean{" +
                    "strHpTitle='" + strHpTitle + '\'' +
                    ", strOriginalImgUrl='" + strOriginalImgUrl + '\'' +
                    ", strAuthor='" + strAuthor + '\'' +
                    ", strContent='" + strContent + '\'' +
                    ", strMarketTime='" + strMarketTime + '\'' +
                    ", strThumbnailUrl='" + strThumbnailUrl + '\'' +
                    '}';
        }

        public String getStrThumbnailUrl() {
            return strThumbnailUrl;
        }

        public void setStrThumbnailUrl(String strThumbnailUrl) {
            this.strThumbnailUrl = strThumbnailUrl;
        }

        public String getStrHpTitle() {
            return strHpTitle;
        }

        public void setStrHpTitle(String strHpTitle) {
            this.strHpTitle = strHpTitle;
        }

        public String getStrOriginalImgUrl() {
            return strOriginalImgUrl;
        }

        public void setStrOriginalImgUrl(String strOriginalImgUrl) {
            this.strOriginalImgUrl = strOriginalImgUrl;
        }

        public String getStrAuthor() {
            return strAuthor;
        }

        public void setStrAuthor(String strAuthor) {
            this.strAuthor = strAuthor;
        }

        public String getStrContent() {
            return strContent;
        }

        public void setStrContent(String strContent) {
            this.strContent = strContent;
        }

        public String getStrMarketTime() {
            return strMarketTime;
        }

        public void setStrMarketTime(String strMarketTime) {
            this.strMarketTime = strMarketTime;
        }
    }
}
