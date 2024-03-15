package com.yaizz.flimlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.yaizz.flimlerapp.R
import com.yaizz.flimlerapp.data.entitiy.Filmler
import com.yaizz.flimlerapp.databinding.CardTasarimBinding
import com.yaizz.flimlerapp.ui.fragment.AnasayfaFragmentDirections

//List arrayList ve Listi kapsar ondan kullandık
//context activity ve fragment tarafından çalıştırıldığını temsil eder
class FlimlerAdapter(var mcontext : Context, var filmlerListesi:List<Filmler>)
    : RecyclerView.Adapter<FlimlerAdapter.CardTasarimTutucu>()
{

    //inner classı üst sınıfa bağlayınca aşağıdaki fonksiyonları verdi
    //holder sınıfı görsel nesneleri temsil eder card üzerindeki //tasarımımızı temsil ediyor tasarım
    inner class CardTasarimTutucu(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)
    //card tasarımı temsil ediyor

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       val binding : CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mcontext),R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }


    //holder ile tasarıma tasarım ile card
    //holder card üzerindeki görsel nesnelere erişmemizi sağlıyor
    //position ise gelen verilerin indexleri gelir sıralama gibi
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        val t = holder.tasarim
        //resim ve tıklama işlemlerini yapamıyoruz data binding ile
        t.imageViewFlim.setImageResource(mcontext.resources.getIdentifier(film.resim,"drawable",mcontext.packageName))

        t.filmNesnesi = film

        t.cardViewFlim.setOnClickListener {
            //Carda tıklanınca olacaklar
            val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)

        }

        t.buttonSepet.setOnClickListener {
            //Snackbar.make(mcontext,t.buttonSepet,"Sepete Eklendi",Snackbar.LENGTH_SHORT).show()
            Snackbar.make(it,"${film.ad} sepete eklendi",Snackbar.LENGTH_SHORT).show()
        }



    }
    //listeleme altyapısı kaç flim gösterecek
    override fun getItemCount(): Int {
        return filmlerListesi.size
    }


}