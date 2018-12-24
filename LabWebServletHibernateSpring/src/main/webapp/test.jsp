<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<%
ApplicationContext context = (ApplicationContext)
		application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

CustomerService customerService = (CustomerService) context.getBean("customerService");
CustomerBean bean1 = customerService.login("Alex", "A");
out.println("<h3>bean="+bean1+"</h3>");

CustomerDAO customerDao = (CustomerDAO) context.getBean("customerDAOHibernate");
CustomerBean bean2 = customerDao.select("Alex");
out.println("<h3>select="+bean2+"</h3>");

ProductDAO ProductDao = (ProductDAO) context.getBean("productDAOHibernate");
List<ProductBean> beans1 = ProductDao.select();
out.println("<h3>beans1="+beans1+"</h3>");

ProductService service = (ProductService) context.getBean("productService");
List<ProductBean> beans2 = service.select(null);
out.println("<h3>beans2="+beans2+"</h3>");
%>

</body>
</html>
