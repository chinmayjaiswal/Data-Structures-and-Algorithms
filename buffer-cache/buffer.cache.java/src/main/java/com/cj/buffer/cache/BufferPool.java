package com.cj.buffer.cache;

public class BufferPool {

  private static final int DEFAULT_HASH_QUEUE_COUNT = 4;
  private static final int DEFAULT_NODES_PER_HASH_QUEUE = 5;

  private final int HASHQUEUE_COUNT;
  private final int NODES_PER_HASH_QUEUE;

  private BufferNode[] hashQueueHeaders;
  private BufferNode freeListHeader = null;

  public BufferPool() {
    this(DEFAULT_HASH_QUEUE_COUNT, DEFAULT_NODES_PER_HASH_QUEUE);
  }

  public BufferPool(int hashQueueCount, int nodesPerHashQueue) {
    HASHQUEUE_COUNT = hashQueueCount;
    NODES_PER_HASH_QUEUE = nodesPerHashQueue;
    bootstrap();
  }

  private void bootstrap() {
    createHashQueues();
    populateFreeList();
  }

  private void createHashQueues() {
    hashQueueHeaders = new BufferNode[HASHQUEUE_COUNT];
    for (int i = 0; i < HASHQUEUE_COUNT; i++) {
      hashQueueHeaders[i] = createQueue();
    }
  }

  private BufferNode createQueue() {
    BufferNode head = null;
    BufferNode temp = null;
    for (int i = 0; i < NODES_PER_HASH_QUEUE; i++) {
      BufferNode newNode = new BufferNode();
      if (head == null) {
        head = newNode;
        temp = head;
      } else {
        temp.setNextHashQueueNode(newNode);
        newNode.setPreviousFreeListNode(temp);
        temp = newNode;
      }
    }

    return head;
  }

  private void populateFreeList() {

    for (int i = 0; i < HASHQUEUE_COUNT; i++) {
      BufferNode currentNode = hashQueueHeaders[i];
      do {

        addNodeInFreeList(currentNode);
        currentNode = currentNode.getNextHashQueueNode();
      } while (currentNode != null);
    }
  }

  private void addNodeInFreeList(BufferNode currentNode) {
    if (freeListHeader == null) {
      freeListHeader = currentNode;
      freeListHeader.setNextFreeListNode(freeListHeader);
      freeListHeader.setPreviousFreeListNode(freeListHeader);
    } else {

      currentNode.setNextFreeListNode(freeListHeader);
      currentNode.setPreviousFreeListNode(freeListHeader.getPreviousFreeListNode());

      freeListHeader.getPreviousFreeListNode().setNextFreeListNode(currentNode);
      freeListHeader.setPreviousFreeListNode(currentNode);
    }
  }

  public String getBufferPoolAsString() {
    StringBuilder sb = new StringBuilder();
    return sb.append(this.getBufferHashQueuesAsString())
        .append(this.getFreeListUsingNextReferenceAsString())
        .append(this.getFreeListUsingPrevReferenceAsString())
        .toString();
  }

  private String getBufferHashQueuesAsString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < HASHQUEUE_COUNT; i++) {
      BufferNode currentNode = hashQueueHeaders[i];
      sb.append("HashQueue[" + i + "]  : ");
      while (currentNode != null) {
        sb.append(String.format("%8s", currentNode.toString()));
        currentNode = currentNode.getNextHashQueueNode();
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  private String getFreeListUsingNextReferenceAsString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%10s", "\nFreeList: "));
    BufferNode temp = freeListHeader;
    do {
      sb.append(String.format("%6s", temp.toString()));
      temp = temp.getNextFreeListNode();
    } while (temp != freeListHeader);
    return sb.toString();
  }

  private String getFreeListUsingPrevReferenceAsString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%10s", "\nFreeList: "));
    BufferNode temp = freeListHeader;
    do {
      temp = temp.getPreviousFreeListNode();
      sb.append(String.format("%6s", temp.toString()));
    } while (temp != freeListHeader);
    return sb.toString();
  }
}
