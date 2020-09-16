package com.cj.io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * This is dummy implementation for file-subsystem
 */
public class FileIOSubSystem implements IOSubSystem {

  // represents default number of i/o devices attached to system
  @SuppressWarnings("unused")
  private static final int DEFAULT_DEVICE_COUNT = 1;

  private static final int DEFAULT_BLOCK_COUNT = 1000;

  private static Map<Integer, String> deviceData = new HashMap<Integer, String>();

  static {
    for (int i = 0; i < DEFAULT_BLOCK_COUNT; i++)
      deviceData.put(
          i, String.format("This String is data on Block number [%d] from default i/o device", i));
  }

  /*
   * This method is expensive. sleep() call is added deliberately to simulate its expensiveness.
   */
  public byte[] readBlock(int deviceNumber, int blockNumber) throws IOException {
    byte[] block = null;
    try {
      Thread.sleep(1000);
      if (deviceData.containsKey(blockNumber)) {
        block = deviceData.get(blockNumber).getBytes();
      } else {
        throw new IOException(
            "I/O operation failed. Invalid block number provided : [" + blockNumber + "]");
      }
    } catch (InterruptedException e) {
      Thread.interrupted();
      throw new IOException("I/O operation failed. Thread is interrupted " + e.getMessage(), e);
    }
    return block;
  }
}
