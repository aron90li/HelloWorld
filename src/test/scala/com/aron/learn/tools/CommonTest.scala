package com.aron.learn.tools

import org.apache.log4j.{PropertyConfigurator, Logger}
import org.apache.spark.{SparkContext, SparkConf}
import org.scalatest.{BeforeAndAfterEach, FunSuite}

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Aron on 2017/11/17.
 */
class CommonTest extends FunSuite with BeforeAndAfterEach{
  val logger = Logger.getLogger(classOf[CommonTest])
  override def beforeEach() {
    PropertyConfigurator.configure("conf/log4j.properties")
  }

  override def afterEach() {
    logger.info("test end")
  }

  test("Array ArrayBuffer"){
    val arr =  new Array[String](2) //定长
    arr(0)="aa"
    arr.map(logger.info)


    val arrayBuffer = new ArrayBuffer[String] //可变
    arrayBuffer += "bb"
    arrayBuffer ++= arr
    arrayBuffer.map(println)
  }

  test("List"){ //列表
    val list = List("aa", "bb") //List值不能改变
  }

  test("flatMap") {
    //环境变量HADOOP_HOME
    System.setProperty("hadoop.home.dir", "D:\\java\\hadoop\\hadoop-common-2.6.0-bin-master");
    val conf = new SparkConf().setAppName("test").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val rdd = sc.textFile("file:///D:\\IdeaProjects\\Learn-HelloWorld\\src\\test\\scala\\com\\aron\\learn\\tools\\test.txt")

    println("result rdd **************************************")
    rdd.collect().foreach(println)

    //RDD[String] --> RDD[ArrayBuffer[(String, String)]]
    val rdd1 = rdd.flatMap(line => {
      val res = ArrayBuffer[(String, String)]()
      val name = line.split(" ")(0)
      val sex = line.split(" ")(1)
      val age = line.split(" ")(2)
      val height = line.split(" ")(3)
      res += Tuple2("name", name)
      res += Tuple2("sex", sex)
      res += Tuple2("age", age)
      res += Tuple2("height", height)
    })
    println("rdd1 result *********************")
    println("rdd1 count: " + rdd1.count())
    rdd1.collect().map(println)


    val rdd2 = rdd.map(line => {
      val res = scala.collection.mutable.Map[String, String]()
      val name = line.split(" ")(0)
      val sex = line.split(" ")(1)
      val age = line.split(" ")(2)
      val height = line.split(" ")(3)
      res += (("name", name))
      res += (("sex", sex))
      res += (("age", age))
      res += (("height", height))
    })
    println("rdd2 result *********************")
    println("rdd2 count: " + rdd2.count())
    rdd2.collect().map(println)


    val rdd3 = rdd.flatMap(line => {
      val res = scala.collection.mutable.Map[String, String]()
      val name = line.split(" ")(0)
      val sex = line.split(" ")(1)
      val age = line.split(" ")(2)
      val height = line.split(" ")(3)

      res += (("name", name))
      res += (("sex", sex))
      res += (("age", age))
      res += (("height", height))
    })
    println("rdd3 result *********************")
    println("rdd3 count: " + rdd3.count())
    rdd3.collect().map(println)
  }
}
