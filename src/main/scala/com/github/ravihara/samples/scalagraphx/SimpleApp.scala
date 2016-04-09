package com.github.ravihara.samples.scalagraphx

import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SimpleApp {
  def main(args: Array[String]) = {
    val sparkHome = System.getenv("SPARK_HOME")
    val sparkConf = new SparkConf().setAppName("Simple GraphX App")
    val sparkCtxt = new SparkContext(sparkConf)

    val users: RDD[(VertexId, (String, String))] =
      sparkCtxt.parallelize(Array((3L, ("rxin", "student")), (7L, ("jgonzal", "postdoc")),
        (5L, ("franklin", "prof")), (2L, ("istoica", "prof"))))

    val relationships: RDD[Edge[String]] =
      sparkCtxt.parallelize(Array(Edge(3L, 7L, "collab"), Edge(5L, 3L, "advisor"),
        Edge(2L, 5L, "colleague"), Edge(5L, 7L, "pi")))

    val dflUser = ("John Doe", "Missing")

    val graph = Graph(users, relationships, dflUser)

    // Graph computations
    val vCnt = graph.vertices.filter({ case (id, (name, pos)) => (pos == "prof") }).count()
    val facts: RDD[String] = graph.triplets.map({ t => (t.srcAttr._1 + " is the " + t.attr + " of " + t.dstAttr._1) })

    facts.collect().foreach(println(_))
    println("Number of professors: " + vCnt)
  }
}
