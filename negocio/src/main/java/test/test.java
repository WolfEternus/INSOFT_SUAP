/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceFacadeLocator;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        Profesor profesor = new Profesor(2, "Alonso", "Ruiz de Chavez", "QWER123456RFC");
        ServiceFacadeLocator.getInstanceFacadeProfesor().saveProfesor(profesor);
        System.out.println("registro exitoso de: " + profesor);
    }
}
