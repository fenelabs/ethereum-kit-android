package io.fenelabs.ethereumkit.contracts

import io.fenelabs.ethereumkit.models.Address

open class ContractEventInstance(val contractAddress: Address) {

    open fun tags(userAddress: Address): List<String> = listOf()

}
