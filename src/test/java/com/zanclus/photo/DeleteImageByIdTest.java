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
 * deleteImageById Test
 */
@RunWith(VertxUnitRunner.class)
public class DeleteImageByIdTest extends BaseTest {

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
    public void test204(TestContext test) {
        Async async = test.async(1);
        String id = null;

        // TODO set parameters for deleteImageById request
        id = null;
        apiClient.deleteImageById(id, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(204, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });
    }

    @Test
    public void test404(TestContext test) {
        Async async = test.async(1);
        String id = null;

        // TODO set parameters for deleteImageById request
        id = null;
        apiClient.deleteImageById(id, (AsyncResult<HttpResponse> ar) -> {
            if (ar.succeeded()) {
                test.assertEquals(404, ar.result().statusCode());
                //TODO add your asserts
            } else {
                test.fail("Request failed");
            }
            async.countDown();
        });
    }


}