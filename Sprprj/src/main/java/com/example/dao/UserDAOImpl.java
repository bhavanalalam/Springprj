package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.dto.UserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDAOImpl implements UserDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/userdb1";
    private static final String USER = "root";  
    private static final String PASS = "root";  
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean registerUser(UserDTO user) {
        boolean status = false;
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            ps.setString(3, hashedPassword);
            int rows = ps.executeUpdate();
            status = rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public UserDTO loginUser(String email, String password) {
        UserDTO user = null;
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String storedHash = rs.getString("password"); 

           
                if (passwordEncoder.matches(password, storedHash)) {
                    user = new UserDTO();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                   
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
