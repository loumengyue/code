<template>
  <div>
    <br/>
    <el-row>
      <el-form ref="form" :model="newsInfo" label-width="100px">
        <el-col :span="6" :offset="1">
          <el-form-item label="消息标题：">
            <el-input
                clearable
                placeholder="请输入消息标题"
                size="large"
                v-model="newsInfo.newTitle">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="1">
          <el-form-item label="发布人：">
            <el-input
                clearable
                placeholder="请输入发布人"
                size="large"
                v-model="newsInfo.newPerson">
            </el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="2" :offset="19" class="btn-add">
        <el-button type="primary" icon="el-icon-search" size="small" @click="initNewsList">搜索</el-button>
      </el-col>
      <el-col :span="2" class="btn-add">
        <el-button type="primary" size="small"@click="exportExcelSelect">导出Excel</el-button>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="22" :offset="1">
        <el-table
            :data="newsList"
            border
            style="width: 100%">
          <el-table-column
              prop="newId"
              label="消息ID"
              width="100">
          </el-table-column>
          <el-table-column
              prop="newTitle"
              label="消息标题"
              width="120">
          </el-table-column>
          <el-table-column
              prop="newContent"
              label="消息内容">
            <template slot-scope="{ row }">
              <el-tooltip class="item" effect="dark" placement="top">
                <div slot="content">
                  {{ row.newContent.substring(0, 30) }}<br/>
                  {{ row.newContent.substring(30, 60) }}<br/>
                  {{ row.newContent.substring(60, 90) }}<br/>
                  {{ row.newContent.substring(90, 120) }}<br/>
                </div>
                <span>{{ changeNewsContentSize(row.newContent) }}</span>
              </el-tooltip>
            </template>
          </el-table-column>
          <el-table-column
              prop="newTime"
              label="发布时间">
          </el-table-column>
          <el-table-column
              prop="newPerson"
              label="发布人"
              width="180">
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
    <br/>
    <el-row>
      <el-col :span="10" :offset="12">
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page.sync="pageInfo.pageNum"
            :page-size="pageInfo.pageSize"
            layout="total, prev, pager, next, jumper"
            :total="pageInfo.total">
        </el-pagination>
      </el-col>
    </el-row>
    <br/>

    <!--  弹框打印  -->
    <el-dialog title="表格保存预览" width="70%" :visible.sync="selectWindow">
      <el-table :data="selectData" id="selectTable" height="380px">
        <el-table-column prop="newId" label="消息ID" width="100"></el-table-column>
        <el-table-column prop="newTitle" label="消息标题" width="120"></el-table-column>
        <el-table-column prop="newContent" label="消息内容"></el-table-column>
        <el-table-column prop="newTime" label="发布时间"></el-table-column>
        <el-table-column prop="newPerson" label="发布人" width="180"></el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="exportExcel">确定保存</el-button>
      </div>
    </el-dialog>

    <!--  弹框  -->
    <el-dialog title="消息" :visible.sync="newsDialogShow">
      <el-row>
        <el-col :span="21">
          <el-form :model="newsEditTemp">
            <el-form-item label="消息标题" :label-width="'120px'">
              <el-input v-model="newsEditTemp.newTitle" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="消息内容" :label-width="'120px'">
              <el-input type="textarea"  v-model="newsEditTemp.newContent"></el-input>
            </el-form-item>
            <el-form-item label="发布人" :label-width="'120px'">
              <el-input v-model="newsEditTemp.newPerson"></el-input>
            </el-form-item>
            <el-form-item label="是否置顶" :label-width="'120px'">
              <el-select v-model="newsEditTemp.newPriority">
                <el-option label="是" value="1"></el-option>
                <el-option label="否" value="0"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditNews">取 消</el-button>
        <el-button type="primary" @click="ensureNews">确 定</el-button>
      </div>
    </el-dialog>

    <!--  弹框  -->
    <el-dialog title="消息" :visible.sync="newsNewDialogShow">
      <el-row>
        <el-col :span="21">
          <el-form :model="newsNew">
            <el-form-item label="消息标题" :label-width="'120px'">
              <el-input v-model="newsNew.newTitle" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="消息内容" :label-width="'120px'">
              <el-input type="textarea" v-model="newsNew.newContent"></el-input>
            </el-form-item>
            <el-form-item label="发布人" :label-width="'120px'">
              <el-input v-model="newsNew.newPerson"></el-input>
            </el-form-item>
            <el-form-item label="是否置顶" :label-width="'120px'">
              <el-select v-model="newsNew.newPriority">
                <el-option label="是" value="1"></el-option>
                <el-option label="否" value="0"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditNews">取 消</el-button>
        <el-button type="primary" @click="ensureAddNews">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {addOneNews,selectNewsPage,ensureDeleteNews,updateByNews} from '@/api/news'
