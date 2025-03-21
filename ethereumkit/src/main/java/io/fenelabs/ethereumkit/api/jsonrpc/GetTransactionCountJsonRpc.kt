package io.fenelabs.ethereumkit.api.jsonrpc

import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.DefaultBlockParameter

class GetTransactionCountJsonRpc(
        @Transient val address: Address,
        @Transient val defaultBlockParameter: DefaultBlockParameter
) : LongJsonRpc(
        method = "eth_getTransactionCount",
        params = listOf(address, defaultBlockParameter)
)
