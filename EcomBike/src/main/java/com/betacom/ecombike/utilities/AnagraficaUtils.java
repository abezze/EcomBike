package com.betacom.ecombike.utilities;

public class AnagraficaUtils {
	
	public static boolean isCodiceFiscaleValido(String cf) {
		boolean result = false;
		
        if (cf == null || (cf.length() != 11 && cf.length() != 16)) return false;
        
        cf = cf.toUpperCase();

        if (cf.matches("^[A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1}$"))
        	result = true;
        
        if (!result)
        	result = isPartitaIvaValida(cf);
        
        return result;
	}
	
	public static boolean isPartitaIvaValida(String piva) {
        if (piva == null || !piva.matches("^[0-9]{11}$")) return false;
        
        return true;
	}

}
