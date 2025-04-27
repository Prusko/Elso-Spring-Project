package com.example.elsoproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.elsoproject.domain.Blogger;

public interface BloggerRepository extends CrudRepository<Blogger, Long> {
    List<Blogger> findAll();
}
