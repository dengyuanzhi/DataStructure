import java.util.Objects;

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组容量 capacity
     * @param capacity
     *
     */
    public Array(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }

    /**
     * 无参构造函数
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断是否为空
     * @return
     */
    public  boolean isEmpty(){
        return size==0;
    }

    /**
     * 向所有元素后面添加元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index,E  e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed. Require index>=0 and index<=size.");

        if(size==data.length)
            resize(2*data.length);
//        依次后移，空出index
        for (int i = size-1; i >=index; i--) {
            data[i+1]=data[i];
        }
        data[index] =  e;//赋值添加
        size++;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index<0||index>size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index]=e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在，返回-1
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;//找到，返回 i
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret=data[index];
        for (int i = index+1; i <size ; i++) {
            //往前移
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;//loitering objects !=memory leak
        return ret;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public boolean removeElement(E e){
        int index=find(e);
        if(index!=-1){
            remove(index);
        }
        return true;
    }
    @Override
    public String toString(){
          StringBuffer res=new StringBuffer();
          res.append(String.format("Arrys:size=%d,capacity=%d\n",size,data.length));
          res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 动态数组，开辟新空间
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E newData[]= (E[]) new Objects[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        data=newData;
    }
}
