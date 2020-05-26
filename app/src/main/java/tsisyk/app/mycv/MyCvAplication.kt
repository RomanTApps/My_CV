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
import tsisyk.app.mycv.repository.MyCvRepository
import tsisyk.app.mycv.repository.MyCvRepositoryImpl
import tsisyk.app.mycv.ui.experience.description.JobDescriptionViewModelFactory
import tsisyk.app.mycv.ui.experience.list.FirmListViewModelFactory
import tsisyk.app.mycv.ui.info.InfoViewModelFactory

class MyCvAplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy { import(androidModule(this@MyCvAplication))

        bind() from singleton { CVDatabase(instance()) }
        bind() from singleton { instance<CVDatabase>().infoDao() }
        bind() from singleton { instance<CVDatabase>().workExperienceDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { MyMockApiService(instance()) }
        bind<NetWorkDataSource>() with singleton { NetWorkDataSourceImpl(instance()) }
        bind<MyCvRepository>() with singleton { MyCvRepositoryImpl(instance(), instance(), instance()) }
        bind() from provider { InfoViewModelFactory(instance()) }
        bind() from provider { FirmListViewModelFactory(instance()) }
        bind() from provider { JobDescriptionViewModelFactory(instance()) }

    }
}