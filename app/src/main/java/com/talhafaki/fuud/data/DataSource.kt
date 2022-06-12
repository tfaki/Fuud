package com.talhafaki.fuud.data

import com.talhafaki.fuud.domain.FuudResponse

/**
 * Created by talhafaki on 12.06.2022.
 */
interface DataSource {
    suspend fun getFuudList(): Result<List<FuudResponse>>
}