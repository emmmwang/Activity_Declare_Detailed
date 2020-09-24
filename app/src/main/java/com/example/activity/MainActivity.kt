package com.example.activity











import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 1.手机开机到应用程序----->缩略图标被点击的流程
 * 2.点击图标-> 启动ActivityThread->线程的入口点main函数->创建ActivityThread
 * ->创建仪表类对象 管理程序的生命周期 mInstrumentation = new Instrumentation();
 * 创建上下文Context ContextImpl context = ContextImpl.createAppContext{
 * getSystemCotext().mPackageInfo);
 * ->创建应用程序 mInitialApplication = context. mPackageInfo.makeApplication(true,null）；
 *      ->app=mActivityThread.mInstrumentation.newApplication(cl,appClass,appContext);
 * ->毁掉application的onCreate方法 instrumentation.callApplicationOnCreate(app)
 *
 * 3.启动Activity额流程：ActivityThread
 * ->handleLaunchActivity->performActivity
 * ->创建Activity上下文  createBaseContextForActivity
 * ->床创建启动的页面 activity=mInstrumentation.newActivity(cl,component.getClassName(),r.intent;
 * ->将界面和window绑定activity.attach(appContext,window)
 * ->调用onCreate方法布局activity界面 mInstrumentation.callActivityOonCreate(activity,r.state);
 * ->activity.performCreate(icicle);
 * ->onCreate(icicle);
 * 在Activity子类中 通过实现onCreate方法 来对界面进行初始化（UI布局，逻辑初始化）
 *

 *
 */

/**
 * 什么是Context 上下文
 * Application Activity Service 有上下文 运行环境
 *  Context提供了访问系统资源的方法  可以理解为就是一个桥梁 设备<->Context<->界面
 *
 * Activity的context和applicationContext的区别
 * 大多数情况下可以相互使用
 * 如果涉及界面跳转的时候 尽量使用activity的context 提供了默认的任务栈
 * applicationContext没有提供任务栈
 *
 *
 * Activity就是一个独立的界面    AppCompatActivity
 * 实现页面之间的跳转
 *      1.显示跳转： 同一个应用  不同界面之间的跳转  明确指定从哪个页面跳转到哪个页面
 *      2.隐式跳转： 不同应用之间  进行界面跳转（微信支付页面->淘宝页面）
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            //明确指定从当前界面跳转到 MyApplication界面
            val intent= Intent(this,MyApplication::class.java)

            //启动跳转
            startActivity(intent)
        }
        getDrawable(R.drawable.ic_launcher_background)
    }
}





















