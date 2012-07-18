package com.canoo.dolphin.demo;

import com.canoo.dolphin.core.client.Dolphin;
import com.canoo.dolphin.core.client.comm.UiThreadHandler;

import java.util.concurrent.CountDownLatch;

public class JavaDemo {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        InMemoryConfig inMemoryConfig = new InMemoryConfig();

        Dolphin.getClientConnector().setUiThreadHandler(new UiThreadHandler() {
            @Override
            public void executeInsideUiThread(Runnable runnable) {
                System.out.println("going inside ui");
                // do inside the UI thread:
                runnable.run();
                latch.countDown();
            }
        });
        inMemoryConfig.withActions();
        inMemoryConfig.register(new JavaAction());

        ConsoleView.show();
        System.out.println("waiting to finish");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

