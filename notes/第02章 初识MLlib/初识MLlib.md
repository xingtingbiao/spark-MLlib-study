初识MLlib

1. MLlib 介绍                   3. MLlib数据格式
2. MLlib 与 ml库                4. 应用场景




一. MLlib 介绍
    a. 是基于Spark core 的机器学习库, 具有Spark的优点

    b. 底层计算经过优化, 比常规编码效率要高

    c. 实现多种机器学习算法, 可以进行模型训练及预测





二. MLlib 与 ml库 

As of Spark 2.0, the RDD-based APIs in the spark.mllib package have entered maintenance mode. The primary Machine Learning API for Spark is now the DataFrame-based API in the spark.ml package.

1) Spark MLlib实现的算法
    a. 逻辑回归  朴素贝叶斯  线性回归  SVM  决策树  LDA  矩阵分解 etc.

2) Spark MLlib 官方介绍
    ******一定要去看官方文档******
    http://spark.apache.org





三. MLlib的数据结构

1) MLlib的数据格式
    a. 本地向量(local vector)
        本地向量是存储在本地节点上的, 其基本数据类型是Vector. 其有两个子集, 分别是密集与稀疏的, 我们一般使用Vectors工厂类来生成, 例如:
        Vectors.dense(1.0, 2.0, 3.0)  稠密
        Vectors.sparse(3, (0,1), (1,2), (2,3))  稀疏

    b. 标签数据(labeled point)
        我们在前面的课程中介绍过 "监督学习", 知道监督学习是(x, y)数据形式, 其中这个y就是标签, x就是特征向量. 标签数据也是一样, 我们来看一下这个代码:
        LabeledPoint(1.0, Vectors.dense(1.0, 2.0, 3.0))    y=f(x)

    c. 本地矩阵(local matrix)
        与向量相似, 本地矩阵类型为Matrix, 分为稠密和稀疏两种类型. 同样使用工厂方法Matrices来生成. 但是要注意: MLlib的矩阵是按列存储的. 
        例如下面创建一个 3 * 3 的单位矩阵:
        Matrices.dense(3, 3, Array(1, 0, 0, 0, 1, 0, 0, 0, 1))   
        1.0 0.0 0.0
        0.0 1.0 0.0   ==> 从左往右竖着数的 形成 Array(1, 0, 0, 0, 1, 0, 0, 0, 1)
        0.0 0.0 1.0

        类似地, 稀疏矩阵的创建方法: 
        Matrices.sparse(3, 3, Array(0,1,2,3), Array(0,1,2), Array(1,1,1))


    d. 分布式矩阵(distributed matrix)
        分布式矩阵意为把一个矩阵数据分布式存储到多个RDD中. 将分布式矩阵进行数据转换需要全局的 shuffle 函数, 最基本的分布式矩阵是: RowMatrix.


    e. 分布式数据集
        RDD Dataset DataFrame 都是Spark 的分布式数据集的数据格式, 三者在一定程度上可以相互转换, 有各自的适用范围. 其中RDD最为基础且简单的一种数据形式.

        RDD:
            RDD(Resilient Distributed Datasets), 弹性分布式数据集, 是Spark中结构最简单, 也是最常用的一类数据集形式.
            可以理解为把输入数据进行简单的封装之后形成的对内存数据的抽象.

        Dataset:
            与RDD分行存储, 没有列的概念不同, Dataset引入了列的概念, 这一点类似于一个csv文件结构. 类似于一个简单的二维表.

        DataFrame:
            DataFrame结构与Dataset是类似的, 都引入了列的概念. 与Dataset不同的是, DataFrame中的每一行都被再次封装为Row的对象. 
            需要通过该对象的方法获取到具体的值.




