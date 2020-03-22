package com.java.ntt.concurrency;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LRU
 * @Description
 * @Author niutongtong
 * @Date 2020/1/15 2:35 下午
 * @Version V1.0
 **/
public class LRU<K,V> extends LinkedHashMap<K,V> {
   private static Integer MAX_ENTRIES =3;
  @Override
  protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
    return size()>MAX_ENTRIES;
  }
  LRU(){
    super(MAX_ENTRIES,0.75f,true);
  }

}
