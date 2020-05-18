package com.rakeshv;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GenericCircularBuffer<String> stringBuffer = new StringsCircularBuffer(5);

        stringBuffer.offer("hello");
        stringBuffer.offer("world");
        stringBuffer.offer("from");
        stringBuffer.offer("generics");

        System.out.println(stringBuffer.getResult());

        GenericCircularBuffer<Integer> intBuffer = new IntegerCircularBuffer();
        intBuffer.offer(1);
        intBuffer.offer(2);
        intBuffer.offer(3);
        intBuffer.offer(4);
        intBuffer.offer(5);
        intBuffer.offer(6);
        intBuffer.offer(7);
        intBuffer.offer(8);
        intBuffer.offer(9);
        intBuffer.offer(10);
        System.out.println(intBuffer.getResult());
    }
    
    
}
