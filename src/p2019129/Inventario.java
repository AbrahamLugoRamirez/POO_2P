/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2019129;

/**
 *
 * @author Jonathan Salcedo
 */
public class Inventario {
    private int num_piña;
    private int num_mandarina;
    private int precio_piña;
    private int precio_mandarina;

    public Inventario(int num_piña, int num_mandarina, int precio_piña, int precio_mandarina) {
        this.num_piña = num_piña;
        this.num_mandarina = num_mandarina;
        this.precio_piña = precio_piña;
        this.precio_mandarina = precio_mandarina;
    }

    public int getNum_piña() {
        return num_piña;
    }

    public int getNum_mandarina() {
        return num_mandarina;
    }

    public int getPrecio_piña() {
        return precio_piña;
    }

    public int getPrecio_mandarina() {
        return precio_mandarina;
    }

    public void setNum_piña(int num_piña) {
        this.num_piña -= num_piña;
    }

    public void setNum_mandarina(int num_mandarina) {
        this.num_mandarina -= num_mandarina;
    }

    public void setPrecio_piña(int precio_piña) {
        this.precio_piña = precio_piña;
    }

    public void setPrecio_mandarina(int precio_mandarina) {
        this.precio_mandarina = precio_mandarina;
    }
    
    
    

      
    
    
    
    public boolean nCajas(int nCajas){
        if (getNum_mandarina() +getNum_piña()>= nCajas*10){
            return true;            
        }else{
            return false;
        }        
    }
    
    
    
    
    
    
    
}
