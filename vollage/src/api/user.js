import service from '@/api/request'


/**
 * 登录
 * @returns
 */
export function login(username,password) {
    return service({
        url: '/login',
        method: 'post',
        data: {
            username,
            password
        }
    })
}



/**
 * 查询所有的角色
 * @returns
 */
export function getRoleList() {
    return service({
        url: '/getAllRole',
        method: 'post',
    })
}

class UserManager {

    static getAllUserList(queryUser){
        return service({
            url: '/getAllUser',
            method: 'post',
            data: queryUser
        })
    }

   static getUserByName(user){
        return service({
            url: '/getUserByName',
            method: 'post',
            data: user

        })
    }
    static updateUser(user){
        return service({
            url: '/updateUser',
            method: 'post',
            data: user
        })
    }
    static addUser(user){
        return service({
            url: '/addUser',
            method: 'post',
            data: user
        })
    }
    static deleteUser(userId){
        return service({
            url: '/deleteUser?id='+userId,
            method: 'get'
        })
    }
}



export {
    UserManager
}
