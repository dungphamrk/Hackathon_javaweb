package com.data.hackathon.repository;

import com.data.hackathon.model.Category;
import com.data.hackathon.util.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDao {

    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        String sql = "{call get_all_categories()}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                Category p = new Category();
                p.setCategory_id(rs.getInt("category_id"));
                p.setCategory_name(rs.getString("category_name"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Category findById(int id) {
        String sql = "{call find_category_by_id(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    Category p = new Category();
                    p.setCategory_id(rs.getInt("Category_id"));
                    p.setCategory_name(rs.getString("Category_name"));
                    p.setDescription(rs.getString("description"));
                    p.setStatus(rs.getInt("status"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Category category) {
        String sql = "{call insert_category(?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, category.getCategory_name());
            cs.setInt(2, category.getStatus());
            cs.setString(3, category.getDescription());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Category Category) {
        String sql = "{call update_category(?, ?, ?,?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, Category.getCategory_id());
            cs.setString(2, Category.getCategory_name());
            cs.setInt(3, Category.getStatus());
            cs.setString(4, Category.getDescription());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "{call delete_category(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

