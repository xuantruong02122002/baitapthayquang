/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baibtaptuan6_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author TechCare
 */
public class BookModify {
     public static List<book> findAll() {
        List<book> bookList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
          
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly_book", "root", "");
            
            //query
            String sql = "select * from book";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                book b = new book(resultSet.getInt("id"), resultSet.getString("title"), 
                        resultSet.getString("price"));
                bookList.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return bookList;
    }
      public static void update(book b) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly_book", "root", "");
            
            //query
            String sql = "update book set title=?,price=? where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, b.getTitle());
            statement.setString(2, b.getPrice());
           
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
     public static void insert(book b) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly_book", "root", "");
            
            //query
            String sql = "insert into book( title, price) values(  ?, ?)";
            statement = connection.prepareCall(sql);
            
            
            statement.setString(1, b.getTitle());
            statement.setString(2, b.getPrice());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
     public static List<book> findByTitle(String title) {
        List<book> bookList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly_book", "root", "");
            
           
            String sql = "select * from book where title like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+title+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                book b = new book(resultSet.getInt("id"), resultSet.getString("price"),resultSet.getString("title"));
                bookList.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return bookList;
    }


       public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly_book", "root", "");
            
            //query
            String sql = "delete from book where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            
                statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
    }


}
