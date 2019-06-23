package cn.ousky.smartcampus.util;

import cn.ousky.smartcampus.entity.News;
import org.springframework.web.multipart.MultipartFile;

public class NewsUpLoad {
    private News news;
    private MultipartFile[] files;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
