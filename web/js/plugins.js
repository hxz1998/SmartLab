/**
 * 引入其他插件
 */
document.write("<script type='text/javascript' src='js/mui.min.js' ></script>");
document.write("<script type='text/javascript' src='js/vue.min.js' ></script>");

function initNewsDate(oNews) {
	mui.ajax('http://localhost:8080/smartlab/api/get/news/list', {
		type: 'post',
		success: function(data) {
			var oJson = JSON.parse(data);
			var str = JSON.stringify(oJson.user);
			oNews = oNews.concat(covert(oJson));
		},
		error: function(xhr, type, errorThrown) {
			console.log(errorThrown);
			console.log(type)
		}
	});

	/**
	 * 新闻的辅助方法，用来格式化列表对象
	 * @param {Object} items
	 */
	function covert(items) {
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

}