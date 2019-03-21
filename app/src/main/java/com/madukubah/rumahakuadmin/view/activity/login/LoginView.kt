package com.madukubah.rumahakuadmin.view.activity.login

import com.madukubah.rumahakuadmin.config.base.BasePresenter
import com.madukubah.rumahakuadmin.config.base.BaseView
import com.madukubah.rumahakuadmin.model.User
import com.madukubah.rumahakuadmin.model.response.UserResponse

interface LoginView
{
    interface Presenter : BasePresenter
    {
        fun postData( username : String, password : String )
        fun onPostSuccess( response: UserResponse? )

    }

    interface MView : BaseView<Presenter>
    {
        fun showMessage( status : Int? ,message : String?, user : User? )
    }
}