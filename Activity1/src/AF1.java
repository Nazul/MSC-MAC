import java.util.Scanner;


public class AF1 {
	enum States {
		initial,
		valid,
		invalid
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		while(!s.equals(".")) {
			States state = States.initial;
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch(state) {
				case initial:
					if(Character.isAlphabetic(c)) state = States.valid;
					else state = States.invalid;
					break;
				case valid:
					if(Character.isLetterOrDigit(c)) state = States.valid;
					else state = States.invalid;
					break;
				case invalid:
					break;
				}
			}
			if(state == States.valid)
				System.out.println("Is valid");
			else
				System.out.println("Is invalid");
			s = sc.next();
		}
		System.out.println();
		sc.close();
	}
}

//EOF
