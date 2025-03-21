package io.fenelabs.erc20kit.decorations

import io.fenelabs.ethereumkit.contracts.ContractEvent
import io.fenelabs.ethereumkit.decorations.TransactionDecoration
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.TransactionTag
import java.math.BigInteger

class ApproveEip20Decoration(
    val contractAddress: Address,
    val spender: Address,
    val value: BigInteger
) : TransactionDecoration {

    override fun tags() = listOf(contractAddress.hex, TransactionTag.EIP20_APPROVE)

    companion object {
        val signature = ContractEvent(
            "Approval",
            listOf(
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Uint256
            )
        ).signature
    }
}
