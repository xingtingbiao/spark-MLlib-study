package com.xtb.spark.mllib

import breeze.linalg.DenseMatrix
import org.apache.spark.mllib.linalg.Matrices
import org.junit.Test

/**
  * Spark中矩阵基本使用
  */
class MatrixTests {

  @Test
  def testMatrix(): Unit = {
    /**
      * 创建一个两行三列的矩阵, 注意: 矩阵依然是按列存储的, 所以他的结果是:
      * 1.0  3.0  5.0
      * 2.0  4.0  6.0
      */
    val m1 = Matrices.dense(2, 3, Array(1, 2, 3, 4, 5, 6))
    /**
      * 1.0  2.0  3.0
      * 4.0  5.0  6.0
      */
    val m2 = Matrices.dense(2, 3, Array(1, 4, 2, 5, 3, 6))
    println(m1)
    println("----------------")
    println(m2)
    println("----------------")

    /**
      * 对矩阵的更多操作: Breeze
      * 这里是以行向量一行一行创建的
      */
    val m3 = DenseMatrix(Array(1, 2, 3), Array(4, 5, 6))
    println(m3)
    println("----------------")

    /**
      * reshape: 重塑矩阵行列, 重塑的时候是按列一个一个顺序赋值的
      */
    val m4 = DenseMatrix(Array(1, 2, 3, 4, 5, 6)).reshape(2, 3)
    println(m4)
    println("----------------")
    println(m4.reshape(3, 2))
    println("----------------")
    println(m4.t)
    println("----------------")

    println(m4 * m4.t)
    println("----------------")
  }
}
