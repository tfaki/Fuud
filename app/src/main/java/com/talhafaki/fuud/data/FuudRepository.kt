package com.talhafaki.fuud.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.talhafaki.fuud.domain.FuudResponse
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * Created by talhafaki on 12.06.2022.
 */

@Singleton
class FuudRepository @Inject constructor() : DataSource {
    private val db: FirebaseFirestore = Firebase.firestore

    override suspend fun getFuudList(): Result<List<FuudResponse>> =
        suspendCoroutine { continuation ->
            db.collection("foodList")
                .get()
                .addOnSuccessListener {
                    try {
                        continuation.resume(Result.Success((it.toObjects(FuudResponse::class.java))))
                    } catch (e: Exception) {
                        continuation.resume(Result.Error(e))
                    }
                }.addOnFailureListener {
                    continuation.resume(Result.Error(it))
                }
        }
}
