package com.example.shaobozhuang.myapplication.bean;

import java.util.List;

public class NewstBean {
    private List<TalkerBean> talkers;

    private List<WorkBean> works;

    private List<NoticeBean> notices;

    public List<TalkerBean> getTalkers() {
        return talkers;
    }

    public void setTalkers(List<TalkerBean> talkers) {
        this.talkers = talkers;
    }

    public List<WorkBean> getWorks() {
        return works;
    }

    public void setWorks(List<WorkBean> works) {
        this.works = works;
    }

    public List<NoticeBean> getNotices() {
        return notices;
    }

    public void setNotices(List<NoticeBean> notices) {
        this.notices = notices;
    }

    public static class NoticeBean {
        private String otherName;
        private String noticeContent;

        public String getOtherName() {
            return otherName;
        }

        public void setOtherName(String otherName) {
            this.otherName = otherName;
        }

        public String getNoticeContent() {
            return noticeContent;
        }

        public void setNoticeContent(String noticeContent) {
            this.noticeContent = noticeContent;
        }
    }
    public static class WorkBean {
        private String otherName;
        private String taskName;

        public String getOtherName() {
            return otherName;
        }

        public void setOtherName(String otherName) {
            this.otherName = otherName;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }
    }
    public static class TalkerBean {
        private String name;
        private String headImg;
        private String message;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
