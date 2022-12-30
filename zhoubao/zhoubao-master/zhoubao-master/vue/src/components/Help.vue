<template>
	<div>
		<el-collapse v-model="activeNames" >
			<el-collapse-item title="概述" name="1">
				<div>
					<h1>目录说明</h1>
					<ul>
						<li>
							<h2>规范汇总</h2>
							<h3>所有的规范信息</h3>
						</li>
						<li>
							<h2>规范细则</h2>
							<h3>具体的一个规范</h3>
						</li>
						<li>
            	<h2>Markdown</h2>
            	<h3>模板编辑</h3>
            </li>
					</ul>
					<h3>遇到问题请联系：HEPS 控制组</h3>
				</div>
			</el-collapse-item>
		</el-collapse>
	</div>
</template>

<script>
	export default {
		name: 'Help',
		data() {
			return {
				activeNames: ['1']
			}
		},
	}
</script>

<style scoped>
	div {
		width: 96%;
		margin: auto;
	}
</style>
