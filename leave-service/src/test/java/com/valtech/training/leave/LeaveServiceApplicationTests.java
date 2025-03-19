package com.valtech.training.leave;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.leave.vos.LeaveMasterVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeaveServiceApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void createLeaveMastersTest() {
		String baseUrl = "http://localhost:"+port+"/api/v1/leaveMasters/";
		List leaveMasters = restTemplate.getForObject(baseUrl, List.class);
		System.out.println("Size = "+leaveMasters.size());
		if(leaveMasters.size() == 0)	{
			System.out.println("adding Leave Masters ... ...");
			restTemplate.postForObject(baseUrl
					,new LeaveMasterVO(0, 5, 5, 5, 6), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl
					,new LeaveMasterVO(0, 4, 4, 4, 7), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl
					,new LeaveMasterVO(0, 3, 3, 3, 8), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl
					,new LeaveMasterVO(0, 3, 3, 3, 9), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl
					,new LeaveMasterVO(0, 3, 3, 3, 10), LeaveMasterVO.class);
		}
	}

}
