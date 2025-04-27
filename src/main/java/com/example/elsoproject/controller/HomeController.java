package com.example.elsoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.elsoproject.domain.Story;
import com.example.elsoproject.service.StoryService;

@Controller
public class HomeController {

    private StoryService storyService;

    @Autowired
    public void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }

    @RequestMapping("/")
    public String stories(Model model){
        model.addAttribute("pageTitle", "Minden napra egy SFJ sztori");
        model.addAttribute("stories", storyService.getStories());
        return "stories";
    }

    @RequestMapping("/user/{id}")
    public String searchForStory(@PathVariable(value = "id") String id, Model model) throws Exception {
        List<Story> stories = storyService.getStories();
        Story searchedStory = null;
        for (Story s : stories){
            if (String.valueOf(s.getId()).equals(id)){
                searchedStory = s;
            }
        }

        model.addAttribute("story", searchedStory);

        return "searchedstory";
    }
}
