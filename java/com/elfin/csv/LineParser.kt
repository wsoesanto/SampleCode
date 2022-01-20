package com.elfin.csv

interface LineParser<T> {

  fun parse(line: ArrayList<String>) : T;

  companion object {
    class ArrayStringParser : LineParser<List<String>> {

      override fun parse(line: ArrayList<String>): List<String> {
        return line
      }
    }
  }
}