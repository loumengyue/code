import service from "@/api/request";


export function getAllPopulation(name){
    return service({
        url: '/getPopulationByName',
        method: 'get',
        params: {
            name
        }
    })
}

export function getMyPopulationList(id){
    return service({
        url: '/getMyPopulationList?id='+id,
        method: 'post',
        params: {
            id
        }
    })
}



class PopulationManager {

    static getAllPopulationList(queryPopulation){
        return service({
            url: '/getAllPopulation',
            method: 'post',
            data: queryPopulation
        })
    }
    static getMyAllPopulation(queryPopulation){
        return service({
            url: '/getMyAllPopulation',
            method: 'post',
            data: queryPopulation
        })
    }

    static updatePopulation(population){
        return service({
            url: '/updatePopulation',
            method: 'post',
            data: population
        })
    }
    static addPopulation(population){
        return service({
            url: '/addPopulation',
            method: 'post',
            data: population
        })
    }
    static deletePopulation(id){
        return service({
            url: '/deletePopulation?id='+id,
            method: 'get'
        })
    }
}



export {
    PopulationManager
}