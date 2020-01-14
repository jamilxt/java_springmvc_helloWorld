package com.spring5.practice;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletCxt) {

		// Create the 'root' Spring Application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		rootContext.refresh();

		// Manage the lifeCycle of the root application context
		servletCxt.addListener(new ContextLoaderListener(rootContext));

		// Create and register the DispatcherServlet
		AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
		servletContext.register(ServletConfig.class);
		ServletRegistration.Dynamic registration = servletCxt.addServlet("servlet",
				new DispatcherServlet(servletContext));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");

	}

}
