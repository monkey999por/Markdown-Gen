package whatis;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileLogic {

  /**
   * ファイルの作成、読み込み、書き込み、削除のやり方
   *
   * @see Paths
   * @since 2022/11/17
   */
  static void fileOperation() throws IOException {

    // 作成
    // create file
    String filename = "C:\\temp\\file.txt";
    File outFile = new File(filename.toString());
    boolean ready = outFile.exists() && outFile.delete();
    if (ready)
      Files.createFile(Path.of(filename));

    // 書き込み
    FileWriter writer = new FileWriter(filename);
    String br = System.getProperty("line.separator");
    writer.write("aaaa" + br);
    writer.write("bbbb" + br);
    writer.write("cccc" + br);

    // バッファを書き込み 普通はcloseすれば書き込まれるから不要
    writer.flush();

    // 読み込み 全行
    String contents = Files.readString(Paths.get(filename));
    // aaaa
    // bbbb
    // cccc
    System.out.println(contents);

    // 読み込み　1文字
    FileReader fileReader = new FileReader(outFile, StandardCharsets.UTF_8);
    System.out.println(fileReader.read());// 一文字読み込み 97 ※aの文字コード

    // 読み込み　1行
    BufferedReader rowReader = new BufferedReader(fileReader);
    String content;
    while ((content = rowReader.readLine()) != null) {
      // aaa（※↑同じファイルに対してraedとかすると、その分はすでに読み込まれたことになるっぽい。なので↓の出力はaaa）
      // , bbbb, cccc
      System.out.println(content);
    }

    // try with resourceだとこんな感じ closeは不要
    try (FileReader f = new FileReader(filename);
         BufferedReader b = new BufferedReader(f)) {
      System.out.println(b.readLine()); // aaaa
    } catch (Exception e) {
    }

    // close
    try {
      writer.close();
    } catch (IOException e) {
      try {
        writer.close();
      } catch (Exception e1) {
      }
    }
  }
}
