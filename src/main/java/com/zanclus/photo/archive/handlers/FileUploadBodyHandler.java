package com.zanclus.photo.archive.handlers;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.reactivex.core.Vertx;

public class FileUploadBodyHandler implements BodyHandler {

    private Vertx vertx;

    private boolean handleFileUploads = false;
    private long bodyLimit = 1024*1024*1024;
    private String uploadsDirectory = "/tmp";
    private boolean mergeFormAttributes = false;
    private boolean deleteUploadedFilesOnEnd = false;
    private boolean isPreallocateBodyBuffer = false;

    private FileUploadBodyHandler() {
        super();
    }

    private FileUploadBodyHandler(Vertx vertx) {
        super();
        this.vertx = vertx;
    }

    public static FileUploadBodyHandler bodyHandler(io.vertx.core.Vertx vertx) {
        return new FileUploadBodyHandler(Vertx.newInstance(vertx));
    }

    public static FileUploadBodyHandler bodyHandler(Vertx vertx) {
        return new FileUploadBodyHandler(vertx);
    }

    /**
     * Set whether file uploads will be handled
     *
     * @param handleFileUploads true if they should be handled
     * @return reference to this for fluency
     */
    @Override
    public BodyHandler setHandleFileUploads(boolean handleFileUploads) {
        return this;
    }

    /**
     * Set the maximum body size -1 means unlimited
     *
     * @param bodyLimit the max size
     * @return reference to this for fluency
     */
    @Override
    public BodyHandler setBodyLimit(long bodyLimit) {
        this.bodyLimit = bodyLimit;
        return this;
    }

    /**
     * Set the uploads directory to use
     *
     * @param uploadsDirectory the uploads directory
     * @return reference to this for fluency
     */
    @Override
    public BodyHandler setUploadsDirectory(String uploadsDirectory) {
        this.uploadsDirectory = uploadsDirectory;
        return this;
    }

    /**
     * Set whether form attributes will be added to the request parameters
     *
     * @param mergeFormAttributes true if they should be merged
     * @return reference to this for fluency
     */
    @Override
    public BodyHandler setMergeFormAttributes(boolean mergeFormAttributes) {
        this.mergeFormAttributes = mergeFormAttributes;
        return this;
    }

    /**
     * Set whether uploaded files should be removed after handling the request
     *
     * @param deleteUploadedFilesOnEnd true if uploaded files should be removed after handling the request
     * @return reference to this for fluency
     */
    @Override
    public BodyHandler setDeleteUploadedFilesOnEnd(boolean deleteUploadedFilesOnEnd) {
        this.deleteUploadedFilesOnEnd = deleteUploadedFilesOnEnd;
        return this;
    }

    /**
     * Pre-allocate the body buffer according to the value parsed from content-length header.
     * The buffer is capped at 64KB
     *
     * @param isPreallocateBodyBuffer {@code true} if body buffer is pre-allocated according to the size
     *                                read from content-length Header.
     *                                {code false} if body buffer is pre-allocated to 1KB, and is resized dynamically
     * @return reference to this for fluency
     */
    @Override
    public BodyHandler setPreallocateBodyBuffer(boolean isPreallocateBodyBuffer) {
        this.isPreallocateBodyBuffer = isPreallocateBodyBuffer;
        return this;
    }

    /**
     * Something has happened, so handle it.
     *
     * @param ctx the event to handle
     */
    @Override
    public void handle(RoutingContext ctx) {
        if (ctx.fileUploads() != null && ctx.fileUploads().size() > 0) {
            final JsonArray files = new JsonArray();
            ctx.fileUploads().iterator().forEachRemaining(f -> {
                if (f.contentType().toLowerCase().startsWith("image")) {
                    JsonObject fileInfo = new JsonObject();
                    fileInfo.put("filename", f.fileName());
                    fileInfo.put("localPath", f.uploadedFileName());
                    fileInfo.put("type", f.contentType());
                    fileInfo.put("size", f.size());
                    files.add(fileInfo);
                }
            });
            if (files.size() > 0) {
                ctx.put("uploads", files);
            }
        }
    }
}
