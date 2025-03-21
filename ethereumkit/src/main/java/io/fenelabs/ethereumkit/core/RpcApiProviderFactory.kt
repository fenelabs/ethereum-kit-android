package io.fenelabs.ethereumkit.core

import io.fenelabs.ethereumkit.api.core.IRpcApiProvider
import io.fenelabs.ethereumkit.api.core.NodeApiProvider
import io.fenelabs.ethereumkit.models.RpcSource

object RpcApiProviderFactory {

    private val providersCache = mutableMapOf<RpcSource, IRpcApiProvider>()

    @Synchronized
    fun nodeApiProvider(rpcSource: RpcSource) = when (val cachedProvider = providersCache[rpcSource]) {
        null -> {
            val rpcApiProvider: IRpcApiProvider = when (rpcSource) {
                is RpcSource.Http -> {
                    NodeApiProvider(rpcSource.uris, EthereumKit.gson, rpcSource.auth)
                }

                is RpcSource.WebSocket -> throw IllegalStateException("Websocket not supported")
            }

            providersCache[rpcSource] = rpcApiProvider

            rpcApiProvider
        }

        else -> {
            cachedProvider
        }
    }

}
