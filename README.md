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
## 001 数字にする
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
        - System.outで`"convert2num() started"`を表示する
        - 文字列を入力する
        - BufferedReaderを作る
        - BufferedReader.readLine()で文字列を入力する
        - 変数numStrに格納する
    - 処理
      - ifで整数か？小数か？他の型か？を判断する
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
      D --> |他の型| F[数字ではありませんを出力]
      E --> G((終了))
      F --> G
    ```

## 002 3の倍数
  > ユーザーに入力させた数字が3の倍数かどうかを判定する。 3の倍数の場合は`"3の倍数です"`、違う場合は`"3の倍数ではありません"`と表示する。
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
