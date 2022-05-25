import service from "@/api/request";


export function getOrganByName(organ){
    return service({
        url: '/getOrganByName',
        method: 'post',
        data: organ
    })
}

class OrganManager {

    static getAllOrganList(queryOrgan){
        return service({
            url: '/getAllOrgan',
            method: 'post',
            data: queryOrgan
        })
    }

    static updateOrgan(organ){
        return service({
            url: '/updateOrgan',
            method: 'post',
            data: organ
        })
    }
    static addOrgan(organ){
        return service({
            url: '/addOrgan',
            method: 'post',
            data: organ
        })
    }
    static deleteOrgan(id){
        return service({
            url: '/deleteOrgan',
            method: 'get',
            params: {
                id
            }
        })
    }
}



export {
    OrganManager
}