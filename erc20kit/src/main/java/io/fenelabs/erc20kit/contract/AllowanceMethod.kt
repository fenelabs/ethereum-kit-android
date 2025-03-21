package io.fenelabs.erc20kit.contract

import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.models.Address

class AllowanceMethod(val owner: Address, val spender: Address) : ContractMethod() {

    override val methodSignature = "allowance(address,address)"
    override fun getArguments() = listOf(owner, spender)

}
