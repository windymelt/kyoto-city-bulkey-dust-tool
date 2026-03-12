# Kyoto city bulkey dust tool

京都市の粗大ごみ収集に関する情報を収集し活用するためのツールです。

> [!CAUTION]
> ここで提供しているツールはすべて非公式です。このツールを利用することによって発生したいかなる損害も作者は負いません。このツールを使用したことにより、自動的にこの条件を受諾したものとみなします。
> 
> このリポジトリは GPL 2.0 によってライセンスされています。

## ツール

### `fetch-list-as-tsv.scala`

ネットで受け付けできる粗大ごみの情報をTSV形式で標準出力します。LLMに入力するなどして活用できます。

#### Prerequisites

- JVM 11 or more
- Scala CLI
- Playwright

#### Synopsis

```sh
% scala-cli fetch-list-as-tsv.scala
```
