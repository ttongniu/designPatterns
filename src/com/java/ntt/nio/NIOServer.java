package com.java.ntt.nio;
import	java.util.ArrayList;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.Key;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName NIOServer
 * @Description
 * @Author niutongtong
 * @Date 2020/1/22 4:47 下午
 * @Version V1.0
 **/
public class NIOServer {
    // 通道管理器
    private Selector  selector;

  /**
   *  获得一个serverSocket通道 并对该通道做一些初始化的工作
   * @param port
   * @throws IOException
   */
  public void initServer(int port) throws IOException{
      //获取一个serverSocket的通道

      //设置通道为非阻塞

      //将该通道对应的serverSocket绑定到port端口

      //获取一个通道管理器

      //将通过管理器和该通道绑定，并为该通道注册selectionKey.op_accept事件，注册该事件后，
      //当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。


    }

    public void listen() throws IOException{

      System.out.println("服务端启动成功！");
      while (true){
        //当注册的事件到达时，方法返回；否则，该方法会一直阻塞
        selector.select();

        Iterator ite  =  this.selector.selectedKeys().iterator();

        while (ite.hasNext()){
          SelectionKey selectionKey = (SelectionKey) ite.next();
          ite.remove();
          if(selectionKey.isAcceptable()){
            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();

            SocketChannel channel = server.accept();

            channel.configureBlocking(false);

            channel.write(ByteBuffer.wrap(new String("向客户端发送一条消息").getBytes()));
            channel.register(this.selector,SelectionKey.OP_READ);
          }else if(selectionKey.isReadable()){
            read(selectionKey);
          }

        }

      }

    }

  private void read(SelectionKey selectionKey) {

     SocketChannel  socketChannel = (SocketChannel) selectionKey.channel();
   

  }
}
