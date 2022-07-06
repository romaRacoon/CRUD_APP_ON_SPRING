package web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import web.config.WebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Application implements WebApplicationInitializer {
    private static final String DISPATCHER = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(annotationConfigWebApplicationContext));

        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet(DISPATCHER,
                new DispatcherServlet(annotationConfigWebApplicationContext));
        servletRegistration.addMapping("/");
        servletRegistration.setLoadOnStartup(1);
    }
}
