import vue from '@vitejs/plugin-vue'

export default {
    base: './',
	server: {                // ← ← ← ← ← ←
	    host: '0.0.0.0'    ,// ← 新增内容 ←
	},
    plugins: [vue()],
    optimizeDeps: {
        include: ['schart.js']
    }
}