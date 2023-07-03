package org.naby.project.common.microservice;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

public class MS {
    private MS(){}
    public static void run() throws IOException {
       ResourceConfig config = new PackagesResourceConfig("org.naby.project");
       HttpServer server = HttpServerFactory.create("http://localhost:9990/", config);
       server.start();
   }
}