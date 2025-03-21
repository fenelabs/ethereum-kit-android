package io.fenelabs.erc20kit.events

import io.fenelabs.ethereumkit.contracts.ContractEvent
import io.fenelabs.ethereumkit.contracts.ContractEventInstance
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.TransactionTag
import java.math.BigInteger

class TransferEventInstance(
    contractAddress: Address, val from: Address, val to: Address, val value: BigInteger,
    val tokenInfo: TokenInfo?
) : ContractEventInstance(contractAddress) {

    override fun tags(userAddress: Address): List<String> {
        val tags = mutableListOf(contractAddress.hex, TransactionTag.EIP20_TRANSFER)

        if (from == userAddress) {
            tags.add(TransactionTag.tokenOutgoing(contractAddress.hex))
            tags.add(TransactionTag.OUTGOING)
            tags.add(TransactionTag.toAddress(to.hex))
        }

        if (to == userAddress) {
            tags.add(TransactionTag.tokenIncoming(contractAddress.hex))
            tags.add(TransactionTag.INCOMING)
            tags.add(TransactionTag.fromAddress(from.hex))
        }

        return tags
    }

    companion object {
        val signature = ContractEvent(
            "Transfer",
            listOf(
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Uint256
            )
        ).signature
    }
}

data class TokenInfo(val tokenName: String, val tokenSymbol: String, val tokenDecimal: Int)

