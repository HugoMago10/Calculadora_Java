package Calculadora;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kim
 */
final class ExpRegular {
    private Pattern pat;//Patron
    private Matcher mat;
    private final boolean val;
    
    public ExpRegular ( String patron, String cadena ){
        val = valida ( patron, cadena );
    }
    
    public boolean valida ( String patron, String cadena ){
        pat = Pattern.compile(patron);
        mat = pat.matcher(cadena);
        return mat.matches();
    }
    
    public boolean getValor (){
        return val;
    }
    
}
