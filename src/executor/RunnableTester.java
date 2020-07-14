package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTester {
    public static void main(String[] args) {
        ExecutorService threadExecutor =
                Executors.newFixedThreadPool(2);
        System.out.println("Stating threads");
        threadExecutor.execute(new PrintTask());
        threadExecutor.execute(new PrintTask());
        threadExecutor.execute(new PrintTask());
        threadExecutor.execute(new PrintTask());
        threadExecutor.shutdown();

    }
}
