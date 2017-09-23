package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.lang.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    protected Logger logger = LoggerFactory.getLogger(CalculadoraController.class.getName());

    private final AddressService service;
    private final AtomicLong counter = new AtomicLong();
    private final Calculadora calculadora = new Calculadora();

    @Autowired
    public CalculadoraController(AddressService service) {
        this.service = service;
    }

    @RequestMapping("/sumar")
    public ResultadoOperacion sumar(@RequestParam(value="numero1", defaultValue="0") String numero1, 
						@RequestParam(value="numero2", defaultValue="0") String numero2) throws Exception {
		
		int num1 = Integer.parseInt(numero1);
		int num2 = Integer.parseInt(numero2);
		int res = calculadora.sumar(num1, num2);
		
		String tipo = "Suma";
		String resultado = Integer.toString(res);
		String serverAddress = service.getServerAddress();
		
        return new ResultadoOperacion(counter.incrementAndGet(), tipo, numero1, numero2, resultado, serverAddress);
    }
	
	@RequestMapping("/restar")
    public ResultadoOperacion restar(@RequestParam(value="numero1", defaultValue="0") String numero1, 
						@RequestParam(value="numero2", defaultValue="0") String numero2) throws Exception {
		
		int num1 = Integer.parseInt(numero1);
		int num2 = Integer.parseInt(numero2);
		int res = calculadora.restar(num1, num2);
		
		String tipo = "Resta";
		String resultado = Integer.toString(res);
		String serverAddress = service.getServerAddress();
		
        return new ResultadoOperacion(counter.incrementAndGet(), tipo, numero1, numero2, resultado, serverAddress);
    }
	
	@RequestMapping("/multiplicar")
    public ResultadoOperacion multiplicar(@RequestParam(value="numero1", defaultValue="0") String numero1, 
						@RequestParam(value="numero2", defaultValue="0") String numero2) throws Exception {
		
		int num1 = Integer.parseInt(numero1);
		int num2 = Integer.parseInt(numero2);
		int res = calculadora.multiplicar(num1, num2);
		
		String tipo = "Multiplicacion";
		String resultado = Integer.toString(res);
		String serverAddress = service.getServerAddress();
		
        return new ResultadoOperacion(counter.incrementAndGet(), tipo, numero1, numero2, resultado, serverAddress);
    }
	
	@RequestMapping("/dividir")
    public ResultadoOperacion dividir(@RequestParam(value="numero1", defaultValue="0") String numero1, 
						@RequestParam(value="numero2", defaultValue="0") String numero2) throws Exception {
		
		int num1 = Integer.parseInt(numero1);
		int num2 = Integer.parseInt(numero2);
		int res = calculadora.dividir(num1, num2);
		
		String tipo = "Division";
		String resultado = Integer.toString(res);
		String serverAddress = service.getServerAddress();
		
        return new ResultadoOperacion(counter.incrementAndGet(), tipo, numero1, numero2, resultado, serverAddress);
    }
}