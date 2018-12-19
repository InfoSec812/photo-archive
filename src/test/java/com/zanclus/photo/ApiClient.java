package com.zanclus.photo;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.streams.ReadStream;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.entity.ContentType;

public class ApiClient {
    private WebClient client;
    private int port;
    private String host;

    private static final String PHOTO_PATH = "/photo";
    private static final String USER_PATH = "/user";
    private static final String GROUP_PATH = "/group";
    private static final String TEXT_ENCODING = "UTF-8";
    private static final String URI_REGEX = "\\{{1}([.;?*+]*([^\\{\\}.;?*+]+)[^\\}]*)\\}{1}";
    
    private String ApiKeyAuth_token;
    

    private MultiMap cookieParams;

    ApiClient(Vertx vertx, String host, int port) {
        client = WebClient.create(vertx, new WebClientOptions().setDefaultHost(host).setDefaultPort(port));
        this.port = port;
        this.host = host;

        cookieParams = MultiMap.caseInsensitiveMultiMap();
    }

    ApiClient(WebClient client) {
        this.client = client;

        cookieParams = MultiMap.caseInsensitiveMultiMap();
    }

    /**
     * Call userLogin with empty body. 
     * 
     * @param handler The handler for the asynchronous request
     */
    public void userLoginWithEmptyBody(
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.put(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call userLogin with Json body. 
     * 
     * @param body Json object or bean that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void userLoginWithJson(
        Object body, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.put(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_JSON.getMimeType(), request);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendJson(body, handler);
    }

    /**
     * Call userLogin with application/xml buffer body. 
     * 
     * @param buffer Buffer that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void userLoginWithXmlBuffer(
        Buffer buffer, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.put(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_XML.getMimeType(), request);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendBuffer(buffer, handler);
    }

    /**
     * Call userLogin with application/xml stream body. 
     * 
     * @param stream ReadStream that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void userLoginWithXmlStream(
        ReadStream<Buffer> stream, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.put(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_XML.getMimeType(), request);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendStream(stream, handler);
    }

    /**
     * Call userLogin with form application/x-www-form-urlencoded body. 
     * 
     * @param form Form that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void userLoginWithForm(
        MultiMap form, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.put(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_FORM_URLENCODED.getMimeType(), request);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendForm(form, handler);
    }

    /**
     * Call newUser with empty body. 
     * 
     * @param handler The handler for the asynchronous request
     */
    public void newUserWithEmptyBody(
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call newUser with Json body. 
     * 
     * @param body Json object or bean that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void newUserWithJson(
        Object body, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_JSON.getMimeType(), request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendJson(body, handler);
    }

    /**
     * Call newUser with application/xml buffer body. 
     * 
     * @param buffer Buffer that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void newUserWithXmlBuffer(
        Buffer buffer, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_XML.getMimeType(), request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendBuffer(buffer, handler);
    }

    /**
     * Call newUser with application/xml stream body. 
     * 
     * @param stream ReadStream that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void newUserWithXmlStream(
        ReadStream<Buffer> stream, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_XML.getMimeType(), request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendStream(stream, handler);
    }

    /**
     * Call newUser with form application/x-www-form-urlencoded body. 
     * 
     * @param form Form that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void newUserWithForm(
        MultiMap form, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = USER_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_FORM_URLENCODED.getMimeType(), request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendForm(form, handler);
    }

    /**
     * Call getUserDetailsByName with empty body. 
     * 
     * @param id Parameter id inside path
     * @param handler The handler for the asynchronous request
     */
    public void getUserDetailsByName(
        String id,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        

        // Generate the uri
        String uri = "/user/{id}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        

        HttpRequest request = client.get(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call newGroup with empty body. 
     * 
     * @param handler The handler for the asynchronous request
     */
    public void newGroupWithEmptyBody(
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = GROUP_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call newGroup with Json body. 
     * 
     * @param body Json object or bean that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void newGroupWithJson(
        Object body, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = GROUP_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_JSON.getMimeType(), request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendJson(body, handler);
    }

    /**
     * Call newGroup with application/xml buffer body. 
     * 
     * @param buffer Buffer that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void newGroupWithXmlBuffer(
        Buffer buffer, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = GROUP_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_XML.getMimeType(), request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendBuffer(buffer, handler);
    }

    /**
     * Call newGroup with application/xml stream body. 
     * 
     * @param stream ReadStream that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void newGroupWithXmlStream(
        ReadStream<Buffer> stream, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = GROUP_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_XML.getMimeType(), request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendStream(stream, handler);
    }

    /**
     * Call newGroup with form application/x-www-form-urlencoded body. 
     * 
     * @param form Form that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void newGroupWithForm(
        MultiMap form, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = GROUP_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), ContentType.APPLICATION_FORM_URLENCODED.getMimeType(), request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendForm(form, handler);
    }

    /**
     * Call getGroupById with empty body. 
     * 
     * @param id Parameter id inside path
     * @param handler The handler for the asynchronous request
     */
    public void getGroupById(
        String id,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        

        // Generate the uri
        String uri = "/group/{id}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        

        HttpRequest request = client.get(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call updateGroupById with empty body. 
     * 
     * @param id Parameter id inside path
     * @param handler The handler for the asynchronous request
     */
    public void updateGroupById(
        String id,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        

        // Generate the uri
        String uri = "/group/{id}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        

        HttpRequest request = client.put(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call addUserToGroup with empty body. 
     * 
     * @param id Parameter id inside path
     * @param userId Parameter userId inside path
     * @param handler The handler for the asynchronous request
     */
    public void addUserToGroup(
        String id,
        String userId,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        if (userId == null) throw new RuntimeException("Missing parameter userId in path");
        

        // Generate the uri
        String uri = "/group/{id}/add/{userId}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        uri = uri.replace("{userId}", this.renderPathParam("userId", userId));
        

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call deleteUserFromGroup with empty body. 
     * 
     * @param id Parameter id inside path
     * @param userId Parameter userId inside path
     * @param handler The handler for the asynchronous request
     */
    public void deleteUserFromGroup(
        String id,
        String userId,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        if (userId == null) throw new RuntimeException("Missing parameter userId in path");
        

        // Generate the uri
        String uri = "/group/{id}/delete/{userId}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        uri = uri.replace("{userId}", this.renderPathParam("userId", userId));
        

        HttpRequest request = client.delete(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call addPhoto with empty body. 
     * 
     * @param handler The handler for the asynchronous request
     */
    public void addPhotoWithEmptyBody(
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = PHOTO_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call addPhoto with image/* buffer body. 
     * 
     * @param buffer Buffer that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void addPhotoWithImageBuffer(
        Buffer buffer, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = PHOTO_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam(HttpHeaderNames.CONTENT_TYPE.toString(), "image/*", request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendBuffer(buffer, handler);
    }

    /**
     * Call addPhoto with image/* stream body. 
     * 
     * @param stream ReadStream that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void addPhotoWithImageStream(
        ReadStream<Buffer> stream, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = PHOTO_PATH;

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam("Content-Type", "image/*", request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendStream(stream, handler);
    }

    /**
     * Call getImageById with empty body. 
     * 
     * @param handler The handler for the asynchronous request
     */
    public void getImageById(
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        

        // Generate the uri
        String uri = "/photo/{id}";

        HttpRequest request = client.get(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call updateImageById with empty body. 
     * 
     * @param id Parameter id inside path
     * @param handler The handler for the asynchronous request
     */
    public void updateImageByIdWithEmptyBody(
        String id,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        

        // Generate the uri
        String uri = "/photo/{id}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        

        HttpRequest request = client.put(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call updateImageById with Json body. 
     * 
     * @param id Parameter id inside path
     * @param body Json object or bean that represents the body of the request
     * @param handler The handler for the asynchronous request
     */
    public void updateImageByIdWithJson(
        String id,
        Object body, Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        

        // Generate the uri
        String uri = "/photo/{id}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        

        HttpRequest request = client.put(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.addHeaderParam("Content-Type", "application/json", request);
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.sendJson(body, handler);
    }

    /**
     * Call deleteImageById with empty body. 
     * 
     * @param id Parameter id inside path
     * @param handler The handler for the asynchronous request
     */
    public void deleteImageById(
        String id,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        

        // Generate the uri
        String uri = "/photo/{id}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        

        HttpRequest request = client.delete(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call getTagsByPhotoId with empty body. 
     * 
     * @param id Parameter id inside path
     * @param handler The handler for the asynchronous request
     */
    public void getTagsByPhotoId(
        String id,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        

        // Generate the uri
        String uri = "/photo/{id}/tag";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        

        HttpRequest request = client.get(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call addTagToPhoto with empty body. 
     * 
     * @param id Parameter id inside path
     * @param tag Parameter tag inside path
     * @param handler The handler for the asynchronous request
     */
    public void addTagToPhoto(
        String id,
        String tag,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        if (tag == null) throw new RuntimeException("Missing parameter tag in path");
        

        // Generate the uri
        String uri = "/photo/{id}/tag/{tag}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        uri = uri.replace("{tag}", this.renderPathParam("tag", tag));
        

        HttpRequest request = client.post(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }

    /**
     * Call deleteTagFromPhoto with empty body. 
     * 
     * @param id Parameter id inside path
     * @param tag Parameter tag inside path
     * @param handler The handler for the asynchronous request
     */
    public void deleteTagFromPhoto(
        String id,
        String tag,
        Handler<AsyncResult<HttpResponse>> handler) {
        // Check required params
        if (id == null) throw new RuntimeException("Missing parameter id in path");
        if (tag == null) throw new RuntimeException("Missing parameter tag in path");
        

        // Generate the uri
        String uri = "/photo/{id}/tag/{tag}";
        uri = uri.replaceAll(URI_REGEX, "{$2}"); //Remove * . ; ? from url template
        uri = uri.replace("{id}", this.renderPathParam("id", id));
        uri = uri.replace("{tag}", this.renderPathParam("tag", tag));
        

        HttpRequest request = client.delete(uri);

        MultiMap requestCookies = MultiMap.caseInsensitiveMultiMap();
        this.attachApiKeyAuthSecurity(request, requestCookies);
        this.attachBearerAuthSecurity(request, requestCookies);
        

        this.renderAndAttachCookieHeader(request, requestCookies);
        request.send(handler);
    }


    // Security requirements functions
    private void attachBasicAuthSecurity (HttpRequest request, MultiMap cookies) {

    }

        private void attachBearerAuthSecurity (HttpRequest request, MultiMap cookies) {

    }

        private void attachApiKeyAuthSecurity (HttpRequest request, MultiMap cookies) {

        this.addHeaderParam("X-API-Key", this.ApiKeyAuth_token, request);
        
    }

    // Security parameters functions
    
    /**
     * Set access token for security scheme ApiKeyAuth
     */
    public void setApiKeyAuthToken(String token) {
        this.ApiKeyAuth_token = token;
    }
    

    // Parameters functions

    /**
     * Remove a cookie parameter from the cookie cache
     *
     * @param paramName name of cookie parameter
     */
    public void removeCookie(String paramName) {
        cookieParams.remove(paramName);
    }

    private void addQueryParam(String paramName, Object value, HttpRequest request) {
        request.addQueryParam(paramName, String.valueOf(value));
    }

    /**
     * Add a cookie param in cookie cache
     *
     * @param paramName name of cookie parameter
     * @param value value of cookie parameter
     */
    public void addCookieParam(String paramName, Object value) {
        renderCookieParam(paramName, value, cookieParams);
    }

    private void addHeaderParam(String headerName, Object value, HttpRequest request) {
        request.putHeader(headerName, String.valueOf(value));
    }

    private String renderPathParam(String paramName, Object value) {
        return String.valueOf(value);
    }

    private void renderCookieParam(String paramName, Object value, MultiMap map) {
        map.remove(paramName);
        map.add(paramName, String.valueOf(value));
    }

    /**
     * Following this table to implement parameters serialization
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | style          | explode | in            | array                               | object                                 |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | matrix         | false   | path          | ;color=blue,black,brown             | ;color=R,100,G,200,B,150               |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | matrix         | true    | path          | ;color=blue;color=black;color=brown | ;R=100;G=200;B=150                     |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | label          | false   | path          | .blue.black.brown                   | .R.100.G.200.B.150                     |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | label          | true    | path          | .blue.black.brown                   | .R=100.G=200.B=150                     |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | false   | query, cookie | color=blue,black,brown              | color=R,100,G,200,B,150                |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | true    | query, cookie | color=blue&color=black&color=brown  | R=100&G=200&B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | false   | path, header  | blue,black,brown                    | R,100,G,200,B,150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | true    | path, header  | blue,black,brown                    | R=100,G=200,B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | spaceDelimited | false   | query         | blue%20black%20brown                | R%20100%20G%20200%20B%20150            |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | pipeDelimited  | false   | query         | blue|black|brown                    | R|100|G|200                            |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | deepObject     | true    | query         | n/a                                 | color[R]=100&color[G]=200&color[B]=150 |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     */

    /**
     * Render path value with matrix style exploded/not exploded
     *
     * @param paramName
     * @param value
     * @return
     */
    private String renderPathMatrix(String paramName, Object value) {
        return ";" + paramName + "=" + String.valueOf(value);
    }

    /**
     * Render path array with matrix style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | matrix         | false   | path          | ;color=blue,black,brown             | ;color=R,100,G,200,B,150               |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathArrayMatrix(String paramName, List<Object> values) {
        String serialized = String.join(",", values.stream().map(object -> encode(String.valueOf(object))).collect(Collectors.toList()));
        return ";" + paramName + "=" + serialized;
    }

    /**
     * Render path object with matrix style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | matrix         | false   | path          | ;color=blue,black,brown             | ;color=R,100,G,200,B,150               |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathObjectMatrix(String paramName, Map<String, Object> values) {
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            listToSerialize.add(entry.getKey());
            listToSerialize.add(encode(String.valueOf(entry.getValue())));
        }
        String serialized = String.join(",", listToSerialize);
        return ";" + paramName + "=" + serialized;
    }

    /**
     * Render path array with matrix style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | matrix         | true    | path          | ;color=blue;color=black;color=brown | ;R=100;G=200;B=150                     |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathArrayMatrixExplode(String paramName, List<Object> values) {
        return String.join("", values.stream().map(object -> ";" + paramName + "=" + encode(String.valueOf(object))).collect(Collectors.toList()));
    }

    /**
     * Render path object with matrix style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | matrix         | true    | path          | ;color=blue;color=black;color=brown | ;R=100;G=200;B=150                     |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathObjectMatrixExplode(String paramName, Map<String, Object> values) {
      return String.join("", values.entrySet().stream().map(
        entry -> ";" + entry.getKey() + "=" + encode(String.valueOf(entry.getValue()))
      ).collect(Collectors.toList()));
    }

    /**
     * Render path value with label style exploded/not exploded
     *
     * @param paramName
     * @param value
     * @return
     */
    private String renderPathLabel(String paramName, Object value) {
        return "." + String.valueOf(value);
    }

    /**
     * Render path array with label style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | label          | false   | path          | .blue.black.brown                   | .R.100.G.200.B.150                     |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathArrayLabel(String paramName, List<Object> values) {
        return "." + String.join(".", values.stream().map(object -> encode(String.valueOf(object))).collect(Collectors.toList()));
    }

    /**
     * Render path object with label style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | label          | false   | path          | .blue.black.brown                   | .R.100.G.200.B.150                     |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathObjectLabel(String paramName, Map<String, Object> values) {
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            listToSerialize.add(entry.getKey());
            listToSerialize.add(encode(String.valueOf(entry.getValue())));
        }
        return "." + String.join(".", listToSerialize);
    }

    /**
     * Render path array with label style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | label          | true    | path          | .blue.black.brown                   | .R=100.G=200.B=150                     |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathArrayLabelExplode(String paramName, List<Object> values) {
        return renderPathArrayLabel(paramName, values);
    }

    /**
     * Render path object with label style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | label          | true    | path          | .blue.black.brown                   | .R=100.G=200.B=150                     |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathObjectLabelExplode(String paramName, Map<String, Object> values) {
        String result = "";
        for (Map.Entry<String, Object> value : values.entrySet())
            result = result.concat("." + value.getKey() + "=" + encode(String.valueOf(value.getValue())));
        return result;
    }

    /**
     * Render path array with simple style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | false   | path, header  | blue,black,brown                    | R,100,G,200,B,150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathArraySimple(String paramName, List<Object> values) {
        return String.join(",", values.stream().map(object -> encode(String.valueOf(object))).collect(Collectors.toList()));
    }

    /**
     * Render path object with simple style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | false   | path, header  | blue,black,brown                    | R,100,G,200,B,150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathObjectSimple(String paramName, Map<String, Object> values) {
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            listToSerialize.add(entry.getKey());
            listToSerialize.add(encode(String.valueOf(entry.getValue())));
        }
        return String.join(",", listToSerialize);
    }

    /**
     * Render path array with simple style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | true    | path, header  | blue,black,brown                    | R=100,G=200,B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathArraySimpleExplode(String paramName, List<Object> values) {
        return renderPathArraySimple(paramName, values);
    }

    /**
     * Render path object with simple style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | true    | path, header  | blue,black,brown                    | R=100,G=200,B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @return
     */
    private String renderPathObjectSimpleExplode(String paramName, Map<String, Object> values) {
        return String.join(",",
          values.entrySet().stream().map((entry) -> entry.getKey() + "=" + encode(String.valueOf(entry.getValue()))).collect(Collectors.toList()));
    }

    /**
     * Add query array with form style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | false   | query, cookie | color=blue,black,brown              | color=R,100,G,200,B,150                |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @param request
     */
    private void addQueryArrayForm(String paramName, List<Object> values, HttpRequest request) {
        String serialized = String.join(",", values.stream().map(object -> String.valueOf(object)).collect(Collectors.toList()));
        this.addQueryParam(paramName, serialized, request); // Encoding is done by WebClient
    }

    /**
     * Add query object with form style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | false   | query, cookie | color=blue,black,brown              | color=R,100,G,200,B,150                |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @param request
     */
    private void addQueryObjectForm(String paramName, Map<String, Object> values, HttpRequest request) {
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            listToSerialize.add(entry.getKey());
            listToSerialize.add(String.valueOf(entry.getValue()));
        }
        String serialized = String.join(",", listToSerialize);
        this.addQueryParam(paramName, serialized, request); // Encoding is done by WebClient
    }

    /**
     * Add cookie array with form style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | false   | query, cookie | color=blue,black,brown              | color=R,100,G,200,B,150                |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     */
    private void renderCookieArrayForm(String paramName, List<Object> values, MultiMap map) {
        String value = String.join(",", values.stream().map(object -> String.valueOf(object)).collect(Collectors.toList()));
        map.remove(paramName);
        map.add(paramName, value);
    }

    /**
     * Add a cookie array parameter in cookie cache
     *
     * @param paramName name of cookie parameter
     * @param values list of values of cookie parameter
     */
    public void addCookieArrayForm(String paramName, List<Object> values) {
        renderCookieArrayForm(paramName, values, cookieParams);
    }

    /**
     * Add cookie object with form style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | false   | query, cookie | color=blue,black,brown              | color=R,100,G,200,B,150                |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     */
    private void renderCookieObjectForm(String paramName, Map<String, Object> values, MultiMap map) {
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            listToSerialize.add(entry.getKey());
            listToSerialize.add(String.valueOf(entry.getValue()));
        }
        String value = String.join(",", listToSerialize);
        map.remove(paramName);
        map.add(paramName, value);
    }

    /**
     * Add a cookie object parameter in cookie cache
     *
     * @param paramName name of cookie parameter
     * @param values map of values of cookie parameter
     */
    public void addCookieObjectForm(String paramName, Map<String, Object> values) {
        renderCookieObjectForm(paramName, values, cookieParams);
    }

    /**
     * Add query array with form style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | true    | query, cookie | color=blue&color=black&color=brown  | R=100&G=200&B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @param request
     */
    private void addQueryArrayFormExplode(String paramName, List<Object> values, HttpRequest request) {
        for (Object value : values)
            this.addQueryParam(paramName, String.valueOf(value), request);
    }

    /**
     * Add query object with form style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | true    | query, cookie | color=blue&color=black&color=brown  | R=100&G=200&B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @param request
     */
    private void addQueryObjectFormExplode(String paramName, Map<String, Object> values, HttpRequest request) {
        for (Map.Entry<String, Object> value : values.entrySet())
            this.addQueryParam(value.getKey(), String.valueOf(value.getValue()), request);
    }

    /**
     * Add cookie array with form style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | true    | query, cookie | color=blue&color=black&color=brown  | R=100&G=200&B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     */
    private void renderCookieArrayFormExplode(String paramName, List<Object> values, MultiMap map) {
        map.remove(paramName);
        for (Object value : values)
            map.add(paramName, String.valueOf(value));
    }

    public void addCookieArrayFormExplode(String paramName, List<Object> values) {
        renderCookieArrayFormExplode(paramName, values, cookieParams);
    }

    /**
     * Add cookie object with form style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | form           | true    | query, cookie | color=blue&color=black&color=brown  | R=100&G=200&B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     */
    private void renderCookieObjectFormExplode(String paramName, Map<String, Object> values, MultiMap map) {
        for (Map.Entry<String, Object> value : values.entrySet()) {
            map.remove(value.getKey());
            map.add(value.getKey(), String.valueOf(value.getValue()));
        }
    }

    public void addCookieObjectFormExplode(String paramName, Map<String, Object> values) {
        renderCookieObjectFormExplode(paramName, values, cookieParams);
    }

    /**
     * Add header array with simple style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | false   | path, header  | blue,black,brown                    | R,100,G,200,B,150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param headerName
     * @param values
     * @param request
     */
    private void addHeaderArraySimple(String headerName, List<Object> values, HttpRequest request) {
        String serialized = String.join(",", values.stream().map(object -> String.valueOf(object)).collect(Collectors.toList()));
        this.addHeaderParam(headerName, serialized, request);
    }

    /**
     * Add header object with simple style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | false   | path, header  | blue,black,brown                    | R,100,G,200,B,150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param headerName
     * @param values
     * @param request
     */
    private void addHeaderObjectSimple(String headerName, Map<String, Object> values, HttpRequest request) {
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            listToSerialize.add(entry.getKey());
            listToSerialize.add(String.valueOf(entry.getValue()));
        }
        String serialized = String.join(",", listToSerialize);
        this.addHeaderParam(headerName, serialized, request);
    }

    /**
     * Add header array with simple style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | true    | path, header  | blue,black,brown                    | R=100,G=200,B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param headerName
     * @param values
     * @param request
     */
    private void addHeaderArraySimpleExplode(String headerName, List<Object> values, HttpRequest request) {
        this.addHeaderArraySimple(headerName, values, request);
    }

    /**
     * Add header object with simple style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | simple         | true    | path, header  | blue,black,brown                    | R=100,G=200,B=150                      |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param headerName
     * @param values
     * @param request
     */
    private void addHeaderObjectSimpleExplode(String headerName, Map<String, Object> values, HttpRequest request) {
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            listToSerialize.add(entry.getKey() + "=" + String.valueOf(entry.getValue()));
        }
        String serialized = String.join(",", listToSerialize);
        this.addHeaderParam(headerName, serialized, request);
    }

    /**
     * Add query array with spaceDelimited style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | spaceDelimited | false   | query         | blue%20black%20brown                | R%20100%20G%20200%20B%20150            |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @param request
     */
    private void addQueryArraySpaceDelimited(String paramName, List<Object> values, HttpRequest request) {
        String serialized = String.join(" ", values.stream().map(object -> String.valueOf(object)).collect(Collectors.toList()));
        this.addQueryParam(paramName, serialized, request); // Encoding is done by WebClient
    }

    /**
     * Add query object with spaceDelimited style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | spaceDelimited | false   | query         | blue%20black%20brown                | R%20100%20G%20200%20B%20150            |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @param request
     */
    private void addQueryObjectSpaceDelimited(String paramName, Map<String, Object> values, HttpRequest request) {
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            listToSerialize.add(entry.getKey());
            listToSerialize.add(String.valueOf(entry.getValue()));
        }
        String serialized = String.join(" ", listToSerialize);
        this.addQueryParam(paramName, serialized, request); // Encoding is done by WebClient
    }

    /**
     * Add query array with pipeDelimited style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | pipeDelimited  | false   | query         | blue|black|brown                    | R|100|G|200                            |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @param request
     */
    private void addQueryArrayPipeDelimited(String paramName, List<Object> values, HttpRequest request) {
        String serialized = String.join("|", values.stream().map(object -> String.valueOf(object)).collect(Collectors.toList()));
        this.addQueryParam(paramName, serialized, request); // Encoding is done by WebClient
    }

    /**
     * Add query object with pipeDelimited style and not exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | pipeDelimited  | false   | query         | blue|black|brown                    | R|100|G|200                            |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @param request
     */
    private void addQueryObjectPipeDelimited(String paramName, Map<String, Object> values, HttpRequest request) {
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            listToSerialize.add(entry.getKey());
            listToSerialize.add(String.valueOf(entry.getValue()));
        }
        String serialized = String.join("|", listToSerialize);
        this.addQueryParam(paramName, serialized, request); // Encoding is done by WebClient
    }

    /**
     * Add query object with deepObject style and exploded
     *
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     | deepObject     | true    | query         | n/a                                 | color[R]=100&color[G]=200&color[B]=150 |
     +----------------+---------+---------------+-------------------------------------+----------------------------------------+
     *
     * @param paramName
     * @param values
     * @param request
     */
    private void addQueryObjectDeepObjectExplode(String paramName, Map<String, Object> values, HttpRequest request) {
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            this.addQueryParam(paramName + "[" + entry.getKey() + "]", String.valueOf(entry.getValue()), request);
        }
    }


    private void renderAndAttachCookieHeader(HttpRequest request, MultiMap otherCookies) {
        if ((otherCookies == null || otherCookies.isEmpty()) && cookieParams.isEmpty())
            return;
        List<String> listToSerialize = new ArrayList<>();
        for (Map.Entry<String, String> e : cookieParams.entries()) {
            if (otherCookies!= null && !otherCookies.contains(e.getKey())) {
                try {
                    listToSerialize.add(URLEncoder.encode(e.getKey(), TEXT_ENCODING) + "=" + URLEncoder.encode(e.getValue(), TEXT_ENCODING));
                } catch (UnsupportedEncodingException e1) {
                }
            }
        }
        if (otherCookies != null) {
            for (Map.Entry<String, String> e : otherCookies.entries()) {
                try {
                    listToSerialize.add(URLEncoder.encode(e.getKey(), TEXT_ENCODING) + "=" + URLEncoder.encode(e.getValue(), TEXT_ENCODING));
                } catch (UnsupportedEncodingException e1) {
                }
            }
        }
        request.putHeader("Cookie", String.join("; ", listToSerialize));
    }

    // Other functions

    private String encode(String s) {
        try {
            return URLEncoder.encode(s, TEXT_ENCODING);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Close the connection with server
     *
     */
    public void close() {
        client.close();
    }

}
