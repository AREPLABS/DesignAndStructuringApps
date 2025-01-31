package com.mycompany.webserver;

import java.net.*;

public class URLParser {

public static void main(String[] args) throws MalformedURLException {
 URL myurl = new URL("https://ldbn.is.escuelaing.edu.co/index.html?val=90&t=56#events");
 System.out.println("protocol: /" + myurl.getProtocol());
 System.out.println("protocol: /" + myurl.getAuthority());
 System.out.println("protocol: /" + myurl.getHost());
 System.out.println("protocol: /" + myurl.getPort());
 System.out.println("protocol: /" + myurl.getPath());
 System.out.println("protocol: /" + myurl.getQuery());
 System.out.println("protocol: /" + myurl.getFile());
 System.out.println("protocol: /" + myurl.getRef());
}
}   