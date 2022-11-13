package app.monkey999.creater;

import app.monkey999.HatenaConst;
import app.monkey999.file.FileLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Javascript implements Creator {

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
    // ⇒これはいったんやらない
    // 次のドキュメンテーションコメントまでを```で囲む

    // コメントとか処理する用のスタック的な
    // 正規表現用 あとで見直す
    @Override
    public void create(String inputFileName) {
        try {
            var file = new FileLogic(inputFileName);

            // 目次
            file.write(HatenaConst.agenda);

            // i: ファイルの行番号
            var temp = new ArrayList<String>();
            for (int i = 1; i < file.getRowCount(); i++) {
                var target = file.getRow(i).strip();


                // ドキュメンテーションコメント処理
                // 一致したらそのままコメント外す
                var startDocComment = "\\s*\\t*\\/\\*\\*";
                Pattern pstart = Pattern.compile(startDocComment);

                var endDocCommnet = "\\s*\\t*\\*/";
                Pattern pend = Pattern.compile(endDocCommnet);


                // 通常のコメント処理
                var comment = "\\/\\/";
                Pattern pcomment = Pattern.compile(comment);

                if (pcomment.matcher(target).find()) {
                    System.out.println("find!!" + file.getRow(i));
                }


            }

            //

            file.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
