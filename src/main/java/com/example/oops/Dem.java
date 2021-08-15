package com.example.oops;

class One{
	
	
}
class Two{
	
}

public class Dem {
	
	public void print(String one) {
		System.out.println("One's print method");
		int a = 1;
		
	}
	
	public void print(Object two) {
		System.out.println("Two's print method");
	}
	
	public static void main(String[] args) {
		Dem d = new Dem();
		d.print(null);
		d.print(" t");
		d.print(new Object());
		
		
		switch ('U') {
        case 'U':
             System.out.println("U");
            break;
        case 'R':
        	System.out.println("L");
            break;
        case 'L':
        	System.out.println("L");
            break;
        default:
        	System.out.println("D");
            break;
		}
	}

}
