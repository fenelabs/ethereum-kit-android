package io.fenelabs.uniswapkit.v3.contract

import io.fenelabs.ethereumkit.contracts.ContractMethodFactories
import io.fenelabs.uniswapkit.v3.router.*

object UniswapV3ContractMethodFactories : ContractMethodFactories() {
    init {
        val swapContractMethodFactories = listOf(
            ExactInputMethod.Factory(),
            ExactOutputMethod.Factory(),
            ExactInputSingleMethod.Factory(),
            ExactOutputSingleMethod.Factory(),
            UnwrapWETH9Method.Factory(),
            MulticallMethod.Factory(UniswapV3ContractMethodFactories),
        )
        registerMethodFactories(swapContractMethodFactories)
    }
}
