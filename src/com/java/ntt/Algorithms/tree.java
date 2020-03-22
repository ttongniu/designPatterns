package com.java.ntt.Algorithms;

import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName tree
 * @Description
 *  * 遍历二叉树
 *  * 分别以递归和非递归实现前序、中序、后序遍历二叉树、与层级遍历
 * @Author niutongtong
 * @Date 2020/1/28 12:59 下午
 * @Version V1.0
 **/
public class tree {

  //递归
  //前序遍历

  public void preOrder(Node node){
    if(node==null){
      return;
    }
    System.out.println("前序"+node.getValue());
    preOrder(node.getLeft());
    preOrder(node.getRight());
  }
  //中序遍历
  public void inOrder(Node node){
    if(node == null){
      return;
    }
    inOrder(node.getLeft());
    System.out.println("中序"+node.getValue());
    inOrder(node.getRight());
  }
  //后序遍历
 public void postOrder(Node node){
    if(node == null){
       return;
    }
    postOrder(node.getLeft());
    postOrder(node.getRight());
    System.out.println("后序"+node.getValue());
 }
  //非递归
  //前序遍历-- 使用栈
  public void preOrderTraversal(Node node){
    if(node == null){
      return;
    }
    Stack<Node>  nodeStack  =  new Stack<>();
    nodeStack.push(node);
    while (!nodeStack.isEmpty()){
      Node cur_node = nodeStack.lastElement();
      nodeStack.pop();
      if(!nodeStack.isEmpty() && nodeStack.lastElement()==null){
        nodeStack.pop();
        System.out.println("前序"+cur_node.getValue());
        continue;
      }
      if(cur_node.getRight()!=null){
         nodeStack.push(cur_node.getRight());
      }
      if(cur_node.getLeft()!=null){
        nodeStack.push(cur_node.getLeft());
      }
      //前序 nullptr 标记当前节点的左右子树已经遍历
      nodeStack.push(null);
      nodeStack.push(cur_node);
    }
  }
  //中序遍历
  public void inOrderTraversal(Node node){
    if(node == null){
      return;
    }
    Stack<Node>  nodeStack  =  new Stack<>();
    nodeStack.push(node);
    while (!nodeStack.isEmpty()){
      Node cur_node = nodeStack.lastElement();
      nodeStack.pop();
      if(!nodeStack.isEmpty() && nodeStack.lastElement()==null){
        nodeStack.pop();
        System.out.println("中序"+cur_node.getValue());
        continue;
      }
      if(cur_node.getRight()!=null){
        nodeStack.push(cur_node.getRight());
      }
      //中序 nullptr 标记当前节点的左右子树已经遍历
      nodeStack.push(null);
      nodeStack.push(cur_node);
      if(cur_node.getLeft()!=null){
        nodeStack.push(cur_node.getLeft());
      }

    }
  }
  //后序遍历
  public void postOrderTraversal(Node node){
    if(node == null){
      return;
    }
    Stack<Node>  nodeStack  =  new Stack<>();
    nodeStack.push(node);
    while (!nodeStack.isEmpty()){
      Node cur_node = nodeStack.lastElement();
      nodeStack.pop();
      if(!nodeStack.isEmpty() && nodeStack.lastElement()==null){
        nodeStack.pop();
        System.out.println("后序"+cur_node.getValue());
        continue;
      }
      //后序 nullptr 标记当前节点的左右子树已经遍历
      nodeStack.push(null);
      nodeStack.push(cur_node);
      if(cur_node.getRight()!=null){
        nodeStack.push(cur_node.getRight());
      }

      if(cur_node.getLeft()!=null){
        nodeStack.push(cur_node.getLeft());
      }

    }
  }

  //层级遍历
    //实现过程
    //1、首先将二叉树的根节点push到队列中，判断队列不为NULL，就输出队头的元素，
    //2、判断节点如果有孩子，就将孩子push到队列中，
    //3、遍历过的节点出队列，
    //4、循环以上操作，直到Tree == NULL。
  public void levelOrder(Node node){
    if(node ==null){
      return;
    }
    Queue<Node> queue = null;
    if(node!=null){
      queue.add(node);
    }
    while (!queue.isEmpty()){
      System.out.println(queue.peek().getValue());
      if(queue.peek().getLeft()!=null){
         queue.add(queue.peek().getLeft());
      }
      if(queue.peek().getRight()!=null){
        queue.add(queue.peek().getRight());
      }
      queue.poll();
    }
  }
}
class Node {

  private  int value;
  private  Node left;
  private  Node right;

  public Node(int value){
    this.value=value;
    this.left=null;
    this.right=null;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

}