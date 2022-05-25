import service from '@/api/request'


/**
 * 添加文件
 * @returns
 */
export function addOneFile(file) {
    return service({
        url: '/addFile',
        method: 'post',
        data: file
    })
}

/**
 * 分页查询文件
 * @returns
 */
export function findFilePage(condition) {
    return service({
        url: '/getAllFiles',
        method: 'post',
        data: condition
    })
}

/**
 * 更新文件信息
 * @returns
 */
export function updateByFile(file) {
    return service({
        url: '/updateFile',
        method: 'post',
        data: file
    })
}

/**
 * 删除文件
 * @returns
 */
export function ensureDeleteFile(id) {
    return service({
        url: '/deleteFile',
        method: 'get',
        params: {
            id
        }
    })
}

