/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author ariel
 */
public class SqlHelper {
    
    static Logger log = Logger.getLogger(SqlHelper.class.getName());
    
    public static boolean hasColumn (ResultSet rs, String column) {
        try{
            rs.findColumn(column);
            return true;
        } catch (SQLException sqlex){
            log.warning("column doesn't exist " + column);
        }

        return false;
    }
    
}
