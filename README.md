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
