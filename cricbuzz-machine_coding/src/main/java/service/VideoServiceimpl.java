package service;


import Entity.Video;
import Model.Videorequest;
import Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceimpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;


    @Override
    public Long addvideo(Videorequest videorequest) {

        Video video = Video.builder().title(videorequest.getTitle()).url(videorequest.getUrl())
                .build();
        videoRepository.save(video);

        return video.getId();

    }

    @Override
    public void deleteVideoById(Long id) {

        videoRepository.deleteById(id);
    }

    @Override
    public List<Video> getvideos() {

        return videoRepository.findAll();

    }
}
