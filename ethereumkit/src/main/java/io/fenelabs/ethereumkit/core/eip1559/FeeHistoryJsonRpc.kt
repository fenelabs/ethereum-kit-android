package io.fenelabs.ethereumkit.core.eip1559

import io.fenelabs.ethereumkit.api.jsonrpc.JsonRpc
import io.fenelabs.ethereumkit.models.DefaultBlockParameter

class FeeHistoryJsonRpc(
        @Transient val blocksCount: Long,
        @Transient val defaultBlockParameter: DefaultBlockParameter,
        @Transient val rewardPercentile: List<Int>,
) : JsonRpc<FeeHistory>(
        method = "eth_feeHistory",
        params = listOf(blocksCount, defaultBlockParameter, rewardPercentile)
) {
    @Transient
    override val typeOfResult = FeeHistory::class.java
}
