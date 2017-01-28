package iteso.msc.mac.Homework6;


// Clase para codificar una cadena de texto usando el código Huffman
public class Encoder {
	// Método estático para codificar una cadena. Toma carácter por carácter
	// y solicita el código binario que representa cada carácter.
	public static String Encode(String s, HuffmanTree t) {
		String r = "", c = "";
		// Recorremos la cadena un carácter a la vez
		for(int i = 0; i < s.length(); i++) {
			// Se obtiene el código binario
			c = t.GetCode(s.substring(i, i + 1));
			// Si no encontró el código usamos * para indicarlo
			if(c.isEmpty())
				r += "*";
			else
				r += c;
		}
		// Regresamos el resultado
		return r;
	}
}
