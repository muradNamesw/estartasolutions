package com.estarta.stationery.koin

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.estarta.stationery.data.source.remote.ApiServiceFactory
import com.estarta.stationery.data.source.remote.ContextProviders
import com.estarta.stationery.utils.PreferenceStorage
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module


val appModule: Module = module {

    single { ApiServiceFactory.getService() }//ApiService
    single { ContextProviders.getInstance() }//ContextProviders
//    single {
//        Room.databaseBuilder(
//            androidContext(),
//            GambiaDatabase::class.java, "gambia-database"
//        ).allowMainThreadQueries()
//            .addMigrations(
//                MIGRATION_1_2,
//                MIGRATION_2_3,
//                MIGRATION_3_4,
//                MIGRATION_4_5,
//                MIGRATION_5_6,
//                MIGRATION_6_7,
//                MIGRATION_7_8,
//                MIGRATION_8_9,
//                MIGRATION_9_10,
//                MIGRATION_10_11,
//                MIGRATION_11_12,
//                MIGRATION_12_13,
//                MIGRATION_13_14,
//                MIGRATION_14_15
//            ).build()
//    }
    single { PreferenceStorage(androidContext()) }
}

//for every migration provide a migration object
// with the changes happened on db Scheme and increase version number
val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Since we didn't alter the table, there's nothing else to do here.
    }
}
//val MIGRATION_2_3 = object : Migration(2, 3) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE transactions_table ADD COLUMN invoice_ref TEXT")
//    }
//}
//val MIGRATION_3_4 = object : Migration(3, 4) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL(
//            "CREATE TABLE `type_table` (`id` INTEGER, " +
//                    "`name` TEXT" +
//                    ", `display_name` TEXT" +
//                    ", `classification` TEXT" +
//                    ", `create_date` TEXT" +
//                    ", `write_date` TEXT" +
//                    ", `__last_update` TEXT" +
//                    ", PRIMARY KEY(`id`))"
//        )
//    }
//}
//
//val MIGRATION_4_5 = object : Migration(4, 5) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE transactions_table ADD COLUMN quantity INTEGER NOT NULL DEFAULT 0")
//    }
//}
//
//val MIGRATION_5_6 = object : Migration(5, 6) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("CREATE TABLE `last_update_tabel` (`id` INTEGER,`name` TEXT,`last_update_date` TEXT,PRIMARY KEY(`id`))")
//        database.execSQL(
//            "CREATE TABLE `partner_table` (`id` INTEGER,`name` TEXT,`display_name` TEXT,`national_id` TEXT,`mobile` TEXT, PRIMARY KEY(`id`))"
//        )
//        database.execSQL(
//            "CREATE TABLE `search_item_table` (`id` INTEGER, " +
//                    "`name` TEXT" +
//                    ", `state` TEXT" +
//                    ", `reference_number` TEXT" +
//                    ", `classification_id` TEXT" +
//                    ", `address_location_id` TEXT" +
//                    ", `partner_id` TEXT" +
//                    ", `tax_value` TEXT" +
//                    ", `partner_nat_id` TEXT" +
//                    ", `partner_contact_number` TEXT" +
//                    ", `address` TEXT" +
//                    ", `latitude` DOUBLE" +
//                    ", `longitude` DOUBLE" +
//                    ", `dynamic_label` TEXT" +
//                    ", `value` TEXT" +
//                    ", `type` TEXT" +
//                    ", `last_payment` TEXT" +
//                    ", `expiry_date` TEXT" +
//                    ", `display_name` TEXT" +
//                    ", `area` TEXT" +
//                    ", `item_type` TEXT" +
//                    ", PRIMARY KEY(`id`))"
//        )
//    }
//}
//
//val MIGRATION_6_7 = object : Migration(6, 7) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE partner_table ADD COLUMN email TEXT")
//    }
//}
//val MIGRATION_7_8 = object : Migration(7, 8) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE search_item_table ADD COLUMN updated INTEGER NOT NULL DEFAULT 1")
//    }
//}
//val MIGRATION_8_9 = object : Migration(8, 9) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE partner_table ADD COLUMN updated INTEGER NOT NULL DEFAULT 1")
//    }
//}
//val MIGRATION_9_10 = object : Migration(9, 10) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("CREATE TABLE `attachment_item_table` (`id` INTEGER,`type` TEXT,`item_id` INTEGER, `file` BLOB, `label` TEXT, `updated` INTEGER ,PRIMARY KEY(`id`))")
//    }
//}
//val MIGRATION_10_11 = object : Migration(10, 11) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE search_item_table ADD COLUMN server_id INTEGER")
//    }
//}
//
//val MIGRATION_11_12 = object : Migration(11, 12) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE search_item_table ADD COLUMN active INTEGER")
//        database.execSQL("ALTER TABLE partner_table ADD COLUMN server_id INTEGER")
//
//        database.execSQL(
//            "CREATE TABLE `market_item_table` (`id` DOUBLE, " +
//                    "`name` TEXT" +
//                    ", `state` TEXT" +
//                    ", `reference_number` TEXT" +
//                    ", `classification_id` TEXT" +
//                    ", `address_location_id` TEXT" +
//                    ", `partner_id` TEXT" +
//                    ", `tax_value` TEXT" +
//                    ", `partner_nat_id` TEXT" +
//                    ", `partner_contact_number` TEXT" +
//                    ", `address` TEXT" +
//                    ", `latitude` DOUBLE" +
//                    ", `longitude` DOUBLE" +
//                    ", `dynamic_label` TEXT" +
//                    ", `value` TEXT" +
//                    ", `type` TEXT" +
//                    ", `last_payment` TEXT" +
//                    ", `expiry_date` TEXT" +
//                    ", `display_name` TEXT" +
//                    ", `area` TEXT" +
//                    ", `item_type` TEXT" +
//                    ", `server_id` INTEGER" +
//                    ", `active` INTEGER" +
//                    ", PRIMARY KEY(`id`))"
//        )
//        database.execSQL(
//            "CREATE TABLE `license_item_table` (`id` DOUBLE, " +
//                    "`name` TEXT" +
//                    ", `state` TEXT" +
//                    ", `reference_number` TEXT" +
//                    ", `classification_id` TEXT" +
//                    ", `address_location_id` TEXT" +
//                    ", `partner_id` TEXT" +
//                    ", `tax_value` TEXT" +
//                    ", `partner_nat_id` TEXT" +
//                    ", `partner_contact_number` TEXT" +
//                    ", `address` TEXT" +
//                    ", `latitude` DOUBLE" +
//                    ", `longitude` DOUBLE" +
//                    ", `dynamic_label` TEXT" +
//                    ", `value` TEXT" +
//                    ", `type` TEXT" +
//                    ", `last_payment` TEXT" +
//                    ", `expiry_date` TEXT" +
//                    ", `display_name` TEXT" +
//                    ", `area` TEXT" +
//                    ", `item_type` TEXT" +
//                    ", `server_id` INTEGER" +
//                    ", `active` INTEGER" +
//                    ", PRIMARY KEY(`id`))"
//        )
//        database.execSQL(
//            "CREATE TABLE `property_item_table` (`id` DOUBLE, " +
//                    "`name` TEXT" +
//                    ", `state` TEXT" +
//                    ", `reference_number` TEXT" +
//                    ", `classification_id` TEXT" +
//                    ", `address_location_id` TEXT" +
//                    ", `partner_id` TEXT" +
//                    ", `tax_value` TEXT" +
//                    ", `partner_nat_id` TEXT" +
//                    ", `partner_contact_number` TEXT" +
//                    ", `address` TEXT" +
//                    ", `latitude` DOUBLE" +
//                    ", `longitude` DOUBLE" +
//                    ", `dynamic_label` TEXT" +
//                    ", `value` TEXT" +
//                    ", `type` TEXT" +
//                    ", `last_payment` TEXT" +
//                    ", `expiry_date` TEXT" +
//                    ", `display_name` TEXT" +
//                    ", `area` TEXT" +
//                    ", `item_type` TEXT" +
//                    ", `server_id` INTEGER" +
//                    ", `active` INTEGER" +
//                    ", PRIMARY KEY(`id`))"
//        )
//    }
//}
//val MIGRATION_12_13 = object : Migration(12, 13) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL(
//            "CREATE TABLE `transaction_receipt_table` (`id` INTEGER, " +
//                    "`type` TEXT" +
//                    ", `item_id` TEXT" +
//                    ", `collect_type` TEXT" +
//                    ", `longitude` TEXT" +
//                    ", `latitude` TEXT" +
//                    ", `creation_date` TEXT" +
//                    ", `tax_value` TEXT" +
//                    ", `user_id` TEXT" +
//                    ", `server_id` INTEGER" +
//                    ", `invoice_number` TEXT" +
//                    ", PRIMARY KEY(`id`))"
//        )
//    }
//}
//val MIGRATION_13_14 = object : Migration(13, 14) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL(
//            "CREATE TABLE `ad_hoc_transaction_table` (`id` INTEGER, " +
//                    "`service_id` INTEGER" + //-
//                    "`service_name` TEXT" +
//                    ", `latitude` DOUBLE" + //-
//                    ", `longitude` DOUBLE" + //-
//                    ", `total_tax` DOUBLE" + //-
//                    ", `classification_id` INTEGER" + //-
//                    ", `classification_name` TEXT" +
//                    ", `location_id` INTEGER" + //-
//                    ", `location_name` TEXT" +
//                    ", `customer` INTEGER" + //-
//                    ", `customer_name` TEXT" +
//                    ", `owner_phone` TEXT" +
//                    ", `creation_date` INTEGER" +
//                    ", `user_id` INTEGER" + //-
//                    ", `calcs` TEXT" +//-
//                    ", `invoice_ref` TEXT" +//-
//                    ", `updated` INTEGER" +
//                    ", `adhoc_id` INTEGER" +
//                    ", PRIMARY KEY(`id`))"
//        )
//
//        database.execSQL(
//            "CREATE TABLE `adhoc_calc_table` (`id` INTEGER, " +
//                    "`name` TEXT" +
//                    ", `calc_dynamic_label` TEXT" +
//                    ", `calc_name` TEXT" +
//                    ", `calc_type` TEXT" +
//                    ", `calc_id` INTEGER" +
//                    ", `calc_value` INTEGER" +
//                    ", `service_id` INTEGER" +
//                    ", `type_id` INTEGER" +
//                    ", PRIMARY KEY(`id`))"
//        )
//        database.execSQL(
//            "CREATE TABLE `adhoc_service_table` (`service_name` TEXT" +
//                     ", `service_id` INTEGER" +
//                     ", PRIMARY KEY(`service_id`))"
//        )
//        database.execSQL(
//            "CREATE TABLE `adhoc_type_table` (`type_name` TEXT" +
//                    ", `service_id` INTEGER" +
//                    ", `type_id` INTEGER" +
//                    ", PRIMARY KEY(`type_id`))"
//        )
//    }
//}
//val MIGRATION_14_15 = object : Migration(14,15) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        //items_table
////        @PrimaryKey(autoGenerate = true) var id: Int? = 0,
////        var name: String? = null,
////        var phone: String? = null,
////        var transaction_id: Int? = null,
////        var invoice_number: Long? = null
//        // Create the new table
//        database.execSQL(
//            "CREATE TABLE items_new (id INTEGER, name TEXT, phone TEXT, transaction_id INTEGER, invoice_number INTEGER, PRIMARY KEY(id))"
//        );
//// Copy the data
//        database.execSQL(
//            "INSERT INTO items_new (id, name, phone, transaction_id, invoice_number) SELECT id, name, phone, transaction_id, invoice_number FROM items_table"
//        );
//// Remove the old table
//        database.execSQL("DROP TABLE items_table");
//// Change the table name to the correct one
//        database.execSQL("ALTER TABLE items_new RENAME TO items_table");
//    }



