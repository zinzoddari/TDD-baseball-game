package study;

import org.junit.jupiter.api.Test;

public class LambdaTest {
    @Test
    void Hello를_console에_출력하는_람다식_Thread구현() {
        Thread thread = new Thread(() -> {
            System.out.println("hello");
        });
        thread.run();
    }

    @Test
    void Hello를_console에_출력하는_Thread구현() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });

        thread.run();
    }
}
