//加载笔记本列表
function loadNoteBooks(){
	 $.ajax({
     	url:"http://localhost:8081/SDAU_CloudNote/notebook/loadnotebooks.do",
     	type:"post",
     	data:"json",
     	data:{"userId":userId},
     	success:function(result){
     		if(result.status==0){//说明后台加载笔记本成功
     			var noteBooks=result.data;
     		    //循环获取每个笔记本
     		    for(var i=0;i<noteBooks.length;i++){
     		    	var noteBookName=noteBooks[i].cn_notebook_name;//获取笔记本名
     		    	var noteBookId=noteBooks[i].cn_notebook_id;//获取笔记本的id
     		    	
     		    	var s_li='<li class="online">';
						s_li+="<a>";
						s_li+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
						s_li+='</i> '+noteBookName+'</a></li>';
						
						//拼接后的字符串是dom格式，需要 转换为jQuery格式
						var $s_li=$(s_li);
						//给li添加上bookId
						$s_li.data("noteBookId",noteBookId);
     		    	//将字符串$s_li添加到ul列表中
     		    	$("#book_list").append($s_li);
     		    }
     		}
     	}
     });	 
}

//弹出添加笔记本窗口
function showAddNoteBookWindow(){
	 $(".opacity_bg").show();//显示灰色背景
	 $("#can").load("alert/alert_notebook.html");//弹出新建笔记本的框
}

//关闭添加笔记本窗口
function closeWindow(){
	$("#can").empty();
 	$(".opacity_bg").hide();  //隐藏灰色背景
}

//新建笔记本
function addNoteBook(){
	//获取添加笔记本的框的笔记名
    var noteBookName=$("#input_notebook").val().trim();
	//检验noteName是否为空
	var flag=true;
	if(noteBookName==""){
		alert("请输入笔记本名称");
		flag=false;
	}
	//发送ajax请求   
	if(flag){
		$.ajax({
			url:"http://localhost:8081/SDAU_CloudNote/notebook/addnotebook.do",
			type:"post",
			data:{"noteBookName":noteBookName,"userId":userId},
			dataType:"json",
			success:function(result){
				//关闭弹窗和背景色
				closeWindow();
				var s_li='<li class="online">';
				s_li+="<a>";
				s_li+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
				s_li+='</i> '+noteBookName+'</a></li>';
			    
				var noteBookId=result.data;
				
    			var $s_li=$(s_li);
				$s_li.data("noteBookId",noteBookId);
				$("#book_list").append($s_li);//prepend
			}, 
			error:function(){
				alert("创建失败");
			}
		});
	}
}
