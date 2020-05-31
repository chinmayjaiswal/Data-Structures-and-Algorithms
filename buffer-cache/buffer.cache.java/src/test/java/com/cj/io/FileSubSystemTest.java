package com.cj.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

public class FileSubSystemTest {
  private IOSubSystem ioSubSystem = new FileIOSubSystem();

  @Test
  public void ioSubSystems_are_slow() {
    try {
      Instant startTime = Instant.now();
      byte[] readBlock = ioSubSystem.readBlock(1, 2);
      Duration timeElapsed = Duration.between(startTime, Instant.now());
      assertTrue(timeElapsed.toMillis() > 500);
      assertEquals(
          String.format("This String is data on Block number [%d] from default i/o device", 2),
          new String(readBlock));
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }
}
