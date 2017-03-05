package rs.ac.uns.ftn.tseo;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class TSEO_2016_App {

	public static void main( String[] args )
    {
		SpringApplication.run(TSEO_2016_App.class, args);
    	System.out.println("<<<>>>	TSEO_2016_App STARTED	<<<>>>");
    }
	
	/**
	 * Submitting a Multipart request (multipart/form-data) using PUT and Spring-boot
	 */
	@Bean
	public MultipartResolver multipartResolver() {
	   return new StandardServletMultipartResolver() {
	     @Override
	     public boolean isMultipart(HttpServletRequest request) {
	        String method = request.getMethod().toLowerCase();
	        //By default, only POST is allowed. Since this is an 'update' we should accept PUT.
	        if (!Arrays.asList("put", "post").contains(method)) {
	           return false;
	        }
	        String contentType = request.getContentType();
	        return (contentType != null &&contentType.toLowerCase().startsWith("multipart/"));
	     }
	   };
	}
}
