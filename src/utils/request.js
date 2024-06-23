import axios from 'axios';
import {
	ElMessage,
	ElMessageBox
} from "element-plus";

//项目请求根路径
const baseURL = "http://localhost:8088/study_system/";
// 请求配置
const service = axios.create({
	// process.env.NODE_ENV === 'development' 来判断是否开发环境
	// easy-mock服务挂了，暂时不使用了
	// baseURL: 'https://www.easy-mock.com/mock/592501a391470c0ac1fab128',
	baseURL: baseURL,
	timeout: 5000
});

service.interceptors.request.use(
	config => {
		return config;
	},
	error => {
		console.log(error);
		return Promise.reject();
	}
);


// 请求拦截 可以用于判断登录
/*http.interceptors.request.use(config => {
	//请求头设置
	let token = localStorage.getItem('token') || ''
	config.headers.Authorization = token
	return config
}, err => {
	console.log(err);
});*/


// 响应拦截器
service.interceptors.response.use(
	// 通过状态码判断请求状态
	response => {
		if (response.status === 200) {
			return response.data;

			//自定义状态码判断操作结果
			/*if(response.data.status=== 200){
				return response.data;
			}else{
				ElMessage.error(response.data.msg || '操作失败');
				Promise.reject();
			}*/
		} else {
			ElMessage.error(response.data.msg || '操作失败');
			Promise.reject();
		}
	},
	error => {
		ElMessage.error('系统异常，请检查服务端是否启动');
		return Promise.reject();
	}
)

/*
service.interceptors.response.use(
    response => {
        if (response.status === 200) {
            return response.data;
        } else {
            Promise.reject();
        }
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);*/

export  {
	baseURL
};
export default service;
