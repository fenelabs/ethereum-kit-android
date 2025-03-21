package io.fenelabs.uniswapkit.v3.quoter

import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.uniswapkit.v3.SwapPath
import java.math.BigInteger

class QuoteExactOutputMethod(
    val path: SwapPath,
    val amountOut: BigInteger,
) : ContractMethod() {

    override val methodSignature = "quoteExactOutput(bytes,uint256)"
    override fun getArguments() = listOf(path.abiEncodePacked(), amountOut)

}
