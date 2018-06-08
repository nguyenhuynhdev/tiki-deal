package vn.tiki.data.util

import java.nio.charset.Charset
import android.content.res.AssetManager

fun AssetManager.readFile(file: String): String {
  return open(file).bufferedReader(Charset.forName("utf-8")).use { it.readText() }
}
