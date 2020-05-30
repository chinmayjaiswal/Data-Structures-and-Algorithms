package com.cj.buffer.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class BufferPoolTest {

  @Test
  public void setUp() {
    BufferPool pool = new BufferPool();
    String bufferPoolAsString = pool.getBufferPoolAsString();
    System.out.println(bufferPoolAsString);

    assertEquals(
        getFileAsString("src/test/java/com/cj/buffer/cache/defaultBufferAsString.txt").trim(),
        bufferPoolAsString);
  }

  private String getFileAsString(String path) {
    String result = "";
    try {
      byte[] fileAsBytes = Files.readAllBytes(Paths.get(path));
      return new String(fileAsBytes);
    } catch (Exception e) {
      fail("An error occured while reading file + " + path);
    }
    return result;
  }

  @SuppressWarnings("unused")
  private void writeStringInFile(String data, String path) {
    try {
      Files.write(Paths.get(path), data.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      fail("An error occured while writing data in file ");
      e.printStackTrace();
    }
  }
}
