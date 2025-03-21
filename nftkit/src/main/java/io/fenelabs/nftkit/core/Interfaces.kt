package io.fenelabs.nftkit.core

import io.fenelabs.nftkit.models.Nft
import io.fenelabs.nftkit.models.NftType

interface ITransactionSyncerListener {
    fun didSync(nfts: List<Nft>, type: NftType)
}

interface IBalanceSyncManagerListener {
    fun didFinishSyncBalances()
}