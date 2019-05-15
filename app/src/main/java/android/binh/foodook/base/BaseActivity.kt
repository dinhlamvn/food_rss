package android.binh.foodook.base

import android.binh.foodook.commons.Commons
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.kaopiz.kprogresshud.KProgressHUD

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_SEE_COOK_DETAIL : Int = 1001
    }
    private var mProgress : KProgressHUD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
    }

    abstract fun getLayoutResource() : Int

    fun showProgress(message : String) {
        mProgress = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(message)
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);
        if (!isFinishing) mProgress!!.show()
    }

    fun dismissProgress() {
        if (isFinishing) return
        if (Commons.isNotNull(mProgress) && mProgress!!.isShowing) {
            mProgress!!.dismiss()
            mProgress = null
        }
    }
}