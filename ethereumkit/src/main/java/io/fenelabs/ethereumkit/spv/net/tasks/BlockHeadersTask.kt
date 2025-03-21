package io.fenelabs.ethereumkit.spv.net.tasks

import io.fenelabs.ethereumkit.spv.core.ITask
import io.fenelabs.ethereumkit.spv.models.BlockHeader

class BlockHeadersTask(val blockHeader: BlockHeader, val limit: Int, val reverse: Boolean = false) : ITask