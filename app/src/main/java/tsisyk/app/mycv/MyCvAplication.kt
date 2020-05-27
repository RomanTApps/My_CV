package tsisyk.app.mycv

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.generic.*
import tsisyk.app.mycv.database.MyCvDatabase
import tsisyk.app.mycv.network.*
import tsisyk.app.mycv.repository.MyCvRepository
import tsisyk.app.mycv.repository.MyCvRepositoryImpl
import tsisyk.app.mycv.ui.experience.detailes.CompanyDescriptionViewModelFactory
import tsisyk.app.mycv.ui.experience.list.CompanyListViewModelFactory
import tsisyk.app.mycv.ui.info.InfoViewModelFactory

class MyCvAplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidModule(this@MyCvAplication))

        bind() from singleton { MyCvDatabase(instance()) }
        bind() from singleton { instance<MyCvDatabase>().infoDao() }
        bind() from singleton { instance<MyCvDatabase>().workExperienceDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { MyMockApiService(instance()) }
        bind<NetWorkDataSource>() with singleton { NetWorkDataSourceImpl(instance()) }
        bind<MyCvRepository>() with singleton {
            MyCvRepositoryImpl(
                instance(),
                instance(),
                instance()
            )
        }
        bind() from provider { InfoViewModelFactory(instance()) }
        bind() from provider { CompanyListViewModelFactory(instance()) }
//        bind() from provider { JobDescriptionViewModelFactory(instance()) }
        bind() from factory { firmName: String -> CompanyDescriptionViewModelFactory( instance(), firmName) }

    }
}