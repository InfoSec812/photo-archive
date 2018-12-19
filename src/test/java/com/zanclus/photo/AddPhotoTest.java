package com.zanclus.photo;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.streams.ReadStream;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.core.AsyncResult;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.core.json.JsonObject;
import io.vertx.core.MultiMap;
import org.junit.*;
import org.junit.runner.RunWith;

/**
 * addPhoto Test
 */
@RunWith(VertxUnitRunner.class)
public class AddPhotoTest extends BaseTest {

    @Override
    @Before
    public void before(TestContext context) {
        super.before(context);
        //TODO add some test initialization code like security token retrieval
    }

    @Override
    @After
    public void after(TestContext context) {
        //TODO add some test end code like session destroy
        super.after(context);
    }

    @Test
    public void test202(TestContext test) {
        Async async = test.async(3);

        // TODO set parameters for addPhotoWithEmptyBody request
        apiClient.addPhotoWithEmptyBody((AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for addPhotoWithImage*Buffer request
        Buffer buffer = null;
        apiClient.addPhotoWithImageBuffer(buffer, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for addPhotoWithImage*Stream request
        ReadStream<Buffer> stream = null;
        apiClient.addPhotoWithImageStream(stream, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });
    }

    @Test
    public void test403(TestContext test) {
        Async async = test.async(3);

        // TODO set parameters for addPhotoWithEmptyBody request
        apiClient.addPhotoWithEmptyBody((AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(403, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for addPhotoWithImage*Buffer request
        Buffer buffer = null;
        apiClient.addPhotoWithImageBuffer(buffer, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(403, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for addPhotoWithImage*Stream request
        ReadStream<Buffer> stream = null;
        apiClient.addPhotoWithImageStream(stream, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(403, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });
    }


}