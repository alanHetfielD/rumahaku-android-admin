package com.madukubah.rumahakuadmin.view.activity.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.bumptech.glide.Glide
import com.madukubah.rumahakuadmin.BuildConfig
import com.madukubah.rumahakuadmin.R
import com.madukubah.rumahakuadmin.config.Config
import com.madukubah.rumahakuadmin.config.invisible
import com.madukubah.rumahakuadmin.model.Item
import com.madukubah.rumahakuadmin.view.activity.detail.slider.SliderAdapter
import com.madukubah.rumahakuadmin.view.activity.detail.slider.SliderFragment
import com.madukubah.rumahakuadmin.view.fragment.contact.ContactFragment
import kotlinx.android.synthetic.main.activity_detail_item.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast

class DetailItemActivity
    :
        AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_item)
        item = intent.getParcelableExtra(ITEM)

        val actionBar = supportActionBar
        actionBar?.title = item.item_name
        setupUI()

        btn_hubungi.onClick {
            val contactFragment : ContactFragment = ContactFragment(){
                when( it ){
                    0->{
                        val dialPhoneIntent = Intent( Intent.ACTION_DIAL, Uri.parse("tel:" + item.user_profile_phone ))
                        startActivity(dialPhoneIntent)
                    }
                    1->{
                        sendSMS()
                    }
                }
            }
            val ft = getSupportFragmentManager().beginTransaction()
            contactFragment.show(ft , "doalog")
        }
    }

    private fun sendSMS()
    {   val tx = " saya tertarik dengan untuk memesan ' " + item.item_name + " ' \n\n Sms Via Rumah Aku App"
        val i = Intent( Intent.ACTION_VIEW, Uri.fromParts("sms", "" + item.user_profile_phone  , this.toString()) )
        i.putExtra("sms_body", tx );

        try {
            startActivity( i )
            finish()
            toast("buka sms ")
        } catch (e: Exception) {
            toast("gagal mengirim sms")
        }
    }

    private fun setupViewPager(pager : ViewPager, Images : List<String>)
    {
        val adapter = SliderAdapter( supportFragmentManager )

        Images.map {
            adapter.addFragment( SliderFragment.newInstance(BuildConfig.ITEM_IMAGE + it ) )
        }

        pager?.adapter = adapter
    }
    @SuppressLint("SetTextI18n")
    private fun setupUI()
    {
        tv_harga.text ="Rp. "+ Config.priceFormat( ""+item.item_price )
        tv_dilihat.text = " 100 kali dilihat"
        tv_owner.text = """${item.user_profile_fullname} """
        tv_store_address.text = item.store_name
        tv_item_description.text = item.item_description
        tv_facilities.text = Config.convert( item.item_facility )
        if( item.category_id != CATEGORY_BTN ){
            item_facility_layout.invisible()
        }

        val url = item.user_profile_image_path
        url.let {
            Glide.with(this)
                    .load( BuildConfig.USER_IMAGE + url)
                    .into( profile_image )
        }

        val images = item.item_images.split(";")

        setupViewPager( viewPager_slider , images )
    }

    companion object {
        const val ITEM = "ITEM"
        const val CATEGORY_BTN = 3
    }
    lateinit var  item : Item
}
