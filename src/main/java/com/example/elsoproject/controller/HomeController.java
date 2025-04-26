package com.example.elsoproject.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.elsoproject.domain.Story;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String stories(Model model){
        model.addAttribute("pageTitle", "Minden napra egy SFJ sztori");
        model.addAttribute("stories", getStories());
        return "stories";
    }

    @RequestMapping("/user/{id}")
    public String searchForStory(@PathVariable(value = "id") String id, Model model) throws Exception {
        ArrayList<Story> stories = new ArrayList<>();
        Story searchedStory = null;
        stories = getStories();
        for (Story s : stories){
            if (String.valueOf(s.getId()).equals(id)){
                searchedStory = s;
            }
        }

        model.addAttribute("story", searchedStory);

        return "searchedstory";
    }

    private ArrayList<Story> getStories(){
        ArrayList<Story> stories = new ArrayList<>();

        Story story1 = new Story();
        story1.setId(0);
        story1.setTitle("Elso storym");
        story1.setPosted(new Date());
        story1.setAuthor("Prusko");
        story1.setContent("<p>Na ez az adat mar eles adat.</p>");
        
        Story story2 = new Story();
        story2.setId(1);
        story2.setTitle("Masodik storym");
        story2.setPosted(new Date());
        story2.setAuthor("Gyula");
        story2.setContent("<p>Gyula tortenete senkit nem erdekel.</p>");

        Story story3 = new Story();
        story3.setId(2);
        story3.setTitle("Harmadik storym");
        story3.setPosted(new Date());
        story3.setAuthor("Csini");
        story3.setContent("<p>Csinos a csani.</p>");

        stories.add(story1);
        stories.add(story2);
        stories.add(story3);

        return stories;
    }
}
