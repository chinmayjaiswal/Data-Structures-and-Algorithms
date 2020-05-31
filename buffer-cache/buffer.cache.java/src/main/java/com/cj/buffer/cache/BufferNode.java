package com.cj.buffer.cache;

public class BufferNode {

  private static int instanceCounter = 0; // This field is for testing and debugging purpose only
  private int nodeId; // This field is for testing and debugging purpose only

  private byte[] data;

  private BufferNode nextHashQueueNode;

  private BufferNode previousHashQueueNode;

  private BufferNode nextFreeListNode;

  private BufferNode previousFreeListNode;

  public BufferNode() {
    nodeId = ++instanceCounter;
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

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "[" + nodeId + "]";
  }
}
