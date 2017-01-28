import java.util.Scanner;


public class AF2 {
	enum States {
		s0,   s1,  s2,  s3,  s4,  s5,  s6,  s7,  s8,  s9,
		s10, s11, s12, s13, s14, s15, s16, s17, s18, s19,
		s20, s21, s22
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		while(!s.equals("x")) {
			States state = States.s0;
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch(state) {
				case s0:
					if(c == '0') state = States.s1;
					else if(c == '1') state = States.s2;
					else state = States.s22;
					break;
				case s1:
					if(c == '2') state = States.s4;
					else if(c == '1' || c == '3' || c == '5' || c == '7' || c == '8') state = States.s3;
					else if(c == '4' || c == '6' || c == '9') state = States.s5;
					else state = States.s22;
					break;
				case s2:
					if(c == '0' || c == '2') state = States.s3;
					else if(c == '1') state = States.s5;
					else state = States.s22;
					break;
				case s3:
					if(c == '/') state = States.s7;
					else state = States.s22;
					break;
				case s4:
					if(c == '/') state = States.s6;
					else state = States.s22;
					break;
				case s5:
					if(c == '/') state = States.s8;
					else state = States.s22;
					break;
				case s6:
					if(c == '0') state = States.s9;
					else if(c == '1') state = States.s10;
					else if(c == '2') state = States.s11;
					else state = States.s22;
					break;
				case s7:
					if(c == '0') state = States.s9;
					else if(c == '1' || c == '2') state = States.s10;
					else if(c == '3') state = States.s13;
					else state = States.s22;
					break;
				case s8:
					if(c == '0') state = States.s9;
					else if(c == '1' || c == '2') state = States.s10;
					else if(c == '3') state = States.s14;
					else state = States.s22;
					break;
				case s9:
					if(c >= '1' && c <= '9') state = States.s12;
					else state = States.s22;
					break;
				case s10:
					if(c >= '0' && c <= '9') state = States.s12;
					else state = States.s22;
					break;
				case s11:
					if(c >= '0' && c <= '8') state = States.s12;
					else state = States.s22;
					break;
				case s12:
					if(c == '/') state = States.s15;
					else state = States.s22;
					break;
				case s13:
					if(c == '0' || c == '1') state = States.s12;
					else state = States.s22;
					break;
				case s14:
					if(c == '0') state = States.s12;
					else state = States.s22;
					break;
				case s15:
					if(c == '2') state = States.s16;
					else if(c >= '3' && c <= '9') state = States.s21;
					else state = States.s22;
					break;
				case s16:
					if(c == '0') state = States.s18;
					else if(c >= '1' && c <= '9') state = States.s17;
					else state = States.s22;
					break;
				case s17:
					if(c >= '0' && c <= '9') state = States.s19;
					else state = States.s22;
					break;
				case s18:
					if(c >= '1' && c <= '9') state = States.s19;
					else state = States.s22;
					break;
				case s19:
					if(c >= '0' && c <= '9') state = States.s20;
					else state = States.s22;
					break;
				case s20:
					state = States.s22;
					break;
				case s21:
					if(c >= '0' && c <= '9') state = States.s17;
					else state = States.s22;
					break;
				case s22:
					break;
				}
			}
			if(state == States.s20)
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
