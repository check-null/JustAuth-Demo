package me.zhyd.justauth.vo;

import java.util.Objects;

public class QQVO {
    private Integer ret;
    private String msg;
    private String nickname;
    private String figureurl;
    private String figureurl1;
    private String figureurl2;
    private String figureurlQq1;
    private String figureurlQq2;
    private String gender;

    public QQVO(Integer ret, String msg, String nickname, String figureurl, String figureurl1, String figureurl2, String figureurlQq1, String figureurlQq2, String gender) {
        this.ret = ret;
        this.msg = msg;
        this.nickname = nickname;
        this.figureurl = figureurl;
        this.figureurl1 = figureurl1;
        this.figureurl2 = figureurl2;
        this.figureurlQq1 = figureurlQq1;
        this.figureurlQq2 = figureurlQq2;
        this.gender = gender;
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFigureurl() {
        return figureurl;
    }

    public void setFigureurl(String figureurl) {
        this.figureurl = figureurl;
    }

    public String getFigureurl1() {
        return figureurl1;
    }

    public void setFigureurl1(String figureurl1) {
        this.figureurl1 = figureurl1;
    }

    public String getFigureurl2() {
        return figureurl2;
    }

    public void setFigureurl2(String figureurl2) {
        this.figureurl2 = figureurl2;
    }

    public String getFigureurlQq1() {
        return figureurlQq1;
    }

    public void setFigureurlQq1(String figureurlQq1) {
        this.figureurlQq1 = figureurlQq1;
    }

    public String getFigureurlQq2() {
        return figureurlQq2;
    }

    public void setFigureurlQq2(String figureurlQq2) {
        this.figureurlQq2 = figureurlQq2;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QQVO qqvo = (QQVO) o;
        return Objects.equals(ret, qqvo.ret) &&
                Objects.equals(msg, qqvo.msg) &&
                Objects.equals(nickname, qqvo.nickname) &&
                Objects.equals(figureurl, qqvo.figureurl) &&
                Objects.equals(figureurl1, qqvo.figureurl1) &&
                Objects.equals(figureurl2, qqvo.figureurl2) &&
                Objects.equals(figureurlQq1, qqvo.figureurlQq1) &&
                Objects.equals(figureurlQq2, qqvo.figureurlQq2) &&
                Objects.equals(gender, qqvo.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ret, msg, nickname, figureurl, figureurl1, figureurl2, figureurlQq1, figureurlQq2, gender);
    }

    @Override
    public String toString() {
        return "QQVO{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", nickname='" + nickname + '\'' +
                ", figureurl='" + figureurl + '\'' +
                ", figureurl1='" + figureurl1 + '\'' +
                ", figureurl2='" + figureurl2 + '\'' +
                ", figureurlQq1='" + figureurlQq1 + '\'' +
                ", figureurlQq2='" + figureurlQq2 + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
