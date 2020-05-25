package com.cj.buffer.cache;

public class BufferNode {

  private BufferNode nextHashQueueNode;

  private BufferNode previousHashQueueNode;

  public void setNextHashQueueNode(BufferNode node) {
    this.nextHashQueueNode = node;
  }

  public void setPreviousHashQueueNode(BufferNode node) {
    this.previousHashQueueNode = node;
  }

}
