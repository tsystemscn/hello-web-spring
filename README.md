# Hello example with SpringMVC framework

## Init the basic project

### Create a Maven war project

__Create a new webapp project from Eclipse__

    File -> New -> Maven Project

Next -> Filter: `webapp`(maven-archetype-webapp)

`groupId`: `com.tsystems.demo`(project group)
`artifactId`: `hello-web-spring`(the project name)
`version`: `0.0.1-SNAPSHOT` (default)

or __Copy from the exist `hello-web` project and change some configuration__

Change the artifactId(didn't allow duplicate) to `hello-web-spring`.

Reset the `web.xml` file in the `src/main/webapp/WEB-INF` folder(remove related servlet mapping).

    <!DOCTYPE web-app PUBLIC
    "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
    "http://java.sun.com/dtd/web-app_2_3.dtd" >
    <web-app>
        <display-name>Hello Web Application</display-name>
    </web-app>

Import the exist maven project `hello-web-spring`.

## Add SpringMVC support

### Import spring-mvc jar in POM.xml

        <!-- spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>

### Add the spring configuration

    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context-3.2.xsd">
        <context:component-scan base-package="com.tsystems.demo" />
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix">
                <value>/WEB-INF/jsp/</value>
            </property>
            <property name="suffix">
                <value>.jsp</value>
            </property>
        </bean>
        <mvc:resources mapping="/resources/**" location="/resources/" />
        <mvc:annotation-driven />
    </beans>

### Add spring servlet mapping in web.xml

        <servlet>
            <servlet-name>spring-web</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:spring.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>
    
        <servlet-mapping>
            <servlet-name>spring-web</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>

### Create the Controller class and related request mapping method

    @Controller
    public class HelloController {
        @RequestMapping(value = "/hello/{message}", method = RequestMethod.GET)
        public ModelAndView hello(@PathVariable("message") String message) {
            // view: hello.jsp
            String viewName = "hello";
            // model
            ModelMap map = new ModelMap();
            map.put("message", message);
            return new ModelAndView(viewName, map);
        }
    }

## Add Spring EL support

Update standard JSP descriptor in `web.xml` or set `isELIgnored="false"`.

    <web-app xmlns="http://java.sun.com/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                          http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
      version="3.0"
      metadata-complete="true">

