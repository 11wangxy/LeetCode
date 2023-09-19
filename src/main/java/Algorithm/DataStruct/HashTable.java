package Algorithm.DataStruct;

import javax.xml.stream.events.EntityReference;
import java.util.Calendar;
import java.util.concurrent.Semaphore;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-18 23:10
 * @description: leetCode
 */
public class HashTable {
    //节点类
    static class Entry{
        int hash;
        Object value;
        Object key;
        Entry next;

        public Entry(int hash, Object value, Object key) {
            this.hash = hash;
            this.value = value;
            this.key = key;
        }
    }

    Entry[] table=new Entry[16];//设为2的n次方
    int size=0;//元素个数
    float loadFactor=0.75f;//设置负载因子
    int threshold= (int) (loadFactor*table.length);//数组大小阈值

    //扩容操作
    private void resize() {
        Entry[] newTable=new Entry[table.length<<1];//扩大两倍
        for (int i = 0; i < table.length; i++) {
            Entry p=table[i];//拿到每个链表头
            if (p!=null){
                //对半拆分链表，移动到新的数组
                //拆分规律 hash&table.length==0为一组  hash&table.length！=0为一组
                Entry a=null;
                Entry b=null;
                Entry aHead=null;
                Entry bHead=null;
                while (p!=null){
                    if (((p.hash& table.length))==0){
                        if (a!=null){
                            a.next=p;
                        }else {
                            aHead=p;
                        }
                        a=p;
                    }else{
                        if (b!=null){
                            b.next=p;
                        }else {
                            aHead=p;
                        }
                        b=p;
                    }
                    p=p.next;
                }
                if (a!=null){
                    a.next=null;
                    newTable[i]=aHead;
                }
                if (b!=null){
                    b.next=null;
                    newTable[i+ table.length]=bHead;
                }
            }
        }
        table=newTable;
        threshold= (int) (table.length*loadFactor);
    }
    //哈希算法 字符类
    public  int getHashCode(String property) {
        int hash = 0;
        for (int i = 0; i < property.length(); i++) {
            hash = (hash<<5)-hash + property.charAt(i);
        }
        return hash;
    }
    //根据hash码获取value
    Object get(int hash,Object key){
        int index=hash&(table.length)-1;
        if (table[index]==null){
            return null;
        }
        Entry p=table[index];
        while (p!=null){
            if (p.key.equals(key)){
                return p.value;
            }
            p=p.next;
        }
        return null;
    }
    //向哈希表中存入新的key value，如果重复则更新
    void put(int hash,Object key,Object value){
        int index=hash&(table.length)-1;
        //1.index有空位，直接新增
        if (table[index]==null){
            table[index]=new Entry(hash,key,value);
        }else {
            //如果没有空位，直接新增操作
            Entry p=table[index];
            while (true){
                if (p.key.equals(key)){
                    p.value=value;
                    return;
                }
                if (p.next==null){
                    break;
                }
                p=p.next;
            }
            p.next=new Entry(hash,key,value);

        }
        size++;
        if (size>threshold){
            resize();
        }
    }
    //根据hash码删除，返回删除的value
    Object remove(int hash,Object key){
        int index=hash&(table.length)-1;
        if (table[index]==null){
            return null;
        }
        Entry p = table[index];
        Entry prev=null;
        while (p!=null){
            if (p.key.equals(key)){
                //找到了，删除
                if (prev != null) {
                    prev.next=p.next;
                }else {
                    table[index]=p.next;
                }
                size--;
                return p.value;
            }
            prev=p;
            p=p.next;
        }
        return  null;
    }

    Object get(Object key){
        int hash = key.hashCode();
        int index=hash&(table.length)-1;
        if (table[index]==null){
            return null;
        }
        Entry p=table[index];
        while (p!=null){
            if (p.key.equals(key)){
                return p.value;
            }
            p=p.next;
        }
        return null;
    }
    void put(Object key,Object value){
        int hash = key.hashCode();
        int index=hash&(table.length)-1;
        //1.index有空位，直接新增
        if (table[index]==null){
            table[index]=new Entry(hash,key,value);
        }else {
            //如果没有空位，直接新增操作
            Entry p=table[index];
            while (true){
                if (p.key.equals(key)){
                    p.value=value;
                    return;
                }
                if (p.next==null){
                    break;
                }
                p=p.next;
            }
            p.next=new Entry(hash,key,value);

        }
        size++;
        if (size>threshold){
            resize();
        }
    }
    Object remove(Object key){
        int hash = key.hashCode();
        int index=hash&(table.length)-1;
        if (table[index]==null){
            return null;
        }
        Entry p = table[index];
        Entry prev=null;
        while (p!=null){
            if (p.key.equals(key)){
                //找到了，删除
                if (prev != null) {
                    prev.next=p.next;
                }else {
                    table[index]=p.next;
                }
                size--;
                return p.value;
            }
            prev=p;
            p=p.next;
        }
        return  null;
    }
}
