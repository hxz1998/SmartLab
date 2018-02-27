<%--
  User: Mr.Hu
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<base href="<%=basePath%>" />
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>实验室综合管理系统</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
		<link rel="stylesheet" href="dist/css/skins/skin-blue.css">
		<link rel="stylesheet" href="plugins/pace/pace.min.css" />

		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	  <![endif]-->

		<!-- Google Font -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
	</head>

	<body class="hold-transition skin-blue fixed sidebar-mini">
		<div class="wrapper">

			<header class="main-header">
				<!-- Logo -->
				<a href="login.action" class="logo">
					<!-- mini logo for sidebar mini 50x50 pixels -->
					<span class="logo-mini"><b>S</b>Lab</span>
					<!-- logo for regular state and mobile devices -->
					<span class="logo-lg"><b>Smart</b>Lab</span>
				</a>
				<!-- Header Navbar: style can be found in header.less -->
				<nav class="navbar navbar-static-top">
					<!-- Sidebar toggle button-->
					<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
						<span class="sr-only">Toggle navigation</span>
					</a>

					<div class="navbar-custom-menu">
					</div>
				</nav>
			</header>
			<!-- Left side column. contains the logo and sidebar -->
			<aside class="main-sidebar">
			</aside>

			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<!-- Content Header (Page header) -->
				<section class="content-header">
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="error-page">
						<h2 class="headline text-yellow"> 404</h2>
						<div class="error-content">
							<h3><i class="fa fa-warning text-yellow"></i> 啊偶，这是哪里？</h3>

							<p>
								您似乎来到了一个荒无人烟的沙漠...<br/>
								<a href="login.action">返回我的首页</a>
							</p>

						</div>
						<!-- /.error-content -->
					</div>
					<!-- /.error-page -->
				</section>
				<!-- /.content -->
			</div>
			<!-- /.content-wrapper -->

			<!-- Main Footer -->
			<footer class="main-footer">
				<!-- To the right -->
				<div class="pull-right hidden-xs">
					任何你想到的
				</div>
				<!-- Default to the left -->
				<strong>Copyright &copy; 2018 <a href="https://github.com/MonkeyAndDog/">Mr.Hu</a>.</strong> All rights reserved.
			</footer>

			<!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
			<div class="control-sidebar-bg"></div>
		</div>
		<!-- ./wrapper -->

		<!-- REQUIRED JS SCRIPTS -->
		<script src="plugins/pace/pace.min.js"></script>
		<!-- jQuery 3 -->
		<script src="bower_components/jquery/dist/jquery.min.js"></script>
		<!-- Bootstrap 3.3.7 -->
		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<!-- AdminLTE App -->
		<script src="dist/js/adminlte.min.js"></script>
		<script type="text/javascript" src="js/plugins.js"></script>
		<script type="text/javascript" src="js/vue.min.js"></script>
		<script>
			mui.init(
				initData()
			)

			function initData() {
				/**
				 *初始化新闻列表 
				 */
				mui.ajax('http://101.200.56.88:8080/smartlab/api/get/news/list', {
				    data:{
				        apikey:'HDFY32JN28'
					},
					type: 'post',
					success: function(data) {
						var oJson = JSON.parse(data);
						news.news = news.news.concat(covertNews(oJson));
					},
					error: function(xhr, type, errorThrown) {
						console.log(errorThrown);
						console.log(type)
					}
				})

				/**
				 *初始化项目列表 
				 */
                mui.ajax('http://101.200.56.88:8080/smartlab/api/get/project/list', {
                    data:{
                        apikey:'HDFY32JN28'
                    },
                    type: 'post',
					success: function(data) {
						var oJson = JSON.parse(data);
						projects.projects = projects.projects.concat(covertProject(oJson));
					}
				})
			}

			var news = new Vue({
				el: '#newsList',
				data: {
					news: []
				}
			})
		
			var projects = new Vue({
				el: '#project',
				data: {
					projects: []
				}
			})
		
			function covertNews(items) {
				var newItems = [];
				items.forEach(function(item) {
					newItems.push({
						title: item.title,
						createDate: item.createDate,
						pushUser: item.user.name,
						id: item.id
					});
				});
				return newItems;
			}

			function covertProject(items) {
				var newItems = [];
				items.forEach(function(item) {
					newItems.push({
						info: item.content,
						id: item.id,
						pm: item.pmUser.name,
						progress: item.progress
					});
				});
				return newItems;
			}
		</script>

	</body>

</html>