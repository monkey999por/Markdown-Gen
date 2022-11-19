
### ■WHAT IS  

通常のソースファイルからはてなブログ用のマークダウンファイルを生成する。  
今のところ変換の内容は  
- ドキュメンテーションコメントをセクション、補足に変換。
- 通常のコード、コメントを```で囲む。  

### ■Build Setting
intelljでモジュール設定⇒アーティファクト⇒追加ボタン⇒jar⇒依存関係を持つ...

### ■RUN
- 開発中: intelljでMain実行  
実行時引数:  
args[0]: 変換対象のソースファイル  
args[1]: ソースファイルの種類　例: javascript  
  
- jar実行
  - intelljでbuild⇒アーティファクトのビルド⇒Markdown-gen.jar
  - `java -jar Markdown-Gen.jar "filename.java" java`

### ■変換対象  
2022/11/19時点  
java, javascript, 通常ファイル 

### ■TODO  
- 言語系  
javascript意外全部  
- はてなブログにAPIで投稿、タグ付け
