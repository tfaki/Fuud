package com.talhafaki.fuud

import android.util.Log
import androidx.compose.runtime.Composable
import com.google.firebase.firestore.FirebaseFirestore

/**
 * Created by talhafaki on 11.06.2022.
 */
@Composable
fun MainScreen() {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    db.collection("foodList").get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Log.d("Success",document.id + " => " + document.data)
            }
        }
        .addOnFailureListener { exception ->
            Log.d("Error getting documents: ", exception.message ?: "")
        }
}