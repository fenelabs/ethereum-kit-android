package io.fenelabs.erc20kit.contract

import io.fenelabs.ethereumkit.contracts.ContractMethodFactory
import io.fenelabs.ethereumkit.contracts.ContractMethodHelper
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.spv.core.toBigInteger

object TransferMethodFactory : ContractMethodFactory {

    override val methodId = ContractMethodHelper.getMethodId(TransferMethod.methodSignature)

    override fun createMethod(inputArguments: ByteArray): TransferMethod {
        val address = Address(inputArguments.copyOfRange(12, 32))
        val value = inputArguments.copyOfRange(32, 64).toBigInteger()

        return TransferMethod(address, value)
    }

}
