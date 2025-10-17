package serialization;

import java.io.Serializable;


public class objet implements Serializable {
	   

	    public double a;
	    public double b;
	    public char operateur;

	    public objet(double a, double b, char c) {
	        this.a = a;
	        this.b = b;
	        this.operateur = c;
	    }
	    public double getA() {
	        return a;
	    }

	    public double getB() {
	        return b;
	    }

	    public char getOperateur() {
	        return operateur;
	    }
	    
	    
	}

