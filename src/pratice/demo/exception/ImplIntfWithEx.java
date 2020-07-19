package pratice.demo.exception;

public class ImplIntfWithEx implements IntfWithEx {
    @Override
    public void danger() throws Exception {
        throw new Exception();
    }

    @Override
    public void safe(){
        try{
            throw new Exception();
        }catch (Exception ex){

        }

    }
}
