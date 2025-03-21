package io.fenelabs.nftkit.contracts

import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.contracts.ContractMethodFactory
import io.fenelabs.ethereumkit.contracts.ContractMethodHelper
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.spv.core.toBigInteger

class Eip1155SafeTransferFromMethodFactory : ContractMethodFactory {
    override val methodId = ContractMethodHelper.getMethodId(Eip1155SafeTransferFromMethod.methodSignature)

    override fun createMethod(inputArguments: ByteArray): ContractMethod {
        val from = Address(inputArguments.copyOfRange(12, 32))
        val to = Address(inputArguments.copyOfRange(44, 64))
        val tokenId = inputArguments.copyOfRange(64, 96).toBigInteger()
        val value = inputArguments.copyOfRange(96, 128).toBigInteger()
        val data = inputArguments.copyOfRange(128, 160)

        return Eip1155SafeTransferFromMethod(from, to, tokenId, value, data)
    }
}