import service from "@/api/request";

class MemberManager {

    static getAllMemberList(queryMember){
        return service({
            url: '/getAllMember',
            method: 'post',
            data: queryMember
        })
    }

    static updateMember(Member){
        return service({
            url: '/updateMember',
            method: 'post',
            data: Member
        })
    }
    static addMember(Member){
        return service({
            url: '/addMember',
            method: 'post',
            data: Member
        })
    }
    static deleteMember(id){
        return service({
            url: '/deleteMember?id='+id,
            method: 'get'
        })
    }
}



export {
    MemberManager
}