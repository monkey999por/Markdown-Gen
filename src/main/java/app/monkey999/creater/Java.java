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

    /**
     * 基本はjavascriptと同じだが、以下を実施
     * 1. ドキュメンテーションコメント内のアノテーションは削除する
     *
     * @param inputFileName
     */
    @Override
    public void create(String inputFileName) {
        try {
            var file = new FileLogic(inputFileName);

            // 目次
            file.writeBr(HatenaConst.agenda);

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

