package io.fenelabs.oneinchkit.decorations

import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.core.IMethodDecorator
import io.fenelabs.oneinchkit.contracts.OneInchContractMethodFactories

class OneInchMethodDecorator(private val contractMethodFactories: OneInchContractMethodFactories) : IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
