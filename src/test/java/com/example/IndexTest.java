package com.example;

 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IndexTest {
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSumaSinParametros() throws Exception {

        this.mockMvc.perform(get("/index"))
            //.andDo(print()).andExpect(status().isOk());
                .andDo(print()).andExpect(status().isOk());
    }

    private ResultHandler print() {
        return null;
	}
}
