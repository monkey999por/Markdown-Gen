package app.monkey999.creater;

public class Css implements Creator {

    @Override
    public void message(){
        System.out.println("""
                Css create;
                """);
    }

    @Override
    public void create(String inputFileName) {
        
    }
}
