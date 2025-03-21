package io.fenelabs.uniswapkit

import io.fenelabs.ethereumkit.models.Chain
import io.fenelabs.uniswapkit.models.Token

class PairSelector(
    private val tokenFactory: io.fenelabs.uniswapkit.TokenFactory
) {
    fun tokenPairs(chain: Chain, tokenA: Token, tokenB: Token): List<Pair<Token, Token>> =
        if (tokenA.isEther || tokenB.isEther) {
            listOf(Pair(tokenA, tokenB))
        } else {
            val etherToken = tokenFactory.etherToken(chain)

            listOf(Pair(tokenA, tokenB), Pair(tokenA, etherToken), Pair(tokenB, etherToken))
        }
}
