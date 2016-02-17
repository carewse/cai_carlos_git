package org.carlos.server.jetty;

import javax.servlet.Servlet;

import org.carlos.server.jetty.servlet.HelloServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServerSample {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		WebAppContext webAppContext = new WebAppContext("/home/cai_carlos/workspace/b2b/target/sbkj-b2b-mall-1.0.0-SNAPSHOT", "/b2b/");
		WebAppContext webAppContext2 = new WebAppContext("/home/cai_carlos/myworkspace/carlos-maven-project/carlos-maven-web/target/carlos-maven-web-1.0-SNAPSHOT", "/");
		WebAppContext webAppContext3 = new WebAppContext("/home/cai_carlos/workspace/snpromotion/target/sbkj-prom-sn-1.0.0-SNAPSHOT", "/sbsn/");
		// server.setHandler(webAppContext);

		// ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);//
		// context.setContextPath("/content");
		// context.addServlet(new ServletHolder(new HelloServlet()), "/hello");
		// server.setHandler(context);

		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[] { webAppContext3 });

		server.setHandler(contexts);

		server.start();
		server.join();
	}
}
