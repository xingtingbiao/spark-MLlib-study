package com.xtb.spark.mllib

import breeze.linalg.DenseVector
import org.apache.spark.ml.linalg.Vectors
import org.junit.Test

/**
  * Spark中向量基本使用
  */
@Test
class VectorTests {

  @Test
  def testVector(): Unit = {
    val vector = Vectors.dense(1.0, 0.0, 3.0)
    println(vector)

    val v1 = DenseVector(1, 2, 3, 4)
    val v2 = v1 + v1
    println(v2)
    // 这里的乘是向量的叉乘
    println(v1 * v1.t)
    println(v1 * v1)
  }

}
