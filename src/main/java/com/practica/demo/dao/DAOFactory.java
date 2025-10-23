package com.practica.demo.dao;

import com.practica.demo.dao.mueble.DAOMueble;
import com.practica.demo.dao.mueble.DAOMuebleMySQL;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOMueble daoMueble;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOMueble getDaoMueble(){
        if(this.daoMueble == null){
            this.daoMueble = new DAOMuebleMySQL();
        }
        return this.daoMueble;
    }

}
