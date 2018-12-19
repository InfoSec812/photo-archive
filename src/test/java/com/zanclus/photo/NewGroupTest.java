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
 * newGroup Test
 */
@RunWith(VertxUnitRunner.class)
public class NewGroupTest extends BaseTest {

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
        Async async = test.async(5);

        // TODO set parameters for newGroupWithEmptyBody request
        apiClient.newGroupWithEmptyBody((AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithJson request
        JsonObject body = new JsonObject();
        apiClient.newGroupWithJson(body, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithXmlBuffer request
        Buffer buffer = null;
        apiClient.newGroupWithXmlBuffer(buffer, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithXmlStream request
        ReadStream<Buffer> stream = null;
        apiClient.newGroupWithXmlStream(stream, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithForm request
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        apiClient.newGroupWithForm(form, (AsyncResult<HttpResponse> ar) -> {
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
        Async async = test.async(5);

        // TODO set parameters for newGroupWithEmptyBody request
        apiClient.newGroupWithEmptyBody((AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(403, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithJson request
        JsonObject body = new JsonObject();
        apiClient.newGroupWithJson(body, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(403, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithXmlBuffer request
        Buffer buffer = null;
        apiClient.newGroupWithXmlBuffer(buffer, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(403, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithXmlStream request
        ReadStream<Buffer> stream = null;
        apiClient.newGroupWithXmlStream(stream, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(403, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithForm request
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        apiClient.newGroupWithForm(form, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(403, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });
    }

    @Test
    public void test409(TestContext test) {
        Async async = test.async(5);

        // TODO set parameters for newGroupWithEmptyBody request
        apiClient.newGroupWithEmptyBody((AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(409, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithJson request
        JsonObject body = new JsonObject();
        apiClient.newGroupWithJson(body, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(409, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithXmlBuffer request
        Buffer buffer = null;
        apiClient.newGroupWithXmlBuffer(buffer, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(409, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithXmlStream request
        ReadStream<Buffer> stream = null;
        apiClient.newGroupWithXmlStream(stream, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(409, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newGroupWithForm request
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        apiClient.newGroupWithForm(form, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(409, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });
    }


}