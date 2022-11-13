package app.monkey999.creater;

public class Nextjs implements Creator {

    @Override
    public void message(){
        System.out.println("""
                Nextjs create;
                """);
    }

    @Override
    public void create(String inputFileName) {
        
    }
}
