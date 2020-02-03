package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculadoraApplicationTest {
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sumaCuandoResultadoOk() throws Exception {
	//Arrage
	int operador1=5;
	int operador2=3;
	int resultado=8;
	    
	//Act
	Object peticion=this.mockMvc.perform(get("/calculadora/sumar")
				.param("numero1", "5")
				.param("numero2", "3"))
                .andDo(print()).andExpect(status().isOk());
		
	//Assert
        //peticion.andExpect(jsonPath("$.resultado").value("8"));
    }
}
