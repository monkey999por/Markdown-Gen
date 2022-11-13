package app.monkey999.creater;

public class Powershell implements Creator {

    @Override
    public void message(){
        System.out.println("""
                Powershell create;
                """);
    }

    @Override
    public void create(String inputFileName) {
        
    }
}
