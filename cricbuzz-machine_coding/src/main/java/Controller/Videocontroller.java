package Controller;
import Entity.News;
import Entity.Video;

import Model.Videorequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import service.VideoService;

import java.util.List;

@RestController
@RequestMapping("news")
public class Videocontroller {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<List<News>> getvideo() {
        List<Video> news1= videoService.getvideos();
        return new ResponseEntity(news1,HttpStatus.FOUND);
    }

    // Insert news
    @PostMapping("addnews")
    public ResponseEntity<Long> addVideo(@RequestBody Videorequest videorequest){
        Long id=videoService.addvideo(videorequest);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }



    @DeleteMapping("videos/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable Long id) {
        videoService.deleteVideoById(id);
        return new ResponseEntity<>("Video with ID " + id + " deleted successfully", HttpStatus.OK);
    }
}

