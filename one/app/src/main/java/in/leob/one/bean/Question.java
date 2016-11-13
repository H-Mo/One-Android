package in.leob.one.bean;

import java.io.Serializable;

/**
 * @author leobin
 * @time 2016/11/10  14:44
 * @desc 问答数据的封装
 */
public class Question implements Serializable{
    private String strQuestionTitle;
    private String strQuestionContent;
    private String strAnswerTitle;
    private String strAnswerContent;

    private String sEditor;//责任编辑
    private String strQuestionMarketTime;//时间
    private String sWebLk;

    public String getSWebLk() {
        return sWebLk;
    }

    public void setSWebLk(String sWebLk) {
        this.sWebLk = sWebLk;
    }

    public String getSEditor() {
        return sEditor;
    }

    public void setSEditor(String sEditor) {
        this.sEditor = sEditor;
    }

    public String getStrQuestionMarketTime() {
        return strQuestionMarketTime;
    }

    public void setStrQuestionMarketTime(String strQuestionMarketTime) {
        this.strQuestionMarketTime = strQuestionMarketTime;
    }


    public String getStrQuestionTitle() {
        return strQuestionTitle;
    }

    public void setStrQuestionTitle(String strQuestionTitle) {
        this.strQuestionTitle = strQuestionTitle;
    }

    public String getStrQuestionContent() {
        return strQuestionContent;
    }

    public void setStrQuestionContent(String strQuestionContent) {
        this.strQuestionContent = strQuestionContent;
    }

    public String getStrAnswerTitle() {
        return strAnswerTitle;
    }

    public void setStrAnswerTitle(String strAnswerTitle) {
        this.strAnswerTitle = strAnswerTitle;
    }

    public String getStrAnswerContent() {
        return strAnswerContent;
    }

    public void setStrAnswerContent(String strAnswerContent) {
        this.strAnswerContent = strAnswerContent;
    }
}
