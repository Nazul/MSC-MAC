package iteso.msc.mac.Homework6;


// Clase para decodificar cadenas.
public class Decoder {
	// Método estático para decodificar una cadena de 0's y 1's
	// Toma la cadena original y comienza a buscar los símbolos. GetSymbol() regresará el símbolo
	// que corresponde al recorrido realizado. Si no se mandaron suficientes bits, GetSymbol() regresará más de un símbolo.
	public static String Decode(String s, HuffmanTree t) {
		// Si no tiene nada la cadena, no hay símbolos que regresar
		if(s.isEmpty()) return "";
		// Variables para recorrer la cadena.
		int i = 0, j = 1;
		// El código actual que se analizará. Iniciamos con el primer bit solamente.
		String code = s.substring(0, 1);
		// Resultado
		String r = "";
		// Símbolo obtenido al llamar GetSymbol()
		String symbol;

		// Mientras todavía tengamos bits por procesar...
		while(i < s.length()) {
			do {
				// Buscamos los símbolos de la parte que estamos analizando
				code = s.substring(i, j++);
				symbol = t.GetSymbol(code);
			// Terminaremos de preguntar por símbolos cuando encontremos un símbolo (carácter)
			} while(symbol.length() > 1 && j <= s.length());
			if (symbol.length() == 1)
				// Agregamos el símbolo obtenido al resultado
				r += symbol;
			else
				r += "*";
			// Nos recorremos a la posición siguiente de los bits que usamos para obtener un símbolo
			i = j - 1;
		}

		// Regresamos el resultado
		return r;
	}
}
