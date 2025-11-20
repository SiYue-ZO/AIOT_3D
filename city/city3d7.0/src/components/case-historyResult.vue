<template>
  <div v-show="isTableShow">
    <el-table :data="tableData" stripe style="width: 100%;color:#fff">
      <el-table-column prop="name" label="处理人员" width="80"></el-table-column>
      <el-table-column prop="date" label="处理时间" width="100"></el-table-column>
      <el-table-column prop="caseState" label="案件状态"></el-table-column>
      <el-table-column prop="caseResult" label="处理意见"></el-table-column>
    </el-table>
  </div>
</template>

<script>
  export default {
    name: "case-historyResult",
    data() {
      return {
        isTableShow: true,
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          caseState: '已接受案件',
          caseResult: '请及时处理'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          caseState: '案件处理中',
          caseResult: '案件处理中'
        }, {
          date: '2016-05-05',
          name: '王小虎',
          caseState: '已处理完成案件',
          caseResult: '案件处理已完成，请及时结案'
        }]
      }
    },
    methods: {},
    mounted() {
      //案件处理历史记录
    }
  }
</script>

<style scoped>

</style>
