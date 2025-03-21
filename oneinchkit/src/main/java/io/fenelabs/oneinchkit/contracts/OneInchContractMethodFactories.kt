package io.fenelabs.oneinchkit.contracts

import io.fenelabs.ethereumkit.contracts.ContractMethodFactories
import io.fenelabs.oneinchkit.contracts.v4.SwapMethodFactoryV4
import io.fenelabs.oneinchkit.contracts.v4.UnoswapMethodFactoryV4
import io.fenelabs.oneinchkit.contracts.v4.UnparsedSwapMethodsFactoryV4
import io.fenelabs.oneinchkit.contracts.v5.SwapMethodFactoryV5
import io.fenelabs.oneinchkit.contracts.v5.UnoswapMethodFactoryV5
import io.fenelabs.oneinchkit.contracts.v5.UnparsedSwapMethodsFactoryV5

object OneInchContractMethodFactories : ContractMethodFactories() {

    init {
        val swapContractMethodFactories = listOf(
            UnoswapMethodFactoryV5(),
            SwapMethodFactoryV5(),
            UnparsedSwapMethodsFactoryV5(),
            UnoswapMethodFactoryV4(),
            SwapMethodFactoryV4(),
            UnparsedSwapMethodsFactoryV4()
        )
        registerMethodFactories(swapContractMethodFactories)
    }

}
