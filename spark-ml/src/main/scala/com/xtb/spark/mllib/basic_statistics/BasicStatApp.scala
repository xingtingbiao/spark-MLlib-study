package com.xtb.spark.mllib.basic_statistics

import org.apache.spark.sql.SparkSession

/**
  * 基础统计练习
  */
object BasicStatApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("BasicStatApp").master("local[2]").getOrCreate()
    val lines = spark.read.textFile("data/beijing.txt")
    val strings = lines.take(10)
    println(strings)

    spark.stop()
  }

}
