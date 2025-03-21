package io.fenelabs.erc20kit.contract

import io.fenelabs.ethereumkit.contracts.ContractMethod

class DecimalsMethod: ContractMethod() {
    override var methodSignature = "decimals()"
    override fun getArguments() = listOf<Any>()
}
