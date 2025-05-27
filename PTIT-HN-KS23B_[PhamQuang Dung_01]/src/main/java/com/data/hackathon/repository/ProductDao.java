package com.data.hackathon.repository;

import com.data.hackathon.model.Product;
import com.data.hackathon.util.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductDao {

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        String sql = "{call get_all_products()}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                Product p = new Product();
                p.setProduct_id(rs.getInt("product_id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setPrice(rs.getDouble("price"));
                p.setImage(rs.getString("image"));
                p.setDescription(rs.getString("description"));
                p.setCreated_at(LocalDateTime.parse(rs.getString("created_at")));
                p.setStatus(rs.getInt("status"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product findById(int id) {
        String sql = "{call find_product_by_name(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    Product p = new Product();
                    p.setProduct_id(rs.getInt("product_id"));
                    p.setProduct_name(rs.getString("product_name"));
                    p.setPrice(rs.getDouble("price"));
                    p.setImage(rs.getString("image"));
                    p.setDescription(rs.getString("description"));
                    p.setCreated_at(LocalDateTime.parse(rs.getString("created_at")));
                    p.setStatus(rs.getInt("status"));
                    p.setCategory_name(rs.getString("category_name"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Product product) {
        String sql = "{call insert_product(?, ?, ?, ?, ?, ?,>)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, product.getProduct_name());
            cs.setDouble(2, product.getPrice());
            cs.setInt(3, product.getStatus());
            cs.setString(4, product.getImage());
            cs.setString(5, product.getDescription());
            cs.setString(6, product.getCreated_at().toString());
            cs.setString(7,product.getCategory_name());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Product product) {
        String sql = "{call update_product(?, ?, ?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, product.getProduct_name());
            cs.setDouble(2, product.getPrice());
            cs.setInt(3, product.getStatus());
            cs.setString(4, product.getImage());
            cs.setString(5, product.getDescription());
            cs.setString(6, product.getCreated_at().toString());
            cs.setString(7,product.getCategory_name());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "{call delete_product(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