import htmlToExcel from "@/utils/htmlToExcel";

export default {
  name: "NewsManage",
  data() {
    return {
      newsList: [],
      pageInfo: {
        total: 0,
        pageNum: 1,
        pageSize: 10
      },
      newsInfo: {
        newId: '',
        newTitle: '',
        newContent: '',
        newTime: '',
        newPerson: '',
        newPriority: ''
      },
      newsEditTemp: {
        newId: '',
        newTitle: '',
        newContent: '',
        newTime: '',
        newPerson: '',
        newPriority: ''
      },
      newsNew: {
        newId: '',
        newTitle: '',
        newContent: '',
        newTime: '',
        newPerson: '',
        newPriority: ''
      },
      newsDialogShow: false,
      newsNewDialogShow: false,
      selectData:[],
      selectWindow:false,
    }
  },
  created() {
    this.initNewsList();
    this.getNewsList();
  },
  methods: {
    //打印
    exportExcel() {
      htmlToExcel.getExcel('#selectTable','通知通告信息')
    },
     exportExcelSelect(){
      this.selectWindow = true;
    },
    async getNewsList(){
      const { data: res } = await this.$http.post("getNewsList");
      console.log(res);
      this.selectData=res.data.newsList;// 将返回数据赋值
    },

    //初始化数据
    initNewsList() {
      let condition = Object.assign({}, this.newsInfo)
      let newsPageArgs = {
        condition,
        pageNum: this.pageInfo.pageNum,
        pageSize: this.pageInfo.pageSize
      }
      selectNewsPage(newsPageArgs).then(res => {
        if (res.data.code === "SUCCESS") {
          this.newsList = res.data.data.list
          this.pageInfo.pageNum = res.data.data.pageNum
          this.pageInfo.total = res.data.data.total
        } else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })

    },
    search(){
      this.pageInfo.pageNum = 1
      this.pageInfo.pageSize = 20
      this.initNewsList()
    },
    //处理每页条数改变事件
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageInfo.pageSize = val
      this.initNewsList()
    },
    //处理当前页改变事件
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageInfo.pageNum = val
      this.initNewsList()
    },
    //修改村委信息
    editNews(news) {
      this.newsEditTemp = Object.assign({}, news)
      this.newsDialogShow = true
    },
    //取消修改
    cancelEditNews() {
      this.newsEditTemp = {
        newId: '',
        newTitle: '',
        newContent: '',
        newTime: '',
        newPerson: '',
        newPriority: ''
      }
      this.newsNew = {
        newId: '',
        newTitle: '',
        newContent: '',
        newTime: '',
        newPerson: '',
        newPriority: ''
      }
      this.newsDialogShow = false
      this.newsNewDialogShow = false
    },
    //确定修改
    ensureNews() {
      updateByNews(this.newsEditTemp).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("修改成功")
          this.initNewsList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
      })
      this.newsDialogShow = false
    },
    deleteNews(news) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        ensureDeleteNews(news.newId).then(res => {
          if (res.data.code === "SUCCESS"){
            this.$message.success("删除成功")
            this.cancelEditNews()
            this.initNewsList()
          }else {
            this.$message.error(res.data.msg)
          }
        }).catch(error => {
          console.log(error)
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    addNews() {
      this.newsNewDialogShow = true
    },
    ensureAddNews(){
      addOneNews(this.newsNew).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("添加成功")
          this.initNewsList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })
      this.newsNewDialogShow = false
    },
    changeNewsContentSize(content){
      if (content.length >= 18){
        console.log()
        return content.substring(0,18)+"……";
      }else {
        return content
      }
    },


  }
}
</script>

<style scoped>
.btn-add {
  margin-bottom: 10px;
  text-align: center;
}


</style>

