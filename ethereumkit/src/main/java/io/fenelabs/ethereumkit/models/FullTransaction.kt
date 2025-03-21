package io.fenelabs.ethereumkit.models

import io.fenelabs.ethereumkit.decorations.TransactionDecoration

class FullTransaction(
    val transaction: Transaction,
    val decoration: TransactionDecoration
)
