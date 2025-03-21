package io.fenelabs.nftkit.core

import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.contracts.ContractMethodFactories
import io.fenelabs.ethereumkit.core.IMethodDecorator

class Eip1155MethodDecorator(
    private val contractMethodFactories: ContractMethodFactories
) : IMethodDecorator {
    override fun contractMethod(input: ByteArray): ContractMethod? {
        return contractMethodFactories.createMethodFromInput(input)
    }
}