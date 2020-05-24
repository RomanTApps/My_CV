package tsisyk.app.mycv

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import tsisyk.app.mycv.database.CVDatabase
import tsisyk.app.mycv.network.*
import tsisyk.app.mycv.repository.CvRepository
import tsisyk.app.mycv.repository.CvRepositoryImpl
import tsisyk.app.mycv.ui.info.InfoViewModelFactory

class MyCvAplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy { import(androidModule(this@MyCvAplication))

        bind() from singleton { CVDatabase(instance()) }
        bind() from singleton { instance<CVDatabase>().infoDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { MyMockApiService(instance()) }
        bind<NetWorkDataSource>() with singleton { NetWorkDataSourceImpl(instance()) }
        bind<CvRepository>() with singleton { CvRepositoryImpl(instance(), instance()) }
        bind() from provider { InfoViewModelFactory(instance()) }

    }
}