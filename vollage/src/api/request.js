import axios from 'axios'
/**
 * 封装axios请求
 */
// create an axios instance
const service = axios.create({
    baseURL: 'http://127.0.0.1:8080/',//本地请求路径
    timeout: 3600 // request timeout
})

// request 拦截器，
service.interceptors.request.use(
    config => {
        // do something before request is sent
        //TODO: 请求拦截器，如设置Token
        return config
    },
    error => {
        // do something with request error
        console.log(error)
        return Promise.reject(error)
    }
)

// 响应拦截
service.interceptors.response.use(

    response => {
        //TODO: 响应拦截器，可以统一处理返回响应码
        return response
    },
    error => {
        return Promise.reject(error)
    }
)

export default service
