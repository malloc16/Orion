package hr.mario.orion.flights.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	/*
	 * implements WebApplicationInitializer
	 * 
	 * @Override public void onStartup(ServletContext arg0) throws
	 * ServletException { AnnotationConfigWebApplicationContext ctx = new
	 * AnnotationConfigWebApplicationContext();
	 * ctx.register(SpringConfig.class); ctx.setServletContext(arg0);
	 * 
	 * ServletRegistration.Dynamic servlet = arg0.addServlet("dispatcher", new
	 * DispatcherServlet(ctx)); servlet.setLoadOnStartup(1);
	 * servlet.addMapping("/");
	 * 
	 * }
	 */

}
