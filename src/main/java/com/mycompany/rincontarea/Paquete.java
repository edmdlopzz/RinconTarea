/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rincontarea;

import java.util.Objects;

/**
 *
 * @author eduar
 */
public class Paquete {
   private String codigo;
 private double peso;
 private String destino;

 //Constructor    
 public Paquete(String codigo, double peso, String destino) {
        this.codigo = codigo;
        this.peso = peso;
        this.destino = destino;
    }

 // sobrescribir los métodos equals() y hashCode() para que el sistema identifique que dos paquetes son iguales si tienen el mismo código, independientemente de su peso o destino.
    @Override
    public int hashCode() {
       return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paquete other = (Paquete) obj;
        
        return Objects.equals(this.codigo, other.codigo);

    }
    
    @Override
    public String toString() {
        return "Paquete{" + "codigo=" + codigo + ", peso=" + peso + ", destino=" + destino + '}';
    } 


}
