package com.zanclus.photo;

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
 * newUser Test
 */
@RunWith(VertxUnitRunner.class)
public class NewUserTest extends BaseTest {

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

        // TODO set parameters for newUserWithEmptyBody request
        apiClient.newUserWithEmptyBody((AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newUserWithJson request
        JsonObject body = new JsonObject();
        apiClient.newUserWithJson(body, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newUserWithXmlBuffer request
        Buffer buffer = null;
        apiClient.newUserWithXmlBuffer(buffer, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newUserWithXmlStream request
        ReadStream<Buffer> stream = null;
        apiClient.newUserWithXmlStream(stream, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newUserWithForm request
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        apiClient.newUserWithForm(form, (AsyncResult<HttpResponse> ar) -> {
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
    public void test401(TestContext test) {
        Async async = test.async(5);

        // TODO set parameters for newUserWithEmptyBody request
        apiClient.newUserWithEmptyBody((AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(401, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newUserWithJson request
        JsonObject body = new JsonObject();
        apiClient.newUserWithJson(body, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(401, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newUserWithXmlBuffer request
        Buffer buffer = null;
        apiClient.newUserWithXmlBuffer(buffer, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(401, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newUserWithXmlStream request
        ReadStream<Buffer> stream = null;
        apiClient.newUserWithXmlStream(stream, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(401, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for newUserWithForm request
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        apiClient.newUserWithForm(form, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(401, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });
    }


}