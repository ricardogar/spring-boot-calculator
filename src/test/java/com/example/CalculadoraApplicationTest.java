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
    public void testSumaSinParametros() throws Exception {

        this.mockMvc.perform(get("/calculadora/sumar"))
				.andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("0"));
    }

    @Test
    public void testSuma() throws Exception {

        this.mockMvc.perform(get("/calculadora/sumar")
				.param("numero1", "5")
				.param("numero2", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("8"));
    }
	
	@Test
    public void testResta() throws Exception {

        this.mockMvc.perform(get("/calculadora/restar")
				.param("numero1", "6")
				.param("numero2", "2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("4"));
    }
	
	@Test
    public void testMultiplicacion() throws Exception {

        this.mockMvc.perform(get("/calculadora/multiplicar")
				.param("numero1", "2")
				.param("numero2", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("6"));
    }
	
	@Test
    public void testDivision() throws Exception {

        this.mockMvc.perform(get("/calculadora/dividir")
				.param("numero1", "8")
				.param("numero2", "4"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("2"));
    }
	
	@Test
    public void testDivisionEntreCero() throws Exception {

        this.mockMvc.perform(get("/calculadora/dividir")
				.param("numero1", "5")
				.param("numero2", "0"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("0"));
    }
}