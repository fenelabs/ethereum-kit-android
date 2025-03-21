package io.fenelabs.ethereumkit.decorations

import io.fenelabs.ethereumkit.contracts.ContractEventInstance
import io.fenelabs.ethereumkit.contracts.ContractMethod
import io.fenelabs.ethereumkit.contracts.EmptyMethod
import io.fenelabs.ethereumkit.core.ITransactionDecorator
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.models.InternalTransaction
import java.math.BigInteger

class EthereumDecorator(private val address: Address) : ITransactionDecorator {

    override fun decoration(from: Address?, to: Address?, value: BigInteger?, contractMethod: ContractMethod?, internalTransactions: List<InternalTransaction>, eventInstances: List<ContractEventInstance>): TransactionDecoration? {
        if (from == null || value == null) return null
        if (to == null) return ContractCreationDecoration()

        if (contractMethod != null && contractMethod is EmptyMethod) {
            if (from == address) {
                return OutgoingDecoration(to, value, to == address)
            }

            if (to == address) {
                return IncomingDecoration(from, value)
            }
        }

        return null
    }

}
