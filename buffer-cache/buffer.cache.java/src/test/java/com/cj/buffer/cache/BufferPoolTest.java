package com.cj.buffer.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;
// added this line for git test
public class BufferPoolTest {

  @Test
  public void BufferPoolInit_defaultDefaultSize_machesExpectedOutput() {
    BufferPool pool = new BufferPool();
    String bufferPoolAsString = pool.getBufferPoolAsString();
    assertEquals(
        getFileAsString("src/test/java/com/cj/buffer/cache/defaultBufferAsString.txt"),
        bufferPoolAsString);
  }

  @Test
  public void BufferPoolInit_customSize_machesExpectedOutput() {
    BufferPool pool = new BufferPool(2, 5);
    String bufferPoolAsString = pool.getBufferPoolAsString();
    assertEquals(
        getFileAsString("src/test/java/com/cj/buffer/cache/customSizeBufferPool.txt"),
        bufferPoolAsString);
  }

  private String getFileAsString(String path) {
    String result = "";
    try {
      byte[] fileAsBytes = Files.readAllBytes(Paths.get(path));
      return new String(fileAsBytes);
    } catch (Exception e) {
      e.printStackTrace();
      fail("An error occured while reading file + " + path);
    }
    return result;
  }

  @SuppressWarnings("unused")
  private void writeStringInFile(String data, String path) {
    try {
      Files.write(Paths.get(path), data.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
      fail("An error occured while writing data in file ");
    }
  }

  // @Test
  public void testWhileLoop() throws InterruptedException {
    int count = 0;
    int time = 0;
    while (count < 2 * 60 * 5) {
      Thread.sleep(500);
      time = time + 500;
      // int timeElapsed = (time) / (1000 * 60);
      System.out.println("This is loop count #" + (++count) + " Time elapsed " + time);
    }
  }
}
