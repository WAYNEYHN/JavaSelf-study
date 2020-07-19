package pratice.demo.exception;

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
