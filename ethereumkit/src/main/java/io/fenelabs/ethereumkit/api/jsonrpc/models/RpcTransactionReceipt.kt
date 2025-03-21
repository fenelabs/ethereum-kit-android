package io.fenelabs.ethereumkit.api.jsonrpc.models

import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.TransactionLog

class RpcTransactionReceipt(
        val transactionHash: ByteArray,
        val transactionIndex: Int,
        val blockHash: ByteArray,
        val blockNumber: Long,
        val from: Address,
        val to: Address?,
        val effectiveGasPrice: Long,
        val cumulativeGasUsed: Long,
        val gasUsed: Long,
        val contractAddress: Address?,
        val logs: List<TransactionLog>,
        val logsBloom: ByteArray,
        val root: ByteArray?,
        val status: Int?
)
