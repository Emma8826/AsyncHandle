package fileHandle.async;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Spring Boot 會在應用程序完全啟動後執行這個 bean 的 run 方法
 * reference : https://blog.csdn.net/LBL_lin/article/details/129362825
 */
@Component
@Order(1) // 如果有多個CommandLineRunner可以用Order指定加載的順序
public class AsyncFileIORunner implements CommandLineRunner {
    private final AsyncFileIO asyncFileIO;

    public AsyncFileIORunner(AsyncFileIO asyncFileIO){
        this.asyncFileIO = asyncFileIO;
    }
    @Override
    public void run(String... args) throws Exception {
        asyncFileIO.performAsyncFileIO();
    }
}
