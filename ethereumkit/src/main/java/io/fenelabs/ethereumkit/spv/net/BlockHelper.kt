package io.fenelabs.ethereumkit.spv.net

import io.fenelabs.ethereumkit.core.ISpvStorage
import io.fenelabs.ethereumkit.network.INetwork
import io.fenelabs.ethereumkit.spv.models.BlockHeader

class BlockHelper(val storage: ISpvStorage, val network: INetwork) {

    val lastBlockHeader: BlockHeader
        get() = storage.getLastBlockHeader() ?: network.checkpointBlock

}
