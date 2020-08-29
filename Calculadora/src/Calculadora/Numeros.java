package Calculadora;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kim
 */
public class Numeros {
    private double num1, num2, resultado;
    private JPanel prin;
    
    public Numeros (){
        this (0, 0);
    }
    
    public Numeros(int num1, int num2){
        setNum1( num1 );
        setNum2( num2 );
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
    
    public double getResultado(){
        return resultado;
    }
    
    public void Imprime (){
        JOptionPane.showMessageDialog(prin, "Resultado: " + resultado,
                "Resultado", JOptionPane.PLAIN_MESSAGE );
    }
    
    public void resta (){
        resultado = num1 - num2;
    }
    
    public void suma (){
        resultado = num1 + num2;
    }
    
    public void multiplicacion (){
        resultado = num1 * num2;
    }
    
    public void division (){
        try{
            resultado = num1 / num2;
        }catch ( ArithmeticException e ){
            JOptionPane.showMessageDialog(null, "Denominador Cero!",
                    "Error", JOptionPane.PLAIN_MESSAGE );
        }
    }    
}
