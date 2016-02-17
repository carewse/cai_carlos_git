package org.carlos.server.jetty;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

	private Server server;
	private int port;
	private WebAppContext webApp;
	private WebAppClassLoader classLoader;
	private String webAppPath;
	private String contextPath;
	private String[] jarFilters;
	private String[] jarsPaths;
	private String[] classesPaths;

	public JettyServer(int port, String webAppPath, String contextPath){
		this.port = port;
		this.server = new Server(port);
		initWebApp(webAppPath, contextPath);
	}

	public int getPort() {
		return port;
	}

	private void initWebApp(String webAppPath, String contextPath) {
		File webFile = new File(webAppPath);
		if (!webFile.exists()) {
			throw new NullPointerException("项目路径错误" + webAppPath);
		}
		this.webApp = new WebAppContext(webAppPath, contextPath);
	}

	public void addClassPath(String[] classesPaths, String[] jarsPaths, String[] jarFilters) throws IOException {
		initClassesPath(classesPaths, jarsPaths, jarFilters);
		addClassPath();
	}

	private void addClassPath() throws IOException {
		if (null == webApp) {
			throw new NullPointerException("项目不存在");
		}
		classLoader = new WebAppClassLoader(webApp);
		String classPath = classesPath();
		classLoader.addClassPath(classPath);
		webApp.setClassLoader(classLoader);
	}

	public void start() throws Exception {
		if (null == this.webApp) {
			throw new NullPointerException("项目不存在");
		}
		server.setHandler(this.webApp);
		server.start();
		server.join();
	}

	private String jarsPath() {
		if (null == this.jarsPaths) {
			return null;
		}
		StringBuilder jarPaths = new StringBuilder();
		for (String jarPath : this.jarsPaths) {
			File file = new File(jarPath);
			if (!file.exists() || !file.isDirectory()) {
				continue;
			}
			File[] listFiles = file.listFiles();
			loop: for (File _file : listFiles) {
				String _fileName = _file.getName();
				if (null != this.jarFilters) {
					for (String jarFilter : this.jarFilters) {
						if (_fileName.startsWith(jarFilter)) {
							continue loop;
						}
					}
				}
				String _filePath = _file.getAbsolutePath();
				jarPaths.append(_filePath).append(",");
			}
		}
		return jarPaths.toString();
	}

	private String classesPath() {
		StringBuilder projectClassesPaths = new StringBuilder();
		if (null != this.classesPaths) {
			for (String classesPath : this.classesPaths) {
				File file = new File(classesPath);
				if (!file.exists() || !file.isDirectory()) {
					continue;
				}
				projectClassesPaths.append(classesPath).append(",");
			}
		}
		projectClassesPaths.append(jarsPath());
		return projectClassesPaths.toString();
	}

	private void initClassesPath(String[] classesPaths, String[] jarsPaths, String[] jarFilters) {
		this.classesPaths = classesPaths;
		this.jarsPaths = jarsPaths;
		this.jarFilters = jarFilters;
	}

	public static void main(String[] args) throws Exception {

		// /home/cai_carlos/workspace/branch-2015-07-27-star/sbkj-prom-tb-web/target/promtb
		// JettyServerArgs _args = JettyServerArgs.itemProjectServerArgs("/home/cai_carlos/workspace/branch-item");
		 JettyServerArgs _args = JettyServerArgs.drpOrderProjectServerArgs("/home/cai_carlos/workspace/branch-2015-09-21-bugfix");// 订单助手
//		JettyServerArgs _args = JettyServerArgs.drpOrderProjectServerArgs("/home/cai_carlos/workspace/orderaide");// 订单助手主干
		// JettyServerArgs _args = JettyServerArgs.b2bMallProjectServerArgs("/home/cai_carlos/workspace/b2b");// b2b商城
		// JettyServerArgs _args = JettyServerArgs.drpPromtbProjectServerArgs("/home/cai_carlos/workspace/branch-2015-07-27-star");// 星星店长
		// JettyServerArgs _args = JettyServerArgs.jdPromtbServerArgs("/home/cai_carlos/workspace/jdpromotion-bugfix");//京东促销
		JettyServer jettyServer = new JettyServer(_args.getPort(), _args.getWebAppPath(), _args.getContextPath());
		jettyServer.addClassPath(_args.getClassesPaths(), _args.getJarsPaths(), _args.getJarFilters());
		jettyServer.start();
	}
}
