import service from '@/api/request'


/**
 * 添加村委信息
 * @returns
 */
export function addOneVillage(village) {
    return service({
        url: '/addVillage',
        method: 'post',
        data: village
    })
}

/**
 * 分页查询村委信息
 * @returns
 */
export function selectVillagePage(condition) {
    return service({
        url: '/getAllVillage',
        method: 'post',
        data: condition
    })
}


/**
 * 更新村委信息
 * @returns
 */
export function updateByVillage(village) {
    return service({
        url: '/updateVillage',
        method: 'post',
        data: village
    })
}

/**
 * 删除村委信息
 * @returns
 */
export function ensureDeleteVillage(id) {
    return service({
        url: '/deleteVillage',
        method: 'get',
        params: {
            id
        }
    })
}

/**
 * 更新村委信息
 * @returns
 */
export function getAllVillage(village) {
    return service({
        url: '/getAll',
        method: 'post',
        data: village
    })
}

