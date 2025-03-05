package com.valtech.training.jaxwsclient.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.jaws.HelloWorld;
import com.valtech.training.jaws.webservices.MovieServiceWS;

@Configuration
public class WebServiceClientConfig {
	
	@Bean
	public MovieServiceWS createMovieService()	{
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(MovieServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.jaws.training.valtech.com/"
				,"MovieServiceWSImplService"));
		proxy.setAddress("http://localhost:7770/services/movieService");
		return proxy.create(MovieServiceWS.class);
	}
	
	@Bean
	public HelloWorld createHelloWorldService()	{
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(HelloWorld.class);
		proxy.setServiceName(new QName("http://jaws.training.valtech.com/","HelloWorldImplService"));
		proxy.setAddress("http://localhost:7770/services/helloWorld");
		return proxy.create(HelloWorld.class);
	}

}
