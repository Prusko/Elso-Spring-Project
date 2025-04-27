package com.example.elsoproject.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elsoproject.domain.Blogger;
import com.example.elsoproject.domain.Story;
import com.example.elsoproject.repository.BloggerRepository;
import com.example.elsoproject.repository.StoryRepository;

import jakarta.annotation.PostConstruct;

@Service
public class StoryService {

    private StoryRepository storyRepo;
    private BloggerRepository bloggerRepo;

    @Autowired
    public void setStoryRepo(StoryRepository storyRepo) {
        this.storyRepo = storyRepo;
    }

    @Autowired
    public void setBloggerRepo(BloggerRepository bloggerRepo) {
        this.bloggerRepo = bloggerRepo;
    }

    public List<Story> getStories() {
        return storyRepo.findAll();
    }
    
    @PostConstruct
    private void init(){
        Blogger blogger = new Blogger("Gyula", 21);
        bloggerRepo.save(blogger);

        Story story = new Story("Teszt cim", "Nem sok minden lesz itt", LocalDate.parse("2025-11-30"), blogger);
        storyRepo.save(story);
    }
}
