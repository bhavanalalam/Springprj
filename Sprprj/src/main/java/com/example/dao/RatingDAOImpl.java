package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.dto.RatingDTO;

public class RatingDAOImpl implements RatingDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/userdb1";
    private static final String USER = "root";
    private static final String PASS = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8+ driver
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean saveOrUpdateRating(RatingDTO rating) {
        boolean status = false;
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            // First try to update
            String updateSql = "UPDATE movie_ratings SET rating=? WHERE user_id=? AND movie_id=?";
            PreparedStatement psUpdate = con.prepareStatement(updateSql);
            psUpdate.setInt(1, rating.getRating());
            psUpdate.setInt(2, rating.getUserId());
            psUpdate.setInt(3, rating.getMovieId());
            int rows = psUpdate.executeUpdate();

            if (rows == 0) {
                // If no row updated, insert a new one
                String insertSql = "INSERT INTO movie_ratings(user_id, movie_id, rating) VALUES (?, ?, ?)";
                PreparedStatement psInsert = con.prepareStatement(insertSql);
                psInsert.setInt(1, rating.getUserId());
                psInsert.setInt(2, rating.getMovieId());
                psInsert.setInt(3, rating.getRating());
                rows = psInsert.executeUpdate();
            }

            status = rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public RatingDTO getUserRating(int userId, int movieId) {
        RatingDTO rating = null;
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT user_id, movie_id, rating FROM ratings WHERE user_id=? AND movie_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, movieId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rating = new RatingDTO();
                rating.setUserId(rs.getInt("user_id"));
                rating.setMovieId(rs.getInt("movie_id"));
                rating.setRating(rs.getInt("rating"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rating;
    }

}
