package com.Goit11;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class SimpleHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        URI endpoint = exchange.getRequestURI();
        ResponseEntity responseEntity = null;
        try {
            switch (requestMethod) {
                case "GET":
                    responseEntity = handleGet(exchange);
                    break;
                case "POST":
                    responseEntity = handlePost(exchange);
                    break;
                case "PUT":
                    responseEntity = handlePut(exchange);
                    break;
                case "DELETE":
                    responseEntity = handleDelete(exchange);
                    break;
            }
        } catch (Exception e){
            throw new RuntimeException("ERROR");
        }finally {
            sendResponse(exchange, responseEntity);
        }
    }

    private ResponseEntity handleDelete(HttpExchange exchange) {

        return ResponseEntity.of("deleted", 204);
    }

    private ResponseEntity handlePut(HttpExchange exchange) throws IOException {
            byte[] bytes = exchange.getRequestBody().readAllBytes();
        return ResponseEntity.of("updated", 200);
    }

    private ResponseEntity handlePost(HttpExchange exchange) throws IOException {
        byte[] bytes = exchange.getRequestBody().readAllBytes();
        return ResponseEntity.of("created", 201);
    }


    private ResponseEntity handleGet(HttpExchange exchange) {

        return ResponseEntity.of("deleted", 200);
    }

    private static void sendResponse(HttpExchange exchange, ResponseEntity responseEntity) throws IOException {
        exchange.sendResponseHeaders(responseEntity.getStatus(), responseEntity.getContent().length());
        OutputStream os = exchange.getResponseBody();
        os.write(responseEntity.getContent().getBytes());
        os.close();
    }
}
