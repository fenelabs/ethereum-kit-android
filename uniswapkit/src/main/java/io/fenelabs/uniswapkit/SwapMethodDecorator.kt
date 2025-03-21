package io.fenelabs.uniswapkit

import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.core.IMethodDecorator
import io.fenelabs.uniswapkit.contract.SwapContractMethodFactories

class SwapMethodDecorator(private val contractMethodFactories: SwapContractMethodFactories) : IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
