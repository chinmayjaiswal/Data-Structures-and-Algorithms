package com.cj.io;

import java.io.IOException;

public interface IOSubSystem {
  /*
   * This operation is quite expensive and should be used only when necessary.
   * Buffer cache algorithms will invoke this method as required.
   */
  byte[] readBlock(int deviceNumber, int blockNumber) throws IOException;
}
