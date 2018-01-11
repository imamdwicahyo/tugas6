/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.imamdc.latihanmvcjdbc.main;

import edu.imamdc.latihanmvcjdbc.database.KingsBarbershopDatabase;
import edu.imamdc.latihanmvcjdbc.entity.Pelanggan;
import edu.imamdc.latihanmvcjdbc.eror.PelangganException;
import edu.imamdc.latihanmvcjdbc.service.PelangganDAO;
import edu.imamdc.latihanmvcjdbc.view.MainViewPelanggan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author IDC
 * Nim 10116494
 * Nama Imam Dwi Cahyo
 * Kelas PBO-11
 * 
 */
public class LatihanCRUDMVCDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, PelangganException {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainViewPelanggan pelanggan = new MainViewPelanggan();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (SQLException e) {
                } catch (PelangganException ex) {
                    Logger.getLogger(LatihanCRUDMVCDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
