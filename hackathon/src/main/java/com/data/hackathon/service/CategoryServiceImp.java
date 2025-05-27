package com.data.hackathon.service;

import com.data.hackathon.model.Category;
import com.data.hackathon.model.Category;
import com.data.hackathon.repository.CategoryDao;
import com.data.hackathon.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        System.out.println(categoryDao.findAll());
        return categoryDao.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public void insert(Category Category) {
        categoryDao.insert(Category);
    }

    @Override
    public void update(Category Category) {
        categoryDao.update(Category);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }
}
