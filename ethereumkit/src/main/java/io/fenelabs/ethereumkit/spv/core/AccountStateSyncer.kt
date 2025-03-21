package io.fenelabs.ethereumkit.spv.core

import io.fenelabs.ethereumkit.core.ISpvStorage
import io.fenelabs.ethereumkit.models.Address
import io.fenelabs.ethereumkit.spv.models.AccountStateSpv
import io.fenelabs.ethereumkit.spv.models.BlockHeader
import io.fenelabs.ethereumkit.spv.net.handlers.AccountStateTaskHandler
import io.fenelabs.ethereumkit.spv.net.tasks.AccountStateTask

class AccountStateSyncer(private val storage: ISpvStorage,
                         private val address: Address) : AccountStateTaskHandler.Listener {

    interface Listener {
        fun onUpdate(accountState: AccountStateSpv)
    }

    var listener: Listener? = null

    fun sync(taskPerformer: ITaskPerformer, blockHeader: BlockHeader) {
        taskPerformer.add(AccountStateTask(address, blockHeader))
    }

    override fun didReceive(accountState: AccountStateSpv, address: Address, blockHeader: BlockHeader) {
        storage.saveAccountSate(accountState)
        listener?.onUpdate(accountState)
    }

}
