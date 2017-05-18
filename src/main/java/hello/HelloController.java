package hello;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
	
	private static final MathContext mc = new MathContext(5, RoundingMode.HALF_EVEN); 
	
	@Value("${conversion.fahrenheit.to.celcius}")
	private String fToCelsius;
	
	@Value("${conversion.km.to.mile}")
	private String kmToMiles;
	
	
	@Value("${conversion.meter.to.yard}")
	private String meterToYard;
	 

	@PostMapping("/fahrenheittotocelcius")
    public ResponseEntity<String> fahrenheitToCelcius(@RequestBody BigDecimal figure) {
		
		 
		
		if(figure!=null){
			
			if(figure.compareTo(BigDecimal.ZERO)>0){
				
				BigDecimal rs = figure.subtract(new BigDecimal("32")).multiply(new BigDecimal(fToCelsius), mc);
				return new ResponseEntity<String>(rs.toPlainString(), HttpStatus.OK);
			}
		}
        return new ResponseEntity<String>("Please Provide a valid amount", HttpStatus.BAD_REQUEST);
    }
    
	@PostMapping("/kmtomile")
    public ResponseEntity<String>  conversioKmToMile(@RequestBody BigDecimal figure) {
       
	if(figure!=null){
			
			if(figure.compareTo(BigDecimal.ZERO)>0){
				
				BigDecimal rs = figure.multiply(new BigDecimal(kmToMiles), mc);
				return new ResponseEntity<String>(rs.toPlainString(), HttpStatus.OK);
			}
		}
        return new ResponseEntity<String>("Please Provide a valid amount", HttpStatus.BAD_REQUEST);

    }
    
    
	@PostMapping("/metertoyard")
    public ResponseEntity<String>  conversionMeterToYard(@RequestBody BigDecimal figure) {
        
	if(figure!=null){
			
			if(figure.compareTo(BigDecimal.ZERO)>0){
				
				BigDecimal rs = figure.multiply(new BigDecimal(meterToYard), mc);
				return new ResponseEntity<String>(rs.toPlainString(), HttpStatus.OK);
			}
		}
        return new ResponseEntity<String>("Please Provide a valid amount", HttpStatus.BAD_REQUEST);
    }
    
}
