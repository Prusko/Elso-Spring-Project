package com.example.elsoproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.elsoproject.domain.Story;

public interface StoryRepository extends CrudRepository<Story, Long> {

    List<Story> findAll();

}
