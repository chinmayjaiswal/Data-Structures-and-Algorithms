package com.cj.buffer.cache;

public class BufferCache {

  private BufferPool pool;

  public BufferCache(BufferPool bufferPool) {
    super();
    this.pool = bufferPool;
  }

  public BufferNode getblk(int deviceNumber, int blockNumber) {
    BufferNode node = pool.findBuffer(deviceNumber, blockNumber);

    return null;
  }
}
