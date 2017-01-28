package iteso.msc.mac.Homework6;


// Clase para codificar una cadena de texto usando el c�digo Huffman
public class Encoder {
	// M�todo est�tico para codificar una cadena. Toma car�cter por car�cter
	// y solicita el c�digo binario que representa cada car�cter.
	public static String Encode(String s, HuffmanTree t) {
		String r = "", c = "";
		// Recorremos la cadena un car�cter a la vez
		for(int i = 0; i < s.length(); i++) {
			// Se obtiene el c�digo binario
			c = t.GetCode(s.substring(i, i + 1));
			// Si no encontr� el c�digo usamos * para indicarlo
			if(c.isEmpty())
				r += "*";
			else
				r += c;
		}
		// Regresamos el resultado
		return r;
	}
}
