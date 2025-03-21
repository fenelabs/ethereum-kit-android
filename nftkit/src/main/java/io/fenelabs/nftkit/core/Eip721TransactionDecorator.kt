package io.fenelabs.nftkit.core

import io.fenelabs.ethereumkit.contracts.ContractEventInstance
import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.core.ITransactionDecorator
import io.fenelabs.ethereumkit.decorations.TransactionDecoration
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.InternalTransaction
import io.fenelabs.nftkit.contracts.Eip721SafeTransferFromMethod
import io.fenelabs.nftkit.decorations.OutgoingEip721Decoration
import io.fenelabs.nftkit.events.Eip721TransferEventInstance
import java.math.BigInteger

class Eip721TransactionDecorator(
    private val userAddress: Address
) : ITransactionDecorator {

    override fun decoration(
        from: Address?,
        to: Address?,
        value: BigInteger?,
        contractMethod: ContractMethod?,
        internalTransactions: List<InternalTransaction>,
        eventInstances: List<ContractEventInstance>
    ): TransactionDecoration? {
        if (from == null || to == null || value == null || contractMethod == null) return null

        return when {
            contractMethod is Eip721SafeTransferFromMethod && from == userAddress -> {
                OutgoingEip721Decoration(
                    contractAddress = to,
                    to = contractMethod.to,
                    tokenId = contractMethod.tokenId,
                    sentToSelf = contractMethod.to == userAddress,
                    tokenInfo = eventInstances.mapNotNull { it as? Eip721TransferEventInstance }.firstOrNull { it.contractAddress == to }?.tokenInfo
                )
            }
            else -> null
        }
    }
}