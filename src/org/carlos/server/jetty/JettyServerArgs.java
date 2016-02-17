package org.carlos.server.jetty;

public class JettyServerArgs {

	int port;
	String webAppPath;
	String contextPath;
	String[] classesPaths;
	String[] jarsPaths;
	String[] jarFilters;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getWebAppPath() {
		return webAppPath;
	}

	public void setWebAppPath(String webAppPath) {
		this.webAppPath = webAppPath;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String[] getClassesPaths() {
		return classesPaths;
	}

	public void setClassesPaths(String[] classesPaths) {
		this.classesPaths = classesPaths;
	}

	public String[] getJarsPaths() {
		return jarsPaths;
	}

	public void setJarsPaths(String[] jarsPaths) {
		this.jarsPaths = jarsPaths;
	}

	public String[] getJarFilters() {
		return jarFilters;
	}

	public void setJarFilters(String[] jarFilters) {
		this.jarFilters = jarFilters;
	}

	public static JettyServerArgs carlosProjectServerArgs() {
		int port = 9090;
		String webAppPath = "E:/workspace/carlos-maven-project/carlos-maven-web/src/main/webapp";
		String contextPath = "/carlos";
		String[] jarFilters = new String[] { "carlos-maven" };
		String[] jarsPaths = new String[] { "E:/workspace/carlos-maven-project/carlos-maven-web/target/carlos-maven-web-1.0-SNAPSHOT/WEB-INF/lib", };
		String[] classesPaths = new String[] { "E:/workspace/carlos-maven-project/carlos-maven-web/target/carlos-maven-web-1.0-SNAPSHOT/WEB-INF/lib",
				"E:/workspace/carlos-maven-project/carlos-maven-web/target/classes", "E:/workspace/carlos-maven-project/carlos-maven-hello/target/classes",
				"E:/workspace/carlos-maven-project/carlos-maven-common/target/classes", };
		JettyServerArgs carlosProjectServerArgs = new JettyServerArgs();
		carlosProjectServerArgs.setPort(port);
		carlosProjectServerArgs.setClassesPaths(classesPaths);
		carlosProjectServerArgs.setWebAppPath(webAppPath);
		carlosProjectServerArgs.setContextPath(contextPath);
		carlosProjectServerArgs.setJarFilters(jarFilters);
		carlosProjectServerArgs.setJarsPaths(jarsPaths);
		return carlosProjectServerArgs;
	}

	public static JettyServerArgs drpProjectServerArgs(String webPath) {
		int port = 9090;
		String webAppPath = new StringBuilder(webPath).append("/drp-web/src/main/webapp").toString();
		String contextPath = "/drp";
		String[] jarFilters = new String[] { "drp-" };
		String[] jarsPaths = new String[] { new StringBuilder(webPath).append("/drp-web/target/drp/WEB-INF/lib").toString(), };
		String[] classesPaths = new String[] { new StringBuilder(webPath).append("/drp-canal/target/classes").toString(),
				new StringBuilder(webPath).append("/drp-common/target/classes").toString(), new StringBuilder(webPath).append("/drp-crm/target/classes").toString(),
				new StringBuilder(webPath).append("/drp-fad/target/classes").toString(), new StringBuilder(webPath).append("/drp-item/target/classes").toString(),
				new StringBuilder(webPath).append("/drp-report/target/classes").toString(), new StringBuilder(webPath).append("/drp-services/target/classes").toString(),
				new StringBuilder(webPath).append("/drp-sys/target/classes").toString(), new StringBuilder(webPath).append("/drp-web/target/drp/WEB-INF/classes").toString(), // 打包路径
																																												// 配置文件需要打包参数
		// "E:/branch-2014-12-29-book/sbkj-admin/target/classes",
		// "E:/branch-2014-12-29-book/sbkj-im/target/classes",
		// "E:/branch-2014-12-29-book/sbkj-info-message/target/classes",
		// "E:/branch-2014-12-29-book/sbkj-pmc/target/classes",
		// "E:/branch-2014-12-29-book/sbkj-purchase/target/classes",
		// "E:/branch-2014-12-29-book/sbkj-user-biz/target/classes",
		// "E:/branch-2014-12-29-book/sbkj-user-common/target/classes",
		// "E:/branch-2014-12-29-book/sbkj-user-limit/target/classes",
		};
		JettyServerArgs drpProjectServerArgs = new JettyServerArgs();
		drpProjectServerArgs.setPort(port);
		drpProjectServerArgs.setClassesPaths(classesPaths);
		drpProjectServerArgs.setWebAppPath(webAppPath);
		drpProjectServerArgs.setContextPath(contextPath);
		drpProjectServerArgs.setJarFilters(jarFilters);
		drpProjectServerArgs.setJarsPaths(jarsPaths);
		return drpProjectServerArgs;
	}

	public static JettyServerArgs drpOrderProjectServerArgs(String webPath) {
		int port = 8080;
		// String webAppPath = new StringBuilder(webPath).append("/sbkj-order-web/src/main/webapp").toString();
		String webAppPath = new StringBuilder(webPath).append("/sbkj-orderaide-web/target/sbkj-order").toString();
		String contextPath = "/order";
		String[] jarFilters = new String[] { "sbkj-orderaide-" };
		String[] jarsPaths = new String[] { new StringBuilder(webPath).append("/sbkj-orderaide-web/target/sbkj-order/WEB-INF/lib").toString(), };
		String[] classesPaths = new String[] { new StringBuilder(webPath).append("/sbkj-orderaide-biz/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-orderaide-common/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-orderaide-task/target/classes").toString(),
				// new StringBuilder(webPath).append("/sbkj-order-web/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-orderaide-web/target/sbkj-order/WEB-INF/classes").toString(), };
		JettyServerArgs drpProjectServerArgs = new JettyServerArgs();
		drpProjectServerArgs.setPort(port);
		drpProjectServerArgs.setClassesPaths(classesPaths);
		drpProjectServerArgs.setWebAppPath(webAppPath);
		drpProjectServerArgs.setContextPath(contextPath);
		drpProjectServerArgs.setJarFilters(jarFilters);
		drpProjectServerArgs.setJarsPaths(jarsPaths);
		return drpProjectServerArgs;
	}
	
	public static JettyServerArgs itemProjectServerArgs(String webPath) {
		int port = 8080;
		String webAppPath = new StringBuilder(webPath).append("/sbkj-item-web/target/sbkj-item").toString();
		String contextPath = "/";
		String[] jarFilters = new String[] { "sbkj-item-" };
		String[] jarsPaths = new String[] { new StringBuilder(webPath).append("/sbkj-item-web/target/sbkj-item/WEB-INF/lib").toString(), };
		String[] classesPaths = new String[] { 
				new StringBuilder(webPath).append("/sbkj-item-common/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-item-biz/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-item-auth/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-item-api/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-item-zookeeper/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-orderaide-web/target/sbkj-item/WEB-INF/classes").toString(), };
		JettyServerArgs drpProjectServerArgs = new JettyServerArgs();
		drpProjectServerArgs.setPort(port);
		drpProjectServerArgs.setClassesPaths(classesPaths);
		drpProjectServerArgs.setWebAppPath(webAppPath);
		drpProjectServerArgs.setContextPath(contextPath);
		drpProjectServerArgs.setJarFilters(jarFilters);
		drpProjectServerArgs.setJarsPaths(jarsPaths);
		return drpProjectServerArgs;
	}

	public static JettyServerArgs drpPromtbProjectServerArgs(String webPath) {
		int port = 8080;
		// String webAppPath = new StringBuilder(webPath).append("/sbkj-order-web/src/main/webapp").toString();
		String webAppPath = new StringBuilder(webPath).append("/sbkj-sk-tb-web/target/shopkeeper").toString();// 项目路径
		String contextPath = "/shopkeeper";
		String[] jarFilters = new String[] { "sbkj-sk-tb-" };// 包过滤
		String[] jarsPaths = new String[] { new StringBuilder(webPath).append("/sbkj-sk-tb-web/target/shopkeeper/WEB-INF/lib").toString(), };
		String[] classesPaths = new String[] { 
				new StringBuilder(webPath).append("/sbkj-sk-tb-common/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-competition/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-crm/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-evaluation/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-item/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-negative/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-public/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-rank/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-showcase/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-trade/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-warehouse/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-uc/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-sk-tb-web/target/shopkeeper/WEB-INF/classes").toString(), };
		JettyServerArgs drpProjectServerArgs = new JettyServerArgs();
		drpProjectServerArgs.setPort(port);
		drpProjectServerArgs.setClassesPaths(classesPaths);
		drpProjectServerArgs.setWebAppPath(webAppPath);
		drpProjectServerArgs.setContextPath(contextPath);
		drpProjectServerArgs.setJarFilters(jarFilters);
		drpProjectServerArgs.setJarsPaths(jarsPaths);
		return drpProjectServerArgs;
	}
	
	public static JettyServerArgs jdPromtbServerArgs(String webPath) {
		int port = 8080;
		String webAppPath = new StringBuilder(webPath).append("/sbkj-prom-jd-web/target/promjd").toString();// 项目路径
		String contextPath = "/promjd";
		String[] jarFilters = new String[] { "sbkj-prom-jd-" };// 包过滤
		String[] jarsPaths = new String[] { new StringBuilder(webPath).append("/sbkj-prom-jd-web/target/promjd/WEB-INF/lib").toString(), };
		String[] classesPaths = new String[] { 
				new StringBuilder(webPath).append("/sbkj-prom-jd-biz/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-prom-jd-common/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-prom-jd-web/target/promjd/WEB-INF/classes").toString(), };
		JettyServerArgs drpProjectServerArgs = new JettyServerArgs();
		drpProjectServerArgs.setPort(port);
		drpProjectServerArgs.setClassesPaths(classesPaths);
		drpProjectServerArgs.setWebAppPath(webAppPath);
		drpProjectServerArgs.setContextPath(contextPath);
		drpProjectServerArgs.setJarFilters(jarFilters);
		drpProjectServerArgs.setJarsPaths(jarsPaths);
		return drpProjectServerArgs;
	}

	public static JettyServerArgs drpOrderSearchProjectServerArgs(String webPath) {
		int port = 8090;
		String webAppPath = new StringBuilder(webPath).append("/sbkj-search-web/target/sbkj-search").toString();
		String contextPath = "/search";
		String[] jarFilters = new String[] { "sbkj-search-" };
		String[] jarsPaths = new String[] { new StringBuilder(webPath).append("/sbkj-search-web/target/sbkj-order/WEB-INF/lib").toString(), };
		String[] classesPaths = new String[] { new StringBuilder(webPath).append("/sbkj-search-biz/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-search-common/target/classes").toString(),
				new StringBuilder(webPath).append("/sbkj-search-web/target/sbkj-order/WEB-INF/classes").toString(), };
		JettyServerArgs drpProjectServerArgs = new JettyServerArgs();
		drpProjectServerArgs.setPort(port);
		drpProjectServerArgs.setClassesPaths(classesPaths);
		drpProjectServerArgs.setWebAppPath(webAppPath);
		drpProjectServerArgs.setContextPath(contextPath);
		drpProjectServerArgs.setJarFilters(jarFilters);
		drpProjectServerArgs.setJarsPaths(jarsPaths);
		return drpProjectServerArgs;
	}
	
	public static JettyServerArgs b2bMallProjectServerArgs(String webPath) {
		int port = 8080;
		String webAppPath = new StringBuilder(webPath).append("/src/main/webapp").toString();
		String contextPath = "/b2b";
//		String[] jarFilters = new String[] { "sbkj-search-" };
		String[] jarsPaths = new String[] { new StringBuilder(webPath).append("/target/sbkj-b2b-mall-1.0.0-SNAPSHOT/WEB-INF/lib").toString(), };
		String[] classesPaths = new String[] { new StringBuilder(webPath).append("/target/classes").toString(), };
		JettyServerArgs drpProjectServerArgs = new JettyServerArgs();
		drpProjectServerArgs.setPort(port);
		drpProjectServerArgs.setClassesPaths(classesPaths);
		drpProjectServerArgs.setWebAppPath(webAppPath);
		drpProjectServerArgs.setContextPath(contextPath);
//		drpProjectServerArgs.setJarFilters(jarFilters);
		drpProjectServerArgs.setJarsPaths(jarsPaths);
		return drpProjectServerArgs;
	}

	public static void main(String[] args) throws Exception {
		JettyServerArgs searchArgs = JettyServerArgs.drpOrderSearchProjectServerArgs("/home/cai_carlos/workspace/sbkj-order-search");
		JettyServer searchServer = new JettyServer(searchArgs.getPort(), searchArgs.getWebAppPath(), searchArgs.getContextPath());
		searchServer.addClassPath(searchArgs.getClassesPaths(), searchArgs.getJarsPaths(), searchArgs.getJarFilters());
		searchServer.start();
	}
}
