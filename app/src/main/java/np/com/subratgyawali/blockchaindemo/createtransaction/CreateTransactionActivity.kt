package np.com.subratgyawali.blockchaindemo.createtransaction

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.base.BaseActivity
import np.com.subratgyawali.blockchaindemo.databinding.ActivityCreateTransactionsBinding
import np.com.subratgyawali.blockchaindemo.domain.Addresses
import np.com.subratgyawali.blockchaindemo.domain.MyAddress
import np.com.subratgyawali.blockchaindemo.domain.Response
import np.com.subratgyawali.blockchaindemo.domain.TransactionModel
import np.com.subratgyawali.blockchaindemo.main.MainActivity
import javax.inject.Inject


class CreateTransactionActivity : BaseActivity(), CreateTransactionPageContract.View {

    lateinit var dataBinding:ActivityCreateTransactionsBinding

    @Inject
    lateinit var presenter: CreateTransactionPageContract.Presenter

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, CreateTransactionActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_create_transactions)
        title = "Create Transaction"
        presenter.start()
        presenter.getMyAddress()
        dataBinding.button.setOnClickListener {
            var amount = dataBinding.etAmount.text.toString()
            if(amount.isNotEmpty()){
                presenter.createTransaction(TransactionModel(amount = amount.toInt(),
                        recipient = dataBinding.tvRecipient.text.toString(),
                        sender = dataBinding.tvSender.text.toString()))
            }else{
                dataBinding.etAmount.error = "Enter Amount"
            }
        }
    }

    override fun onGetImageSuccess(address: Addresses) {
        if(address.addresses.isEmpty()){
            dataBinding.tvRecipient.text = "No recipient Available"
            dataBinding.button.isEnabled = false
        }
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,address.addresses)
        dataBinding.spinner.adapter = adapter
        dataBinding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

                  }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                dataBinding.tvRecipient.text = String.format(parent?.getItemAtPosition(position).toString())
            }

        }

    }

    override fun onMyAddressSuccess(address: MyAddress) {
        if (address.address.isNotEmpty())
        dataBinding.tvSender.text = String.format(address.address)
    }

    override fun onCreateTransactionSuccess(response: Response) {
        super.onBackPressed()
    }

    override fun errorResponse(response: Throwable) {

    }


}
