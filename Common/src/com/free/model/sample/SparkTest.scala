package com.free.model.sample

import org.apache.spark.{SparkConf, SparkContext}

object SparkTest {
  def main(args: Array[String]) {
    val inputFile = "d:/1.txt";//args(0)
    val outputFile = "d:/2";//args(1)
    val conf = new SparkConf().setAppName("wordCount")
    conf.setMaster("local[2]")

    // Create a Scala Spark Context.
    val sc = new SparkContext(conf)
    // Load our input data.
    val input =  sc.textFile(inputFile)
    // Split  up into words.
    val words = input.flatMap(line => line.split(" "))
    // Transform into word and count.
    val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
    // Save the word count back out to a text file, causing evaluation.
    counts.saveAsTextFile(outputFile)
  }
}
