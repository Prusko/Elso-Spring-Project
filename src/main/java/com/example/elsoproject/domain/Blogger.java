package com.example.elsoproject.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Blogger {

    @SequenceGenerator(name = "blogger_sequence", sequenceName = "blogger_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "blogger_sequence")
    @Id
    private Long id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "blogger")
    private List<Story> stories;

    private Blogger() {}

    
    public Blogger(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    };
    
}
