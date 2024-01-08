package Controller;
import Entity.News;
import Model.Newsrequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.NewsService;

import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> getNews() {
        List<News> news1= newsService.getPaginatedNews();
        return new ResponseEntity(news1,HttpStatus.FOUND);
    }

    // Insert news
    @PostMapping("addnews")
    public ResponseEntity<Long> addNews(@RequestBody Newsrequest newsrequest){
        Long id=newsService.addNews(newsrequest);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }



    @DeleteMapping("news/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable Long id) {
        newsService.deleteNewsById(id);
        return new ResponseEntity<>("News with ID " + id + " deleted successfully", HttpStatus.OK);
    }
}

