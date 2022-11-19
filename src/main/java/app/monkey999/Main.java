package app.monkey999;

import app.monkey999.constant.Const;
import app.monkey999.creater.Creator;
import app.monkey999.creater.CreatorFactory;
import app.monkey999.creater.CreatorName;
import app.monkey999.creater.Javascript;
import app.monkey999.file.FileLogic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * @param args args[0]: 変換対象ファイル args[1]: ファイルの言語 例: javascript
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // show help
        var top = " ";
        var nest1 = "   ";
        var nest2 = "     ";
        if (args.length == 0) {
            System.out.println();
            System.out.println("---Create Markdown from any source file---");
            System.out.println("Usage: ");

            System.out.println(top + "mdgen filename file_type");
            System.out.println();
            System.out.println(nest1 + "filename: ");
            System.out.println(nest2 + "absolute path");
            System.out.println();
            System.out.println(nest1 + "filetype: ");
            Arrays.stream(CreatorName.values()).forEach((item) -> System.out.println(nest2 + item));


        } else {


            System.out.println("args[0]: " + args[0]);
            System.out.println("args[1]: " + args[1].toLowerCase());

            Creator creator = switch (args[1].toLowerCase()) {
                case "java" -> CreatorFactory.getInstance(CreatorName.Java);
                case "javascript" -> CreatorFactory.getInstance(CreatorName.javascript);
                case "php" -> CreatorFactory.getInstance(CreatorName.PHP);
                case "powershell" -> CreatorFactory.getInstance(CreatorName.Powershell);
                case "nextjs" -> CreatorFactory.getInstance(CreatorName.nextjs);
                case "html" -> CreatorFactory.getInstance(CreatorName.html);
                case "css" -> CreatorFactory.getInstance(CreatorName.css);
                case "nomal" -> CreatorFactory.getInstance(CreatorName.nomal);
                default -> null;

            };

            creator.message();
            creator.create(args[0]);
        }

    }
}