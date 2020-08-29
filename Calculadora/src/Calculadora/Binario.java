package Calculadora;

/**
 *
 * @author kim
 */
public class Binario {
    
    private String numero;
    
    public Binario ()throws ExceptionTipo{
        this ("0");
    }
    
    public Binario ( String numero ) throws ExceptionTipo{
        setNumero ( numero );
    }
    
    public void setNumero ( String numero ) throws ExceptionTipo{
        if ( !verificaNumero ( numero ) )
            throw new ExceptionTipo ("No es un numero Binario");
        else
            this.numero = numero;
    }
    
    public String getNumero (){
        return numero;
    }
    
    public String getParidad (){
        int j = 0;
        String cad = "";
        for ( int i = 0; i < numero.length(); i++ ){
            if ( numero.charAt(i) =='1'){
                j++;
            }
        }
        cad += j%2 == 0 ? '0' : '1';
        return cad + numero;
    }
    
    public int getDecimal (){
        int num = 0;
        int bit = 1 << ( numero.length() - 1 );
        
        for ( int i = 0; i < numero.length(); i++ ){
            if ( numero.charAt( i) == '1')
                num |= bit;
            bit = bit >> 1;
        }
        return num;
    }
    
    public String getBinario ( int num ){
        return Integer.toBinaryString( num );
    }
    
    public String getSucesor (){
        return getBinario ( getDecimal () + 1);
    }
    
    public String getAntecesor (){
        
        if ( getDecimal () != 0){
            return getBinario ( getDecimal () -1 );
        }
        
        return "0";
    }
    
    public String getComplemento (){
        String aux = " ";
        for ( int i = 0; i < numero.length(); i++ ){
            aux += ( numero.charAt( i ) == '0') ? '1' : '0';
        }
        return aux;
    }
    
    @Override
    public String toString (){
        return "Numero Binario: "+numero;
    }
    
    public static void main (String [] args ){
        try{
            Binario binario = new Binario ("11201");
            System.out.println ( binario.toString () );
            System.out.println ("Complemento: "+ binario.getComplemento() );
            System.out.println ("Paridad: "+ binario.getParidad() );
            System.out.println ("Decimal: "+ binario.getDecimal() );
            System.out.println ("Sucesor: " + binario.getSucesor() );
            System.out.println ("Antecesor: " + binario.getAntecesor() );
        }catch(ExceptionTipo e ){
            System.err.println ( e.getMessage() );
        }
    }

    private boolean verificaNumero(String numero) {
        ExpRegular exp = new ExpRegular ("\\b(0|1)+\\b", numero );
        return exp.getValor ();
    }
    
}