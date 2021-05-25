package com.spectro.contactlist

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ContactHelperTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val sharedPreferences =
        context.getSharedPreferences("com.spectro.contactlist.PREFERENCES", Context.MODE_PRIVATE)
    private val contactHelper = ContactHelper(sharedPreferences)

    @Test
    fun `Quando chamar o metodo getListContact() com 2 contatos, deve retornar uma lista de 2 contatos`(){
        //Prepara
        mockListDoisContatos()

        //Valida
        val list = contactHelper.getListContacts()
        assertEquals(2, list.size)
    }

    @Test
    fun `Quando chamar o metodo getListContacts() sem contatos, deve retornar uma lista vazia`(){
        //Prepara
        mockListContatosVazia()

        //Valida
        val list = contactHelper.getListContacts()
        assertEquals(0, list.size)
    }

    private fun mockListDoisContatos(){
        contactHelper.setListContacts(
            arrayListOf(
                Contact(
                    "Guilherme Big Test",
                    "(34) 12345-67899",
                    "img.png"
                ),
                Contact(
                    "Vil Nilsus",
                    "(34) 99999-8888",
                    "img.png"
                )
            )
        )
    }

    private fun mockListContatosVazia(){
        contactHelper.setListContacts(arrayListOf())
    }
}