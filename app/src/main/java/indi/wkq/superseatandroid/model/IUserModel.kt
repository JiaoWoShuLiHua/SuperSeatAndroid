package indi.wkq.superseatandroid.model

import indi.wkq.superseatandroid.fragment.LoginFragment
import indi.wkq.superseatandroid.fragment.MeFragment
import indi.wkq.superseatandroid.presenter.impl.UserPresenterImpl

/**
 * @author  calesq
 * @date    2021/4/29
 *
 * 用户数据层接口
 */
interface IUserModel {
    fun login(username : String, password : String, upi : UserPresenterImpl, l : LoginFragment)

    fun getUserInfo(token : String, upi : UserPresenterImpl, m : MeFragment)
}