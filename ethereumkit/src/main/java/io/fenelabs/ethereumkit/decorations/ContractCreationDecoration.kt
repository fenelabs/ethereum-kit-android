package io.fenelabs.ethereumkit.decorations

class ContractCreationDecoration : TransactionDecoration {
    override fun tags() = listOf("contractCreation")
}
