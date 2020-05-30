package com.cj.buffer.cache;

public class BufferNode {

  private static int instanceCounter = 0;
  private int debuggingId;

  private BufferNode nextHashQueueNode;

  private BufferNode previousHashQueueNode;

  private BufferNode nextFreeListNode;

  private BufferNode previousFreeListNode;

  public BufferNode() {
    debuggingId = ++instanceCounter;
  }

  public void setNextHashQueueNode(BufferNode node) {
    this.nextHashQueueNode = node;
  }

  public BufferNode getNextHashQueueNode() {
    return nextHashQueueNode;
  }

  public void setPreviousHashQueueNode(BufferNode node) {
    this.previousHashQueueNode = node;
  }

  public BufferNode getPreviousHashQueueNode() {
    return previousHashQueueNode;
  }

  public BufferNode getNextFreeListNode() {
    return nextFreeListNode;
  }

  public void setNextFreeListNode(BufferNode nextFreeListNode) {
    this.nextFreeListNode = nextFreeListNode;
  }

  public BufferNode getPreviousFreeListNode() {
    return previousFreeListNode;
  }

  public void setPreviousFreeListNode(BufferNode previousFreeListNode) {
    this.previousFreeListNode = previousFreeListNode;
  }

  @Override
  public String toString() {
    return "[" + debuggingId + "]";
  }
}
