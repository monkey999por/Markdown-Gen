package app.monkey999;

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
    public static void main(String[] args) {

        // 入力ファイル
        var inputFile = Paths.get(args[0]);
        var br = System.getProperty("line.separator");

        System.out.println(inputFile.toAbsolutePath());

        try {


            // create file
            var filename = inputFile.getParent() + "\\" + inputFile.getFileName().toString().split("\\.")[0] + ".md";
            System.out.println(filename);
            var file = new File(filename.toString());
            var ready = file.exists() && file.delete();

            if (ready) {
                Files.createFile(Path.of(filename));
            }

            // write file
            var filewriter = new FileWriter(file);
            if (file.exists() && file.isFile() && file.canWrite()) {
                //とりあえず変換の使用を考えていこう
                // いったんはてなブログ用だけ考えよう

                // [:contents] これつければ　はてなブログは勝手に目次生成してくれる
                // 目次の生成は ### の大きい方から順に
                // httpとかはタグで囲った方がいいのかな？

                // とりあえず
                // 前後の空白削除　（後ろは空白2文字で固定
                // 　// 始める箇所は//を削除コメントの箇所を削除 ///とかも削除だよ
                // ドキュメンテーションコメントの1行目をタイトルに　（1行目というか、最初に見つかった行　
                // 　⇒タイトルのネストどうする？
                // 　　 ⇒###とかはついてる前提にするか
                // 2行目以降で :before :after でそれぞれ上下につける　（改行とか空白は無視　それぞれ
                // : beforeの終わりは:afterが見つかるまで。afterの終わりはドキュメンテーションコメントの終わりまで　なければすべてbeforeに。変なとこで:before見つかってもそれは無視で
                // 次のドキュメンテーションコメントまでを```で囲む

                // 正規表現確認用
                //判定する文字列
//                String str = "012-345-6789";
//                //判定するパターンを生成
//                Pattern p = Pattern.compile("\\d{2,4}-\\d{2,4}-\\d{4}"); //電話番号
//                //Pattern p = Pattern.compile("^\\d{3}-\\d{4}$"); //郵便番号
//                Matcher m = p.matcher(str);


//                System.out.println(m.find()); //true


                // コメントとか処理する用のスタック的な
                // 正規表現用 あとで見直す
                var startDocComment = "\\s*\\t*\\/\\*\\*";
                Pattern pstart = Pattern.compile(startDocComment);

                var endDocCommnet = "\\s*\\t*\\*/";
                Pattern pend  = Pattern.compile(endDocCommnet);

                var comment = "";
                System.out.println(startDocComment);
                System.out.println(endDocCommnet);
                System.out.println(comment);
                var temp = new ArrayList<String>();
                filewriter.write("[:contents]");

                Files.lines(inputFile, StandardCharsets.UTF_8).forEach(row -> {
                    try {
                        var stra = row.strip();
                        if (pstart.matcher(stra).find()) {

                            System.out.println(startDocComment);
                            System.out.println("find!!" + row);
                        }
                        if (pend.matcher(stra).find()) {

                            System.out.println(endDocCommnet);
                            System.out.println("find!!" + row);
                        }
//                        System.out.println(stra);

                        filewriter.write("aaa" + row + br);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                filewriter.close();
            }
            // これはファイル全行
//            var content = Files.readString(inputFile, StandardCharsets.UTF_8);


        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        System.out.println("Hello world!");
    }
}
