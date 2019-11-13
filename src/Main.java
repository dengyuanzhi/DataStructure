public class Main {
    public static void main(String[] args){
        Array<Integer> array=new Array<Integer>();//泛型，包装类
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
            System.out.println(array);
        }

        array.addFirst(8);
        System.out.println(array);
        /**
         * 向后移，往下标为一的地方插入元素         */
        array.add(1,9);
        System.out.println(array);

//        array.remove(2);
//        System.out.println(array);
//
//        array.removeElement(4);
//        System.out.println(array);
//
//        array.removeFirst();
//        System.out.println(array);

    }
}
