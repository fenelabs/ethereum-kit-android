package io.fenelabs.erc20kit.core

import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.contracts.ContractMethodFactories
import io.fenelabs.ethereumkit.core.IMethodDecorator

class Eip20MethodDecorator(
    private val contractMethodFactories: ContractMethodFactories
) : IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
