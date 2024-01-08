package service;

import Entity.News;
import Model.Newsrequest;

import java.util.List;

public interface NewsService {


    Long addNews(Newsrequest newsrequest);

    List<News> getPaginatedNews();

    void deleteNewsById(Long id);
}
