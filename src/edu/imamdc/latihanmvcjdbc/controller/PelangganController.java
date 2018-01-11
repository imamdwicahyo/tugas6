/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.imamdc.latihanmvcjdbc.controller;

import edu.imamdc.latihanmvcjdbc.model.PelangganModel;
import edu.imamdc.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;

/**
 *
 * @author IDC
 * Nim 10116494
 * Nama Imam Dwi Cahyo
 * Kelas PBO-11
 * 
 */
public class PelangganController {
    
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(PelangganView view){
        model.resetPelanggan();
    }
    
    public void insertPelanggan(PelangganView view){
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showConfirmDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length()>255) {
            JOptionPane.showConfirmDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if (telepon.length()>12) {
            JOptionPane.showConfirmDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (!email.contains("@")||!email.contains(".")) {
            JOptionPane.showConfirmDialog(view, "Format email todak valid");
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showConfirmDialog(view, new Object[]{"Terjadi eror didatabase dengan pesan ",throwable.getMessage()});
            }
        }
    }
    
    public void updatePelanggan(PelangganView view){
        if (view.getTablePelanggan().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silakan seleksi baris data yang akan di ubah");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtId().getText());
        
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showConfirmDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length()>255) {
            JOptionPane.showConfirmDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if (telepon.length()>12) {
            JOptionPane.showConfirmDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (!email.contains("@")||!email.contains(".")) {
            JOptionPane.showConfirmDialog(view, "Format email todak valid");
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Di ubah");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showConfirmDialog(view, new Object[]{"Terjadi eror didatabase dengan pesan ",throwable.getMessage()});
            }
        }
    }
    
    public void deletePelanggan(PelangganView view){
        if (view.getTablePelanggan().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silakan seleksi baris data yang akan di hapus");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus")==JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            
            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Di hapus");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showConfirmDialog(view, new Object[]{"Terjadi eror didatabase dengan pesan ",throwable.getMessage()});
            }
        }
        
    }    
}
