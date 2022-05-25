import service from "@/api/request";

class PartyManager {

    static getAllPartyList(queryParty){
        return service({
            url: '/getAllParty',
            method: 'post',
            data: queryParty
        })
    }

    static updateParty(Party){
        return service({
            url: '/updateParty',
            method: 'post',
            data: Party
        })
    }
    static addParty(Party){
        return service({
            url: '/addParty',
            method: 'post',
            data: Party
        })
    }
    static deleteParty(id){
        return service({
            url: '/deleteParty?id='+id,
            method: 'get'
        })
    }
}



export {
    PartyManager
}