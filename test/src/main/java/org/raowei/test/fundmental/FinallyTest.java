package org.raowei.test.fundmental;

/**
 * @author raowei
 * @date 2019-06-03
 */
public class FinallyTest {


    public static void main(String[] args) {

        int i = NoException();
        System.out.println("Finally result:" + i);

        int i2 = hasException();
        System.out.println("Finaly result2 : " + i2);
    }

    public static int NoException(){
        int i=10;
        try{
            System.out.println("i in try block is"+i);
            return --i;
        }catch(Exception e){
            --i;
            System.out.println("i in catch - form try block is"+i);
            return --i;
        }finally{

            System.out.println("i in finally - from try or catch block is"+i);
            return --i;
        }
    }


    public static int hasException(){
        int i=10;
        try{
            System.out.println("i in try block is"+i);
            throw  new RuntimeException(i + " exception");
        }catch(Exception e){
            --i;
            System.out.println("i in catch - form try block is"+i);
            return --i;
        }finally{

            System.out.println("i in finally - from try or catch block is"+i);
            return --i;
        }
    }
}
