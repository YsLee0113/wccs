import {
    createRouter,
    createWebHashHistory
} from "vue-router";
import Home from "../views/Home.vue";

const routes = [{
    path: '/',
    redirect: '/dashboard'
}, {
    path: "/",
    name: "Home",
    component: Home,
    children: [
        {
            path: "/CarouselTable",
            name: "CarouselTable",
            meta: {
                title: '轮播图'
            },
            component: () => import(  "../views/CarouselTable.vue")
        },
        {
            path: "/Pageinfo",
            name: "Pageinfo",
            meta: {
                title: '统计图'
            },
            component: () => import(  "../views/Pageinfo.vue")
        },
        {
            path: "/FilesinfoTable",
            name: "FilesinfoTable",
            meta: {
                title: '附件资料'
            },
            component: () => import(  "../views/FilesinfoTable.vue")
        },


        {
            path: "/dashboard",
            name: "dashboard",
            meta: {
                title: '系统首页'
            },
            component: () => import( /* webpackChunkName: "dashboard" */ "../views/Dashboard.vue")
        }, {
            path: "/UserinfoTable",
            name: "UserinfoTable",
            meta: {
                title: '用户信息'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/UserinfoTable.vue")
        }, {
            path: "/AdmininfoTable",
            name: "AdmininfoTable",
            meta: {
                title: '管理员信息'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/AdmininfoTable.vue")
        }, {
            path: "/SorttypeTable",
            name: "SorttypeTable",
            meta: {
                title: '分类信息'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/SorttypeTable.vue")
        }, {
            path: "/NoticeinfoTable",
            name: "NoticeinfoTable",
            meta: {
                title: '公告信息'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/NoticeinfoTable.vue")
        }, {
            path: "/DatainfoTable",
            name: "DatainfoTable",
            meta: {
                title: '课程信息'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/DatainfoTable.vue")
        }, {
            path: "/HomeworkTable",
            name: "HomeworkTable",
            meta: {
                title: '作业信息'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/HomeworkTable.vue")
        }, {
            path: "/ExaminfoTable",
            name: "ExaminfoTable",
            meta: {
                title: ' 试卷信息'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/ExaminfoTable.vue")
        }, {
            path: "/ScoreinfoTable",
            name: "ScoreinfoTable",
            meta: {
                title: ' 试卷结果信息'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/ScoreinfoTable.vue")
        }, {
            path: "/WorkinfoTable",
            name: "WorkinfoTable",
            meta: {
                title: '任务信息'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/WorkinfoTable.vue")
        }, {
            path: "/SchartA",
            name: "SchartA",
            meta: {
                title: '用户统计'
            },
            component: () => import( /* webpackChunkName: "table" */ "../views/SchartA.vue")
        }, {
            path: "/permission",
            name: "permission",
            meta: {
                title: '权限管理',
                permission: true
            },
            component: () => import( /* webpackChunkName: "permission" */ "../views/Permission.vue")
        }, {
            path: "/i18n",
            name: "i18n",
            meta: {
                title: '国际化语言'
            },
            component: () => import( /* webpackChunkName: "i18n" */ "../views/I18n.vue")
        }, {
            path: '/404',
            name: '404',
            meta: {
                title: '找不到页面'
            },
            component: () => import( /* webpackChunkName: "404" */ '../views/404.vue')
        }, {
            path: '/403',
            name: '403',
            meta: {
                title: '没有权限'
            },
            component: () => import( /* webpackChunkName: "403" */ '../views/403.vue')
        }, {
            path: '/user',
            name: 'user',
            meta: {
                title: '个人中心'
            },
            component: () => import( /* webpackChunkName: "user" */ '../views/User.vue')
        }]
}, {
    path: "/login",
    name: "Login",
    meta: {
        title: '登录'
    },
    component: () => import( /* webpackChunkName: "login" */ "../views/Login.vue")
}];

const router = createRouter({
    history: createWebHashHistory(),
    routes
});

router.beforeEach((to, from, next) => {
    document.title = `${to.meta.title} | vue系统`;
    const role = localStorage.getItem('ms_username');
    if (!role && to.path !== '/login') {
        next('/login');
    } else if (to.meta.permission) {
        // 如果是管理员权限则可进入，这里只是简单的模拟管理员权限而已
        role === 'admin' ?
            next() :
            next('/403');
    } else {
        next();
    }
});

export default router;
