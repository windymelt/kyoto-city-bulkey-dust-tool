#!/usr/bin/env -S scala-cli shebang

//> using scala 3.3.8
//> using options -Yfuture-lazy-vals -java-output-version:11
//> using dep "com.microsoft.playwright:playwright:1.58.0"

// ここで取得できるのは、Webで受付できる粗大ごみに限られる。

import com.microsoft.playwright.*
import com.microsoft.playwright.options.WaitForSelectorState
import scala.jdk.CollectionConverters.*

inline def eprintln[A](x: A) = System.err.println(x)

@main def run(): Unit =
  val playwright = Playwright.create()
  val browser = playwright.chromium().launch() // headless mode

  try
    val page = browser.newPage()

    eprintln("ページにアクセス中...")
    page.navigate("https://www.ogomi-kyoto.jp/eco/view/kyoto/dustSearch.html")

    eprintln("#dustlist の出現を待機中...")
    page.waitForSelector(
      "#dustlist tr",
      new Page.WaitForSelectorOptions()
        .setState(WaitForSelectorState.VISIBLE)
        .setTimeout(15000)
    )

    eprintln("テーブル取得中...")
    val rows = page.querySelectorAll("#dustlist tr").asScala

    for row <- rows do
      val cells = row.querySelectorAll("th, td").asScala
      val values = cells.map(_.innerText().trim).mkString("\t")
      println(values)

  finally
    browser.close()
    playwright.close()
