Spark环境安装



一. Spark 环境安装
    a. Spark 由scala语言编写, 提供多种语言接口, 需要JVM
    b. 官方为我们提供了Spark编译好的版本, 可以不必进行手动编译
    c. Spark安装不难, 配置需要注意, 并且不一定需要Hadoop环境



二. Spark配置若干要点
    a. 在配置前尽量先阅读官方文档, 避免直接从网上找配置教程

    b. 要为节点设置好使用的内存, 否则可能导致节点利用率低;

    c. 注意Spark中IP和端口号的配置, 以免UnknowHostException

    配置看官网*******
    spark-env.sh: 
        SPARK_LOCAL_IP=hadoop001   (建议)


    spark-defaults.conf: 
            




三. 学习Spark shell

    a. Spark shell 是一个bash脚本, 在./bin目录下
    b. Spark shell 为我们事先配置好了上下文(context)和会话(session)





四. 实战WordCount  参考之前的Spark SQL和Spark Streaming即可
1) WordCount简介
    a. WordCount意为词频统计, 是大数据分析中最为基础的一种任务. 英文分词较容易, 直接分隔空格即可.

    b. 实现思路: 首先将文件中所有的单词提取出来, 然后合并相同的单词.






-------本章小结-------

1. 安装Spark                  2. Spark 配置若干要点
3. Spark local 模式搭建       4. 学习 Spark shell


