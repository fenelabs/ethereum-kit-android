package io.fenelabs.erc20kit.contract

import io.fenelabs.ethereumkit.contracts.ContractMethod

class NameMethod: ContractMethod() {
    override var methodSignature = "name()"
    override fun getArguments() = listOf<Any>()
}
