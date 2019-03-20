package com.xtb.spark.mllib.basic_statistics

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.sql.SparkSession

/**
  * 基础统计练习
  */
object BasicStatApp {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("BasicStatApp").master("local[2]").getOrCreate()
    val lines = spark.read.textFile("data/beijing.txt").rdd
    val value = lines.flatMap(_.split(",")).map(x => Vectors.dense(x.toDouble))
//    value.take(10).foreach(println)
    // 开始使用Statistics进行一些统计
    // 统计的列统计
    val summary = Statistics.colStats(value)
    println(summary.max)
    println(summary.mean)  // a dense vector containing the mean value for each column
    println(summary.variance)  // column-wise variance
    println(summary.numNonzeros)  // number of nonzeros in each column

    spark.stop()
  }

}
