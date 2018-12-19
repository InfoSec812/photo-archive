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
 * userLogin Test
 */
@RunWith(VertxUnitRunner.class)
public class UserLoginTest extends BaseTest {

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

        // TODO set parameters for userLoginWithEmptyBody request
        apiClient.userLoginWithEmptyBody((AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for userLoginWithJson request
        JsonObject body = new JsonObject();
        apiClient.userLoginWithJson(body, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for userLoginWithXmlBuffer request
        Buffer buffer = null;
        apiClient.userLoginWithXmlBuffer(buffer, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for userLoginWithXmlStream request
        ReadStream<Buffer> stream = null;
        apiClient.userLoginWithXmlStream(stream, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(202, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for userLoginWithForm request
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        apiClient.userLoginWithForm(form, (AsyncResult<HttpResponse> ar) -> {
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

        // TODO set parameters for userLoginWithEmptyBody request
        apiClient.userLoginWithEmptyBody((AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(401, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for userLoginWithJson request
        JsonObject body = new JsonObject();
        apiClient.userLoginWithJson(body, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(401, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for userLoginWithXmlBuffer request
        Buffer buffer = null;
        apiClient.userLoginWithXmlBuffer(buffer, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(401, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for userLoginWithXmlStream request
        ReadStream<Buffer> stream = null;
        apiClient.userLoginWithXmlStream(stream, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(401, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });

        // TODO set parameters for userLoginWithForm request
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        apiClient.userLoginWithForm(form, (AsyncResult<HttpResponse> ar) -> {
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