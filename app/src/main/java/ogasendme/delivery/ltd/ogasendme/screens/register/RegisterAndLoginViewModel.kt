package ogasendme.delivery.ltd.ogasendme.screens.register

import android.content.Context
import androidx.lifecycle.ViewModel
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.screens.anything.showToastMessage
import ogasendme.delivery.ltd.ogasendme.utils.AppUtils

//@HiltViewModel
class RegisterAndLoginViewModel : ViewModel() {

    fun isEmailValid(email: String, context: Context): Boolean {
        return if (AppUtils.validEmail(email)) {
            true
        } else {
            showToastMessage(context, context.resources.getString(R.string.invalid_email_msg_lbl))
            false
        }
    }

    fun isFullNameValid(fullName: String, context: Context): Boolean {
        return if (AppUtils.validUserInput(fullName)) {
            true
        } else {
            showToastMessage(context, context.resources.getString(R.string.invalid_full_msg_lbl))
            false
        }
    }

    fun isPhoneNumberValid(phone:String, context: Context): Boolean{
        return if (AppUtils.validPhoneNumber(phone)) {
            true
        } else {
            showToastMessage(context, context.resources.getString(R.string.invalid_phone_msg_lbl))
            false
        }
    }

}