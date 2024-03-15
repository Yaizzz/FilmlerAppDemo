package com.yaizz.flimlerapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yaizz.flimlerapp.data.entitiy.Filmler
import com.yaizz.flimlerapp.data.repo.FilmlerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {

    var frepo = FilmlerRepository()
    var flimlerListesi = MutableLiveData<List<Filmler>>()

    init { //uygulama ilk açıldığında anda veri gelmesi için
        filmleriYukle()
    }

     fun filmleriYukle() {
         //main arayüze yakın olduğumuz için IO veri tabınında denir
        CoroutineScope(Dispatchers.Main).launch {
            flimlerListesi.value =frepo.filmleriYukle()

        }

         //ANA SAYFANIN VİEW MODELİNDEN ANA SAYFA FRAGMENTE VERİ TAŞIMAK İSTİYORSAK
         //LİVE DATA KULLANMAMIZ GEREKİYOR
    }
}