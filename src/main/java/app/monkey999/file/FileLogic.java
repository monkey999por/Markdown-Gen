package app.monkey999.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileLogic {

    private File outFile;
    private FileWriter writer;
    // markdown用の改行
    private String mbr = "  ";
    private String br = System.getProperty("line.separator");

    private List<String> inputFileRows = new ArrayList<>();
    private int rowCount = 0;

    /**
     * ファイルを読み込み、そのファイルと同名の.mdファイルを作成する
     * 作成した.mdファイルへの書き込みを行う。（読み込みファイルは操作不可）
     *
     * @param inFileName
     */
    public FileLogic(String inFileName) {
        // 各種変数の初期化
        // 出力ファイルの作成
        // writerの準備
        try {
            // 入力ファイル
            var inputFile = Paths.get(inFileName);
            System.out.println(inputFile.toAbsolutePath());

            // create file
            var filename = inputFile.getParent() + "\\" + inputFile.getFileName().toString() + ".md";
            System.out.println(filename);
            outFile = new File(filename.toString() );
            var ready = outFile.exists() && outFile.delete();

            if (ready)
                Files.createFile(Path.of(filename));

            // 行ごとのリストを初期化
            if (outFile.exists() && outFile.isFile() && outFile.canWrite())
                Files.lines(inputFile, StandardCharsets.UTF_8).forEach(inputFileRows::add);

            this.rowCount = inputFileRows.size();

            // 行数を初期化

            // write file
            writer = new FileWriter(outFile);
        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * input fileの特定の行の内容を取得
     * @param row 行番号
     */
    public String getRow(int row){
        return this.inputFileRows.get(row - 1);
    }

    /**
     * @param content ファイルに書き込む内容
     */
    public void write(String content) throws IOException {
        writer.write(content + br);
    }

    /**
     * マークダウン用の改行(スペース２こ)を含めて書き込み
     * @param content ファイルに書き込む内容
     */
    public void writeBr(String content) throws IOException {
        writer.write(content + mbr + br);
    }

    /**
     * {@link FileWriter#close()}をcall
     * @see FileWriter#close()
     * @throws Exception closeが失敗した。
     */
    public void close() throws Exception {
        try  {
            writer.close();
        } catch (IOException e) {
            throw new Exception("ファイル書き込みエラー");
        }
    }

    public int getRowCount() {
        return rowCount;
    }
}
