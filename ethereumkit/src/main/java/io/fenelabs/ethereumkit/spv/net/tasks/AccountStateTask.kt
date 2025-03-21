package io.fenelabs.ethereumkit.spv.net.tasks

import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.spv.core.ITask
import io.fenelabs.ethereumkit.spv.models.BlockHeader

class AccountStateTask(val address: Address, val blockHeader: BlockHeader) : ITask
