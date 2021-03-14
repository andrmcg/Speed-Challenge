package com.example.androiddevchallenge



val favouriteCollectionImageResources = listOf<Asset>(Asset(R.drawable.short_mantras,"Short mantras"),Asset(R.drawable.nature_meditations,"Nature meditations"),
    Asset(R.drawable.stress_and_anxiety,"Stress and anxiety"),Asset(R.drawable.self_massage,"Self massage"),
    Asset(R.drawable.overwhelmed,"Overwhelmed"),Asset(R.drawable.nightly_wind_down,"Nightly wind down"))
val alignYourBodyImageResources = listOf<Asset>(Asset(R.drawable.inversions,"Inversions"),Asset(R.drawable.quick_yoga,"Quick yoga"),Asset(R.drawable.stretching,"Stretching"),
    Asset(R.drawable.tabata,"Tabata"),Asset(R.drawable.hiit,"Hiit"),Asset(R.drawable.pre_natal_yoga,"Pre natal yoga"))
val alignYourMindImageResources = listOf<Asset>(Asset(R.drawable.meditate,"Meditate"),Asset(R.drawable.with_kids,"With kids"),Asset(R.drawable.aromatherapy,"Aromatherapy"),
    Asset(R.drawable.on_the_go,"On The Go"),Asset(R.drawable.with_pets,"With pets"),Asset(R.drawable.high_stress,"High stress"))

data class Asset(val imageResource:Int, val imageName:String)