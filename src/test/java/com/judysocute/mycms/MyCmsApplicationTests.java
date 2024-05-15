package com.judysocute.mycms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.judysocute.model.MyBean;

@SpringBootTest
class MyCmsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void whenSerializingUsingJsonGetter_thenCorrect()
	  throws JsonProcessingException {
	 
	    MyBean bean = new MyBean(1, "My bean");

	    String result = new ObjectMapper().writeValueAsString(bean);
	}

}
