package com.example.activity

import android.app.Application

//必须在manifests文件中配置一下
//系统才知道在创建的时候 是MyApplication还是系统的Application
class MyApplication: Application() {
    override fun onCreate() {
        /**
         * 当重写福尔利的方法是 是否需要调用父类的方法
         * 1.如果父类实现是空的 通常不需要调用
         * 2.如果父类有实现  通常需要使用super调用一线父类的方法
         */
        super.onCreate()

        println("emmmm")
    }
}