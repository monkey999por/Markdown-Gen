### ■WHAT IS  

通常のソースファイルからはてなブログ用のマークダウンファイルを生成する。  
今のところ変換の内容は  
- ドキュメンテーションコメントをセクション、補足に変換。
- 通常のコード、コメントを```で囲む。  

### ■RUN
開発中。intelljでMain実行  
実行時引数: args[0]: 変換対象のソースファイル  

### ■変換対象  
現在はjavascriptのみ  

### ■TODO  
- 言語系  
HTML, CSS  
PHP,  
java  
- はてなブログにAPIで投稿、タグ付け