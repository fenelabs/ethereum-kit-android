package io.fenelabs.ethereumkit.spv.net.tasks

import io.fenelabs.ethereumkit.spv.core.ITask
import io.fenelabs.ethereumkit.models.RawTransaction
import io.fenelabs.ethereumkit.models.Signature

class SendTransactionTask(val sendId: Int,
                          val rawTransaction: RawTransaction,
                          val signature: Signature) : ITask
