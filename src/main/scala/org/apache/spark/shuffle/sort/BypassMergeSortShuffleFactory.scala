package org.apache.spark.shuffle.sort

import org.apache.spark._
import org.apache.spark.shuffle._
import org.apache.spark.shuffle.api.ShuffleExecutorComponents

object BypassMergeSortShuffleFactory {

    def bypassMerge[K, V](bypassMergeSortHandle: BypassMergeSortShuffleHandle[K, V], mapId: Long,  metrics: ShuffleWriteMetricsReporter,  shuffleExecutorComponents: ShuffleExecutorComponents) :  ShuffleWriter[K, V]  = {
        val env = SparkEnv.get
        return new BypassMergeSortShuffleWriter(
            env.blockManager,
            bypassMergeSortHandle,
            mapId,
            env.conf,
            metrics,
            shuffleExecutorComponents)
    }
}