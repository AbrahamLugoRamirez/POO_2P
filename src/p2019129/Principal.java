/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2019129;

import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Salcedo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int cant_piña = 0;
        int cant_mandarina = 0;
        int precio_piña = 0;
        int precio_mandarina =0;
        
        
        int precio_caja=0;
        int precio_cajas=0;
               
        
        int cant_cajas;
        
        
        Inventario inventario = null;
        int op = 0;
        JOptionPane.showMessageDialog(null, "INTEGRANTES: " + "\nJonathan Salcedo");
        while (op != 3) {
            try {

                op = Integer.parseInt((JOptionPane.showInputDialog("Ingrese la opcion:"
                        + "\n1. Registrar inventario"
                        + "\n2. Armado de cajas"
                        + "\n3. salir  "
                        + "\n**DIGITE SU OPCIÓN**")));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ERROR \n Si Desea Salir del Programa Ingrese el Numero 5  ", "******ERROR*****", JOptionPane.WARNING_MESSAGE);
                break;
            }

            switch (op) {
                case 1:
                 try {

                    cant_piña = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de refrescos de Piña"));
                    precio_piña = Integer.parseInt(JOptionPane.showInputDialog("Digite el precio de los refrescos de piña"));
                    cant_mandarina = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de refrescos de Mandarina"));
                    precio_mandarina = Integer.parseInt(JOptionPane.showInputDialog("Digite el precio de los refrescos de Mandarina"));
                    Inventario invent = new Inventario(cant_piña, cant_mandarina, precio_piña, precio_mandarina);
                    inventario = invent;
                    //System.out.println("--" + inventario.getNum_manzana());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "VALOR NO VALIDO", "INGRESE UN NÚMERO VALIDO", JOptionPane.WARNING_MESSAGE);
                }
                break;
                case 2:
                    try {

                    cant_cajas = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de cajas: "));

                    if (inventario.nCajas(cant_cajas)) {
                        for (int i = 0; i < cant_cajas; i++) {

                            int opcS = Integer.parseInt((JOptionPane.showInputDialog("Sabores caja " + (i + 1) + ": "
                                    + "\n 1. Combinado"
                                    + "\n 2. Todo Piña"
                                    + "\n 3. Todo Mandarina")));
                            switch (opcS) {
                                case 1:
                                    int piña = Integer.parseInt((JOptionPane.showInputDialog("Digite numero de refresco sabor a piña: ")));
                                    int mandarina = Integer.parseInt((JOptionPane.showInputDialog("Digite numero de refresco sabor a mandarina: ")));
                                    if (piña + mandarina == 10) {
                                        if (inventario.getNum_piña() < piña || inventario.getNum_mandarina() < mandarina) {
                                            if (inventario.getNum_piña() < piña) {
                                                JOptionPane.showMessageDialog(null, "No hay cantidad suficiente de refrescos sabor a piña ", "VALOR NO VALIDO", JOptionPane.WARNING_MESSAGE);

                                            }
                                            if (inventario.getNum_mandarina() < mandarina) {
                                                JOptionPane.showMessageDialog(null, "No hay cantidad suficiente de refrescos sabor a mandarina ", "VALOR NO VALIDO", JOptionPane.WARNING_MESSAGE);

                                            }

                                        } else {
                                            inventario.setNum_piña(piña);
                                            inventario.setNum_mandarina(mandarina);
                                            System.out.println("Inventario Píña: " + inventario.getNum_piña());
                                            System.out.println("Inventario Mandarina: " + inventario.getNum_mandarina());
                                            precio_caja = piña*inventario.getPrecio_piña() + mandarina*inventario.getPrecio_mandarina();
                                             JOptionPane.showMessageDialog(null, precio_caja, "VALOR A PAGAR", JOptionPane.INFORMATION_MESSAGE);
                                            precio_cajas = precio_cajas + precio_caja;
                                            
                                          
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "VALOR NO VALIDO", "Cantidad no valido", JOptionPane.ERROR_MESSAGE);

                                    }

                                    break;


                                case 2:
                                    if (inventario.getNum_piña() >= 10) {
                                        inventario.setNum_piña(10);
                                        precio_caja = 10*inventario.getPrecio_piña();
                                        JOptionPane.showMessageDialog(null, precio_caja, "VALOR A PAGAR", JOptionPane.INFORMATION_MESSAGE);
                                        precio_cajas = precio_cajas + precio_caja;
                                        
                                        System.out.println("Inventario Piña: " + inventario.getNum_piña());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "VALOR NO VALIDO", "No hay suficiente refrescos de Piña en inventario", JOptionPane.ERROR_MESSAGE);

                                    }
                                    break;
                                case 3:
                                    if (inventario.getNum_mandarina()>= 10) {
                                        inventario.setNum_mandarina(10);
                                        precio_caja = 10*inventario.getPrecio_mandarina();
                                        JOptionPane.showMessageDialog(null, precio_caja, "VALOR A PAGAR", JOptionPane.INFORMATION_MESSAGE);
                                        precio_cajas = precio_cajas + precio_caja;
                                         System.out.println("Inventario Mandarina: " + inventario.getNum_mandarina());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "VALOR NO VALIDO", "No hay suficiente refrescos de mandarina en inventario", JOptionPane.ERROR_MESSAGE);

                                    }

                                    break;
                                default:
                                    break;

                            }

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No hay suficientes refrescos", "No hay suficientes refrescos", JOptionPane.WARNING_MESSAGE);

                    }

                } catch (Error ex) {

                }
                break;
                case 3:
                    
                    JOptionPane.showMessageDialog(null,"Valor total cajas empacadas: "+precio_cajas
                                                   +"\n Unidades de piña restante: " +inventario.getNum_piña()
                                                    +"\n Unidades de mandarina restante: "+inventario.getNum_mandarina()
                                                     +"\n Unidades de mandarina empacados: "+(cant_mandarina-inventario.getNum_mandarina()));
                    
                    
                    
                    
                
                break;

                default:
                    break;
            }

        }

    }

}
