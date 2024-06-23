<template>
    <div class="sidebar">
        <el-menu class="sidebar-el-menu" :default-active="onRoutes" :collapse="collapse" background-color="#324157"
                 text-color="#bfcbd9" active-text-color="#20a0ff" unique-opened router>
            <template v-for="item in items">
                <template v-if="item.subs">
                    <el-submenu :index="item.index" :key="item.index">
                        <template #title>
                            <i :class="item.icon"></i>
                            <span>{{ item.title }}</span>
                        </template>
                        <template v-for="subItem in item.subs">
                            <el-submenu v-if="subItem.subs" :index="subItem.index" :key="subItem.index">
                                <template #title>{{ subItem.title }}</template>
                                <el-menu-item v-for="(threeItem, i) in subItem.subs" :key="i" :index="threeItem.index">
                                    {{ threeItem.title }}
                                </el-menu-item>
                            </el-submenu>
                            <el-menu-item v-else :index="subItem.index" :key="subItem.index">{{ subItem.title }}
                            </el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        <template #title>{{ item.title }}</template>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
    import {
        computed,
        watch
    } from "vue";
    import {
        useStore
    } from "vuex";
    import {
        useRoute
    } from "vue-router";

    export default {
        setup() {
            const items = [{
                icon: "el-icon-lx-home",
                index: "/dashboard",
                title: "系统首页",
            },

                {
                    icon: "el-icon-lx-calendar",
                    index: "1",
                    title: "系统设置管理",
                    subs: [
                        {
                            icon: "el-icon-lx-people",
                            index: "/AdmininfoTable",
                            title: "管理员信息",
                        },
                        {
                            icon: "el-icon-lx-text",
                            index: "/CarouselTable",
                            title: "轮播图信息",
                        },
                        {
                            icon: "el-icon-lx-notification",
                            index: "/NoticeinfoTable",
                            title: "公告信息",
                        },

                    ],
                },

                {
                    icon: "el-icon-lx-text",
                    index: "/FilesinfoTable",
                    title: "附件资料",
                },
                {
                    icon: "el-icon-lx-friend",
                    index: "/UserinfoTable",
                    title: "教师学生",
                },
                {
                    icon: "el-icon-lx-sort",
                    index: "/SorttypeTable",
                    title: "分类信息",
                }, {
                    icon: "el-icon-lx-sort",
                    index: "/HomeworkTable",
                    title: "作业信息",
                },

                {
                    icon: "el-icon-lx-text",
                    index: "/DatainfoTable",
                    title: "课程信息",
                },
                {
                    icon: "el-icon-lx-message",
                    index: "/ExaminfoTable",
                    title: " 试卷信息",
                }, {
                    icon: "el-icon-lx-message",
                    index: "/ScoreinfoTable",
                    title: " 试卷结果",
                }, {
                    icon: "el-icon-lx-message",
                    index: "/WorkinfoTable",
                    title: "任务信息",
                },
                {
                    icon: "el-icon-lx-calendar",
                    index: "3",
                    title: "数据统计",
                    subs: [
                        {
                            index: "/SchartA",
                            title: "学情分析",
                        },
                        {
                            index: "/Pageinfo",
                            title: "成绩分析",
                        },
                        {
                            index: "4",
                            title: "错误页面",
                            subs: [{
                                index: "/404",
                                title: "404页面",
                            }, {
                                index: "/403",
                                title: "403页面",
                            }],
                        },
                    ],
                },
            ];

            const route = useRoute();

            const onRoutes = computed(() => {
                return route.path;
            });

            const store = useStore();
            const collapse = computed(() => store.state.collapse);

            return {
                items,
                onRoutes,
                collapse,
            };
        },
    };
</script>

<style scoped>
    .sidebar {
        display: block;
        position: absolute;
        left: 0;
        top: 70px;
        bottom: 0;
        overflow-y: scroll;
    }

    .sidebar::-webkit-scrollbar {
        width: 0;
    }

    .sidebar-el-menu:not(.el-menu--collapse) {
        width: 250px;
    }

    .sidebar > ul {
        height: 100%;
    }
</style>
