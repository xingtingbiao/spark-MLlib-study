package com.xtb.spark.mllib.basic_statistics

import org.apache.spark.mllib.linalg.Matrices
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.sql.SparkSession

/**
  * 线性相关的一个练习
  * 北京市历年降雨量进行相关性的统计, 看看年份与降水量之间的相关性有多大
  */
object LinearCorrelationApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[2]")
        .appName("LinearCorrelationApp").getOrCreate()

    // yearRainCorr(spark)
    hypothesisTesting()

    spark.stop()
  }

  /**
    * 北京市历年降雨量进行相关性的统计, 看看年份与降水量之间的相关性有多大
    */
  private def yearRainCorr(spark: SparkSession) = {
    val lines = spark.read.textFile("data/beijing2.txt").rdd
    val data = lines.flatMap(_.split(",")).map(_.toDouble)
    val years = data.filter(_ > 1000)
    val rainfall = data.filter(_ < 1000)

    // 判断相关性的函数
    val d = Statistics.corr(years, rainfall)
    println(d)
  }

  /**
    * 独立性检验: 判断性别与左撇子是否存在关系
    * Chi squared test summary:
    * method: pearson
    * degrees of freedom = 1
    * statistic = 3.8587031204632654
    * pValue = 0.049488567227318536   与0.05对比 大于0.05相互独立成立, 否则不成立
    * Strong presumption against null hypothesis: the occurrence of the outcomes is statistically independent..
    */
  private def hypothesisTesting(): Unit = {
    val m = Matrices.dense(2, 2, Array(127, 19, 147, 10))
    val result = Statistics.chiSqTest(m)
    println(result)
  }
}
