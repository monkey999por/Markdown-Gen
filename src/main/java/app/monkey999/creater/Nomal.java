package app.monkey999.creater;

import app.monkey999.HatenaConst;
import app.monkey999.file.FileLogic;

import java.io.IOException;

public class Nomal implements Creator {

    @Override
    public void message(){
        System.out.println("""
                Nomal create;
                """);
    }

    /**
     * 改行部分を空白二つにするだけ
     * @param inputFileName
     */
    @Override
    public void create(String inputFileName) {
        var file = new FileLogic(inputFileName);
        try {
            file.writeBr(HatenaConst.agenda);
            for (int i = 1; i < file.getRowCount(); i++) {
                file.writeBr(file.getRow(i));
            }
            file.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
