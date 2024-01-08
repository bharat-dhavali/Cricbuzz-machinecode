package service;



import Entity.Video;
import Model.Videorequest;

import java.util.List;

public interface VideoService {


    Long addvideo(Videorequest videorequest);

    void deleteVideoById(Long id);

    List<Video> getvideos();
}
