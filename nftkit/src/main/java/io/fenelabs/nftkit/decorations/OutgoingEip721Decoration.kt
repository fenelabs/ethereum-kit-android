package io.fenelabs.nftkit.decorations

import io.fenelabs.ethereumkit.decorations.TransactionDecoration
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.TransactionTag
import io.fenelabs.nftkit.models.TokenInfo
import java.math.BigInteger

class OutgoingEip721Decoration(
    val contractAddress: Address,
    val to: Address,
    val tokenId: BigInteger,
    val sentToSelf: Boolean,
    val tokenInfo: TokenInfo?,
) : TransactionDecoration {

    override fun tags() = listOf(
        contractAddress.hex,
        EIP721_TRANSFER,
        TransactionTag.tokenOutgoing(contractAddress.hex),
        TransactionTag.OUTGOING,
        TransactionTag.toAddress(to.hex)
    )

    companion object {
        const val EIP721_TRANSFER = "eip721Transfer"
    }
}