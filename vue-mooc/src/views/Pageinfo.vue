<template>
    <div>
        <iframe :src="pageUrl" width="100%" :height="windowHeight" frameborder="0" allowfullscreen=""></iframe>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                // 初始化为空组件
                windowHeight: 500,
                //pageUrl: "https://www.taobao.com",
                pageUrl: "/vue/echarts01.html",
            };
        },
        mounted() {
            this.getWindowHeight(); // 在初始化时获取窗口高度

            window.addEventListener('resize', this.getWindowHeight); // 在窗口大小改变时重新获取窗口高度
        },
        beforeDestroy() {
            window.removeEventListener('resize', this.getWindowHeight); // 组件销毁时移除resize事件监听器
        },
        methods: {
            getWindowHeight() {
                this.windowHeight = window.innerHeight - 130;
            }
        }
    };
</script>
<style>
    /* 你的CSS样式 */
</style>
