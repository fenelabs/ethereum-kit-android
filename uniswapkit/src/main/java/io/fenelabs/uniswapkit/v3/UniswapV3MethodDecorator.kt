package io.fenelabs.uniswapkit.v3

import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.core.IMethodDecorator
import io.fenelabs.uniswapkit.v3.contract.UniswapV3ContractMethodFactories

class UniswapV3MethodDecorator(private val contractMethodFactories: UniswapV3ContractMethodFactories) :
    IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
