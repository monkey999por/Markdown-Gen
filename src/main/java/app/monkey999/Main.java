package app.monkey999;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {

        // 入力ファイル
        var inputFile = Paths.get(args[0]);

        Creator js = CreatorFactory.getInstance(CreatorName.javascript);
        js.create(args[0]);

    }
}