package io.fenelabs.erc20kit.core

import io.fenelabs.erc20kit.contract.AllowanceMethod
import io.fenelabs.erc20kit.contract.ApproveMethod
import io.fenelabs.ethereumkit.core.EthereumKit
import io.fenelabs.ethereumkit.core.toRawHexString
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.DefaultBlockParameter
import io.fenelabs.ethereumkit.models.TransactionData
import io.reactivex.Single
import java.math.BigInteger

class AllowanceManager(
        private val ethereumKit: EthereumKit,
        private val contractAddress: Address,
        private val address: Address
) {

    fun allowance(spenderAddress: Address, defaultBlockParameter: DefaultBlockParameter): Single<BigInteger> {
        return ethereumKit
                .call(contractAddress, AllowanceMethod(address, spenderAddress).encodedABI(), defaultBlockParameter)
                .map { result ->
                    BigInteger(result.sliceArray(0..31).toRawHexString(), 16)
                }
    }

    fun approveTransactionData(spenderAddress: Address, amount: BigInteger): TransactionData {
        return TransactionData(contractAddress, BigInteger.ZERO, ApproveMethod(spenderAddress, amount).encodedABI())
    }

}
