/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.imamdc.latihanmvcjdbc.event;

import edu.imamdc.latihanmvcjdbc.entity.Pelanggan;
import edu.imamdc.latihanmvcjdbc.model.PelangganModel;

/**
 *
 * @author IDC
 * Nim 10116494
 * Nama Imam Dwi Cahyo
 * Kelas PBO-11
 * 
 */
public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    public void onInsert(Pelanggan pelanggan);
    public void onDelete();
    public void onUpdate(Pelanggan pelanggan);
    
}
