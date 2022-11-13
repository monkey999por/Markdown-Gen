package app.monkey999.creater;

public class PHP implements Creator {

    @Override
    public void message(){
        System.out.println("""
                PHP create;
                """);
    }

    @Override
    public void create(String inputFileName) {
        
    }
}
