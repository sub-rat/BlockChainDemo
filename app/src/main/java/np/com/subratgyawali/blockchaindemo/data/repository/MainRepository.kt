package np.com.subratgyawali.blockchaindemo.data.repository

import io.reactivex.Observable
import np.com.subratgyawali.blockchaindemo.domain.CurrentTransaction

interface MainRepository {
    fun getCurrentTransaction(): Observable<CurrentTransaction>
}