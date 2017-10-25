package com.example;

public class Calculadora {

    private int resultado;

    public int sumar (int num1, int num2) {
        resultado = num1 + num2;
		return resultado;
    }

	public int restar (int num1, int num2) {
        resultado = num1 - num2;
		return resultado;
    }
	
	public int multiplicar (int num1, int num2) {
        resultado = num1 * num2;
		return resultado;
    }
	
	public int dividir (int num1, int num2) {
        if(num2 == 0){
			return num2;
		}
		resultado = num1 / num2;
		return resultado;
    }
	
	public int promediar (int num1, int num2) {
		resultado = this.dividir(this.sumar(num1, num2), 2);
		return resultado;
    }
}