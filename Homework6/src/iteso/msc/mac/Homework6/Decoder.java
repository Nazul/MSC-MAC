package iteso.msc.mac.Homework6;


// Clase para decodificar cadenas.
public class Decoder {
	// M�todo est�tico para decodificar una cadena de 0's y 1's
	// Toma la cadena original y comienza a buscar los s�mbolos. GetSymbol() regresar� el s�mbolo
	// que corresponde al recorrido realizado. Si no se mandaron suficientes bits, GetSymbol() regresar� m�s de un s�mbolo.
	public static String Decode(String s, HuffmanTree t) {
		// Si no tiene nada la cadena, no hay s�mbolos que regresar
		if(s.isEmpty()) return "";
		// Variables para recorrer la cadena.
		int i = 0, j = 1;
		// El c�digo actual que se analizar�. Iniciamos con el primer bit solamente.
		String code = s.substring(0, 1);
		// Resultado
		String r = "";
		// S�mbolo obtenido al llamar GetSymbol()
		String symbol;

		// Mientras todav�a tengamos bits por procesar...
		while(i < s.length()) {
			do {
				// Buscamos los s�mbolos de la parte que estamos analizando
				code = s.substring(i, j++);
				symbol = t.GetSymbol(code);
			// Terminaremos de preguntar por s�mbolos cuando encontremos un s�mbolo (car�cter)
			} while(symbol.length() > 1 && j <= s.length());
			if (symbol.length() == 1)
				// Agregamos el s�mbolo obtenido al resultado
				r += symbol;
			else
				r += "*";
			// Nos recorremos a la posici�n siguiente de los bits que usamos para obtener un s�mbolo
			i = j - 1;
		}

		// Regresamos el resultado
		return r;
	}
}
