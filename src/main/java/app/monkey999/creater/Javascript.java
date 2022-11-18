package app.monkey999.creater;

import app.monkey999.HatenaConst;
import app.monkey999.file.FileLogic;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Javascript implements Creator {

    @Override
    public void message(){

        System.out.println("""
                    javascript create
                """);
    }

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
            file.writeBr(HatenaConst.agenda);
            System.out.println(file.getRowCount());

            // i: ファイルの行番号
            var temp = new ArrayList<String>();
            // ドキュメンテーションのコメントの中にいる間true
            boolean inSection = false;
            boolean writeCodeBlockStart = false;

            for (int i = 1; i < file.getRowCount(); i++) {
                var target = file.getRow(i).strip();

                // ドキュメンテーション処理
                // 一致したらそのままコメント外す
                {
                    // ドキュメンテーションコメント開始
                    var startDocComment = "^/\\*\\*$";
                    var matcherStart = Pattern.compile(startDocComment).matcher(target);
                    if (matcherStart.find()) {
                        // コードブロック
                        // の終わり
                        if (writeCodeBlockStart) {
                            file.writeBr("```");
                            writeCodeBlockStart = false;
                        }

                        inSection = true;
                        System.out.println("ドキュメンテーションコメント開始");
                        continue;
                    }

                    var endDocComment = "^\\*/$";
                    var matcherEnd = Pattern.compile(endDocComment).matcher(target);
                    // ドキュメンテーションコメント終了
                    if (matcherEnd.find()) {
                        inSection = false;
                        System.out.println("ドキュメンテーションコメント終了");
                        continue;
                    }

                    // ドキュメンテーションコメントの中身はそのまま書き込み(* )は削除
                    if (inSection) {
                        file.writeBr(Pattern.compile("\\*\s*").matcher(target).replaceAll(""));
                        System.out.println("section: " + Pattern.compile("\\*\s*").matcher(target).replaceAll(""));
                    }
                }

                // 通常の処理
                // ```を付与
                if (!inSection){
                    if (!writeCodeBlockStart) {
                        file.write("```javascript");
                        writeCodeBlockStart = true;
                    }

                    // コードブロックの中は加工（空白削除とか）してない素の状態で書き込み
                    file.write(file.getRow(i));
                }
            }
            file.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
