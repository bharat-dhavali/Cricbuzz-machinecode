package service;

import Entity.News;
import Model.Newsrequest;
import Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceimpl implements NewsService{

    @Autowired
    private NewsRepository newsRepository;


    @Override
    public Long addNews(Newsrequest newsrequest) {
        News news=News.builder().title(newsrequest.getTitle()).content(newsrequest.getContent()).build();

        newsRepository.save(news);

        return news.getId();
    }

    @Override
    public List<News> getPaginatedNews() {

        return newsRepository.findAll();

    }

    @Override
    public void deleteNewsById(Long id) {

        newsRepository.deleteById(id);


    }
}
