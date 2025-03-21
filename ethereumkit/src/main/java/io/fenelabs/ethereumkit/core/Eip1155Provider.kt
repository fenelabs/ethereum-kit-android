package io.fenelabs.ethereumkit.core

import io.fenelabs.ethereumkit.api.core.IRpcApiProvider
import io.fenelabs.ethereumkit.api.core.RpcBlockchain
import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.DefaultBlockParameter
import io.fenelabs.ethereumkit.models.RpcSource
import io.fenelabs.ethereumkit.spv.core.toBigInteger
import io.reactivex.Single
import java.math.BigInteger

class Eip1155Provider(
    private val provider: IRpcApiProvider
) {

    class BalanceOfMethod(val owner: Address, val tokenId: BigInteger) : ContractMethod() {
        override val methodSignature = "balanceOf(address,uint256)"
        override fun getArguments() = listOf(owner, tokenId)
    }

    fun getTokenBalance(contractAddress: Address, tokenId: BigInteger, address: Address): Single<BigInteger> {
        val callRpc = RpcBlockchain.callRpc(contractAddress, BalanceOfMethod(address, tokenId).encodedABI(), DefaultBlockParameter.Latest)

        return provider
            .single(callRpc)
            .map { it.sliceArray(IntRange(0, 31)).toBigInteger() }
    }

    companion object {

        fun instance(rpcSource: RpcSource.Http): Eip1155Provider {
            val apiProvider = RpcApiProviderFactory.nodeApiProvider(rpcSource)

            return Eip1155Provider(apiProvider)
        }

    }

}
