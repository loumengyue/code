import service from '@/api/request'


/**
 * 添加村委信息
 * @returns
 */
export function addOneActivity(activity) {
    return service({
        url: '/addActivity',
        method: 'post',
        data: activity
    })
}

/**
 * 分页查询村委信息
 * @returns
 */
export function selectActivityPage(condition) {
    return service({
        url: '/getAllActivity',
        method: 'post',
        data: condition
    })
}

/**
 * 分页查询村委信息
 * @returns
 */
export function selectByCondition(condition) {
    return service({
        url: '/selectByCondition',
        method: 'post',
        data: condition
    })
}

/**
 * 更新村委信息
 * @returns
 */
export function updateByActivity(activity) {
    return service({
        url: '/updateActivity',
        method: 'post',
        data: activity
    })
}

/**
 * 删除村委信息
 * @returns
 */
export function ensureDeleteActivity(id) {
    return service({
        url: '/deleteActivity',
        method: 'get',
        params: {
            id
        }
    })
}

