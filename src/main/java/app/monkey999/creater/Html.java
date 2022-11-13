package app.monkey999.creater;

public class Html implements Creator {

    @Override
    public void message(){
        System.out.println("""
                Html create;
                """);
    }

    @Override
    public void create(String inputFileName) {

        /**
         *
         *
         * <!-- コメントアウト部分 -->
         * <!--
         * コメントアウト部分
         * コメントアウト部分
         * -->
         *
         */
        
    }
}
