package io.fenelabs.erc20kit.events

import io.fenelabs.ethereumkit.contracts.ContractEventInstance
import io.fenelabs.ethereumkit.models.Address
import java.math.BigInteger

class ApproveEventInstance(
    contractAddress: Address,
    val owner: Address,
    val spender: Address,
    val value: BigInteger
) : ContractEventInstance(contractAddress)
