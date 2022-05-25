import service from '@/api/request'

class HouseManager {

    static getAllHouseList(queryHouse){
        return service({
            url: '/getAllHouse',
            method: 'post',
            data: queryHouse
        })
    }
    static getMyAllHouseList(queryHelper){
        return service({
            url: '/getMyAllHouse',
            method: 'post',
            data: queryHelper
        })
    }
    static getMyHouseList(id){
        return service({
            url: '/getMyHouseList?id='+id,
            method: 'post',
        })
    }
    static updateHouse(House){
        return service({
            url: '/updateHouse',
            method: 'post',
            data: House
        })
    }
    static addHouse(House){
        return service({
            url: '/addHouse',
            method: 'post',
            data: House
        })
    }
    static deleteHouse(HouseId){
        return service({
            url: '/deleteHouse?id='+HouseId,
            method: 'get'
        })
    }
}



export {
    HouseManager
}
