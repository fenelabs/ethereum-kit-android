package io.fenelabs.nftkit.decorations

import io.fenelabs.ethereumkit.decorations.TransactionDecoration
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.TransactionTag
import io.fenelabs.nftkit.models.TokenInfo
import java.math.BigInteger

class OutgoingEip1155Decoration(
    val contractAddress: Address,
    val to: Address,
    val tokenId: BigInteger,
    val value: BigInteger,
    val sentToSelf: Boolean,
    val tokenInfo: TokenInfo?,
) : TransactionDecoration {

    override fun tags() = listOf(
        contractAddress.hex,
        EIP1155_TRANSFER,
        TransactionTag.tokenOutgoing(contractAddress.hex),
        TransactionTag.OUTGOING,
        TransactionTag.toAddress(to.hex)
    )

    companion object {
        const val EIP1155_TRANSFER = "eip1155Transfer"
    }
}