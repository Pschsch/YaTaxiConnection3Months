package ru.pschsch.pschschapps.yataxiconnection3months.DaggerClasses;

import dagger.Module;
import dagger.Provides;
import ru.pschsch.pschschapps.yataxiconnection3months.Model.DriverModel;
import ru.pschsch.pschschapps.yataxiconnection3months.Model.FirebaseDBHelper;
import ru.pschsch.pschschapps.yataxiconnection3months.Model.RealmModel;
import ru.pschsch.pschschapps.yataxiconnection3months.Presenter.YaTaxiConPresenter;

@Module
public class DependencyModule {
    @Provides
    FirebaseDBHelper provideFBHelper(){
        return new FirebaseDBHelper();
    }
    @Provides
    DriverModel provideDriverModel() { return new DriverModel(); }
    @Provides
    RealmModel provideRealmModel() { return new RealmModel();}
}
