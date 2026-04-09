/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rincontarea;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**
 *
 * @author eduar
 */
public class Almacen {
//Un array bidimensional de objetos Paquete de 3x3 posiciones
 private Paquete[][] muelle = new Paquete [3][3];

//Un HashSet<String> para almacenar los códigos de los paquetes que entran al sistema y evitar duplicados.
 private HashSet<String> registro = new HashSet<>(); 

// Un ArrayList<Paquete> para los paquetes que han sido despachados de la estantería y esperan al camión.
 private ArrayList<Paquete> colaSalida = new ArrayList<>();

 // Un HashMap<String, Integer> que asocie cada ciudad de destino con el número total de paquetes enviados a ella.
 private HashMap<String, Integer>  estadisticas = new HashMap<>();

//Metodo 1 
 public void recepcionarPaquete(Paquete p, int fila, int col) {
//Verifica si el codigo de seguirdad ya existe y en ese caso genera error y salimos 
     if (registro.contains(p.getCodigo())){
   System.out.println("Error: el codigo" + p.getCodigo() + "ya existe");
   return;
    }
//Si no existe y la posicion esta libre, almacenamos el `paquete y registra su codigo 
   if (muelle[fila][col] ==null) {
       muelle[fila][col] =p;
       registro.add(p.getCodigo());
    System.out.println("El paquete se ha almacenado en la posición" + fila + "," + col);
   } 
   
   else {
        System.out.println("Error. La posición" + fila + "," + col + "ya está ocupada");
      }
     
 }
public void enviarACamion(int fila, int col){
int contador = 0;
Paquete p =muelle[fila][col];
muelle[fila][col] = null;
colaSalida.add(p);
//Actualizamos las estadisticas
contador = estadisticas.getOrDefault(p.getDestino(), 0);
estadisticas.put (p.getDestino(), contador + 1);

}

}
