package app.monkey999.creater;

import app.monkey999.HatenaConst;
import app.monkey999.file.FileLogic;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Java implements Creator {

    @Override
    public void message(){
        System.out.println("""
                Java create;
                """);
    }

    @Override
    public void create(String inputFileName) {

    }
}
