 <template>
 <div>
 <el-button-group>
 <el-button type="primary" icon="el-icon-arrow-left" size="mini" @click="prePage">上一页</el-button>
 <el-button type="primary" size="mini" @click="nextPage">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
 </el-button-group>
 <div style="marginTop: 10px; color: #409EFF">{{ pageNum }} / {{ pageTotalNum }}</div>
	<h3>{{zhoubao.filePath.split("/").reverse()[0]}}</h3>
 <pdf
          :page="pageNum"
          :src="(isPro? zhoubao.filePath:'api/'+zhoubao.filePath)+'#zoom=110'"
          @progress="loadedRatio = $event"
          @num-pages="pageTotalNum=$event"
 >
 </pdf>
 </div>
 </template>

<script>
  import pdf from 'vue-pdf'
	const isPro = Object.is(process.env.NODE_ENV, 'production')
	export default {
		name: 'PdfViewer',
		 components:{
          pdf
      },
		data() {
			return {
			  pageNum: 1,
        pageTotalNum: 1,
        loadedRatio: 0,
				//用于区分开发和生产环境，自动解决跨域问题
				isPro: Object.is(process.env.NODE_ENV, 'production'),
				loading: true,
				clientHeight:''

			}
		},
		mounted() {
	    this.getNumPages()
			// 获取浏览器可视区域高度
			this.clientHeight = `${document.documentElement.clientHeight}`
			//document.body.clientWidth;
			//console.log(self.clientHeight);
			window.onresize = function temp() {
				this.clientHeight = `${document.documentElement.clientHeight}`;

			};
		},
		props: {
			zhoubao: Object,
			id: ''
		},
		watch: {
			'$route'(to, from) {
				// 对路由变化作出响应...
				// console.log(to);
				//  console.log(this);
			},
			// 如果 `clientHeight` 发生改变，这个函数就会运行
			clientHeight: function() {
			//	this.changeFixed(this.clientHeight)
			}

		},
		 methods: {
        // 上一页
        prePage() {
          let page = this.pageNum
          page = page > 1 ? page - 1 : this.pageTotalNum
          this.pageNum = page
        },

        // 下一页
        nextPage() {
          let page = this.pageNum
          page = page < this.pageTotalNum ? page + 1 : 1
          this.pageNum = page
        }
      }
}
</script>

<style scoped>
	h1 {
		margin: 0.3%;
	}

	iframe {
		width: 120%;
		height: 100%;
	}
</style>
