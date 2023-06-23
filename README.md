# ou

### todo wari
  - 具体例
     ```
     実例1:
      • 入力: Michael
      • 出力: Hello, Michael
    ```
  - TODOリスト
    ```
    - 準備作業
    - 入力
    - 処理
    - 出力
    - 動作確認
    ```
  - flow chart
  - test case
  - code
----
## #001 数字にする
  > ユーザーが入力した文字列を数字に変換する。ただし、ユーザーが入力した文字列が数字でない場合は、`"数字ではありません"`と表示する。
  - 具体例
    - case1
      - 入力: 1
      - 出力: 1
    - case2
      - 入力: 0.1
      - 出力: 0.1
    - case3
      - 入力: -1
      - 出力: -1
    - case4
      - 入力: a
      - 出力: 数字ではありません
  - TODOリスト
    - 準備作業
      - ファイル/クラスを作る
        - パッケージを決める
        - TodoTest.javaを作る
      - メソッドを作る
        - convert2num()メソッドを書く
        - 空のmain()メソッドを作る
        - chooseTset(int i)メソッドを作る
    - 入力
        - System.outで`"convert2num() started. Please input >"`を表示する
        - 文字列を入力する
        - BufferedReaderを作る
        - BufferedReader.readLine()で文字列を入力する
        - 変数numStrに格納する
    - 処理
      - ifで正規表現で整数か？小数か？他の型か？を判断する
      - 整数だったらparseInt()で変換
      - 小数だったらparseDouble()で変換
    - 出力
      - System.outで変換された数字を表示する
      - 数字ではない場合はSystem.outで`"数字ではありません"`を表示する
    - 動作確認
      - 全体を動かして確認
        - “1”を入力して確認
        - “0.1”を入力して確認
        - “-1”を入力して確認
        - “a”を入力して確認
  - flow chart
    ```mermaid
    flowchart LR
    A((開始)) --> B(入力)
      B --> C(処理)
      C --> D{ifで型を判断}
      D --> |整数/小数| E[数字を出力]
      D --> |他の型| F[「数字ではありません」を出力]
      E --> G((終了))
      F --> G
    ```

## #002 3の倍数
  > ユーザーに入力させた数字が3の倍数かどうかを判定する。 3の倍数の場合は`"3の倍数です"`、違う場合は`"3の倍数ではありません"`と表示する。
  - 具体例
    - case1
      - 入力: 4
      - 出力: 3の倍数ではありません
    - case2
      - 入力: 6
      - 出力: 3の倍数です
    - case3
      - 入力: 0.3
      - 出力: 3の倍数です
    - case4
      - 入力: -3
      - 出力: 3の倍数です
    - case5
      - 入力: abc
      - 出力: 数字ではありません
- TODOリスト
  - 準備作業
    - メソッドを作る
      - sum()メソッドを書く
      - chooseTset(int i)メソッドを編集する
  - 入力
      - System.outで`"multiOf3() started. Please input >"`を表示する
      - 文字列を入力する
  - 処理
    - ifで小数か？を判断する
    - 小数だったらまだ小数点以下何位を判断する
    - try-catchで数字変換エラーを処理する。
    - 四則計算で3の倍数かと確認する。
  - 出力
    - 3の倍数だったら「3の倍数です」を表示する。
    - 3の倍数ではないなら「3の倍数ではありません」を表示する。
    - 小数点以下2位以上ならば、「小数点以下第2位までのみです。」を表示する。
    - 数字ではない場合、または数字変換エラーが出たら「数字ではありません」を表示する。
  - 動作確認
    - 全体を動かして確認
      - “4”を入力して確認
      - “6”を入力して確認
      - “0.3”を入力して確認
      - “0.3333”を入力して確認
      - “-3”を入力して確認
      - “a”を入力して確認
- flow chart
  ```mermaid
  flowchart LR
  A((開始)) --> B(入力)
    B --> C(処理)
    C --> D{ifで小数点以下桁数を判断}
    D --> |小数点以下2位以上| E[「小数点以下第2位までのみです。」を出力]
    D --> |小数点以下2位以上\n整数| F(3の倍数を判断)
    E --> G((終了))
    F --> |3の倍数| H[「3の倍数です」を出力]
    F --> |3の倍数ではない| I[「3の倍数ではありません」を出力]
    F --> |数字ではない\nエラー| I[「数字ではありません」を出力]
  ```
   
## #003 足し算
  > ユーザーに複数の数字を入力させて、すべての合計を表示する。ユーザーは数字をいくつでも入力できるようにして、"end"と入力したところですべての合計を表示すること。
  - case1
    - 入力: 1 2 3 end
    - 出力: sum: 6
  - case2
    - 入力: -1 -2 3 end
    - 出力: sum: 0
  - case3
    - 入力: 1 2 3 0.5 end
    - 出力: sum: 6.5
  - case4
    - 入力: 1 2 a 5 end
    - 出力: aの時に「数字ではありません」を出力して、飛ばして続き、sum: 8
