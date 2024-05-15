package com.judysocute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.judysocute.model.Menu;

public interface MenuRepository extends CrudRepository<Menu, String> {
}
