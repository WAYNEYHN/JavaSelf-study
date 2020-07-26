package pratice.demo.exception;


/**
 * 异常的使用流程try{} catch(){}finally{}
 * finally里的代码是一定会执行的，即使在try或者catch中return也会执行
 */
public class TestExcetion {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        try{
            int[] arr = new int[1];
            arr[1] = 1;
        }catch (Exception ex){
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        finally {
            System.out.println("123");
        }

        Class clazz = Class.forName("abc");
        clazz.getField("");

        CauseException();
    }

     public static void CauseException(){
        try{
            throw new Exception("");
        }catch (Exception ex){

        }

     }
}
