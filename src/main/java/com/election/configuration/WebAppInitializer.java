package com.election.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
  
public class WebAppInitializer implements WebApplicationInitializer {
	
	
	public void onStartup(ServletContext servletContext) throws ServletException {  
		
		
		 // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
 
        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));
 
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(AppConfig.class);
             
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        
        
        
        
		
      //  AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
       // ctx.register(AppConfig.class);  
        
        
        
   //     ctx.setServletContext(servletContext);    // ? pewnie to samo co  dispatcherServlet.register(AppConfig.class);
        
        
       // Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        
        
        
        
        
        
        
        
      //  dynamic.addMapping("/");  
       // dynamic.setLoadOnStartup(1);  
   }  
}
