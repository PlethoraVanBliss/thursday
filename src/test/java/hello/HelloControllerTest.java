package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
 //@TestPropertySource(locations="classpath:application.properties")
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testConversionMeterToYardOk() throws Exception {
    	
    	
    	
        mvc.perform(MockMvcRequestBuilders.post("/metertoyard")
        		.contentType(MediaType.APPLICATION_JSON).content(BigDecimal.TEN.toPlainString())
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("10.936")));
    }
    
    @Test
    public void testFahrenheitToCelcius() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/fahrenheittotocelcius")
        		.contentType(MediaType.APPLICATION_JSON).content(BigDecimal.ZERO.toPlainString())
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());    }
    
    @Test
    public void testConversionMeterToYard() throws Exception {
     	
        mvc.perform(MockMvcRequestBuilders.post("/metertoyard")
        		.contentType(MediaType.APPLICATION_JSON).content(BigDecimal.ZERO.toPlainString())
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    //@Test
    public void testFahrenheitToCelciusOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/fahrenheittotocelcius")
        		.content(BigDecimal.TEN.toPlainString())
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
    
    @Test
    public void testConversioKmToMile() throws Exception {
    	   mvc.perform(MockMvcRequestBuilders.post("/kmtomile")
           		.contentType(MediaType.APPLICATION_JSON).content(BigDecimal.ZERO.toPlainString())
           		.accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isBadRequest());
    }
    
    //@Test
    public void testConversioKmToMileOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/kmtomile")
        		.content(BigDecimal.TEN.toPlainString())
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
}
