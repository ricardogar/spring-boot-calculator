package com.example;

public class ResultadoOperacion {

    private final long id;
    private final String tipo;
    private final String numero1;
    private final String numero2;
    private final String resultado;
    private final String ip;

    public ResultadoOperacion(long id, String tipo, String numero1, String numero2, String resultado, String ip) {
        this.id = id;
        this.tipo = tipo;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.resultado = resultado;
        this.ip = ip;
    }

    public long getId() {
        return id;
    }

	public String getTipo() {
        return tipo;
    }
	
    public String getNumero1() {
        return numero1;
    }
	
	public String getNumero2() {
        return numero2;
    }
	
	public String getResultado() {
        return resultado;
    }
	
	public String getIp() {
        return ip;
    }
}