package io.fenelabs.nftkit.contracts

import io.fenelabs.ethereumkit.contracts.ContractMethodFactories

object Eip1155ContractMethodFactories : ContractMethodFactories() {
    init {
        registerMethodFactories(listOf(Eip1155SafeTransferFromMethodFactory()))
    }
}