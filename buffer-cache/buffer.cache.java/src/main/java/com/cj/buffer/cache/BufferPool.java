package com.cj.buffer.cache;

public class BufferPool {

  private int totalHashQueues = 10;
  private int nodesPerHashQueue = 10;

  private BufferNode[] hashQueueHeaders;

  public void bootstrap() {
    hashQueueHeaders = new BufferNode[totalHashQueues];
    for (int i = 0; i < totalHashQueues; i++) {
      hashQueueHeaders[i] = createQueue();
    }

  }

  private BufferNode createQueue() {
    BufferNode head = new BufferNode();
    BufferNode tempNode = head;
    for (int i = 0; i < nodesPerHashQueue; i++) {
     BufferNode newNode = new BufferNode();
     tempNode.setNextHashQueueNode(newNode);
     newNode.setPreviousHashQueueNode(tempNode);
     tempNode = newNode;
    }
    return head;
  }

}
