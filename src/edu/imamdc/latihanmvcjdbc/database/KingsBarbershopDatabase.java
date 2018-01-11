/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.imamdc.latihanmvcjdbc.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.imamdc.latihanmvcjdbc.impl.PelangganDAOImpl;
import edu.imamdc.latihanmvcjdbc.service.PelangganDAO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author IDC
 * Nim 10116494
 * Nama Imam Dwi Cahyo
 * Kelas PBO-11
 * 
 */
public class KingsBarbershopDatabase {
    
    private static Connection connection;
    private static PelangganDAO pelangganDao;
    
    public static Connection getConnection() throws SQLException{
        if (connection==null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/kingsbarbershop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();          
        }
        
        return connection;
    }
    
    public static PelangganDAO getPelangganDAO() throws SQLException{
        if (pelangganDao==null) {
            pelangganDao = new PelangganDAOImpl(getConnection());
        }
        
        return pelangganDao;
    }
    
}
