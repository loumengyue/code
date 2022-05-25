import service from "@/api/request";

class HelperManager {

    static getAllHelperList(queryHelper){
        return service({
            url: '/getAllHelper',
            method: 'post',
            data: queryHelper
        })
    }
    static getMyHelperList(id){
        return service({
            url: '/getMyHelperList?id='+id,
            method: 'post',
        })
    }
    static getMyAllHelperList(queryHelper){
        return service({
            url: '/getMyAllHelper',
            method: 'post',
            data: queryHelper
        })
    }

    static updateHelper(helper){
        return service({
            url: '/updateHelper',
            method: 'post',
            data: helper
        })
    }
    static addHelper(helper){
        return service({
            url: '/addHelper',
            method: 'post',
            data: helper
        })
    }
    static deleteHelper(id){
        return service({
            url: '/deleteHelper?id='+id,
            method: 'get'
        })
    }
}



export {
    HelperManager
}