package com.udacity.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends AndroidTestCase {

    private final CountDownLatch mSignal = new CountDownLatch(1);

    public void testJokeRetriever() {
        new JokesAsyncTask(new TestCaseJokeListener()).execute();
        try {
            boolean success = mSignal.await(5, TimeUnit.SECONDS);
            if (!success) {
                fail("Test timed out, make sure the server is actually running.");
            }
        } catch (InterruptedException e) {
            fail();
        }
    }

    private class TestCaseJokeListener implements JokesAsyncTask.IGetJokesListener {

        @Override
        public void onGetJoke(String joke) {
            assertTrue(joke != null && joke.length() > 0);
            mSignal.countDown();
        }
    }
}