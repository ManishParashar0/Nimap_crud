package com.manish.CRUDoperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.CRUDoperation.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
