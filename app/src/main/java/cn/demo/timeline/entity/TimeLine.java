package cn.demo.timeline.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */

public class TimeLine implements Serializable {

    /**
     * msgCode : 0000
     * isSuccess : true
     * rows : [{"daylist":[{"datalist":[{"id":"1100000000000005521","progress":"45","name":"测试1111测试"},{"id":"1100000000000005560","progress":"50","name":"陈测试"}],"month":"01","day":"12"}],"month":"01","year":"2017"},{"daylist":[{"datalist":[{"id":"1100000000000005193","progress":"73","name":"bai-test111111"},{"id":"1100000000000005197","progress":"75","name":"bai-test(课程)"},{"id":"1100000000000005342","progress":"80","name":"kecheng"}],"month":"02","day":"17"},{"datalist":[{"id":"1100000000000005353","progress":"65","name":"课程名称kecheng名称名称"},{"id":"1100200000000005530","progress":"32","name":"测试开始学习"}],"month":"02","day":"18"},{"datalist":[{"id":"1100200000000005530","progress":"21","name":"测试开始学习"}],"month":"02","day":"19"}],"month":"02","year":"2017"}]
     */

    private String msgCode;
    private String isSuccess;
    private List<RowsBean> rows;

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean implements Serializable {
        /**
         * daylist : [{"datalist":[{"id":"1100000000000005521","progress":"45","name":"测试1111测试"},{"id":"1100000000000005560","progress":"50","name":"陈测试"}],"month":"01","day":"12"}]
         * month : 01
         * year : 2017
         */

        private String month;
        private String year;
        private List<DaylistBean> daylist;

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public List<DaylistBean> getDaylist() {
            return daylist;
        }

        public void setDaylist(List<DaylistBean> daylist) {
            this.daylist = daylist;
        }

        public static class DaylistBean implements Serializable {
            /**
             * datalist : [{"id":"1100000000000005521","progress":"45","name":"测试1111测试"},{"id":"1100000000000005560","progress":"50","name":"陈测试"}]
             * month : 01
             * day : 12
             */

            private String month;
            private String day;
            private List<DatalistBean> datalist;

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public List<DatalistBean> getDatalist() {
                return datalist;
            }

            public void setDatalist(List<DatalistBean> datalist) {
                this.datalist = datalist;
            }

            public static class DatalistBean implements Serializable {
                /**
                 * id : 1100000000000005521
                 * progress : 45
                 * name : 测试1111测试
                 */

                private String id;
                private String progress;
                private String name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getProgress() {
                    return progress;
                }

                public void setProgress(String progress) {
                    this.progress = progress;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
