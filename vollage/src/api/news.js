import service from '@/api/request'


/**
 * 添加消息
 * @returns
 */
export function addOneNews(news) {
    return service({
        url: '/addNews',
        method: 'post',
        data: news
    })
}

/**
 * 分页查询消息
 * @returns
 */
export function selectNewsPage(condition) {
    return service({
        url: '/getAllNews',
        method: 'post',
        data: condition
    })
}

/**
 * 更新消息
 * @returns
 */
export function updateByNews(news) {
    return service({
        url: '/updateNews',
        method: 'post',
        data: news
    })
}

/**
 * 删除消息
 * @returns
 */
export function ensureDeleteNews(id) {
    return service({
        url: '/deleteNews',
        method: 'get',
        params: {
            id
        }
    })
}

