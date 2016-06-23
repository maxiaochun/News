package com.xiao.news.domin;

import java.util.List;

/**
 * Created by hasee on 2016/6/19.
 */
public class NewsTabBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-06-23 16:45","title":"山东一精神病被囚锁小屋21年 铁索切开嚎啕痛哭","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/6/23/20160623161525afd77_550.jpg.119x83.jpg","url":"http://news.163.com/16/0623/16/BQ8RBRV600011229.html#f=slist"},{"ctime":"2016-06-23 17:27","title":"男子半边脸被削后让狗叼走啃食 医生白忙25小时","description":"网易社会","picUrl":"http://s.cimg.163.com/photo/0001/2016-06-23/t_BQ8T2CEL00AP0001.peg.119x83.jpg","url":"http://news.163.com/16/0623/17/BQ8TOFP000011229.html#f=slist"},{"ctime":"2016-06-23 16:04","title":"广东陆丰重大制毒案被告人蔡谦被依法执行死刑","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/6/23/20160623154531df805.jpg.119x83.jpg","url":"http://news.163.com/16/0623/16/BQ8P11UT00014JB6.html#f=slist"},{"ctime":"2016-06-23 16:08","title":"内蒙古村支书66刀捅死钉子户案再审宣判:处死刑","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/B7/B79074DA42F5BBB479A1FBA8B1DDBFF2.png.119x83.jpg","url":"http://news.163.com/16/0623/16/BQ8P7QO40001124J.html#f=slist"},{"ctime":"2016-06-23 16:15","title":"山西一女生下跪遭同学掌掴 校方瞒报或被追责","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/6/23/20160623161525afd77_550.jpg.119x83.jpg","url":"http://news.163.com/16/0623/16/BQ8PKU1I00011229.html#f=slist"},{"ctime":"2016-06-23 14:29","title":"游客埃及旅游一家被虫咬 获赔约10万人民币","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/1/13/13A04B8058633D061CA58305E68749DE.jpg.119x83.jpg","url":"http://news.163.com/16/0623/14/BQ8JHFP800014Q4P.html#f=slist"},{"ctime":"2016-06-23 14:56","title":"揭秘烟台遗体搬运工:一天洗20多遍手 绝不说再见","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/A/A3/A38724022FC558D1CFEAE19F6EB90AFD.jpg.119x83.jpg","url":"http://news.163.com/16/0623/14/BQ8L30GQ00011229.html#f=slist"},{"ctime":"2016-06-23 15:01","title":"奇葩惯偷:前年被抓 出狱后烧香求平安行窃","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/C/CD/CD5B1A72568F11DE66291A06547A308A.jpg.119x83.jpg","url":"http://news.163.com/16/0623/15/BQ8LDQKD00011229.html#f=slist"},{"ctime":"2016-06-23 15:24","title":"海城恶性案件犯罪嫌疑人已确认死亡","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/6/23/20160623154531df805.jpg.119x83.jpg","url":"http://news.163.com/16/0623/15/BQ8MME9300011229.html#f=slist"},{"ctime":"2016-06-23 13:59","title":"北京高考理科状元周展平：最爱去图书馆","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/BC/BCFDDED7392E115A03BBA67BCA3BDB8C.jpg.119x83.jpg","url":"http://news.163.com/16/0623/13/BQ8HRGUI00014SEH.html#f=slist"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-06-23 16:45
     * title : 山东一精神病被囚锁小屋21年 铁索切开嚎啕痛哭
     * description : 网易社会
     * picUrl : http://s.cimg.163.com/cnews/2016/6/23/20160623161525afd77_550.jpg.119x83.jpg
     * url : http://news.163.com/16/0623/16/BQ8RBRV600011229.html#f=slist
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}