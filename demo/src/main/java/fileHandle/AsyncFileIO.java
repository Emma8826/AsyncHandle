package fileHandle;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncFileIO {
    public static void main(String[] args) {
        try {
            String directory = "C:\\Users\\2301065\\Desktop\\demo\\demo\\src\\main\\java\\FileHandle";
            String filename = "example1.txt";
            Path path = Paths.get(directory, filename); //創建文件路徑
            //java.nio.file.Files.createDirectories(path.getParent());  // 如果目綠不在就創建路徑(通過確保父目錄存在為後續創建文件做好了準備)

            // 非同步文件通道 - 可讀 寫 創建
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            // 非同步寫入
            ByteBuffer buffer = ByteBuffer.wrap("Async test.".getBytes());
            Future<Integer> writeResult = fileChannel.write(buffer, 0);

            try {
                int bytesWritten = writeResult.get(5, TimeUnit.SECONDS);// 五秒逾時
                System.out.println("Finish  bytes size : " + bytesWritten );
            } catch (TimeoutException e) {
                System.out.println("Writing timeout.");
                writeResult.cancel(true);// timeout時取消操作
            }

//            while (!writeResult.isDone()) {
//                System.out.println("World size : " +writeResult.get() + ", File is writing......");
//            }

            // 非同步讀取
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            Future<Integer> readResult = fileChannel.read(readBuffer, 0);

            try{
                int bytesReader = readResult.get(5,TimeUnit.SECONDS); //五秒逾時
                readBuffer.flip(); // buffer 從寫模式切換到讀模式，沒有用flip的話會直接當下的position開始讀，這樣就會錯過之前所有寫的資料
                System.out.println("Finish read bytes size : " + bytesReader);
                System.out.println("Content is : " + new String(readBuffer.array(),0,bytesReader));
            }catch (TimeoutException e) {
                System.out.println("Writing timeout.");
                writeResult.cancel(true);// timeout時取消操作
            }

//            while (!readResult.isDone()) {
//                System.out.println("File is reading......");
//            }

            //處理讀取的數據
            readBuffer.flip();
            System.out.println("讀取的內容: " + new String(readBuffer.array()).trim());

            fileChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
