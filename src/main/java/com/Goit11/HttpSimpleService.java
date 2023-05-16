package com.Goit11;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpSimpleService {
    HttpServer httpServer;

    public HttpSimpleService(int port, String path, int nThreads) throws IOException {
        InetSocketAddress localhost = new InetSocketAddress(port);
        httpServer = HttpServerProvider.provider().createHttpServer(localhost,0);
        HttpContext context = httpServer.createContext(path, new SimpleHandler());
        httpServer.setExecutor(Executors.newFixedThreadPool(nThreads));
    }

    public void start(){
        httpServer.start();
    }
}
